package io.github.DiamondDolphin1.init;

import io.github.DiamondDolphin1.AutomationExpansion;
import io.github.DiamondDolphin1.automationexpansion.fluid.PentafluroWater;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FluidInit {
   public static final DeferredRegister<Fluid> FLUIDS =
           DeferredRegister.create(ForgeRegistries.FLUIDS, AutomationExpansion.MODID);

   public static final RegistryObject<Fluid> PENTAFLURO_WATER =
   FLUIDS.register("pentafluro_water", () -> new PentafluroWater.Source());

   public static final RegistryObject<Fluid> PENTAFLURO_WATER_FLOWING =
           FLUIDS.register("pentafluro_water_flowing", () -> new PentafluroWater.Flowing());
}
