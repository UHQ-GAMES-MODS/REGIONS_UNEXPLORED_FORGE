package net.regions_unexplored.datagen.provider;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.regions_unexplored.RegionsUnexploredMod;

public class RuBlockModelProvider extends BlockStateProvider {
    public RuBlockModelProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, RegionsUnexploredMod.MOD_ID, exFileHelper);
    }


    @Override
    protected void registerStatesAndModels() {

    }
}
