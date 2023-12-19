package io.runescape.test;

import io.runescape.Server;
import io.runescape.ServerConfiguration;
import io.runescape.ServerState;

import java.io.IOException;

public class TestServerConfiguration {

    /**
     * Loads the server configuration normally and then sets the
     * {@link ServerState} as specified.
     */
    public static ServerConfiguration getConfiguration(ServerState serverState) {
        try {
            ServerConfiguration configuration = Server.loadConfiguration();
            configuration.setServerState(serverState);
            return configuration;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
