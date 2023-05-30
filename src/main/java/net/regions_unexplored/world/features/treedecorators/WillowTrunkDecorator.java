/**
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside net.mcreator.regionsunexplored as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
package net.regions_unexplored.world.features.treedecorators;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.regions_unexplored.block.RuBlocks;

public class WillowTrunkDecorator extends TrunkVineDecorator {
	public static final WillowTrunkDecorator INSTANCE = new WillowTrunkDecorator();
	public static com.mojang.serialization.Codec<WillowTrunkDecorator> codec;
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
			int size = 3;
			for(int i = 0; i < context.logs().size(); i++){
			BlockPos newpos = context.logs().get(i);

			BlockPos bp = newpos.west();
			if(i==0){
				context.setBlock(bp, Blocks.DIRT.defaultBlockState());
			}
			else if(i<=size && i>0){
				context.setBlock(bp, RuBlocks.WILLOW_LOG.get().defaultBlockState());
			}
			

			BlockPos bp1 = newpos.east();
			if(i==0){
				context.setBlock(bp1, Blocks.DIRT.defaultBlockState());
			}
			else if(i<=size && i>0){
				context.setBlock(bp1, RuBlocks.WILLOW_LOG.get().defaultBlockState());
			}
			

			BlockPos bp2 = newpos.north();
			if(i==0){
				context.setBlock(bp2, Blocks.DIRT.defaultBlockState());
			}
			else if(i<=size && i>0){
				context.setBlock(bp2, RuBlocks.WILLOW_LOG.get().defaultBlockState());
			}
			

			BlockPos bp3 = newpos.south();
			if(i==0){
				context.setBlock(bp3, Blocks.DIRT.defaultBlockState());
			}
			else if(i<=size && i>0){
				context.setBlock(bp3, RuBlocks.WILLOW_LOG.get().defaultBlockState());
			}
			
			}
		}
	}

