package com.kvl.payload.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CityRequest {

    @NotBlank(message = "city name is required")
    @Size(max = 100)
    private String name;

    @NotBlank(message = "city code is required")
    @Size(max = 10)
    private String cityCode;

    @NotBlank(message = "country code is required")
    @Size(max = 5)
    private String countryCode;

    @NotBlank(message = "country Name is required")
    @Size(max = 100)
    private String countryName;

    @Size(max = 10)
    private String regionCode;

    @Size(max = 10)
    private String timeZoneOffset;



}
