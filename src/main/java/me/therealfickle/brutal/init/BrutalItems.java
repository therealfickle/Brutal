package me.therealfickle.brutal.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import java.util.function.Function;

import static me.therealfickle.brutal.Brutal.id;

public interface BrutalItems {


    static void init() {

    }

    static Item register(String name, Item.Properties properties) {
        return register(name, Item::new, properties);
    }

    static Item register(String name, Function<Item.Properties, Item> function, Item.Properties properties) {
        var key = ResourceKey.create(Registries.ITEM, id(name));
        var item = function.apply(properties.setId(key));

        return Registry.register(BuiltInRegistries.ITEM, key.identifier(), item);
    }
}
