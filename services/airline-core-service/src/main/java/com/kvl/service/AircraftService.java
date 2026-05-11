package com.kvl.service;


import com.kvl.payload.request.AircraftRequest;
import com.kvl.payload.response.AircraftResponse;

public interface AircraftService {

    AircraftResponse createAircraft(AircraftRequest request,Long ownerId);
    AircraftResponse updateAircraft(AircraftRequest request, Long ownerId);



}
