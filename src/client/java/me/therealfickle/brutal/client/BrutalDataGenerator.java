package me.therealfickle.brutal.client;

import me.therealfickle.brutal.Brutal;
import me.therealfickle.brutal.datagen.assets.ModelProvider;
import me.therealfickle.brutal.datagen.data.loot_table.BlockLootTables;
import me.therealfickle.brutal.datagen.data.recipe.BrutalRecipeProvider;
import me.therealfickle.brutal.datagen.data.tags.BlockTagsProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import org.jspecify.annotations.Nullable;

public class BrutalDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        // Assets
        pack.addProvider(ModelProvider::new);
        // Data
        pack.addProvider(BlockTagsProvider::new);
        pack.addProvider(BlockLootTables::new);
        pack.addProvider(BrutalRecipeProvider::new);

    }

    @Override
    public @Nullable String getEffectiveModId() {
        return Brutal.MODID;
    }

}
