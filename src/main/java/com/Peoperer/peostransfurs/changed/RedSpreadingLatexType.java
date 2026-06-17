package com.Peoperer.peostransfurs.changed;

import com.Peoperer.peostransfurs.Peostransfurs;
import com.Peoperer.peostransfurs.init.ModBlocks;
import com.Peoperer.peostransfurs.init.ModItems;
import com.Peoperer.peostransfurs.init.ModTransfurVariants;
import net.ltxprogrammer.changed.Changed;
import net.ltxprogrammer.changed.entity.TransfurCause;
import net.ltxprogrammer.changed.entity.latex.IClientLatexTypeExtensions;
import net.ltxprogrammer.changed.entity.latex.LatexType;
import net.ltxprogrammer.changed.entity.latex.SpreadingLatexType;
import net.ltxprogrammer.changed.entity.variant.TransfurVariant;
import net.ltxprogrammer.changed.init.*;
import net.ltxprogrammer.changed.item.AbstractLatexBucket;
import net.ltxprogrammer.changed.util.Color3;
import net.ltxprogrammer.changed.world.LatexCoverState;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class RedSpreadingLatexType extends SpreadingLatexType {
    private static final List<Supplier<? extends TransfurVariant<?>>> VARIANTS = Util.make(new ArrayList<>(), list -> {
        list.add(ModTransfurVariants.RED_LATEX_DRONE_WOLF);
    });

    @Override
    public ResourceLocation getLootTable() {
        return BuiltInLootTables.EMPTY;
    }

    @Override
    public void initializeClient(Consumer<IClientLatexTypeExtensions> consumer) {
        consumer.accept(new IClientLatexTypeExtensions() {
            private static final ResourceLocation RED_LATEX_TEXTURE_NON_SIDE = ResourceLocation.fromNamespaceAndPath(Peostransfurs.MODID, "block/red_latex_block_non_side");
            private static final ResourceLocation RED_LATEX_TEXTURE_SIDE = ResourceLocation.fromNamespaceAndPath(Peostransfurs.MODID, "block/red_latex_block_side");

            @Override
            public ResourceLocation getTextureForFace(Direction face) {
                return switch (face) {
                    case NORTH, SOUTH, EAST, WEST -> RED_LATEX_TEXTURE_SIDE;
                    case UP, DOWN -> RED_LATEX_TEXTURE_NON_SIDE;
                };
            }

            @Override
            public Color3 getColor() {
                return Color3.parseHex("FF0000");
            }
        });
    }

    @Override
    public Item getGooItem() {
        return ModItems.RED_LATEX_GOO.get();
    }

    @Override
    public AbstractLatexBucket getBucketItem() {
        return null;
    }

    @Override
    public Block getBlock() {
        return ModBlocks.RED_LATEX_BLOCK.get();
    }

    @Override
    public EntityType<?> getPupEntityType(RandomSource random) {
        return ChangedEntities.DARK_LATEX_WOLF_PUP.get();
    }

    @Override
    public TransfurVariant<?> getTransfurVariant(TransfurCause cause, RandomSource random) {
        return Util.getRandom(VARIANTS, random).get();
    }

    @Override
    public boolean isHostileTo(@Nullable LatexType otherType) {
        return super.isHostileTo(otherType) || otherType == ChangedLatexTypes.WHITE_LATEX.get() || otherType == ChangedLatexTypes.DARK_LATEX.get();
    }

    @Override
    public boolean isFriendlyTo(@Nullable LatexType otherType) {
        return super.isFriendlyTo(otherType) || otherType == this;
    }

    @Override
    public void defaultCoverBehavior(CoveringBlockEvent event) {
        super.defaultCoverBehavior(event);
    }

    @Override
    public void randomTick(LatexCoverState state, ServerLevel level, BlockPos blockPos, RandomSource random) {
        super.randomTick(state, level, blockPos, random);
    }
}
