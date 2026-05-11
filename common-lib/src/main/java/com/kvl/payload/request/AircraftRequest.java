package com.kvl.payload.request;


import com.kvl.enums.AircraftStatus;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AircraftRequest {


    @NotBlank(message = "Aircraft code is required")
    private String code;

    @NotBlank(message = "Aircraft model is required")
    private String model;

    @NotBlank(message = "manufacturer is required")
    private String manufacturer;

    @NotNull(message = "Seating capacity is required")
    @Positive
    private Integer seatingCapacity;

    @Positive(message = "ECONOMY seats must be positive")
    private Integer economySeats;

    @Positive(message = "Premium Economy seats must be positive")
    private Integer premiumEconomySeats;

    @Positive(message = "Business seats must be positive")
    private Integer businessSeats;

    @Positive(message = "first class seats must be positive")
    private Integer firstClassSeats;

    @Positive(message = "Rnage must be positive")
    private Integer rangeKm;

    @Positive(message = "Cruising must be positive")
    private Integer cruisingSpeedKmh;

    @Positive(message = "MaxAltitude must be positive")
    private Integer maxAltitudeFt;

    @Positive(message = "Year must be positive")
    private Integer yearOfManufacture;

    private LocalDate registrationDate;
    private LocalDate nextMaintenanceDate;

    @NotNull(message = "Status is required")
    private AircraftStatus status;


    @NotNull(message = "Availabolity status is required")
    private Boolean iaAvailable;

    private Long currentAirportId;






}
