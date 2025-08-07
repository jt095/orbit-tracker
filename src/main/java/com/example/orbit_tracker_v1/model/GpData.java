package com.example.orbit_tracker_v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GpData {

    @JsonProperty("CCSDS_OMM_VERS")
    private String ccsdsOmmVers;

    @JsonProperty("COMMENT")
    private String comment;

    @JsonProperty("CREATION_DATE")
    private String creationDate;

    @JsonProperty("ORIGINATOR")
    private String originator;

    @JsonProperty("OBJECT_NAME")
    private String objectName;

    @JsonProperty("OBJECT_ID")
    private String objectId;

    @JsonProperty("CENTER_NAME")
    private String centerName;

    @JsonProperty("REF_FRAME")
    private String refFrame;

    @JsonProperty("TIME_SYSTEM")
    private String timeSystem;

    @JsonProperty("MEAN_ELEMENT_THEORY")
    private String meanElementTheory;

    @JsonProperty("EPOCH")
    private String epoch;

    @JsonProperty("MEAN_MOTION")
    private float meanMotion;

    @JsonProperty("ECCENTRICITY")
    private float eccentricity;

    @JsonProperty("INCLINATION")
    private float inclination;

    @JsonProperty("RA_OF_ASC_NODE")
    private float raOfAscNode;

    @JsonProperty("ARG_OF_PERICENTER")
    private float argOfPericenter;

    @JsonProperty("MEAN_ANOMALY")
    private float meanAnomaly;

    @JsonProperty("EPHEMERIS_TYPE")
    private int ephemerisType;

    @JsonProperty("CLASSIFICATION_TYPE")
    private String classificationType;

    @JsonProperty("NORAD_CAT_ID")
    private int noradCatId;

    @JsonProperty("ELEMENT_SET_NO")
    private int elementSetNo;

    @JsonProperty("REV_AT_EPOCH")
    private int revAtEpoch;

    @JsonProperty("BSTAR")
    private float bstar;

    @JsonProperty("MEAN_MOTION_DOT")
    private float meanMotionDot;

    @JsonProperty("MEAN_MOTION_DDOT")
    private float meanMotionDdot;

    @JsonProperty("SEMIMAJOR_AXIS")
    private double semimajorAxis;

    @JsonProperty("PERIOD")
    private double period;

    @JsonProperty("APOAPSIS")
    private double apoapsis;

    @JsonProperty("PERIAPSIS")
    private double periapsis;

    @JsonProperty("OBJECT_TYPE")
    private String objectType;

    @JsonProperty("RCS_SIZE")
    private String rcsSize;

    @JsonProperty("COUNTRY_CODE")
    private String countryCode;

    @JsonProperty("LAUNCH_DATE")
    private String launchDate;

    @JsonProperty("SITE")
    private String site;

    @JsonProperty("DECAY_DATE")
    private String decayDate;

    @JsonProperty("FILE")
    private int file;

    @JsonProperty("GP_ID")
    private int gpId;

    @JsonProperty("TLE_LINE0")
    private String tleLine0;

    @JsonProperty("TLE_LINE1")
    private String tleLine1;

    @JsonProperty("TLE_LINE2")
    private String tleLine2;
}
