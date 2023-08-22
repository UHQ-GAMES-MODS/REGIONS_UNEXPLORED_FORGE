package net.regions_unexplored.world.level.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.material.Fluids;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.data.tags.RuTags;

import java.util.Random;

public class RockPillarFeature extends Feature<NoneFeatureConfiguration> {

    public RockPillarFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        BlockPos pos = context.origin();
        WorldGenLevel level = context.level();
        int var = context.random().nextInt(2)+4;
        int size = context.random().nextInt(14)+7;
        int size2 = level.getSeaLevel()+size;
        if(size2< level.getSeaLevel()){
            return false;
        }
        if(level.getBlockState(pos.below()).getBlock()!= Blocks.SAND){
            return false;
        }
        int doPlace = context.random().nextInt(3);
        if(doPlace == 0){
            return false;
        }

        int j = context.random().nextInt(6)+2;
        int height = 0;

            BlockPos.MutableBlockPos placePos = pos.mutable();
            BlockPos.MutableBlockPos placePos1 = pos.mutable();
            for(int i = 0; i>= -7; i--){
                if(j==1){
                    break;
                }
                if (level.isOutsideBuildHeight(placePos)) {
                    return true;
                }
                int tryPlaceN = context.random().nextInt(5);
                int tryPlaceS = context.random().nextInt(5);
                int tryPlaceE = context.random().nextInt(5);
                int tryPlaceW = context.random().nextInt(5);
                level.setBlock(placePos1, Blocks.STONE.defaultBlockState(), 2);
                placeBlob(level, placePos1, false, 5, 5, 5);
                if(tryPlaceN==0){
                    placeBlob(level, placePos1.north(), false, 5, 5, 5);
                }
                if(tryPlaceS==0){
                    placeBlob(level, placePos1.south(), false, 5, 5, 5);
                }
                if(tryPlaceE==0){
                    placeBlob(level, placePos1.east(), false, 5, 5, 5);
                }
                if(tryPlaceW==0){
                    placeBlob(level, placePos1.west(), false, 5, 5, 5);
                }
                placePos1.move(Direction.DOWN);

            }
            while(placePos.getY() <= size2){
                if (level.isOutsideBuildHeight(placePos)) {
                    return true;
                }
                int tryPlaceN = context.random().nextInt(5);
                int tryPlaceS = context.random().nextInt(5);
                int tryPlaceE = context.random().nextInt(5);
                int tryPlaceW = context.random().nextInt(5);
                level.setBlock(placePos, Blocks.STONE.defaultBlockState(), 2);
                placeBlob(level, placePos, true, j, j+1, j);
                if(tryPlaceN==0){
                    placeBlob(level, placePos.north(), true, j, j+1, j);
                }
                if(tryPlaceS==0){
                    placeBlob(level, placePos.south(), true, j, j+1, j);
                }
                if(tryPlaceE==0){
                    placeBlob(level, placePos.east(), true, j, j+1, j);
                }
                if(tryPlaceW==0){
                    placeBlob(level, placePos.west(), true, j, j+1, j);
                }
                height=height+1;
                if(height==4){
                    j=j-1;
                    height=0;
                    if(j==0){
                        break;
                    }
                }
                placePos.move(Direction.UP);
            }

