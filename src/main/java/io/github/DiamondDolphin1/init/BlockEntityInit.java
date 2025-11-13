package io.github.DiamondDolphin1.init;

import io.github.DiamondDolphin1.AutomationExpansion;
import io.github.DiamondDolphin1.automationexpansion.blockentity.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class BlockEntityInit {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, AutomationExpansion.MODID);

    public static final RegistryObject<BlockEntityType<TestBlockEntity>> TEST_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("test_block_entity",
                    () -> BlockEntityType.Builder.of(TestBlockEntity::new, BlockInit.TEST_BLOCK_ENTITY.get())
                            .build(null));

    public static final RegistryObject<BlockEntityType<ExampleTickingBlockEntity>> EXAMPLE_TICKING_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("example_ticking_block",
                    () -> BlockEntityType.Builder.of(ExampleTickingBlockEntity::new, BlockInit.EXAMPLE_TICKING_BLOCK.get())
                            .build(null));

    public static final RegistryObject<BlockEntityType<ExampleSyncedBlockEntity>> EXAMPLE_SYNCED_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("example_synced_block_entity",
                    () -> BlockEntityType.Builder.of(ExampleSyncedBlockEntity::new, BlockInit.EXAMPLE_SYNCED_BLOCK.get())
                            .build(null));

    public static final RegistryObject<BlockEntityType<ExampleScreenBlockEntity>> EXAMPLE_SCREEN_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("example_screen_block_entity",
                    () -> BlockEntityType.Builder.of(ExampleScreenBlockEntity::new, BlockInit.EXAMPLE_SCREEN_BLOCK.get())
                            .build(null));
}
