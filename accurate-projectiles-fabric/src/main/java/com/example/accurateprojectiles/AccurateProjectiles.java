package com.example.accurateprojectiles;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class AccurateProjectiles implements ModInitializer {
    public static final String MOD_ID = "accurate_projectiles";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Accurate Projectiles loaded; only player-thrown pearls, wind charges, and potions have launch spread removed.");
    }
}
