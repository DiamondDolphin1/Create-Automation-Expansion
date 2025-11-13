package io.github.DiamondDolphin1.init;

import io.github.DiamondDolphin1.AutomationExpansion;
import io.github.DiamondDolphin1.automationexpansion.fluid.FluidRegistryContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FluidInit {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, AutomationExpansion.MODID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, AutomationExpansion.MODID);

    public static final FluidRegistryContainer PENTAFLURO_WATER = new FluidRegistryContainer("pentafluro_water",
            FluidType.Properties.create().canSwim(true).canDrown(true).canPushEntity(true).supportsBoating(true).canExtinguish(true).canHydrate(true).rarity(Rarity.RARE),
            () -> FluidRegistryContainer.createExtension(new FluidRegistryContainer.ClientExtensions(AutomationExpansion.MODID, "pentafluro_water")),
            BlockBehaviour.Properties.copy(Blocks.WATER), new Item.Properties().stacksTo(1));
}
