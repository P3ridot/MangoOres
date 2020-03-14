package peridot.mangoores;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

@Mod("mangoores")
public class MangoOres {

    public static final String MOD_ID = "mangoores";
    public static final String MOD_NAME = "MangoOres";

    private static final Logger LOGGER = LogManager.getLogger();

    private static MangoOres INSTANCE;
    private static SideProxy PROXY;

    public MangoOres() {
        INSTANCE = this;
        PROXY = DistExecutor.runForDist(() -> () -> new SideProxy.Client(), () -> () -> new SideProxy.Server());
    }

    public static String getVersion() {
        Optional<? extends ModContainer> o = ModList.get().getModContainerById(MOD_ID);
        if (o.isPresent()) {
            return o.get().getModInfo().getVersion().toString();
        }
        return "NONE";
    }

    public static boolean isDevBuild() {
        return "NONE".equals(getVersion());
    }


    public static ResourceLocation getId(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    public static Logger getLogger() {
        return LOGGER;
    }

    public static MangoOres getInstance() {
        return INSTANCE;
    }

    public static SideProxy getProxy() {
        return PROXY;
    }
}
