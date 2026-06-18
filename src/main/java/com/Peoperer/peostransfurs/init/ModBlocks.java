package com.Peoperer.peostransfurs.init;

import com.Peoperer.peostransfurs.Peostransfurs;
import com.Peoperer.peostransfurs.block.RedLatexBlock;
import com.Peoperer.peostransfurs.changed.RedSpreadingLatexType;
import net.ltxprogrammer.changed.block.LatexWallSplotch;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Peostransfurs.MODID);

    public static final RegistryObject<Block> RED_LATEX_BLOCK = registerBlock("red_latex_block",
            () -> new RedLatexBlock(BlockBehaviour.Properties.of().sound(SoundType.SLIME_BLOCK).strength(1.0F, 4.0F)));

    public static final RegistryObject<LatexWallSplotch> DARK_LATEX_WALL_SPLOTCH = registerBlockNoItem("red_latex_wall_splotch", () -> new LatexWallSplotch(ModLatexTypes.RED_LATEX, List.of()));

    private static <T extends Block> RegistryObject<T> registerBlockNoItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
