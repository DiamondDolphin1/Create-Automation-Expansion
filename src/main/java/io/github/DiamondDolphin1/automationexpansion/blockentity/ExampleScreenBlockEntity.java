package io.github.DiamondDolphin1.automationexpansion.blockentity;

import io.github.DiamondDolphin1.AutomationExpansion;
import io.github.DiamondDolphin1.automationexpansion.blockentity.util.TickableBlockEntity;
import io.github.DiamondDolphin1.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ExampleScreenBlockEntity extends BlockEntity implements TickableBlockEntity {
    private int ticks = 0, secondsExisted = 0;

    public ExampleScreenBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInit.EXAMPLE_SCREEN_BLOCK_ENTITY.get(), pos, state);
    }

    @Override
    public void tick() {
        if (this.level == null || this.level.isClientSide()) return;

        if (this.ticks++ % 20 == 0) {
            this.secondsExisted++;
            setChanged();
            this.level.sendBlockUpdated(this.worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
        }
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag nbt) {
        super.saveAdditional(nbt);

        var automationexpansionData = new CompoundTag();
        automationexpansionData.putInt("SecondsExisted", this.secondsExisted);
        nbt.put(AutomationExpansion.MODID, automationexpansionData);
    }

    @Override
    public void load(@NotNull CompoundTag nbt) {
        super.load(nbt);

        var automationexpansionData = nbt.getCompound(AutomationExpansion.MODID);
        this.secondsExisted = automationexpansionData.getInt("SecondsExisted");
    }

    @Override
    public @NotNull CompoundTag getUpdateTag() {
       CompoundTag tag = super.getUpdateTag();
       saveAdditional(tag);
       return tag;
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {

        return ClientboundBlockEntityDataPacket.create(this);
    }

    public int getSecondsExisted() {
        return this.secondsExisted;
    }
}
