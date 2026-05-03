package com.kvl.repository;

import com.kvl.model.Airport;
import com.kvl.payload.response.AirportResponse;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AirportRepository extends JpaRepository<Airport,Long> {

   Optional<Airport> findByIataCode(String iaiaCode);

    List<Airport> findByCityId(Long cityId);



}
