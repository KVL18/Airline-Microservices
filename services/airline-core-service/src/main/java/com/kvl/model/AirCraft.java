package com.kvl.model;


import com.kvl.enums.AircraftStatus;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class AirCraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String code;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String manufacturer;

    @Column(nullable = false)
    private Integer seatingCapacity;

    @Column(name = "economy seats")
    private Integer economySeats=0;

    @Column(name = "business_seats")
    private Integer businessSeats=0;

    @Column(name = "premium_economy_seats")
    private Integer premiumEconomySeats=0;

    @Column(name = "first_class_seats")
    private Integer firstClassSeats=0;

    @Column(name = "cruising_speen_kmph")
    private Integer cruisingSpeed;

    private Integer maxAltitudeFt;

    @Column(name = "RangeKm")
    private Integer rangeKm;

    @Column(name = "year")
    private Integer yearOfManufacture;

    private LocalDate registrationDate;
    private LocalDate nextMaintenanceDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",nullable = false)
    private AircraftStatus status = AircraftStatus.ACTIVE;

    private Boolean isAvailable = true;


    @ManyToOne
    private Airline airline;

    private Long currentAirportId;

    @CreatedDate
    @Column(name = "created_at", updatable = false , nullable = false)
    private Instant updatedAt;

    public Integer getTotalSeats(){
        return economySeats+premiumEconomySeats+businessSeats+firstClassSeats;
    }

    public boolean isOperational(){
        return AircraftStatus.ACTIVE.equals(status)
                && Boolean.TRUE.equals(isAvailable);
    }
    public boolean requiresMaintenance(){
        return nextMaintenanceDate!=null
                && nextMaintenanceDate.isBefore(LocalDate.now().plusWeeks(2));
    }

}
