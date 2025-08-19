package com.example.orbit_tracker_v1.service;

import com.example.orbit_tracker_v1.config.CelestrakProperties;
import com.example.orbit_tracker_v1.config.SpaceTrackProperties;
import com.example.orbit_tracker_v1.model.CelestrakTLEData;
import com.example.orbit_tracker_v1.model.GpData;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CelestrakServiceImpl implements CelestrakService {

    private final RestTemplate restTemplate;
    private final CelestrakProperties props;

    public CelestrakServiceImpl(
            @Qualifier("celestrakRestTemplate") RestTemplate restTemplate,
            CelestrakProperties props) {
        this.restTemplate = restTemplate;
        this.props = props;
    }

    @Override
    public List<CelestrakTLEData> fetchTLEData() {

        // Prepare headers to accept JSON
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "text/plain");
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        // Call the JSON endpoint and map into List<GpData>
        ResponseEntity<String> response = restTemplate.exchange(
                props.getQueryPath(),
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {
                }
        );
        String payload = response.getBody();

        List<CelestrakTLEData> tleList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new StringReader(payload));

        String name, line1, line2;
        try {
            while ((name = reader.readLine()) != null &&
                    (line1 = reader.readLine()) != null &&
                    (line2 = reader.readLine()) != null) {
                tleList.add(new CelestrakTLEData(name.trim(), line1.trim(), line2.trim()));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return tleList;
    }
}
