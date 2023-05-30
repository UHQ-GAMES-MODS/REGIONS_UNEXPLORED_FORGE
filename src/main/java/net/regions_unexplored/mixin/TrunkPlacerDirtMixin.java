package net.regions_unexplored.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.regions_unexplored.block.RuBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.BiConsumer;


@Mixin(TrunkPlacer.class)
public abstract class TrunkPlacerDirtMixin {


    @Inject(at=@At("HEAD"), method = "setDirtAt(Lnet/minecraft/world/level/LevelSimulatedReader;Ljava/util/function/BiConsumer;Lnet/minecraft/util/RandomSource;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/levelgen/feature/configurations/TreeConfiguration;)V")
    private static void setDirtAt(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> dirt, RandomSource random, BlockPos pos, TreeConfiguration configuration, CallbackInfo ci) {
        if (!(((net.minecraft.world.level.LevelReader) level).getBlockState(pos).onTreeGrow((net.minecraft.world.level.LevelReader) level, dirt, random, pos, configuration)) && (isForestGrass(level, pos))) {
            dirt.accept(pos, RuBlocks.FOREST_DIRT.get().defaultBlockState());
        }
        if (!(((net.minecraft.world.level.LevelReader) level).getBlockState(pos).onTreeGrow((net.minecraft.world.level.LevelReader) level, dirt, random, pos, configuration)) && (isPlainsGrass(level, pos))) {
            dirt.accept(pos, RuBlocks.PLAINS_DIRT.get().defaultBlockState());
        }
        if (!(((net.minecraft.world.level.LevelReader) level).getBlockState(pos).onTreeGrow((net.minecraft.world.level.LevelReader) level, dirt, random, pos, configuration)) && (isAlphaGrass(level, pos))) {
            dirt.accept(pos, Blocks.DIRT.defaultBlockState());
        }
    }

    private static boolean isForestGrass(LevelSimulatedReader p_70296_, BlockPos p_70297_) {
        return p_70296_.isStateAtPosition(p_70297_, (p_70304_) -> {
            return p_70304_.is(RuBlocks.FOREST_GRASS_BLOCK.get())||p_70304_.is(RuBlocks.FOREST_DIRT.get()) ;
        });
    }
    private static boolean isPlainsGrass(LevelSimulatedReader p_70296_, BlockPos p_70297_) {
        return p_70296_.isStateAtPosition(p_70297_, (p_70304_) -> {
            return p_70304_.is(RuBlocks.PLAINS_GRASS_BLOCK.get())||p_70304_.is(RuBlocks.PLAINS_DIRT.get()) ;
        });
    }
    private static boolean isAlphaGrass(LevelSimulatedReader p_70296_, BlockPos p_70297_) {
        return p_70296_.isStateAtPosition(p_70297_, (p_70304_) -> {
            return p_70304_.is(RuBlocks.ALPHA_GRASS_BLOCK.get())||p_70304_.is(Blocks.DIRT) ;
        });
    }
}
