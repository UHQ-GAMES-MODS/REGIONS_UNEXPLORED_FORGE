package net.regions_unexplored.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.EatBlockGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
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
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.function.Predicate;

@Mixin(value = EatBlockGoal.class)
public class EatBlockGoalMixin {
    @Shadow
    @Final
    public Mob mob;

    @Shadow
    @Final
    public Level level;

    @Inject(method = "canUse",
            at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;GRASS_BLOCK:Lnet/minecraft/world/level/block/Block;"),
            cancellable = true,
            locals = LocalCapture.NO_CAPTURE
    )
    private void regions_unexplored$canUse(CallbackInfoReturnable<Boolean> cir) {
        BlockPos pos = this.mob.blockPosition();

        if (this.level.getBlockState(pos.below()).is(RuBlocks.SILT_GRASS_BLOCK.get()) || this.level.getBlockState(pos.below()).is(RuBlocks.PEAT_GRASS_BLOCK.get())) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "tick",
            at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;GRASS_BLOCK:Lnet/minecraft/world/level/block/Block;"),
            locals = LocalCapture.NO_CAPTURE
    )
    private void regions_unexplored$tick(CallbackInfo ci) {
        BlockPos downPos = this.mob.blockPosition().below();
        BlockState down = this.level.getBlockState(downPos);

        // Modded Dirt likes
        if (down.is(RuBlocks.PEAT_GRASS_BLOCK.get())) {
            if (this.level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)) {
                this.level.levelEvent(2001, downPos, Block.getId(RuBlocks.PEAT_GRASS_BLOCK.get().defaultBlockState()));

                Block replacement = RuBlocks.PEAT_DIRT.get();

                this.level.setBlock(downPos, replacement.defaultBlockState(), 2);
            }

            this.mob.ate();
        }

        if (down.is(RuBlocks.SILT_GRASS_BLOCK.get())) {
            if (this.level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)) {
                this.level.levelEvent(2001, downPos, Block.getId(RuBlocks.SILT_GRASS_BLOCK.get().defaultBlockState()));

                Block replacement = RuBlocks.SILT_DIRT.get();

                this.level.setBlock(downPos, replacement.defaultBlockState(), 2);
            }
            this.mob.ate();
        }
    }
}