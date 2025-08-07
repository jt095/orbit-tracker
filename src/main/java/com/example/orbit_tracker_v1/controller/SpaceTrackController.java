package com.example.orbit_tracker_v1.controller;

import com.example.orbit_tracker_v1.model.GpData;
import com.example.orbit_tracker_v1.service.SpaceTrackService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/gp")
public class SpaceTrackController {

    private final SpaceTrackService service;

    public SpaceTrackController(SpaceTrackService service) {
        this.service = service;
    }

    @GetMapping
    public List<GpData> getGpData() {
        return service.fetchGpData();
    }
}
