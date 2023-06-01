package net.regions_unexplored.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.EatBlockGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.regions_unexplored.block.RuBlocks;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Predicate;

@Mixin(EatBlockGoal.class)
public class EatBlockGoalMixin extends Goal {
    @Shadow
    @Final
    private static Predicate<BlockState> IS_TALL_GRASS;

    @Inject(at=@At("TAIL"), method="tick()V")
    private void tick(CallbackInfo ci) {
        if (((EatBlockGoal)(Object)this).getEatAnimationTick() == this.adjustedTickDelay(4)) {
            BlockPos blockpos = ((EatBlockGoal)(Object)this).mob.blockPosition();
            BlockPos blockpos1 = blockpos.below();
            if (((EatBlockGoal)(Object)this).level.getBlockState(blockpos1).is(RuBlocks.FOREST_GRASS_BLOCK.get())) {
                if (((EatBlockGoal)(Object)this).level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)) {
                    ((EatBlockGoal)(Object)this).level.levelEvent(2001, blockpos1, Block.getId(RuBlocks.FOREST_GRASS_BLOCK.get().defaultBlockState()));
                    ((EatBlockGoal)(Object)this).level.setBlock(blockpos1, RuBlocks.FOREST_DIRT.get().defaultBlockState(), 2);
                }
                ((EatBlockGoal)(Object)this).mob.ate();
            } else if (((EatBlockGoal)(Object)this).level.getBlockState(blockpos1).is(RuBlocks.PLAINS_GRASS_BLOCK.get())) {
                if (((EatBlockGoal)(Object)this).level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)) {
                    ((EatBlockGoal)(Object)this).level.levelEvent(2001, blockpos1, Block.getId(RuBlocks.PLAINS_GRASS_BLOCK.get().defaultBlockState()));
                    ((EatBlockGoal)(Object)this).level.setBlock(blockpos1, RuBlocks.PLAINS_DIRT.get().defaultBlockState(), 2);
                }
                ((EatBlockGoal)(Object)this).mob.ate();
            } else if (((EatBlockGoal)(Object)this).level.getBlockState(blockpos1).is(RuBlocks.ALPHA_GRASS_BLOCK.get())) {
                if (((EatBlockGoal)(Object)this).level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)) {
                    ((EatBlockGoal)(Object)this).level.levelEvent(2001, blockpos1, Block.getId(RuBlocks.ALPHA_GRASS_BLOCK.get().defaultBlockState()));
                    ((EatBlockGoal)(Object)this).level.setBlock(blockpos1, Blocks.DIRT.defaultBlockState(), 2);
                }
                ((EatBlockGoal)(Object)this).mob.ate();
            }
        }
    }

    @Override
    public boolean canUse() {
        if (((EatBlockGoal) (Object) this).mob.getRandom().nextInt(((EatBlockGoal) (Object) this).mob.isBaby() ? 50 : 1000) != 0) {
            return false;
        } else {
            BlockPos blockPos = ((EatBlockGoal) (Object) this).mob.blockPosition();
            if (IS_TALL_GRASS.test(((EatBlockGoal) (Object) this).level.getBlockState(blockPos))) {
                return true;
            } else if (((EatBlockGoal) (Object) this).level.getBlockState(blockPos.below()).is(Blocks.GRASS_BLOCK)) {
                return ((EatBlockGoal) (Object) this).level.getBlockState(blockPos.below()).is(Blocks.GRASS_BLOCK);
            } else if (((EatBlockGoal) (Object) this).level.getBlockState(blockPos.below()).is(RuBlocks.PLAINS_GRASS_BLOCK.get())) {
                return ((EatBlockGoal) (Object) this).level.getBlockState(blockPos.below()).is(RuBlocks.PLAINS_GRASS_BLOCK.get());
            } else if (((EatBlockGoal) (Object) this).level.getBlockState(blockPos.below()).is(RuBlocks.ALPHA_GRASS_BLOCK.get())) {
                return ((EatBlockGoal) (Object) this).level.getBlockState(blockPos.below()).is(RuBlocks.ALPHA_GRASS_BLOCK.get());
            } else {
                return ((EatBlockGoal) (Object) this).level.getBlockState(blockPos.below()).is(RuBlocks.FOREST_GRASS_BLOCK.get());
            }
        }
    }
}