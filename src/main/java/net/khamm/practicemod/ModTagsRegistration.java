package net.khamm.practicemod;

import net.khamm.practicemod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;

public class ModTagsRegistration {
    public static void registerBlockTags() {
        ModTags.Blocks.DOWSING_ROD_VALUABLES = BlockTags.createOptional(new ResourceLocation(PracticeMod.MOD_ID, "data/practicemod/tags/blocks/dowsing_rod_valuables.json"));
    }
}
