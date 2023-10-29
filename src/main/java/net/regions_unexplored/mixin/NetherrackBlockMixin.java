package net.regions_unexplored.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.NetherrackBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.regions_unexplored.block.RuBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(NetherrackBlock.class)
public abstract class NetherrackBlockMixin {


    @Inject(at=@At("HEAD"), method = "performBonemeal(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/util/RandomSource;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)V")
    private void performBonemeal(ServerLevel level, RandomSource randomSource, BlockPos pos, BlockState state, CallbackInfo ci) {
        boolean isCobalt = false;
        boolean isGlistering = false;
        boolean isMycotoxic = false;
        boolean isBrimsprout = false;

        for(BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-1, -1, -1), pos.offset(1, 1, 1))) {
            BlockState blockstate = level.getBlockState(blockpos);
            if (blockstate.is(RuBlocks.GLISTERING_NYLIUM.get())||blockstate.is(RuBlocks.OVERGROWN_BONE_BLOCK.get())) {
                isGlistering = true;
            }

            if (blockstate.is(RuBlocks.COBALT_NYLIUM.get())) {
                isCobalt = true;
            }

            if (blockstate.is(RuBlocks.MYCOTOXIC_NYLIUM.get())) {
                isMycotoxic = true;
            }

            if (blockstate.is(RuBlocks.BRIMSPROUT_NYLIUM.get())) {
                isBrimsprout = true;
            }
        }

        boolean isSet = false;

        if (isGlistering) {
            level.setBlock(pos, RuBlocks.GLISTERING_NYLIUM.get().defaultBlockState(), 3);
            isSet=true;
        }

        if (isCobalt) {
            if(!isSet){
                level.setBlock(pos, RuBlocks.COBALT_NYLIUM.get().defaultBlockState(), 3);
                isSet=true;
            }
            else{
                if(randomSource.nextInt(2)==0) {
                    level.setBlock(pos, RuBlocks.COBALT_NYLIUM.get().defaultBlockState(), 3);
                }
            }
        }

        if (isMycotoxic) {
            if(!isSet){
                level.setBlock(pos, RuBlocks.MYCOTOXIC_NYLIUM.get().defaultBlockState(), 3);
                isSet=true;
            }
            else{
                if(randomSource.nextInt(2)==0) {
                    level.setBlock(pos, RuBlocks.MYCOTOXIC_NYLIUM.get().defaultBlockState(), 3);
                }
            }
        }

        if (isBrimsprout) {
            if(!isSet){
                level.setBlock(pos, RuBlocks.BRIMSPROUT_NYLIUM.get().defaultBlockState(), 3);
                isSet=true;
            }
            else{
                if(randomSource.nextInt(2)==0) {
                    level.setBlock(pos, RuBlocks.BRIMSPROUT_NYLIUM.get().defaultBlockState(), 3);
                }
            }
        }
    }
}
