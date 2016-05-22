package fr.skybeastmc.protocolhack.listeners;

import java.net.InetSocketAddress;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import fr.skybeastmc.protocolhack.Variables;
import fr.skybeastmc.protocolhack.Version;

public class PostLoginListener implements Listener {
	
	@EventHandler
	public void onPostLogin(PostLoginEvent event) {
		Version version = Version.getByProtocol(event.getPlayer().getPendingConnection().getVersion());
		InetSocketAddress address = event.getPlayer().getPendingConnection().getAddress();

		System.out.println("["+address.toString()+"] My name is "+event.getPlayer().getName()+"!");
		
		if(version == null) {
			System.out.println("["+address.toString()+"] Disconnected: bad version");
			event.getPlayer().disconnect(new TextComponent(Variables.getBadProtocolKickMessage()));
		}
		
		/*switch(event.getHandshake().getRequestedProtocol()) {
		case 1:
			if(version != null) System.out.println("["+address.toString()+"] Pingged in with version "
					+version.getName()+" ("+version.getProtocol()+")");
			else System.out.println("["+address.toString()+"] Pingged in with a bad version");
			break;
		case 2:
			if(version == null) {
				System.out.println("["+address.toString()+"] Disconnected: bad version");
				event.getConnection().disconnect(new TextComponent(Variables.getBadProtocolKickMessage()));
			} else {
				System.out.println("["+address.toString()+"] Is using protocol version "
						+version.getName()+" ("+version.getProtocol()+")");
				event.getHandshake().setProtocolVersion(Version.SERVER.getProtocol());
			}
			break;
		}*/
		
	}
}
