package com.Peoperer.peostransfurs.block;

import com.Peoperer.peostransfurs.changed.RedSpreadingLatexType;
import com.Peoperer.peostransfurs.init.ModItems;
import com.Peoperer.peostransfurs.init.ModLatexTypes;
import net.ltxprogrammer.changed.block.AbstractLatexBlock;
import net.ltxprogrammer.changed.entity.latex.SpreadingLatexType;
import net.ltxprogrammer.changed.world.LatexCoverState;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.IPlantable;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class RedLatexBlock extends AbstractLatexBlock {
    public RedLatexBlock(Properties properties) {
        super(properties, RedSpreadingLatexType::new, ModItems.RED_LATEX_GOO);
    }

    @Override
    public @NotNull LatexCoverState getLatexCoverState(BlockState blockState, BlockPos blockPos) {
        return ModLatexTypes.RED_LATEX.get().sourceCoverState();
    }

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
        return false;
    }
}
