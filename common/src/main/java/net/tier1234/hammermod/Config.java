package net.tier1234.hammermod;

import com.mrcrayfish.framework.api.config.*;

public class Config {

    @FrameworkConfig(id = Constants.MOD_ID, name = "client", type = ConfigType.CLIENT)
    public static final Client CLIENT = new Client();

    public static class Client {

        @ConfigProperty(name = "VeinMiner Range", comment = """
                Defines the maximum range of veinminer enchant. Here to define the max area of similar blocks,
                the enchant can break.
                """)
        public final IntProperty veinminerRange = IntProperty.create(10, 1, 225);

        @ConfigProperty(name = "Magnet Radius", comment = """
            Defines the radius in blocks within which the Magnet enchant attracts nearby item drops.
            Higher values may have a minor impact on performance in item-dense areas.
            """)
        public final DoubleProperty magnetRadius = DoubleProperty.create(8, 1, 32.5);

        @ConfigProperty(name = "Show Hammer Overlay", comment = """
                Whether to display the hammer area overlay when holding a hammer tool.
                This is a purely visual feature and belongs on the client side.
                """)
        public final BoolProperty showHammerOverlay = BoolProperty.create(true);

        @ConfigProperty(name = "VeinMiner Break Any Block", comment = """
                If enabled, VeinMiner will chain-break any connected block of the same type,
                not just ore veins. Use with caution as it may impact server performance on large deposits.
                This is server-side as it affects block-breaking logic and world state.
                """)
        public final BoolProperty veinminerBreakAnyBlock = BoolProperty.create(false);


    }
}