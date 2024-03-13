package net.regions_unexplored.world.level.block.aquatic.flouramine;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.world.level.block.state.properties.RuBlockStateProperties;
import org.jetbrains.annotations.Nullable;

public class FlouraminePlantBlock extends GrowingPlantBodyBlock implements LiquidBlockContainer {
   public static final MapCodec<FlouraminePlantBlock> CODEC = simpleCodec(FlouraminePlantBlock::new);

   private static final BooleanProperty ACTIVE = RuBlockStateProperties.ACTIVE;
   protected static final VoxelShape SHAPE = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 16.0D, 10.0D);

   public MapCodec<FlouraminePlantBlock> codec() {
      return CODEC;
   }

   public FlouraminePlantBlock(BlockBehaviour.Properties p_54323_) {
      super(p_54323_, Direction.UP, SHAPE, true);
   }

   protected FlouramineBlock getHeadBlock() {
      return (FlouramineBlock) RuBlocks.FLOURAMINE.get();
   }

   @Override
   public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
      ItemStack item = player.getMainHandItem();
      if (!level.isClientSide) {
         if(!item.getAllEnchantments().containsKey(Enchantments.SILK_TOUCH)){
            level.removeBlock(pos, true);
            BlockPos.MutableBlockPos pos1 = pos.below().mutable();
            while(level.getBlockState(pos1).is(RuBlocks.FLOURAMINE.get())||level.getBlockState(pos1).is(RuBlocks.FLOURAMINE_PLANT.get())){
               level.removeBlock(pos1, true);
               pos1.move(Direction.DOWN);
            }
            explode(level, pos);
         }
      }
      return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
   }

   protected void explode(Level level, BlockPos pos) {
      float f = 4.0F;
      level.explode(null, pos.getX()+0.5, pos.getY()+0.5, pos.getZ()+0.5, f, Level.ExplosionInteraction.BLOCK);
   }

   public FluidState getFluidState(BlockState p_54336_) {
      return Fluids.WATER.getSource(false);
   }

   public boolean canAttachTo(BlockState p_153457_) {
      return this.getHeadBlock().canAttachTo(p_153457_);
   }

   public boolean canPlaceLiquid(@Nullable Player p_298374_, BlockGetter p_54325_, BlockPos p_54326_, BlockState p_54327_, Fluid p_54328_) {
      return false;
   }

   public boolean placeLiquid(LevelAccessor p_54330_, BlockPos p_54331_, BlockState p_54332_, FluidState p_54333_) {
      return false;
   }
}