            return true;
    }

    public void placeCoral(LevelAccessor level, BlockPos pos) {
        Random random = new Random();
        
        int type = random.nextInt(4);
        if(type == 0){
            if (!level.isOutsideBuildHeight(pos)) {
                if (isReplaceable(level, pos.north())) {
                    level.setBlock(pos.north(), Blocks.BRAIN_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.north().north())) {
                    level.setBlock(pos.north().north(), Blocks.BRAIN_CORAL_BLOCK.defaultBlockState(), 2);
                }
                //NORTH-WEST
                if (isReplaceable(level, pos.north().west())) {
                    level.setBlock(pos.north().west(), Blocks.BRAIN_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.north().north().west())) {
                    level.setBlock(pos.north().north().west(), Blocks.BRAIN_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.north().west().west())) {
                    level.setBlock(pos.north().west().west(), Blocks.BRAIN_CORAL_BLOCK.defaultBlockState(), 2);
                }
                //WEST
                if (isReplaceable(level, pos.west())) {
                    level.setBlock(pos.west(), Blocks.BRAIN_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.west().west())) {
                    level.setBlock(pos.west().west(), Blocks.BRAIN_CORAL_BLOCK.defaultBlockState(), 2);
                }
                //SOUTH-WEST
                if (isReplaceable(level, pos.south().west())) {
                    level.setBlock(pos.south().west(), Blocks.BRAIN_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.south().south().west())) {
                    level.setBlock(pos.south().south().west(), Blocks.BRAIN_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.south().west().west())) {
                    level.setBlock(pos.south().west().west(), Blocks.BRAIN_CORAL_BLOCK.defaultBlockState(), 2);
                }
                //SOUTH
                if (isReplaceable(level, pos.south())) {
                    level.setBlock(pos.south(), Blocks.BRAIN_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.south().south())) {
                    level.setBlock(pos.south().south(), Blocks.BRAIN_CORAL_BLOCK.defaultBlockState(), 2);
                }
                //SOUTH-EAST
                if (isReplaceable(level, pos.south().east())) {
                    level.setBlock(pos.south().east(), Blocks.BRAIN_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.south().south().east())) {
                    level.setBlock(pos.south().south().east(), Blocks.BRAIN_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.south().east().east())) {
                    level.setBlock(pos.south().east().east(), Blocks.BRAIN_CORAL_BLOCK.defaultBlockState(), 2);
                }
                //EAST
                if (isReplaceable(level, pos.east())) {
                    level.setBlock(pos.east(), Blocks.BRAIN_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.east().east())) {
                    level.setBlock(pos.east().east(), Blocks.BRAIN_CORAL_BLOCK.defaultBlockState(), 2);
                }
                //NORTH-EAST
                if (isReplaceable(level, pos.north().east())) {
                    level.setBlock(pos.north().east(), Blocks.BRAIN_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.north().north().east())) {
                    level.setBlock(pos.north().north().east(), Blocks.BRAIN_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.north().east().east())) {
                    level.setBlock(pos.north().east().east(), Blocks.BRAIN_CORAL_BLOCK.defaultBlockState(), 2);
                }
            }
        }
        if(type == 1){
            if (!level.isOutsideBuildHeight(pos)) {
                if (isReplaceable(level, pos.north())) {
                    level.setBlock(pos.north(), Blocks.TUBE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.north().north())) {
                    level.setBlock(pos.north().north(), Blocks.TUBE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                //NORTH-WEST
                if (isReplaceable(level, pos.north().west())) {
                    level.setBlock(pos.north().west(), Blocks.TUBE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.north().north().west())) {
                    level.setBlock(pos.north().north().west(), Blocks.TUBE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.north().west().west())) {
                    level.setBlock(pos.north().west().west(), Blocks.TUBE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                //WEST
                if (isReplaceable(level, pos.west())) {
                    level.setBlock(pos.west(), Blocks.TUBE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.west().west())) {
                    level.setBlock(pos.west().west(), Blocks.TUBE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                //SOUTH-WEST
                if (isReplaceable(level, pos.south().west())) {
                    level.setBlock(pos.south().west(), Blocks.TUBE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.south().south().west())) {
                    level.setBlock(pos.south().south().west(), Blocks.TUBE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.south().west().west())) {
                    level.setBlock(pos.south().west().west(), Blocks.TUBE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                //SOUTH
                if (isReplaceable(level, pos.south())) {
                    level.setBlock(pos.south(), Blocks.TUBE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.south().south())) {
                    level.setBlock(pos.south().south(), Blocks.TUBE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                //SOUTH-EAST
                if (isReplaceable(level, pos.south().east())) {
                    level.setBlock(pos.south().east(), Blocks.TUBE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.south().south().east())) {
                    level.setBlock(pos.south().south().east(), Blocks.TUBE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.south().east().east())) {
                    level.setBlock(pos.south().east().east(), Blocks.TUBE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                //EAST
                if (isReplaceable(level, pos.east())) {
                    level.setBlock(pos.east(), Blocks.TUBE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.east().east())) {
                    level.setBlock(pos.east().east(), Blocks.TUBE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                //NORTH-EAST
                if (isReplaceable(level, pos.north().east())) {
                    level.setBlock(pos.north().east(), Blocks.TUBE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.north().north().east())) {
                    level.setBlock(pos.north().north().east(), Blocks.TUBE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.north().east().east())) {
                    level.setBlock(pos.north().east().east(), Blocks.TUBE_CORAL_BLOCK.defaultBlockState(), 2);
                }
            }
        }
        if(type == 2){
            if (!level.isOutsideBuildHeight(pos)) {
                if (isReplaceable(level, pos.north())) {
                    level.setBlock(pos.north(), Blocks.BUBBLE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.north().north())) {
                    level.setBlock(pos.north().north(), Blocks.BUBBLE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                //NORTH-WEST
                if (isReplaceable(level, pos.north().west())) {
                    level.setBlock(pos.north().west(), Blocks.BUBBLE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.north().north().west())) {
                    level.setBlock(pos.north().north().west(), Blocks.BUBBLE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.north().west().west())) {
                    level.setBlock(pos.north().west().west(), Blocks.BUBBLE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                //WEST
                if (isReplaceable(level, pos.west())) {
                    level.setBlock(pos.west(), Blocks.BUBBLE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.west().west())) {
                    level.setBlock(pos.west().west(), Blocks.BUBBLE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                //SOUTH-WEST
                if (isReplaceable(level, pos.south().west())) {
                    level.setBlock(pos.south().west(), Blocks.BUBBLE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.south().south().west())) {
                    level.setBlock(pos.south().south().west(), Blocks.BUBBLE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.south().west().west())) {
                    level.setBlock(pos.south().west().west(), Blocks.BUBBLE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                //SOUTH
                if (isReplaceable(level, pos.south())) {
                    level.setBlock(pos.south(), Blocks.BUBBLE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.south().south())) {
                    level.setBlock(pos.south().south(), Blocks.BUBBLE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                //SOUTH-EAST
                if (isReplaceable(level, pos.south().east())) {
                    level.setBlock(pos.south().east(), Blocks.BUBBLE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.south().south().east())) {
                    level.setBlock(pos.south().south().east(), Blocks.BUBBLE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.south().east().east())) {
                    level.setBlock(pos.south().east().east(), Blocks.BUBBLE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                //EAST
                if (isReplaceable(level, pos.east())) {
                    level.setBlock(pos.east(), Blocks.BUBBLE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.east().east())) {
                    level.setBlock(pos.east().east(), Blocks.BUBBLE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                //NORTH-EAST
                if (isReplaceable(level, pos.north().east())) {
                    level.setBlock(pos.north().east(), Blocks.BUBBLE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.north().north().east())) {
                    level.setBlock(pos.north().north().east(), Blocks.BUBBLE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.north().east().east())) {
                    level.setBlock(pos.north().east().east(), Blocks.BUBBLE_CORAL_BLOCK.defaultBlockState(), 2);
                }
            }
        }
        if(type == 3){
            if (!level.isOutsideBuildHeight(pos)) {
                if (isReplaceable(level, pos.north())) {
                    level.setBlock(pos.north(), Blocks.FIRE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.north().north())) {
                    level.setBlock(pos.north().north(), Blocks.FIRE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                //NORTH-WEST
                if (isReplaceable(level, pos.north().west())) {
                    level.setBlock(pos.north().west(), Blocks.FIRE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.north().north().west())) {
                    level.setBlock(pos.north().north().west(), Blocks.FIRE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.north().west().west())) {
                    level.setBlock(pos.north().west().west(), Blocks.FIRE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                //WEST
                if (isReplaceable(level, pos.west())) {
                    level.setBlock(pos.west(), Blocks.FIRE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.west().west())) {
                    level.setBlock(pos.west().west(), Blocks.FIRE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                //SOUTH-WEST
                if (isReplaceable(level, pos.south().west())) {
                    level.setBlock(pos.south().west(), Blocks.FIRE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.south().south().west())) {
                    level.setBlock(pos.south().south().west(), Blocks.FIRE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.south().west().west())) {
                    level.setBlock(pos.south().west().west(), Blocks.FIRE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                //SOUTH
                if (isReplaceable(level, pos.south())) {
                    level.setBlock(pos.south(), Blocks.FIRE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.south().south())) {
                    level.setBlock(pos.south().south(), Blocks.FIRE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                //SOUTH-EAST
                if (isReplaceable(level, pos.south().east())) {
                    level.setBlock(pos.south().east(), Blocks.FIRE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.south().south().east())) {
                    level.setBlock(pos.south().south().east(), Blocks.FIRE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.south().east().east())) {
                    level.setBlock(pos.south().east().east(), Blocks.FIRE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                //EAST
                if (isReplaceable(level, pos.east())) {
                    level.setBlock(pos.east(), Blocks.FIRE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.east().east())) {
                    level.setBlock(pos.east().east(), Blocks.FIRE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                //NORTH-EAST
                if (isReplaceable(level, pos.north().east())) {
                    level.setBlock(pos.north().east(), Blocks.FIRE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.north().north().east())) {
                    level.setBlock(pos.north().north().east(), Blocks.FIRE_CORAL_BLOCK.defaultBlockState(), 2);
                }
                if (isReplaceable(level, pos.north().east().east())) {
                    level.setBlock(pos.north().east().east(), Blocks.FIRE_CORAL_BLOCK.defaultBlockState(), 2);
                }
            }
        }
    }
    
    public boolean placeBlob(LevelAccessor level, BlockPos pos, boolean b, int i, int j, int k) {
        Random random = new Random();

        if (pos.getY() <= level.getMinBuildHeight() + 3) {
            return false;
        } else {
            for(int l = 0; l < 3; ++l) {
                float f = (float)(i + j + k) * 0.333F + 0.5F;

                for(BlockPos blockpos1 : BlockPos.betweenClosed(pos.offset(-i, -j, -k), pos.offset(i, j, k))) {
                    if (blockpos1.distSqr(pos) <= (double)(f * f)) {
                        if(level.getBlockState(blockpos1.below()).getBlock()== RuBlocks.STONE_GRASS_BLOCK.get()){
                            level.setBlock(blockpos1.below(), Blocks.STONE.defaultBlockState(), 4);
                        }
                        level.setBlock(blockpos1, Blocks.STONE.defaultBlockState(), 4);
                    }
                }

                if(b){
                    for(BlockPos pos2 : BlockPos.betweenClosed(pos.offset(-i, -j, -k), pos.offset(i, j, k))) {
                        if (pos2.distSqr(pos) <= (double)(f * f)) {
                            this.smooth(level, pos2);
                        }
                    }
                }

                for(BlockPos pos1 : BlockPos.betweenClosed(pos.offset(-i, -j, -k), pos.offset(i, j, k))) {
                    if (pos1.distSqr(pos) <= (double)(f * f)) {
                        if(level.isEmptyBlock(pos1.above())||level.getBlockState(pos1.above()).is(Blocks.GRASS)) {
                            if(level.getBlockState(pos1.below()).is(Blocks.STONE)){
                                level.setBlock(pos1, RuBlocks.STONE_GRASS_BLOCK.get().defaultBlockState(), 4);
                                if(random.nextInt(4)==0) {
                                    level.setBlock(pos1.above(), Blocks.GRASS.defaultBlockState(), 4);
                                }
                            }
                        }
                    }
                }

                pos = pos.offset(-1 + random.nextInt(2), -random.nextInt(2), -1 + random.nextInt(2));
            }

            return true;
        }
    }



    private static boolean isRockState(BlockState p_159886_) {
        return p_159886_.is(Blocks.STONE) || p_159886_.is(RuBlocks.STONE_GRASS_BLOCK.get()) || p_159886_.is(Blocks.MOSS_BLOCK);
    }

    private boolean belowIsAir(BlockGetter p_66046_, BlockPos p_66047_) {
        return p_66046_.getBlockState(p_66047_.below()).isAir()||p_66046_.getFluidState(p_66047_.below()).is(Fluids.WATER);
    }


    private void smooth(LevelAccessor level, BlockPos pos) {
                    BlockState blockstate = level.getBlockState(pos);
                    if (isRockState(blockstate)) {
                        if (this.belowIsAir(level, pos)) {
                            if(pos.getY()>=level.getSeaLevel()){
                                this.setBlock(level, pos, Blocks.AIR.defaultBlockState());
                            }
                            else{
                                this.setBlock(level, pos, Blocks.WATER.defaultBlockState());
                            }

                            if(pos.above().getY()>=level.getSeaLevel()){
                                this.setBlock(level, pos.above(), Blocks.AIR.defaultBlockState());
                            }
                            else{
                                this.setBlock(level, pos.above(), Blocks.WATER.defaultBlockState());
                            }
                        } else if (isRockState(blockstate)) {
                            BlockState[] ablockstate = new BlockState[]{level.getBlockState(pos.west()), level.getBlockState(pos.east()), level.getBlockState(pos.north()), level.getBlockState(pos.south())};
                            int i1 = 0;

                            for(BlockState blockstate1 : ablockstate) {
                                if (!isRockState(blockstate1)) {
                                    ++i1;
                                }
                            }

                            if (i1 >= 3) {
                                if(pos.getY()>=level.getSeaLevel()){
                                    this.setBlock(level, pos, Blocks.AIR.defaultBlockState());
                                }
                                else{
                                    this.setBlock(level, pos, Blocks.WATER.defaultBlockState());
                                }
                            }
                        }
                    }
                }

    public static boolean isAirBlock(BlockState state) {
        return state.is(Blocks.AIR)||state.is(Blocks.CAVE_AIR)||state.is(Blocks.VOID_AIR);
    }

    public static boolean isAir(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, RockPillarFeature::isAirBlock);
    }

    public static boolean isReplaceableBlock(BlockState state) {
        return state.is(RuTags.REPLACEABLE_BLOCKS);
    }

    public static boolean isReplaceable(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, RockPillarFeature::isReplaceableBlock);
    }
}