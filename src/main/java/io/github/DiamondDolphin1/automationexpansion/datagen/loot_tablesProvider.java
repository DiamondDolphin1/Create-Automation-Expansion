package io.github.DiamondDolphin1.automationexpansion.datagen;

import io.github.DiamondDolphin1.automationexpansion.datagen.loot.BlockInitLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class loot_tablesProvider {
    public static LootTableProvider create(PackOutput output){
        System.out.println(">>> Generating Loot Tables");
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(BlockInitLootTables::new, LootContextParamSets.BLOCK)
        ));
    }
}
