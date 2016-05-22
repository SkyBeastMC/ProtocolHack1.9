package fr.skybeastmc.protocolhack.listeners;

import java.util.UUID;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.ServerPing.PlayerInfo;
import net.md_5.bungee.api.ServerPing.Players;
import net.md_5.bungee.api.ServerPing.Protocol;
import net.md_5.bungee.api.connection.PendingConnection;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import fr.skybeastmc.protocolhack.Variables;
import fr.skybeastmc.protocolhack.Version;

public class ProxyPingListener implements Listener {
	
	@EventHandler
	public void onProxyPing(ProxyPingEvent event) {
		Version version = Version.getByProtocol(event.getConnection().getVersion());
		
		PendingConnection address = event.getConnection();
		ServerPing response = event.getResponse();
		response.setDescription(Variables.getFirstLine()+"\n"+Variables.getSecondLine());

		PlayerInfo[] infos = new PlayerInfo[Variables.getPlayers().size()];
		int i = 0;
		for(String player : Variables.getPlayers()) {
			infos[i] = new PlayerInfo(player, UUID.randomUUID());
			i++;
		}
		
		Players players = new Players(Variables.getMaxPlayers(), ProxyServer.getInstance().getOnlineCount(), infos);
		
		response.setPlayers(players);
		if(version == null) {
			response.setVersion(new Protocol(Variables.getBadProtocolServerVersion(), 0));
			System.out.println("["+address.toString()+"] Pingged in with a bad version");
		} else {
			System.out.println("["+address.toString()+"] Pingged in with version "
					+version.getName()+" ("+version.getProtocol()+")");
		}
	}
}
