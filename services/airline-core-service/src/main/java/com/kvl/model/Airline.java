package com.kvl.model;


import com.kvl.embeddable.Support;
import com.kvl.enums.AirlineStatus;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String iataCode;

    @Column(nullable = false,unique = true)
    private String icaoCode;


    @Column(nullable = false)
    private  Long ownerId;

    @Column(nullable = false)
    private String name;


    private String alias;

    private String logoUrl;

    private String website;

    @Enumerated(EnumType.STRING)
    private AirlineStatus status = AirlineStatus.ACTIVE;

    private String alliance;


    private  Long headquartersCityId;


    @Embedded
    private Support support;

    private Long updatedById;

    @CreatedDate
    @Column(updatable = false,nullable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant updatedAt;


}

