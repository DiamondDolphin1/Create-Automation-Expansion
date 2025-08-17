package io.github.DiamondDolphin1.automationexpansion.datagen;

import io.github.DiamondDolphin1.AutomationExpansion;
import io.github.DiamondDolphin1.init.BlockInit;
import io.github.DiamondDolphin1.init.TagsInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, AutomationExpansion.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider p_256380_) {
        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(BlockInit.RUBY_ORE.get(),
                        BlockInit.RAW_RUBY_BLOCK.get(),
                        BlockInit.RUBY_BLOCK.get()
                );


        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BlockInit.RUBY_ORE.get(),
                        BlockInit.RUBY_BLOCK.get(),
                        BlockInit.RAW_RUBY_BLOCK.get()
                );
    }
}
