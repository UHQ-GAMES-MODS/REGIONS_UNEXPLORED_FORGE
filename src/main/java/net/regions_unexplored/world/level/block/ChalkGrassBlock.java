package net.regions_unexplored.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;
import java.util.Optional;

public class ChalkGrassBlock extends ChalkDirtBlock implements BonemealableBlock {
   public ChalkGrassBlock(Properties properties) {
      super(properties);
   }

   public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean bool) {
      return level.getBlockState(pos.above()).isAir();
   }

   public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
      return true;
   }

   public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
      BlockPos blockPos = pos.above();
      BlockState blockState = Blocks.GRASS.defaultBlockState();
      Optional<Holder.Reference<PlacedFeature>> optional = level.registryAccess().registryOrThrow(Registries.PLACED_FEATURE).getHolder(VegetationPlacements.GRASS_BONEMEAL);

      label46:
      for(int i = 0; i < 128; ++i) {
         BlockPos blockPos1 = blockPos;

         for(int j = 0; j < i / 16; ++j) {
            blockPos1 = blockPos1.offset(random.nextInt(3) - 1, (random.nextInt(3) - 1) * random.nextInt(3) / 2, random.nextInt(3) - 1);
            if (!level.getBlockState(blockPos1.below()).is(this) || level.getBlockState(blockPos1).isCollisionShapeFullBlock(level, blockPos1)) {
               continue label46;
            }
         }

         BlockState blockState1 = level.getBlockState(blockPos1);
         if (blockState1.is(blockState.getBlock()) && random.nextInt(10) == 0) {
            ((BonemealableBlock)blockState.getBlock()).performBonemeal(level, random, blockPos1, blockState1);
         }

         if (blockState1.isAir()) {
            Holder<PlacedFeature> holder;
            if (random.nextInt(8) == 0) {
               List<ConfiguredFeature<?, ?>> list = level.getBiome(blockPos1).value().getGenerationSettings().getFlowerFeatures();
               if (list.isEmpty()) {
                  continue;
               }

               holder = ((RandomPatchConfiguration)list.get(0).config()).feature();
            } else {
               if (!optional.isPresent()) {
                  continue;
               }

               holder = optional.get();
            }

            holder.value().place(level, level.getChunkSource().getGenerator(), random, blockPos1);
         }
      }

   }

}
