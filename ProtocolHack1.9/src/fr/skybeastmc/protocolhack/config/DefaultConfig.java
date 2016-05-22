package fr.skybeastmc.protocolhack.config;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import fr.skybeastmc.protocolhack.Main;
import fr.skybeastmc.protocolhack.Variables;
import fr.skybeastmc.protocolhack.Version;

public class DefaultConfig {
	private static File file = new File(Main.getPlugin().getDataFolder(), "config.yml");
	private static Configuration config;
	
	public static void init() throws IOException {
		if(!file.exists()) {
			file.getParentFile().mkdirs();
			extractFromJar();
		}
		reload();
	}
	
	public static void extractFromJar() throws IOException {
		InputStream link = Main.getPlugin().getClass().getResourceAsStream("/config.yml");
	    Files.copy(link, file.getAbsoluteFile().toPath());
	}
	
	public static void reload() throws IOException {
		config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
		Variables.setFirstLine(config.getString("motd.firstLine"));
		Variables.setSecondLine(config.getString("motd.secondLine"));
		Variables.setPlayers(config.getStringList("motd.players"));
		Variables.setMaxPlayers(config.getInt("motd.maxPlayers"));
		Variables.setProtocolVersion(Version.getByName(config.getString("protocolhack.version")));
		Variables.setBadProtocolServerVersion(config.getString("protocolhack.badProtocolServerVersion"));
		Variables.setBadProtocolKickMessage(config.getString("protocolhack.badProtocolKickMessage"));
	}
	
	public static void save() throws IOException {
		config.set("motd.firstLine", Variables.getFirstLine());
		config.set("motd.secondLine", Variables.getSecondLine());
		config.set("motd.players", Variables.getPlayers());
		config.set("motd.maxPlayers", Variables.getMaxPlayers());
		config.set("protocolhack.version", Variables.getProtocolVersion().getName());
		config.set("protocolhack.badProtocolServerVersion", Variables.getBadProtocolServerVersion());
		config.set("protocolhack.badProtocolKickMessage", Variables.getBadProtocolKickMessage());
		ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
	}
	
	
	public static Configuration getConfig() {
		return config;
	}
	
	public static void setConfig(Configuration config) {
		DefaultConfig.config = config;
	}

	public static File getFile() {
		return file;
	}

}
