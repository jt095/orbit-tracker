package com.example.orbit_tracker_v1.controller;

import com.example.orbit_tracker_v1.model.CelestrakTLEData;
import com.example.orbit_tracker_v1.model.GpData;
import com.example.orbit_tracker_v1.service.CelestrakService;
import com.example.orbit_tracker_v1.service.SpaceTrackService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/starlink")
@CrossOrigin(origins = "http://localhost:5173") // Vite default port
public class CelestrakController {

    private final CelestrakService service;

    public CelestrakController(CelestrakService service) {
        this.service = service;
    }

    @GetMapping
    public List<CelestrakTLEData> getTLEData() {
        return service.fetchTLEData();
    }
}
