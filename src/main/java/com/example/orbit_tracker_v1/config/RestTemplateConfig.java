package com.example.orbit_tracker_v1.config;

import java.time.Duration;

import com.example.orbit_tracker_v1.config.common.ExternalServiceProperties;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.cookie.BasicCookieStore;
import org.apache.hc.client5.http.config.RequestConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    @Qualifier("spaceTrackRestTemplate")
    public RestTemplate spaceTrackRestTemplate(SpaceTrackProperties props) {
        return buildRestTemplate(props);
    }

    @Bean
    @Qualifier("celestrakRestTemplate")
    public RestTemplate celestrakRestTemplate(CelestrakProperties props) {
        return buildRestTemplate(props);
    }

    public RestTemplate buildRestTemplate(ExternalServiceProperties props) {
        // build a RequestConfig with timeouts
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(props.getTimeouts().getConnect(), java.util.concurrent.TimeUnit.MILLISECONDS)
                .setResponseTimeout(props.getTimeouts().getRead(),   java.util.concurrent.TimeUnit.MILLISECONDS)
                .build();

        // keep cookies between calls
        BasicCookieStore cookieStore = new BasicCookieStore();
        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .setDefaultCookieStore(cookieStore)
                .build();

        HttpComponentsClientHttpRequestFactory factory =
                new HttpComponentsClientHttpRequestFactory(httpClient);

        // wire into RestTemplate with a root URI
        return new RestTemplateBuilder()
                .rootUri(props.getBaseUrl())
                .requestFactory(() -> factory)
                .connectTimeout(Duration.ofMillis(props.getTimeouts().getConnect()))
                .readTimeout(Duration.ofMillis(props.getTimeouts().getRead()))
                .build();
    }
}
