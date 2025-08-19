package com.example.orbit_tracker_v1.config;

import com.example.orbit_tracker_v1.config.common.ExternalServiceProperties;
import com.example.orbit_tracker_v1.config.common.Timeouts;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "external.celestrak")
public class CelestrakProperties implements ExternalServiceProperties{
    @Setter
    private String baseUrl;
    @Setter
    private String queryPath;
    private Timeouts timeouts = new Timeouts();

    public String getBaseUrl() { return baseUrl; }

    public String getQueryPath() { return queryPath; }

    public Timeouts getTimeouts() { return this.timeouts; }
}
