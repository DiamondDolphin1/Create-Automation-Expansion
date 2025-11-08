 package io.github.DiamondDolphin1;

import io.github.DiamondDolphin1.automationexpansion.datagen.DataGenerators;
import io.github.DiamondDolphin1.init.BlockInit;
import io.github.DiamondDolphin1.init.CreativeTabInit;
import io.github.DiamondDolphin1.init.ItemInit;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.EventPriority;




 @Mod("automationexpansion")
 public class AutomationExpansion {
   public static final String MODID = "automationexpansion";

   public AutomationExpansion() {
     IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

    ItemInit.ITEMS.register(bus);
    CreativeTabInit.TABS.register(bus);
       BlockInit.BLOCKS.register(bus);

       bus.addListener(EventPriority.LOWEST, DataGenerators::gatherData);
   }
}



