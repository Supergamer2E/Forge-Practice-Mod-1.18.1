package net.khamm.practicemod.painting;

import net.khamm.practicemod.PracticeMod;
import net.minecraft.world.entity.decoration.Motive;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
    public static final DeferredRegister<Motive> PAINTING_MOVTIES =
            DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, PracticeMod.MOD_ID);

    public static final RegistryObject<Motive> MARATHON =
            PAINTING_MOVTIES.register("marathon", () -> new Motive(16, 16));

    public static final RegistryObject<Motive> FAMILY =
            PAINTING_MOVTIES.register("family", () -> new Motive(16, 32));

    public static void register(IEventBus eventBus) {
        PAINTING_MOVTIES.register(eventBus);
    }
}
