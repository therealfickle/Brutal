package me.therealfickle.brutal;

import me.therealfickle.brutal.data.BrutalBlocks;
import me.therealfickle.brutal.data.BrutalItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Brutal implements ModInitializer {

    public static final String MODID = "brutal";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    @Override
    public void onInitialize() {
        BrutalItems.init();
        BrutalBlocks.init();
    }
    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MODID, path);
    }


}
