package io.github.DiamondDolphin1.init;

import io.github.DiamondDolphin1.automationexpansion.block.custom.CrystaliteBudBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "automationexpansion");

    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .strength(5.0f, 6f )
                    .requiresCorrectToolForDrops()
            ));
    public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore",
            () -> new Block(BlockBehaviour.Properties.of()

            ));
    public static final RegistryObject<Block> RAW_RUBY_BLOCK = BLOCKS.register("raw_ruby_block",
            () -> new Block(BlockBehaviour.Properties.of()

            ));

    public static final RegistryObject<Block> CRYSTALITE_BUD = BLOCKS.register("crystalite_bud",
            () -> new CrystaliteBudBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)
                    .noOcclusion()
                    .noCollission()
            ));
}
