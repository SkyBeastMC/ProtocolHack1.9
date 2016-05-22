package fr.skybeastmc.protocolhack.commands;

import java.io.IOException;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;
import fr.skybeastmc.protocolhack.Variables;
import fr.skybeastmc.protocolhack.config.DefaultConfig;

public class MOTDCommand extends Command {
	private static final String COMMAND = "motd";
	private static final String PERMISSION = "motd.set";

	public MOTDCommand() {
		super(COMMAND, PERMISSION);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if(args.length == 0) {
			sender.sendMessage(new TextComponent("§cUsage: /"+COMMAND+" {motd}"));
			return;
		}
		
		StringBuilder builder = new StringBuilder();
		for(String s : args)
		    builder.append(s+" ");
		String motd = builder.toString();
		
		Variables.setSecondLine(motd);
		try {
			DefaultConfig.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
