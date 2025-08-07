package com.example.orbit_tracker_v1.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "external.space-track")
public class SpaceTrackProperties {
    private String baseUrl;
    private String authPath;
    private String queryPath;
    private String logoutPath;
    private String username;
    private String password;
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
    public void setBaseUrl(String baseUrl) { this.baseUrl = baseUrl; }
    public String getAuthPath() { return authPath; }
    public void setAuthPath(String authPath) { this.authPath = authPath; }
    public String getQueryPath() { return queryPath; }
    public void setQueryPath(String queryPath) { this.queryPath = queryPath; }
    public String getLogoutPath() { return logoutPath; }
    public void setLogoutPath(String logoutPath) { this.logoutPath = logoutPath; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Timeouts getTimeouts() { return this.timeouts; }
}
