package net.khamm.practicemod.block.custom;

import net.khamm.practicemod.item.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class CucumberPlantBlock extends CropBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_5;
    public CucumberPlantBlock(Properties p_52247_) {
        super(p_52247_);
    }

    @Override
    public int getMaxAge() {
        return 5;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.CUCUMBER_SEEDS.get();
    }
}
