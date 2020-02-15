package quarris.ping;

import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void setupClient() {
		ClientRegistry.registerKeyBinding(Ping.PingKey);
	}
}