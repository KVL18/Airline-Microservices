package com.kvl.repository;

import com.kvl.enums.AirlineStatus;
import com.kvl.model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AirlineRepository extends JpaRepository<Airline,Long> {

    Optional<Airline>findByOwnerId(Long ownerId);

    List<Airline> findByStatus(AirlineStatus status);


}
