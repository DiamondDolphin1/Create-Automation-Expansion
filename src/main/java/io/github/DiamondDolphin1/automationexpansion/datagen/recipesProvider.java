package io.github.DiamondDolphin1.automationexpansion.datagen;

import io.github.DiamondDolphin1.AutomationExpansion;
import io.github.DiamondDolphin1.init.BlockInit;
import io.github.DiamondDolphin1.init.ItemInit;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class recipesProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> RUBY_SMELTABLES = List.of(ItemInit.Raw_Ruby.get(),
            BlockInit.RUBY_ORE.get());
    public recipesProvider(PackOutput p_248933_) {
        super(p_248933_);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> p_251297_) {
        System.out.println(">>> Generating Recipes");
        oreSmelting(p_251297_, RUBY_SMELTABLES, RecipeCategory.MISC, ItemInit.Ruby.get(), 0.25f, 200, "ruby");
        oreBlasting(p_251297_, RUBY_SMELTABLES, RecipeCategory.MISC, ItemInit.Ruby.get(), 0.25f, 100, "ruby");
    }
    protected static void oreSmelting(Consumer<FinishedRecipe> p_250654_, List<ItemLike> p_250172_, RecipeCategory p_250588_, ItemLike p_251868_, float p_250789_, int p_252144_, String p_251687_) {
        oreCooking(p_250654_, RecipeSerializer.SMELTING_RECIPE, p_250172_, p_250588_, p_251868_, p_250789_, p_252144_, p_251687_, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> p_248775_, List<ItemLike> p_251504_, RecipeCategory p_248846_, ItemLike p_249735_, float p_248783_, int p_250303_, String p_251984_) {
        oreCooking(p_248775_, RecipeSerializer.BLASTING_RECIPE, p_251504_, p_248846_, p_249735_, p_248783_, p_250303_, p_251984_, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> p_250791_, RecipeSerializer<? extends AbstractCookingRecipe> p_251817_, List<ItemLike> p_249619_, RecipeCategory p_251154_, ItemLike p_250066_, float p_251871_, int p_251316_, String p_251450_, String p_249236_) {
        for(ItemLike itemlike : p_249619_) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), p_251154_, p_250066_,
                    p_251871_, p_251316_, p_251817_)
                    .group(p_251450_).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(p_250791_, AutomationExpansion.MODID + ":" + getItemName(p_250066_) + p_249236_ + "_" + getItemName(itemlike));
        }
}}
