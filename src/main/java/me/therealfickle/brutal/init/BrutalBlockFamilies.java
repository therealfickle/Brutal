package me.therealfickle.brutal.init;

import net.minecraft.data.BlockFamily;
import net.minecraft.world.level.block.Blocks;

import static net.minecraft.data.BlockFamilies.familyBuilder;

public interface BrutalBlockFamilies {
    public static final BlockFamily INDUSTRIAL_CONCRETE = familyBuilder(BrutalBlocks.INDUSTRIAL_CONCRETE)
            .slab(BrutalBlocks.INDUSTRIAL_CONCRETE_SLAB)
            .stairs(BrutalBlocks.INDUSTRIAL_CONCRETE_STAIRS)
            .getFamily();
}
