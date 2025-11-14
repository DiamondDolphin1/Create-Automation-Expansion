 package io.github.DiamondDolphin1;

import io.github.DiamondDolphin1.init.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;




 @Mod("automationexpansion")
 public class AutomationExpansion {
   public static final String MODID = "automationexpansion";

   public AutomationExpansion() {
     IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

    ItemInit.ITEMS.register(bus);
    CreativeTabInit.TABS.register(bus);
    BlockInit.BLOCKS.register(bus);
    BlockEntityInit.BLOCK_ENTITIES.register(bus);
       FluidInit.FLUIDS.register(bus);

   }
}


