package io.github.DiamondDolphin1.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTabInit {
public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "automationexpansion");

  public static final RegistryObject<CreativeModeTab> AUTOMATION_EXPANSION = TABS.register("automation_expansion",
          () -> CreativeModeTab.builder()
               .title(Component.translatable("itemGroup.automation_expansion"))
               .icon(ItemInit.Netherite_Shrapnel.get()::getDefaultInstance)
                  .displayItems((displayParams, output) -> {
                      output.accept(ItemInit.Netherite_Shrapnel.get());
                      output.accept(ItemInit.Coal_Chunks.get());
                  })
                  .build()
  );
 }
