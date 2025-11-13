package io.github.DiamondDolphin1.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ItemInit
{
public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "automationexpansion");

public static void register(IEventBus bus) {
    ITEMS.register(bus);
}

public static final RegistryObject<Item> Netherite_Shrapnel = ITEMS.register("netherite_shrapnel",
        () -> new Item(new Item.Properties()
                .rarity(Rarity.RARE)
                .stacksTo(16)
        ));

public static final RegistryObject<Item> Diamond_Shards = ITEMS.register("diamond_shards",
        () -> new Item(new Item.Properties()
                .rarity(Rarity.UNCOMMON)
        ));

public static final RegistryObject<Item> Coal_Chunks = ITEMS.register("coal_chunks",
        () -> new Item(new Item.Properties()
                .rarity(Rarity.COMMON)
        ));

public static final RegistryObject<Item> Ruby = ITEMS.register("ruby",
        () -> new Item(new Item.Properties()
                .rarity(Rarity.COMMON)
        ));

public static final RegistryObject<Item> Crushed_Ruby = ITEMS.register("crushed_ruby",
        () -> new Item(new Item.Properties()
                .rarity(Rarity.COMMON)
        ));
public static final RegistryObject<Item> Fluorite_Crystals = ITEMS.register("fluorite_crystals",
        () -> new Item(new Item.Properties()
                .rarity(Rarity.RARE)
        ));
    public static final RegistryObject<Item> Raw_Ruby = ITEMS.register("raw_ruby",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.COMMON)
            ));

    public static final RegistryObject<BlockItem> Ruby_Block_Item = ITEMS.register("ruby_block",
        () -> new BlockItem(BlockInit.RUBY_BLOCK.get(),
                new Item.Properties()
                    .rarity(Rarity.COMMON)
        ));

public static final RegistryObject<Item> Crystalite_Bud_Seeds = ITEMS.register("crystalite_seeds",
        () -> new ItemNameBlockItem(BlockInit.CRYSTALITE_BUD.get(), new Item.Properties()
                .rarity(Rarity.UNCOMMON)
        ));

public static final RegistryObject<Item> Crystalite_Budding = ITEMS.register("crystalite_budding",
        () -> new Item(new Item.Properties()
                .rarity(Rarity.UNCOMMON)
        ));
public static final RegistryObject<Item> Raw_Ruby_Block_Item = ITEMS.register("raw_ruby_block",
        () -> new BlockItem(BlockInit.RAW_RUBY_BLOCK.get(),
                new Item.Properties()
                        .rarity(Rarity.COMMON)
        ));
public static final RegistryObject<BlockItem> Test_Block_Entity = ITEMS.register("test_block_entity",
        () -> new BlockItem(BlockInit.TEST_BLOCK_ENTITY.get(),
                new Item.Properties()
                        .rarity(Rarity.COMMON)
));

public static final RegistryObject<BlockItem> Example_Ticking_Block = ITEMS.register("example_ticking_block",
        () -> new BlockItem(BlockInit.EXAMPLE_TICKING_BLOCK.get(),
                new Item.Properties()
                        .rarity(Rarity.COMMON)
        ));

public static final RegistryObject<BlockItem> Example_Synced_Block = ITEMS.register("example_synced_block",
        () -> new BlockItem(BlockInit.EXAMPLE_SYNCED_BLOCK.get(),
                new Item.Properties()
                        .rarity(Rarity.COMMON)
        ));

public static final RegistryObject<BlockItem> Example_Screen_Block = ITEMS.register("example_screen_block",
        () -> new BlockItem(BlockInit.EXAMPLE_SCREEN_BLOCK.get(),
                new Item.Properties()
                        .rarity(Rarity.COMMON)
        ));
 }