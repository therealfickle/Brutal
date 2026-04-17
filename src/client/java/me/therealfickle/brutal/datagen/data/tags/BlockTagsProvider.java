package me.therealfickle.brutal.datagen.data.tags;

import me.therealfickle.brutal.init.BrutalBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class BlockTagsProvider extends FabricTagProvider.BlockTagProvider {
    public BlockTagsProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BrutalBlocks.INDUSTRIAL_CONCRETE)
                .add(BrutalBlocks.INDUSTRIAL_CONCRETE_TILE)
                .add(BrutalBlocks.INDUSTRIAL_CONCRETE_BRICKS);
        valueLookupBuilder(BlockTags.NEEDS_STONE_TOOL)

                .add(BrutalBlocks.INDUSTRIAL_CONCRETE)
                .add(BrutalBlocks.INDUSTRIAL_CONCRETE_TILE)
                .add(BrutalBlocks.INDUSTRIAL_CONCRETE_BRICKS);
        valueLookupBuilder(BlockTags.MINEABLE_WITH_SHOVEL);
    }
}
