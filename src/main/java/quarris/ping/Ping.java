package quarris.ping;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("ping")
public class Ping {
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public static KeyBinding PingKey =
            new KeyBinding("key.ping", InputMappings.Type.MOUSE, 2, "keys.categories.multiplayer");

    public static CommonProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);

    public Ping() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupClient);
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            if (PingKey.isPressed()) {
                System.out.println("Pressed Key");
            }
        }
    }

    public void setupClient(FMLClientSetupEvent event) {
        proxy.setupClient();
    }
}
