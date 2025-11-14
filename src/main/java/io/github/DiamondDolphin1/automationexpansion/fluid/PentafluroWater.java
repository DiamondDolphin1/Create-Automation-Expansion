package io.github.DiamondDolphin1.automationexpansion.fluid;

import io.github.DiamondDolphin1.init.BlockInit;
import io.github.DiamondDolphin1.init.FluidInit;
import io.github.DiamondDolphin1.init.FluidTypeInit;
import io.github.DiamondDolphin1.init.ItemInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import static io.github.DiamondDolphin1.init.FluidInit.PENTAFLURO_WATER;
import static io.github.DiamondDolphin1.init.FluidInit.PENTAFLURO_WATER_FLOWING;

public class PentafluroWater extends FlowingFluid {

    @Override
    public Fluid getFlowing() {
        return PENTAFLURO_WATER_FLOWING.get();
    }

    @Override
    public Fluid getSource() {
        return PENTAFLURO_WATER.get();
    }

    @Override
    protected boolean canConvertToSource(Level level) {
        return true;
    }


    @Override
    protected void beforeDestroyingBlock(LevelAccessor world, BlockPos pos, BlockState state) {
        Block.dropResources(state, world, pos, null);
    }

    @Override
    public Item getBucket() {
        return ItemInit.Pentafluro_water_bucket.get();
    }

    @Override
    protected BlockState createLegacyBlock(FluidState state) {
        return BlockInit.PENTAFLURO_WATER_BLOCK.get().defaultBlockState()
                .setValue(LiquidBlock.LEVEL, getLegacyLevel(state));
    }

    @Override
    public boolean isSource(FluidState state) {
        return false;
    }

    @Override
    public int getTickDelay(LevelReader world) {
        return 5;
    }

    @Override
    protected boolean canBeReplacedWith(FluidState state, BlockGetter world, BlockPos pos, Fluid fluid, Direction direction) {
        return false;
    }

    @Override
    protected int getSlopeFindDistance(LevelReader world) {
        return 4;
    }

    @Override
    protected int getDropOff(LevelReader world) {
        return 1;
    }

    @Override
    public int getAmount(FluidState state) {
        return 8;
    }

    @Override
    protected float getExplosionResistance() {
        return 100.0F;
    }

    public static class Flowing extends PentafluroWater {

        @Override
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        @Override
        public boolean isSource(FluidState state) {
            return false;
        }

        @Override
        public int getAmount(FluidState state) {
            return state.getValue(LEVEL);
        }
    }

    public static class Source extends PentafluroWater {
        @Override
        public boolean isSource(FluidState state) {
            return true;
        }

        @Override
        public int getAmount(FluidState state) {
            return 8;
        }
    }

    public static final ForgeFlowingFluid.Properties PROPERTIES =
            new ForgeFlowingFluid.Properties(
                    () -> FluidTypeInit.PENTAFLURO_WATER_TYPE.get(),
                    PENTAFLURO_WATER,
                    PENTAFLURO_WATER_FLOWING
            )
                    .block(() -> BlockInit.PENTAFLURO_WATER_BLOCK.get()) // link the block here
                    .bucket(() -> ItemInit.Pentafluro_water_bucket.get());



}
