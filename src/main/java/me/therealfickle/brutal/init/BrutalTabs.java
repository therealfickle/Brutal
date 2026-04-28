package me.therealfickle.brutal.init;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;

import static me.therealfickle.brutal.Brutal.id;

public interface BrutalTabs {
    static void init() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register((output) -> {
            output.addBefore(Blocks.BRICKS, BrutalBlocks.INDUSTRIAL_CONCRETE);
            output.addBefore(BrutalBlocks.INDUSTRIAL_CONCRETE, BrutalBlocks.INDUSTRIAL_CONCRETE_POWDER);
            output.addAfter(BrutalBlocks.INDUSTRIAL_CONCRETE_POWDER, BrutalBlocks.INDUSTRIAL_CONCRETE_BRICKS);
            output.addAfter(BrutalBlocks.INDUSTRIAL_CONCRETE_BRICKS, BrutalBlocks.INDUSTRIAL_CONCRETE_TILE);
            output.addAfter(BrutalBlocks.INDUSTRIAL_CONCRETE_TILE, BrutalBlocks.INDUSTRIAL_REBAR_CONCRETE);
            output.addAfter(BrutalBlocks.INDUSTRIAL_REBAR_CONCRETE, BrutalBlocks.INDUSTRIAL_CONCRETE_SLAB);
            output.addAfter(BrutalBlocks.INDUSTRIAL_CONCRETE_SLAB, BrutalBlocks.INDUSTRIAL_CONCRETE_STAIRS);
        });
    }

    static CreativeModeTab register(String name, CreativeModeTab tab) {
        return Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, id(name), tab);
    }
}
