package net.regions_unexplored.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.NetherrackBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.world.level.block.nether.RuNyliumBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(NetherrackBlock.class)
public abstract class NetherrackBlockMixin {
    @Inject(at=@At("HEAD"), method = "performBonemeal(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/util/RandomSource;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)V")
    private void performBonemeal(ServerLevel level, RandomSource randomSource, BlockPos pos, BlockState state, CallbackInfo ci) {
        boolean isSet=false;

        for(BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-1, -1, -1), pos.offset(1, 1, 1))) {
            BlockState blockstate = level.getBlockState(blockpos);
            if(blockstate.getBlock() instanceof RuNyliumBlock){
                if(isSet){
                    if(randomSource.nextInt(2)==0){
                        level.setBlock(pos, blockstate, 3);
                    }
                }
                else{
                    level.setBlock(pos, blockstate, 3);
                    isSet=true;
                }
            }
        }
    }
}
