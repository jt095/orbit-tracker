package com.example.orbit_tracker_v1.service;

import com.example.orbit_tracker_v1.model.CelestrakTLEData;
import com.example.orbit_tracker_v1.model.GpData;

import java.io.IOException;
import java.util.List;

public interface CelestrakService {
   List<CelestrakTLEData> fetchTLEData();
}