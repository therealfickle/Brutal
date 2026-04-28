package me.therealfickle.brutal.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Function;

import static me.therealfickle.brutal.Brutal.id;

public interface BrutalBlocks {

    Block INDUSTRIAL_CONCRETE = register("industrial_concrete", Block::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_LIGHT_GRAY)
                    .requiresCorrectToolForDrops()
                    .strength(1.8f, 1.8f)
                    .sound(SoundType.STONE)
                    .instrument(NoteBlockInstrument.SNARE)
    );
    Block INDUSTRIAL_CONCRETE_SLAB = register("industrial_concrete_slab", SlabBlock::new,
            BlockBehaviour.Properties.ofFullCopy(INDUSTRIAL_CONCRETE));
    Block INDUSTRIAL_CONCRETE_STAIRS = registerStair("industrial_concrete_stairs", INDUSTRIAL_CONCRETE);
    Block INDUSTRIAL_CONCRETE_TILE = register("industrial_concrete_tile", Block::new,
            BlockBehaviour.Properties.ofFullCopy(INDUSTRIAL_CONCRETE));
    Block INDUSTRIAL_CONCRETE_BRICKS = register("industrial_concrete_bricks", Block::new,
            BlockBehaviour.Properties.ofFullCopy(INDUSTRIAL_CONCRETE));
    Block INDUSTRIAL_CONCRETE_POWDER = register("industrial_concrete_powder", block -> new ConcretePowderBlock(INDUSTRIAL_CONCRETE, block),
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE_POWDER));
    Block INDUSTRIAL_REBAR_CONCRETE = register("industrial_rebar_concrete", RotatedPillarBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_LIGHT_GRAY)
                    .requiresCorrectToolForDrops()
                    .strength(2f, 6f)
                    .sound(SoundType.STONE)
                    .instrument(NoteBlockInstrument.SNARE)
    );

    static Block registerNoItem(String name, Function<BlockBehaviour.Properties, Block> function, BlockBehaviour.Properties properties) {
        var key = ResourceKey.create(Registries.BLOCK, id(name));
        var block = function.apply(properties.setId(key));

        return Registry.register(BuiltInRegistries.BLOCK, id(name), block);
    }

    static void init() {

    }

    static Block register(String name, Function<BlockBehaviour.Properties, Block> function, BlockBehaviour.Properties properties) {
        var regBlock = registerNoItem(name, function, properties);
        BrutalItems.register(name, (params) -> new BlockItem(regBlock, params), new Item.Properties());

        return regBlock;
    }


    private static Block registerStair(String string, Block block) {
        return register(string, properties -> new StairBlock(block.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(block));
    }
}
