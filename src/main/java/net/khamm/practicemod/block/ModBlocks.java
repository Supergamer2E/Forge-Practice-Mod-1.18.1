package net.khamm.practicemod.block;

import net.khamm.practicemod.PracticeMod;
import net.khamm.practicemod.block.custom.SpeedyBlock;
import net.khamm.practicemod.item.ModCreativeModeTab;
import net.khamm.practicemod.item.ModItems;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, PracticeMod.MOD_ID);

    public static final RegistryObject<Block> CITRINE_BLOCK = registerBlock("citrine_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(9f).requiresCorrectToolForDrops()), ModCreativeModeTab.PRACTICE_TAB);

    public static final RegistryObject<Block> RAW_CITRINE_BLOCK = registerBlock("raw_citrine_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(7f).requiresCorrectToolForDrops()), ModCreativeModeTab.PRACTICE_TAB);

    public static final RegistryObject<Block> CITRINE_ORE = registerBlock("citrine_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModeTab.PRACTICE_TAB);

    public static final RegistryObject<Block> DEEPSLATE_CITRINE_ORE = registerBlock("deepslate_citrine_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(7f).requiresCorrectToolForDrops()), ModCreativeModeTab.PRACTICE_TAB);
    public static final RegistryObject<Block> NETHERRACK_CITRINE_ORE = registerBlock("netherrack_citrine_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModeTab.PRACTICE_TAB);
    public static final RegistryObject<Block> ENDSTONE_CITRINE_ORE = registerBlock("endstone_citrine_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModeTab.PRACTICE_TAB);

    public static final RegistryObject<Block> SPEEDY_BLOCK = registerBlock("speedy_block",
            () -> new SpeedyBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.PRACTICE_TAB,
            "tooltip.practicemod.block.speedy_block");

    public static final RegistryObject<Block> CITRINE_STAIRS = registerBlock("citrine_stairs",
            () -> new StairBlock(() -> ModBlocks.CITRINE_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModeTab.PRACTICE_TAB);

    public static final RegistryObject<Block> CITRINE_SLAB = registerBlock("citrine_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModeTab.PRACTICE_TAB);

    public static final RegistryObject<Block> CITRINE_FENCE = registerBlock("citrine_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModeTab.PRACTICE_TAB);

    public static final RegistryObject<Block> CITRINE_FENCE_GATE = registerBlock("citrine_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModeTab.PRACTICE_TAB);

    public static final RegistryObject<Block> CITRINE_WALL = registerBlock("citrine_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModeTab.PRACTICE_TAB);

    public static final RegistryObject<Block> CITRINE_BUTTON = registerBlock("citrine_button",
            () -> new StoneButtonBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops().noCollission()), ModCreativeModeTab.PRACTICE_TAB);

    public static final RegistryObject<Block> CITRINE_PRESSURE_PLATE = registerBlock("citrine_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModeTab.PRACTICE_TAB);

    public static final RegistryObject<Block> EBONY_DOOR = registerBlock("ebony_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.PRACTICE_TAB);

    public static final RegistryObject<Block> EBONY_TRAPDOOR = registerBlock("ebony_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.PRACTICE_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab, String tooltipKey) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab, tooltipKey);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab, String tooltipKey) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)) {
            @Override
            public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
                pTooltip.add(new TranslatableComponent(tooltipKey));
            }
        });
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
