package naftoreiclag.stampedcash;

import java.util.logging.Logger;

import org.bukkit.Server;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class StampedCashPlugin extends JavaPlugin
{
	private static StampedCashPlugin instance;
	public static StampedCashPlugin getInstance() { return instance; }
	public StampedCashPlugin() { instance = this; }

	public Server server;
	public Logger logger;
	public PluginManager pluginManager;
	
	@Override
    public void onEnable()
	{
		server = this.getServer();
		logger = this.getLogger();
		pluginManager = server.getPluginManager();
		
		
    }
}
