package com.example.orbit_tracker_v1.config;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "external.celestrak")
public class CelestrakProperties {
    @Setter
    private String baseUrl;
    @Setter
    private String queryPath;
    private Timeouts timeouts = new Timeouts();

    public static class Timeouts {
        private int connect;
        private int read;

        public int getConnect() { return connect; }
        public void setConnect(int connect) { this.connect = connect; }
        public int getRead() { return read; }
        public void setRead(int read) { this.read = read; }
    }

    public String getBaseUrl() { return baseUrl; }

    public String getQueryPath() { return queryPath; }

    public Timeouts getTimeouts() { return this.timeouts; }
}
