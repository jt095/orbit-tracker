package com.example.orbit_tracker_v1.service;

import com.example.orbit_tracker_v1.config.SpaceTrackProperties;
import com.example.orbit_tracker_v1.model.GpData;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class SpaceTrackServiceImpl implements SpaceTrackService {

    private final RestTemplate restTemplate;
    private final SpaceTrackProperties props;

    public SpaceTrackServiceImpl(RestTemplate restTemplate,
                                 SpaceTrackProperties props) {
        this.restTemplate = restTemplate;
        this.props = props;
    }

    @Override
    public List<GpData> fetchGpData() {
        // Login
        MultiValueMap<String, String> creds = new LinkedMultiValueMap<>();
        creds.add("identity", props.getUsername());
        creds.add("password", props.getPassword());
        restTemplate.postForEntity(props.getAuthPath(), creds, String.class);

        // Prepare headers to accept JSON
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        // Call the JSON endpoint and map into List<GpData>
        ResponseEntity<List<GpData>> response = restTemplate.exchange(
                props.getQueryPath(),
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<List<GpData>>() {}
        );
        List<GpData> payload = response.getBody();

        // Logout
        restTemplate.getForEntity(props.getLogoutPath(), String.class);

        return payload;
    }
}
