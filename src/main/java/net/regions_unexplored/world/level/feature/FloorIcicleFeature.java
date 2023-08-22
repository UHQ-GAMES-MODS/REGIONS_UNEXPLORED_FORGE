package net.regions_unexplored.world.level.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.world.level.block.other.IcicleBlock;

public class FloorIcicleFeature extends Feature<NoneFeatureConfiguration> {

    public FloorIcicleFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        BlockPos pos = context.origin();
        WorldGenLevel level = context.level();
        RandomSource randomSource = context.level().getRandom();
        BlockPos.MutableBlockPos checkPos = pos.mutable();
        BlockPos.MutableBlockPos placePos = pos.mutable();
        int size = randomSource.nextInt(4)+2;


        for(int i=0; i<size; i++){
            if(!level.getBlockState(checkPos).canBeReplaced()){
                return false;
            }
        }
        for(int i=0; i<size; i++){
            if(i==0){
                level.setBlock(placePos, RuBlocks.ICICLE.get().defaultBlockState().setValue(IcicleBlock.TIP_DIRECTION, Direction.UP).setValue(IcicleBlock.THICKNESS, DripstoneThickness.TIP), 2);
            }
            else if(i==1){
                level.setBlock(placePos.below(), RuBlocks.ICICLE.get().defaultBlockState().setValue(IcicleBlock.TIP_DIRECTION, Direction.UP).setValue(IcicleBlock.THICKNESS, DripstoneThickness.FRUSTUM), 2);
                level.setBlock(placePos, RuBlocks.ICICLE.get().defaultBlockState().setValue(IcicleBlock.TIP_DIRECTION, Direction.UP).setValue(IcicleBlock.THICKNESS, DripstoneThickness.TIP), 2);
            }
            else if(i==2){
                level.setBlock(placePos.below(2), RuBlocks.ICICLE.get().defaultBlockState().setValue(IcicleBlock.TIP_DIRECTION, Direction.UP).setValue(IcicleBlock.THICKNESS, DripstoneThickness.BASE), 2);
                level.setBlock(placePos.below(), RuBlocks.ICICLE.get().defaultBlockState().setValue(IcicleBlock.TIP_DIRECTION, Direction.UP).setValue(IcicleBlock.THICKNESS, DripstoneThickness.FRUSTUM), 2);
                level.setBlock(placePos, RuBlocks.ICICLE.get().defaultBlockState().setValue(IcicleBlock.TIP_DIRECTION, Direction.UP).setValue(IcicleBlock.THICKNESS, DripstoneThickness.TIP), 2);
            }
            else {
                level.setBlock(placePos.below(2), RuBlocks.ICICLE.get().defaultBlockState().setValue(IcicleBlock.TIP_DIRECTION, Direction.UP).setValue(IcicleBlock.THICKNESS, DripstoneThickness.MIDDLE), 2);
                level.setBlock(placePos.below(), RuBlocks.ICICLE.get().defaultBlockState().setValue(IcicleBlock.TIP_DIRECTION, Direction.UP).setValue(IcicleBlock.THICKNESS, DripstoneThickness.FRUSTUM), 2);
                level.setBlock(placePos, RuBlocks.ICICLE.get().defaultBlockState().setValue(IcicleBlock.TIP_DIRECTION, Direction.UP).setValue(IcicleBlock.THICKNESS, DripstoneThickness.TIP), 2);
            }
            placePos.move(Direction.UP);
        }
        return true;
    }
}