package io.github.DiamondDolphin1.automationexpansion.blockentity;

import io.github.DiamondDolphin1.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class TestBlockEntity extends BlockEntity {
    private int counter;

 public TestBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInit.TEST_BLOCK_ENTITY.get(), pos, state);
 }

 @Override
    public void load(CompoundTag nbt){
     super.load(nbt);
     this.counter = nbt.getInt("Counter");
 }

 @Override
    protected void saveAdditional(@NotNull CompoundTag nbt) {
     super.saveAdditional(nbt);
     nbt.putInt("Counter", this.counter);
 }

}
