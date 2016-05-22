package fr.skybeastmc.protocolhack;

import java.io.IOException;

import net.md_5.bungee.api.plugin.Plugin;
import fr.skybeastmc.protocolhack.commands.MOTDCommand;
import fr.skybeastmc.protocolhack.config.DefaultConfig;
import fr.skybeastmc.protocolhack.listeners.HandshakeListener;
import fr.skybeastmc.protocolhack.listeners.PostLoginListener;
import fr.skybeastmc.protocolhack.listeners.ProxyPingListener;

public class Main extends Plugin {
	private static Plugin plugin;
	
	public void onEnable() {
		plugin = this;
		getProxy().getPluginManager().registerListener(this, new HandshakeListener());
		getProxy().getPluginManager().registerListener(this, new ProxyPingListener());
		getProxy().getPluginManager().registerListener(this, new PostLoginListener());
		getProxy().getPluginManager().registerCommand(this, new MOTDCommand());
		
		try {
			DefaultConfig.init();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(Variables.getProtocolVersion() != null)
			System.out.println("Servers are version " + Variables.getProtocolVersion().getName()
					+ " (" + Variables.getProtocolVersion().getProtocol()+")");
	}
	
	public void onDisable() {}

	public static Plugin getPlugin() {
		return plugin;
	}
}
