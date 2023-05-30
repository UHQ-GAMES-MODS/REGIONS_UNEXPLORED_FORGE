package net.regions_unexplored.world.features.treedecorators;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.regions_unexplored.block.RuBlocks;

public class PineTrunkDecorator extends TrunkVineDecorator {
	public static final PineTrunkDecorator INSTANCE = new PineTrunkDecorator();
	public static com.mojang.serialization.Codec<PineTrunkDecorator> codec;
	public static TreeDecoratorType<?> tdt;
	static {
		codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);
		tdt = new TreeDecoratorType<>(codec);
	}

	@Override
	protected TreeDecoratorType<?> type() {
		return tdt;
	}

	@Override
	public void place(Context context) {
		int size = context.random().nextInt(3)+2;
			for(int i = 0; i < context.logs().size(); i++){
				BlockPos newpos = context.logs().get(i);
				if(context.level().isStateAtPosition(newpos, PineTrunkDecorator::isGrass)){
					newpos = newpos.above();
				}
				if(Feature.isGrassOrDirt(context.level(), newpos)){
					continue;
				}
				else{
					if(i<size){
						context.setBlock(newpos, RuBlocks.STRIPPED_PINE_LOG.get().defaultBlockState());
					}
					else if(i==size){
						context.setBlock(newpos, RuBlocks.PINE_LOG_TRANSITION.get().defaultBlockState());
					}
				}
			}
		}

	public static boolean isGrass(BlockState state) {
		return state.is(Blocks.GRASS_BLOCK)
				||state.is(Blocks.MYCELIUM)
				||state.is(Blocks.DIRT)
				||state.is(RuBlocks.FOREST_GRASS_BLOCK.get())
				||state.is(RuBlocks.PLAINS_GRASS_BLOCK.get())
				||state.is(RuBlocks.ALPHA_GRASS_BLOCK.get())
				||state.is(RuBlocks.FOREST_DIRT.get())
				||state.is(RuBlocks.PLAINS_DIRT.get());
	}
}

