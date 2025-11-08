package io.github.DiamondDolphin1.automationexpansion.datagen;

import io.github.DiamondDolphin1.AutomationExpansion;
import io.github.DiamondDolphin1.init.BlockInit;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class blockstatesProvider extends BlockStateProvider {
    public blockstatesProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, AutomationExpansion.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        System.out.println(">>> Generating Block State");
            blockwithItem(BlockInit.RAW_RUBY_BLOCK);
            blockwithItem(BlockInit.RUBY_BLOCK);
            blockwithItem(BlockInit.RUBY_ORE);
    }

    private void blockwithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()
        ));
    }
}
