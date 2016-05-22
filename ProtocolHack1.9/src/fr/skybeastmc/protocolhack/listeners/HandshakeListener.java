package fr.skybeastmc.protocolhack.listeners;

import java.net.InetSocketAddress;

import net.md_5.bungee.api.event.PlayerHandshakeEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import fr.skybeastmc.protocolhack.Variables;
import fr.skybeastmc.protocolhack.Version;

public class HandshakeListener implements Listener {
	
	@EventHandler
	public void onPlayerHandshake(PlayerHandshakeEvent event) {
		Version version = Version.getByProtocol(event.getHandshake().getProtocolVersion());
		InetSocketAddress address = event.getConnection().getAddress();
		
		switch(event.getHandshake().getRequestedProtocol()) {
		case 1:
			if(version != null) System.out.println("["+address.toString()+"] Pingged in with version "
					+version.getName()+" ("+version.getProtocol()+")");
			else System.out.println("["+address.toString()+"] Pingged in with a bad version");
			break;
		case 2:
			/*if(version == null) {
				System.out.println("["+address.toString()+"] Disconnected: bad version");
				event.getConnection().disconnect(new TextComponent(Variables.getBadProtocolKickMessage()));
			} else {
				System.out.println("["+address.toString()+"] Is using protocol version "
						+version.getName()+" ("+version.getProtocol()+")");*/
			if(version != null)
				event.getHandshake().setProtocolVersion(Variables.getProtocolVersion().getProtocol());
			//}
			break;
		}
		
	}
}
