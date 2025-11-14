package io.github.DiamondDolphin1.init;

import io.github.DiamondDolphin1.AutomationExpansion;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FluidTypeInit {
    // Create a DeferredRegister for FluidTypes
    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create((ResourceLocation) ForgeRegistries.FLUID_TYPES, AutomationExpansion.MODID);

    // Register Pentafluro Water FluidType
    public static final RegistryObject<FluidType> PENTAFLURO_WATER_TYPE =
            FLUID_TYPES.register("pentafluro_water",
                    () -> new FluidType(FluidType.Properties.create()
                            .density(1000)      // example density
                            .viscosity(1000)    // example viscosity
                            .temperature(300)   // example temperature
                    ));
}
