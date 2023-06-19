package net.regions_unexplored.world.level.block.leaves;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.client.particle.RuParticleTypes;
import net.regions_unexplored.config.RuCommonConfig;

public class MauveLeavesBlock extends LeavesBlock {
    public MauveLeavesBlock(Properties p_273704_) {
        super(p_273704_);
    }

    public void animateTick(BlockState p_272714_, Level p_272837_, BlockPos p_273218_, RandomSource p_273360_) {
        super.animateTick(p_272714_, p_272837_, p_273218_, p_273360_);
        if (p_273360_.nextInt(10) == 0) {
            BlockPos blockpos = p_273218_.below();
            BlockState blockstate = p_272837_.getBlockState(blockpos);
            if (!isFaceFull(blockstate.getCollisionShape(p_272837_, blockpos), Direction.UP)) {
                if(RuCommonConfig.TOGGLE_MAUVE_LEAVES_PARTICLE.get()) {
                    spawnParticleBelow(p_272837_, p_273218_, p_273360_, (ParticleOptions) RuParticleTypes.MAUVE_LEAVES.get());
                }
            }
        }
    }

    public static void spawnParticleBelow(Level p_273159_, BlockPos p_273452_, RandomSource p_273538_, ParticleOptions p_273419_) {
        double d0 = (double)p_273452_.getX() + p_273538_.nextDouble();
        double d1 = (double)p_273452_.getY() - 0.05D;
        double d2 = (double)p_273452_.getZ() + p_273538_.nextDouble();
        p_273159_.addAlwaysVisibleParticle(p_273419_, d0, d1, d2, 0.0D, 0.0D, 0.0D);
    }
}