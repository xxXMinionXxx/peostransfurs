package com.Peoperer.peostransfurs.init;

import com.Peoperer.peostransfurs.Peostransfurs;
import net.ltxprogrammer.changed.init.ChangedBlocks;
import net.ltxprogrammer.changed.init.ChangedLatexTypes;
import net.ltxprogrammer.changed.item.AbstractLatexItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM,Peostransfurs.MODID);

    public static final RegistryObject<SpawnEggItem> TEAL_DRAGON_SPAWN_EGG = ITEMS.register("teal_dragon_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.TEAL_DRAGON, 0x3737CD, 0x008888,
                    new Item.Properties()));

    public static final RegistryObject<SpawnEggItem> WHITE_MOUSE_SPAWN_EGG = ITEMS.register("white_mouse_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.WHITE_MOUSE, 0xD3D3D3, 0xDB91E3,
                    new Item.Properties()));

    public static final RegistryObject<SpawnEggItem> BROWN_MOUSE_SPAWN_EGG = ITEMS.register("brown_mouse_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.BROWN_MOUSE, 0xC78A29, 0xDB91E3,
                    new Item.Properties()));

    public static final RegistryObject<SpawnEggItem> LATEX_MYLO_PANDA_SPAWN_EGG = ITEMS.register("latex_mylo_panda_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.LATEX_MYLO_PANDA, 0x49CFF4, 0xEE3B99,
                    new Item.Properties()));

    public static final RegistryObject<SpawnEggItem> LATEX_DRONE_WOLF_SPAWN_EGG = ITEMS.register("latex_drone_wolf_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.LATEX_DRONE_WOLF, 0x000000, 0x0000FF,
                    new Item.Properties()));

    public static final RegistryObject<SpawnEggItem> RED_LATEX_DRONE_WOLF_SPAWN_EGG = ITEMS.register("red_latex_drone_wolf_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.RED_LATEX_DRONE_WOLF, 0x000000, 0xFF0000,
                    new Item.Properties()));

    public static final RegistryObject<SpawnEggItem> FORSETTI = ITEMS.register("forsetti_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.FORSETTI, 0xE3D8C3, 0x453D30,
                    new Item.Properties()));

    public static final RegistryObject<SpawnEggItem> WINGED_FORSETTI = ITEMS.register("winged_forsetti_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.WINGED_FORSETTI, 0xE3D8C3, 0x453D30,
                    new Item.Properties()));

    public static final RegistryObject<SpawnEggItem> SKELETON_DEER = ITEMS.register("skeleton_deer_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.WINGED_FORSETTI, 0xEFE6D5, 0xC9BBA0,
                    new Item.Properties()));


    public static final RegistryObject<AbstractLatexItem> RED_LATEX_GOO = ITEMS.register("red_latex_goo",
            () -> new AbstractLatexItem(ChangedBlocks.DARK_LATEX_WALL_SPLOTCH.get(), ModLatexTypes.RED_LATEX));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
