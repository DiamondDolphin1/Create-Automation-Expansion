package io.github.DiamondDolphin1.automationexpansion.blockentity;

import io.github.DiamondDolphin1.AutomationExpansion;
import io.github.DiamondDolphin1.automationexpansion.blockentity.util.TickableBlockEntity;
import io.github.DiamondDolphin1.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ExampleSyncedBlockEntity extends BlockEntity implements TickableBlockEntity {
    private int tickCounter = 0;

    public ExampleSyncedBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInit.EXAMPLE_SYNCED_BLOCK_ENTITY.get(), pos, state);
    }

    @Override
    public void tick() {
        if (this.level == null || this.level.isClientSide())
            return;

        this.tickCounter++;
        setChanged();
        // sync to the client
        this.level.sendBlockUpdated(this.worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag nbt) {
        super.saveAdditional(nbt);

        CompoundTag automationexpansionData = new CompoundTag();
        automationexpansionData.putInt("TickCounter", this.tickCounter);
        nbt.put(AutomationExpansion.MODID, automationexpansionData);
    }

    @Override
    public void load(@NotNull CompoundTag nbt) {
        super.load(nbt);

        CompoundTag automationexpansionData = nbt.getCompound(AutomationExpansion.MODID);
        this.tickCounter = automationexpansionData.getInt("TickCounter");
    }

    public int getTickCounter() {
        return this.tickCounter;
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag nbt = super.getUpdateTag();
        saveAdditional(nbt);
        return nbt;
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}