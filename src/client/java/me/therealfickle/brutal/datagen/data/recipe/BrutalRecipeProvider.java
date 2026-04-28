package me.therealfickle.brutal.datagen.data.recipe;

import me.therealfickle.brutal.init.BrutalBlockFamilies;
import me.therealfickle.brutal.init.BrutalBlocks;
import me.therealfickle.brutal.init.BrutalItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class BrutalRecipeProvider extends FabricRecipeProvider {
    public BrutalRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> lookup) {
        super(output, lookup);
    }

    @Override
    protected net.minecraft.data.recipes.@NonNull RecipeProvider createRecipeProvider(HolderLookup.@NonNull Provider lookup, @NonNull RecipeOutput exporter) {
        return new BrutalRecipeGen(lookup, exporter);
    }

    @Override
    public @NonNull String getName() {
        return "Brutal recipes";
    }


    public static class BrutalRecipeGen extends RecipeProvider {
        protected BrutalRecipeGen(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            super(provider, recipeOutput);
        }

        @Override
        public void buildRecipes() {
            // RECIPE HERE !!!!
            // Check "VanillaRecipeProvider.class" to see how vanilla does things
            shapeless(RecipeCategory.BUILDING_BLOCKS, BrutalBlocks.INDUSTRIAL_CONCRETE_POWDER, 8)
                    .requires(Blocks.SAND, 4)
                    .requires(Blocks.GRAVEL, 4)
                    .group("concrete_powder") // optional
                    .unlockedBy("has_sand", has(Blocks.SAND)) // optional
                    .unlockedBy("has_gravel", has(Blocks.GRAVEL)) // optional
                    .save(output);
            shaped(RecipeCategory.BUILDING_BLOCKS, BrutalBlocks.INDUSTRIAL_REBAR_CONCRETE, 8)
                    .define('#', BrutalBlocks.INDUSTRIAL_CONCRETE)
                    .define('X', Blocks.IRON_BARS)
                    .pattern("#X#")
                    .pattern("#X#")
                    .pattern("#X#")
                    .unlockedBy("has_industrial_concrete", has(BrutalBlocks.INDUSTRIAL_CONCRETE)) // optional
                    .unlockedBy("has_iron_bars", has(Blocks.IRON_BARS)) // optional
                    .save(output);
            ;
            stonecutterResultFromBase(
                    RecipeCategory.BUILDING_BLOCKS,
                    /* output */ BrutalBlocks.INDUSTRIAL_CONCRETE_TILE,
                    /* input */ BrutalBlocks.INDUSTRIAL_CONCRETE
            );
            stonecutterResultFromBase(
                    RecipeCategory.BUILDING_BLOCKS,
                    /* output */ BrutalBlocks.INDUSTRIAL_CONCRETE_BRICKS,
                    /* input */ BrutalBlocks.INDUSTRIAL_CONCRETE
            );
            stonecutterResultFromBase(
                    RecipeCategory.BUILDING_BLOCKS,
                    /* output */ BrutalBlocks.INDUSTRIAL_CONCRETE_SLAB,
                    /* input */ BrutalBlocks.INDUSTRIAL_CONCRETE
            );
            stonecutterResultFromBase(
                    RecipeCategory.BUILDING_BLOCKS,
                    /* output */ BrutalBlocks.INDUSTRIAL_CONCRETE_STAIRS,
                    /* input */ BrutalBlocks.INDUSTRIAL_CONCRETE
            );
            generateRecipes(BrutalBlockFamilies.INDUSTRIAL_CONCRETE, FeatureFlagSet.of(FeatureFlags.VANILLA));


        }
    }

}
