package io.runescape.test;

import io.runescape.Server;
import io.runescape.ServerConfiguration;
import io.runescape.ServerState;

public class ServerTest {

    private final ServerConfiguration configuration;

    public ServerTest(ServerConfiguration configuration) {
        this.configuration = configuration;
        try {
            Server.startServerless(configuration);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ServerTest(ServerState serverState) {
        this(TestServerConfiguration.getConfiguration(serverState));
    }

    public ServerConfiguration getConfiguration() {
        return configuration;
    }
}
