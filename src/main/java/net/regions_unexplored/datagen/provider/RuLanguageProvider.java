package net.regions_unexplored.datagen.provider;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.regions_unexplored.RegionsUnexploredMod;
import net.regions_unexplored.block.RuBlocks;
import org.jetbrains.annotations.NotNull;

public class RuLanguageProvider extends LanguageProvider {
    public RuLanguageProvider(PackOutput output) {
        super(output, RegionsUnexploredMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.add(RuBlocks.ACACIA_BRANCH.get(), capitalizeString(filterBlockLang(RuBlocks.ACACIA_BRANCH.get())));
        this.add(RuBlocks.ACACIA_SHRUB.get(), capitalizeString(filterBlockLang(RuBlocks.ACACIA_SHRUB.get())));
        this.add(RuBlocks.ALPHA_GRASS_BLOCK.get(), capitalizeString(filterBlockLang(RuBlocks.ALPHA_GRASS_BLOCK.get())));
        this.add(RuBlocks.ALPHA_LEAVES.get(), capitalizeString(filterBlockLang(RuBlocks.ALPHA_LEAVES.get())));
        this.add(RuBlocks.ALPHA_PLANKS.get(), capitalizeString(filterBlockLang(RuBlocks.ALPHA_PLANKS.get())));
        this.add(RuBlocks.ALPHA_STAIRS.get(), capitalizeString(filterBlockLang(RuBlocks.ALPHA_STAIRS.get())));
        this.add(RuBlocks.ALPHA_DANDELION.get(), capitalizeString(filterBlockLang(RuBlocks.ALPHA_DANDELION.get())));
        this.add(RuBlocks.ALPHA_SAPLING.get(), capitalizeString(filterBlockLang(RuBlocks.ALPHA_SAPLING.get())));
        this.add(RuBlocks.ALPHA_LOG.get(), capitalizeString(filterBlockLang(RuBlocks.ALPHA_LOG.get())));
        this.add(RuBlocks.ALPHA_ROSE.get(), capitalizeString(filterBlockLang(RuBlocks.ALPHA_ROSE.get())));
        this.add(RuBlocks.ASHEN_LOG.get(), capitalizeString(filterBlockLang(RuBlocks.ASHEN_LOG.get())));
        this.add(RuBlocks.ASH.get(), capitalizeString(filterBlockLang(RuBlocks.ASH.get())));
        this.add(RuBlocks.BAOBAB_SIGN.get(), capitalizeString(filterBlockLang(RuBlocks.BAOBAB_SIGN.get())));
        this.add(RuBlocks.BAOBAB_HANGING_SIGN.get(), capitalizeString(filterBlockLang(RuBlocks.BAOBAB_HANGING_SIGN.get())));
    }

    /**
     * A method to capitalize a string and remove anything what's between it.
     * <a href="https://stackoverflow.com/questions/1892765/how-to-capitalize-the-first-character-of-each-word-in-a-string">Source</a>
     * @param string the string you want to capitalize.
     * @return a capitalised string.
     */
    private static @NotNull String capitalizeString(String string) {
        char[] chars = string.toLowerCase().toCharArray();
        boolean found = false;
        for (int i = 0; i < chars.length; i++) {
            if (!found && Character.isLetter(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
                found = true;
            } else if (Character.isWhitespace(chars[i]) || chars[i] == '.' || chars[i] == '_') {
                found = false;
            }
        }
        return String.valueOf(chars);
    }

    private static @NotNull String filterBlockLang(@NotNull Block block) {
        return block.getDescriptionId()
                .replace("block.regions_unexplored.", "")
                .replace("_", " ");
    }
}
