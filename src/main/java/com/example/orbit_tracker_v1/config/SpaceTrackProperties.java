package com.example.orbit_tracker_v1.config;

import com.example.orbit_tracker_v1.config.common.ExternalServiceProperties;
import com.example.orbit_tracker_v1.config.common.Timeouts;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "external.space-track")
public class SpaceTrackProperties implements ExternalServiceProperties {
    @Setter
    private String baseUrl;
    @Setter
    private String authPath;
    @Setter
    private String queryPath;
    @Setter
    private String logoutPath;
    @Setter
    private String username;
    @Setter
    private String password;
    private Timeouts timeouts = new Timeouts();

    public String getBaseUrl() { return baseUrl; }

    public String getAuthPath() { return authPath; }

    public String getQueryPath() { return queryPath; }

    public String getLogoutPath() { return logoutPath; }

    public String getUsername() { return username; }

    public String getPassword() { return password; }

    public Timeouts getTimeouts() { return this.timeouts; }
}
