package io.github.DiamondDolphin1.automationexpansion.block;

import io.github.DiamondDolphin1.automationexpansion.blockentity.ExampleTickingBlockEntity;
import io.github.DiamondDolphin1.automationexpansion.blockentity.util.TickableBlockEntity;
import io.github.DiamondDolphin1.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class ExampleTickingBlock extends Block implements EntityBlock, BlockEntityTicker<ExampleTickingBlockEntity> {
    public ExampleTickingBlock(Properties properties) { super(properties); }

    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return BlockEntityInit.EXAMPLE_TICKING_BLOCK_ENTITY.get().create(pos, state);
    }

    @Nullable
    @Override
   public  <T extends BlockEntity> BlockEntityTicker<T> getTicker( @NotNull Level level, @NotNull BlockState state, @NotNull BlockEntityType<T> type) {
        return TickableBlockEntity.getTickerHelper(level);
    }

    @Override
    public void tick(Level p_155253_, BlockPos p_155254_, BlockState p_155255_, ExampleTickingBlockEntity p_155256_) {

    }
}
