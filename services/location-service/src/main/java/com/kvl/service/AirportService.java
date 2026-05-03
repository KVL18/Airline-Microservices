package com.kvl.service;

import com.kvl.model.Airport;
import com.kvl.payload.request.AirportRequest;
import com.kvl.payload.response.AirportResponse;
import org.apache.el.lang.ELArithmetic;

import java.util.List;

public interface AirportService {

    AirportResponse createAirport(AirportRequest request) throws Exception;
    AirportResponse getAirportById(Long id) throws Exception;

    List<AirportResponse> getAllAirport();

    AirportResponse updateAirport(Long id,AirportRequest request) throws Exception;

    void deleteAirport(Long id) throws Exception;

    List<AirportResponse> getAirportByCityId(Long CityId);


}
