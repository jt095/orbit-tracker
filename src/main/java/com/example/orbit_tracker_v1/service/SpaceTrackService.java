package com.example.orbit_tracker_v1.service;

import com.example.orbit_tracker_v1.model.GpData;

import java.util.List;

public interface SpaceTrackService {
   List<GpData> fetchGpData();
}