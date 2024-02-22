package net.regions_unexplored.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.regions_unexplored.data.tags.RuTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CropBlock.class)
public class CropPlacerMixin {
    @Inject(at = @At("HEAD"), method = "mayPlaceOn(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)Z", cancellable = true)
        private void mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
            if(level.getBlockState(pos).is(RuTags.CROP_PLANTABLE_BLOCKS)){
                cir.setReturnValue(state.is(RuTags.CROP_PLANTABLE_BLOCKS));
            }
        }

        @Inject(at = @At("HEAD"), method = "getGrowthSpeed(Lnet/minecraft/world/level/block/Block;Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)F", cancellable = true)
        private static void getGrowthSpeed(Block block, BlockGetter level, BlockPos pos, CallbackInfoReturnable<Float> cir) {
            if(level.getBlockState(pos.below()).is(RuTags.CROP_PLANTABLE_BLOCKS)){
                float f1 = 1.0F;
                BlockPos blockPos1 = pos.below();

                for(int i1 = -1; i1 <= 1; ++i1) {
                    for(int j1 = -1; j1 <= 1; ++j1) {
                        float g1 = 0.0F;
                        BlockState blockState1 = level.getBlockState(blockPos1.offset(i1, 0, j1));
                        if (blockState1.is(RuTags.CROP_PLANTABLE_BLOCKS)) {
                            g1 = 1.0F;
                            if (blockState1.getValue(FarmBlock.MOISTURE) > 0) {
                                g1 = 3.0F;
                            }
                        }

                        if (i1 != 0 || j1 != 0) {
                            g1 /= 4.0F;
                        }

                        f1 += g1;
                    }
                }

                BlockPos blockPos21 = pos.north();
                BlockPos blockPos31 = pos.south();
                BlockPos blockPos41 = pos.west();
                BlockPos blockPos51 = pos.east();
                boolean bl1 = level.getBlockState(blockPos41).is(block) || level.getBlockState(blockPos51).is(block);
                boolean bl21 = level.getBlockState(blockPos21).is(block) || level.getBlockState(blockPos31).is(block);
                if (bl1 && bl21) {
                    f1 /= 2.0F;
                } else {
                    boolean bl31 = level.getBlockState(blockPos41.north()).is(block) || level.getBlockState(blockPos51.north()).is(block) || level.getBlockState(blockPos51.south()).is(block) || level.getBlockState(blockPos41.south()).is(block);
                    if (bl31) {
                        f1 /= 2.0F;
                    }
                }


                cir.setReturnValue(f1);
            }
        }
    }
