package net.tier1234.hammermod;

import net.tearpelato.craftcorelib.api.config.ConfigCategory;
import net.tearpelato.craftcorelib.api.config.ConfigManager;
import net.tearpelato.craftcorelib.api.config.ConfigValue;

public class Config {

    public static final ConfigCategory GENERAL = ConfigCategory.create("general")
            .title("general");

    public static final ConfigValue<Integer> veinminerRange = GENERAL
            .define("veinminerRange",10)
            .range(0,250)
            .name("config.hammer_mod.veinminer")
            .comment("config.hammer_mod.veinminer.desc");





    public static void init() {
        ConfigManager.register(Constants.MOD_ID, GENERAL);
    }
}
