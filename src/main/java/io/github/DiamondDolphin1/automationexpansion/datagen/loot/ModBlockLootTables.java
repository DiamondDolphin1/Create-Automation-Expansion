package io.github.DiamondDolphin1.automationexpansion.datagen.loot;

import io.github.DiamondDolphin1.init.BlockInit;
import io.github.DiamondDolphin1.init.ItemInit;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(BlockInit.RUBY_BLOCK.get());
        this.dropSelf(BlockInit.RAW_RUBY_BLOCK.get());

        this.add(BlockInit.RUBY_ORE.get(),
               block -> createOreDrop(BlockInit.RUBY_ORE.get(), ItemInit.Ruby.get()) );
    }


    protected LootTable.Builder createOreDrop(Block p_250450_, Item p_249745_) {
        return createSilkTouchDispatchTable(p_250450_,
                this.applyExplosionDecay(p_250450_,
                        LootItem.lootTableItem(p_249745_)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
