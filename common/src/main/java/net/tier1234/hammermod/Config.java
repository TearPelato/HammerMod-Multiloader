package net.tier1234.hammermod;

import com.mrcrayfish.framework.api.config.ConfigProperty;
import com.mrcrayfish.framework.api.config.ConfigType;
import com.mrcrayfish.framework.api.config.FrameworkConfig;
import com.mrcrayfish.framework.api.config.IntProperty;

public class Config {

    @FrameworkConfig(id = Constants.MOD_ID, name = "client", type = ConfigType.CLIENT)
    public static final Client CLIENT = new Client();

    public static class Client {

        @ConfigProperty(name = "VeinMiner Range", comment = """
                Defines the maximun range of veinminer enchant. Here to define the max area of similiar blocks,  
                the enchant can break
                """)
        public final IntProperty veinminerRange = IntProperty.create(10, 1, 225);

    }
}
