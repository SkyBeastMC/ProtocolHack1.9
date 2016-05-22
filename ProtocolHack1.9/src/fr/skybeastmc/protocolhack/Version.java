package fr.skybeastmc.protocolhack;

public enum Version {
	v1_9("1.9", 107, new String[] {"1.9", "1.9.1-pre1"}),
	v1_9_1("1.9.1", 108, new String[] {"1.9.1-pre2", "1.9.1-pre3", "1.9.1"}),
	v1_9_2("1.9.2", 109, new String[] {"1.9.2", "16w14a", "16w15a", "16w15b", "1.9.3-pre1"}),
	v1_9_3("1.9.3", 110, new String[] {"1.9.3-pre2", "1.9.3-pre3", "1.9.3", "1.9.4"}),
	v1_9_4("1.9.4", 110, new String[] {"1.9.3-pre2", "1.9.3-pre3", "1.9.3", "1.9.4"});
	
	private String name;
	private int protocol;
	private String[] sharedProtocolVersions;
	
	private Version(String name, int protocol, String[] sharedProtocolVersions) {
		this.name = name;
		this.protocol = protocol;
		this.sharedProtocolVersions = sharedProtocolVersions;
	}

	public String getName() {
		return name;
	}

	public int getProtocol() {
		return protocol;
	}
	
	public String[] getSharedProtocolVersions() {
		return sharedProtocolVersions;
	}
	
	@Override
	public String toString() {
		return name+":"+protocol;
	}
	
	
	public static Version getByName(String version) {
		for(Version v : values()) {
			if(v.getName().equals(version)) {
				return v;
			}
		}
		return null;
	}
	
	public static Version getByProtocol(int protocol) {
		for(Version v : values()) {
			if(v.getProtocol() == protocol) {
				return v;
			}
		}
		return null;
	}
	
}
