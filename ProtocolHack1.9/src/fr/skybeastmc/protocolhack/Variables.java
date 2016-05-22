package fr.skybeastmc.protocolhack;

import java.util.ArrayList;
import java.util.List;

public class Variables {
	private static String firstLine;
	private static String secondLine;
	private static List<String> players;
	private static int maxPlayers;
	private static Version protocolVersion;
	private static String badProtocolServerVersion;
	private static String badProtocolKickMessage;
	
	public static String getFirstLine() {
		return firstLine;
	}
	
	public static void setFirstLine(String firstLine) {
		Variables.firstLine = firstLine.replace("&", "§");
	}

	public static String getSecondLine() {
		return secondLine;
	}

	public static void setSecondLine(String secondLine) {
		Variables.secondLine = secondLine.replace("&", "§");
	}

	public static List<String> getPlayers() {
		return players;
	}

	public static void setPlayers(Iterable<String> players) {
		Variables.players = new ArrayList<String>();
		for(String s : players) {
			Variables.players.add(s.replace("&", "§"));
		}
	}

	public static int getMaxPlayers() {
		return maxPlayers;
	}

	public static void setMaxPlayers(int maxPlayers) {
		Variables.maxPlayers = maxPlayers;
	}

	public static Version getProtocolVersion() {
		return protocolVersion;
	}

	public static void setProtocolVersion(Version protocolVersion) {
		if(protocolVersion == null) {
			System.out.println("Protocol Version not found!");
		}
		Variables.protocolVersion = protocolVersion;
	}

	public static String getBadProtocolServerVersion() {
		return badProtocolServerVersion;
	}

	public static void setBadProtocolServerVersion(String badProtocolServerVersion) {
		Variables.badProtocolServerVersion = badProtocolServerVersion.replace("&", "§");
	}

	public static String getBadProtocolKickMessage() {
		return badProtocolKickMessage;
	}

	public static void setBadProtocolKickMessage(String badProtocolKickMessage) {
		Variables.badProtocolKickMessage = badProtocolKickMessage.replace("&", "§").replace("\\n", "\n");
	}

}
