package net.khamm.practicemod.item.custom;

import net.khamm.practicemod.util.ModTags;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DowsingRodItem extends Item {
    public DowsingRodItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                Block blockBelow = pContext.getLevel().getBlockState(positionClicked.below(i)).getBlock();

                if (isValuableBlock(blockBelow)) {
                    outputValuableCoordinates(positionClicked.below(i), player, blockBelow);
                    foundBlock = true;
                    break;
                }
            }

            if (!foundBlock) {
                player.sendMessage(new TranslatableComponent("item.practicemod.dowsing_rod.no_valuables"),
                        player.getUUID());
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                (player) -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return super.useOn(pContext);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()) {
            pTooltipComponents.add(new TranslatableComponent("tooltip.practicemod.dowsing_rod.tooltip.shift"));
        } else {
            pTooltipComponents.add(new TranslatableComponent("tooltip.practicemod.dowsing_rod.tooltip"));
        }
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block blockBelow) {
        player.sendMessage(new TextComponent("Found " + blockBelow.asItem().getRegistryName().toString() + " at "
                + "(" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"), player.getUUID());
    }

    private boolean isValuableBlock(Block block) {
        System.out.println(block.toString());
        return block.toString().equals("Block{practicemod:citrine_ore}") ||
                block.toString().equals("Block{practicemod:netherrack_citrine_ore}") ||
                block.toString().equals("Block{practicemod:endstone_citrine_ore}") ||
                block.toString().equals("Block{practicemod:deepslate_citrine_ore}") ||
                block.toString().equals("Block{minecraft:redstone_ore}") ||
                block.toString().equals("Block{minecraft:diamond_ore}") ||
                block.toString().equals("Block{minecraft:iron_ore}") ||
                block.toString().equals("Block{minecraft:coal_ore}") ||
                block.toString().equals("Block{minecraft:gold_ore}") ||
                block.toString().equals("Block{minecraft:lapis_ore}") ||
                block.toString().equals("Block{minecraft:emerald_ore}") ||
                block.toString().equals("Block{minecraft:copper_ore}") ||
                block.toString().equals("Block{minecraft:deepslate_coal_ore}") ||
                block.toString().equals("Block{minecraft:deepslate_iron_ore}") ||
                block.toString().equals("Block{minecraft:deepslate_gold_ore}") ||
                block.toString().equals("Block{minecraft:deepslate_redstone_ore}") ||
                block.toString().equals("Block{minecraft:deepslate_lapis_ore}") ||
                block.toString().equals("Block{minecraft:deepslate_diamond_ore}") ||
                block.toString().equals("Block{minecraft:deepslate_emerald_ore}") ||
                block.toString().equals("Block{minecraft:deepslate_copper_ore}");
    }
}

