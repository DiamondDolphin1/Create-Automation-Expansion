package io.github.DiamondDolphin1.automationexpansion.datagen;

import io.github.DiamondDolphin1.AutomationExpansion;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = AutomationExpansion.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        System.out.println(">>> Data Generator");
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new recipesProvider(packOutput));
        generator.addProvider(event.includeServer(), loot_tablesProvider.create(packOutput));

        generator.addProvider(event.includeClient(), new blockstatesProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new modelsitemProvider(packOutput, existingFileHelper));

        tagsblocksGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
                new tagsblocksGenerator(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new itemtagsGenerator(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));

    }

}
