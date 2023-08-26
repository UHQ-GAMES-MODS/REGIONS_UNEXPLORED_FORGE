package net.regions_unexplored.world.level.block.plant.dusktrap;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.regions_unexplored.entity.RuDamageTypes;

import javax.annotation.Nullable;

public abstract class BaseDuskTrapBlock extends DoublePlantBlock {
   protected static final VoxelShape CLOSED_AABB = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
   protected static final VoxelShape AABB = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
   protected static final AABB TOUCH_AABB = new AABB(0.0625D, 0.0D, 0.0625D, 0.9375D, 16.0D, 0.9375D);

   protected BaseDuskTrapBlock(Properties p_273450_) {
      super(p_273450_);
   }

   public VoxelShape getShape(BlockState state, BlockGetter p_49342_, BlockPos p_49343_, CollisionContext p_49344_) {
      return this.getSignalForState(state) > 0 ? CLOSED_AABB : AABB;
   }

   protected int getClosedTime() {
      return 5;
   }

   public boolean isPossibleToRespawnInThis(BlockState p_279155_) {
      return true;
   }

   public void tick(BlockState p_220768_, ServerLevel p_220769_, BlockPos p_220770_, RandomSource p_220771_) {
      int i = this.getSignalForState(p_220768_);
      if (i > 0) {
         this.checkClosed((Entity)null, p_220769_, p_220770_, p_220768_, i);
      }

   }

   public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
      Vec3 entityPos = entity.position();
      Vec3 inPos = new Vec3(pos.getX()+0.05D, pos.getY(), pos.getZ()+0.05D);
      Vec3 outPos = new Vec3(pos.getX()+0.95D, pos.getY(), pos.getZ()+0.95D);
      boolean isInside = entityPos.x>inPos.x&&entityPos.z>inPos.z&&entityPos.x<outPos.x&&entityPos.z<outPos.z;
      boolean isItem = entity instanceof ItemEntity;
      if(!isItem){
         if(isInside)entity.makeStuckInBlock(state, new Vec3(0.4D, 0.1D, 0.4D));
      }
      if (!level.isClientSide) {
         if(entity.isAlive()){
            if(isInside)entity.hurt(level.damageSources().source(RuDamageTypes.DUSK_TRAP), 3.0F);
         }
         entity.makeStuckInBlock(state, new Vec3(0.4D, 0.1D, 0.4D));
         int i = this.getSignalForState(state);
         if (i == 0) {
            this.checkClosed(entity, level, pos, state, i);
         }

      }
   }

   private void checkClosed(@Nullable Entity entity, Level level, BlockPos pos, BlockState state, int power) {
      int i = this.getSignalStrength(level, pos);
      boolean flag = power > 0;
      boolean flag1 = i > 0;
      if (power != i) {
         BlockState blockstate = this.setSignalForState(state, i);

         if(blockstate.getValue(HALF)==DoubleBlockHalf.LOWER){
            BlockPos blockpos = pos.above();
            level.setBlock(blockpos, blockstate.setValue(HALF, DoubleBlockHalf.UPPER), 2);
         }
         else if(blockstate.getValue(HALF)==DoubleBlockHalf.UPPER){
            BlockPos blockpos = pos.below();
            level.setBlock(blockpos, blockstate.setValue(HALF, DoubleBlockHalf.LOWER), 2);
         }
         level.setBlock(pos, blockstate, 2);
         this.updateNeighbours(level, pos);
         level.setBlocksDirty(pos, state, blockstate);
      }

      if (!flag1 && flag) {
         level.playSound((Player)null, pos, SoundType.TWISTING_VINES.getBreakSound(), SoundSource.BLOCKS);
         level.gameEvent(entity, GameEvent.BLOCK_DEACTIVATE, pos);
      } else if (flag1 && !flag) {
         level.playSound((Player)null, pos, SoundType.TWISTING_VINES.getPlaceSound(), SoundSource.BLOCKS);
         level.gameEvent(entity, GameEvent.BLOCK_ACTIVATE, pos);
      }

      if (flag1) {
         level.scheduleTick(new BlockPos(pos), this, this.getClosedTime());
      }

   }

   public void onRemove(BlockState p_49319_, Level p_49320_, BlockPos p_49321_, BlockState p_49322_, boolean p_49323_) {
      if (!p_49323_ && !p_49319_.is(p_49322_.getBlock())) {
         if (this.getSignalForState(p_49319_) > 0) {
            this.updateNeighbours(p_49320_, p_49321_);
         }

         super.onRemove(p_49319_, p_49320_, p_49321_, p_49322_, p_49323_);
      }
   }

   protected void updateNeighbours(Level p_49292_, BlockPos p_49293_) {
      p_49292_.updateNeighborsAt(p_49293_, this);
      p_49292_.updateNeighborsAt(p_49293_.below(), this);
   }

   public int getSignal(BlockState p_49309_, BlockGetter p_49310_, BlockPos p_49311_, Direction p_49312_) {
      return this.getSignalForState(p_49309_);
   }

   public int getDirectSignal(BlockState p_49346_, BlockGetter p_49347_, BlockPos p_49348_, Direction p_49349_) {
      return p_49349_ == Direction.UP ? this.getSignalForState(p_49346_) : 0;
   }

   public boolean isSignalSource(BlockState p_49351_) {
      return true;
   }

   protected static int getEntityCount(Level p_289656_, AABB p_289647_, Class<? extends Entity> p_289686_) {
      return p_289656_.getEntitiesOfClass(p_289686_, p_289647_, EntitySelector.NO_SPECTATORS.and((p_289691_) -> {
         return !p_289691_.isIgnoringBlockTriggers();
      })).size();
   }

   protected abstract int getSignalStrength(Level p_49336_, BlockPos p_49337_);

   protected abstract int getSignalForState(BlockState p_49354_);

   protected abstract BlockState setSignalForState(BlockState p_49301_, int p_49302_);
}