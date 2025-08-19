package com.example.orbit_tracker_v1.config.common;

public interface ExternalServiceProperties {
    String getBaseUrl();
    String getQueryPath();
    Timeouts getTimeouts();
}
