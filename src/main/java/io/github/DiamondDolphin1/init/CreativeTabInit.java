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
                      output.accept(ItemInit.Diamond_Shards.get());
                      output.accept(ItemInit.Raw_Ruby.get());
                      output.accept(ItemInit.Crushed_Ruby.get());
                      output.accept(ItemInit.Fluorite_Crystals.get());
                      output.accept(ItemInit.Crystalite_Bud_Seeds.get());
                      output.accept(ItemInit.Ruby.get());
                      output.accept(ItemInit.Ruby_Block_Item.get());
                      output.accept(ItemInit.Crystalite_Budding.get());
                      output.accept(ItemInit.Raw_Ruby_Block_Item.get());
                      output.accept(ItemInit.Test_Block_Entity.get());
                  })
                  .build()
  );
 }
