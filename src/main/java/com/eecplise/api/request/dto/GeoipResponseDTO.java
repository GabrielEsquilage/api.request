package com.eecplise.api.request.dto;

import lombok.Data;

@Data
public class GeoipResponseDTO {
    private String ip;
    private String city;
    private String state;
    private String state_code;
    private String country;
    private String country_code;
    private String continent;
    private String time_zone;
    private double latitude;
    private double longitude;
}
