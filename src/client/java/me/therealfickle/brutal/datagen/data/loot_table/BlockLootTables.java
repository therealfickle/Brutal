package me.therealfickle.brutal.datagen.data.loot_table;

import me.therealfickle.brutal.init.BrutalBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class BlockLootTables extends FabricBlockLootTableProvider {

    public BlockLootTables(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        dropSelf(BrutalBlocks.INDUSTRIAL_CONCRETE);
        dropSelf(BrutalBlocks.INDUSTRIAL_CONCRETE_TILE);
        dropSelf(BrutalBlocks.INDUSTRIAL_CONCRETE_BRICKS);
        dropSelf(BrutalBlocks.INDUSTRIAL_CONCRETE_POWDER);
    }
}
