package io.github.DiamondDolphin1.automationexpansion.datagen;

import io.github.DiamondDolphin1.AutomationExpansion;
import io.github.DiamondDolphin1.init.ItemInit;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class modelsitemProvider extends ItemModelProvider {
    public modelsitemProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AutomationExpansion.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        System.out.println(">>> Generating Item Model");
        simpleItem(ItemInit.Netherite_Shrapnel);
        simpleItem(ItemInit.Coal_Chunks);
        simpleItem(ItemInit.Crystalite_Bud_Seeds);
        simpleItem(ItemInit.Crushed_Ruby);
        simpleItem(ItemInit.Diamond_Shards);
        simpleItem(ItemInit.Fluorite_Crystals);
        simpleItem(ItemInit.Ruby);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(AutomationExpansion.MODID, "item/" + item.getId().getPath()));
    }
}
