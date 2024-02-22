package net.regions_unexplored.world.level.block.plant.food;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.regions_unexplored.item.RuItems;

public class DuskmelonBlock extends BushBlock implements BonemealableBlock {
   private static final float HURT_SPEED_THRESHOLD = 0.003F;
   public static final int MAX_AGE = 2;
   public static final IntegerProperty AGE = BlockStateProperties.AGE_2;
   private static final VoxelShape SAPLING_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
   private static final VoxelShape MID_GROWTH_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

   public DuskmelonBlock(Properties p_57249_) {
      super(p_57249_);
      this.registerDefaultState(this.stateDefinition.any().setValue(AGE, Integer.valueOf(0)));
   }

   public ItemStack getCloneItemStack(BlockGetter p_57256_, BlockPos p_57257_, BlockState p_57258_) {
      return new ItemStack(RuItems.DUSKMELON_SLICE.get());
   }

   public VoxelShape getShape(BlockState p_57291_, BlockGetter p_57292_, BlockPos p_57293_, CollisionContext p_57294_) {
      if (p_57291_.getValue(AGE) == 0) {
         return SAPLING_SHAPE;
      } else {
         return p_57291_.getValue(AGE) < 2 ? MID_GROWTH_SHAPE : super.getShape(p_57291_, p_57292_, p_57293_, p_57294_);
      }
   }

   public boolean isRandomlyTicking(BlockState p_57284_) {
      return p_57284_.getValue(AGE) < 2;
   }

   public void randomTick(BlockState p_222563_, ServerLevel p_222564_, BlockPos p_222565_, RandomSource p_222566_) {
      int i = p_222563_.getValue(AGE);
      if (i < 2 && p_222564_.getRawBrightness(p_222565_.above(), 0) >= 9 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(p_222564_, p_222565_, p_222563_, p_222566_.nextInt(5) == 0)) {
         BlockState blockstate = p_222563_.setValue(AGE, Integer.valueOf(i + 1));
         p_222564_.setBlock(p_222565_, blockstate, 2);
         p_222564_.gameEvent(GameEvent.BLOCK_CHANGE, p_222565_, GameEvent.Context.of(blockstate));
         net.minecraftforge.common.ForgeHooks.onCropsGrowPost(p_222564_, p_222565_, p_222563_);
      }

   }

   @Override
   public void entityInside(BlockState p_57270_, Level p_57271_, BlockPos p_57272_, Entity p_57273_) {
   }

   public InteractionResult use(BlockState p_57275_, Level p_57276_, BlockPos p_57277_, Player p_57278_, InteractionHand p_57279_, BlockHitResult p_57280_) {
      int i = p_57275_.getValue(AGE);
      boolean flag = i == 2;
      if (!flag && p_57278_.getItemInHand(p_57279_).is(Items.BONE_MEAL)) {
         return InteractionResult.PASS;
      } else if (i > 1) {
         popResource(p_57276_, p_57277_, new ItemStack(RuItems.DUSKMELON_SLICE.get(), 1));
         p_57276_.playSound((Player)null, p_57277_, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + p_57276_.random.nextFloat() * 0.4F);
         BlockState blockstate = p_57275_.setValue(AGE, Integer.valueOf(0));
         p_57276_.setBlock(p_57277_, blockstate, 2);
         p_57276_.gameEvent(GameEvent.BLOCK_CHANGE, p_57277_, GameEvent.Context.of(p_57278_, blockstate));
         return InteractionResult.sidedSuccess(p_57276_.isClientSide);
      } else {
         return super.use(p_57275_, p_57276_, p_57277_, p_57278_, p_57279_, p_57280_);
      }
   }

   protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_57282_) {
      p_57282_.add(AGE);
   }

   public boolean isValidBonemealTarget(LevelReader p_256056_, BlockPos p_57261_, BlockState p_57262_) {
      return p_57262_.getValue(AGE) < 2;
   }

   public boolean isBonemealSuccess(Level p_222558_, RandomSource p_222559_, BlockPos p_222560_, BlockState p_222561_) {
      return true;
   }

   public void performBonemeal(ServerLevel p_222553_, RandomSource p_222554_, BlockPos p_222555_, BlockState p_222556_) {
      int i = Math.min(3, p_222556_.getValue(AGE) + 1);
      p_222553_.setBlock(p_222555_, p_222556_.setValue(AGE, Integer.valueOf(i)), 2);
   }
}
