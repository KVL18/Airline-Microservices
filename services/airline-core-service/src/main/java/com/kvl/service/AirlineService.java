package com.kvl.service;

import com.kvl.enums.AirlineStatus;
import com.kvl.payload.request.AirlineRequest;
import com.kvl.payload.response.AirlineDropdownItem;
import com.kvl.payload.response.AirlineResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AirlineService {

    AirlineResponse createAirline(AirlineRequest request, Long ownerId);
    AirlineResponse getAirlineByOwner(Long ownerId) throws Exception;
    AirlineResponse getAirlineById(Long Id) throws Exception;
    Page<AirlineResponse> getAllAirlines(Pageable pageable);
    AirlineResponse updateAirline(AirlineRequest request, Long ownerId) throws Exception;
    void deleteAirline(Long Id,Long ownerId) throws Exception;
    AirlineResponse changeStatusByAdmin(Long airlineId , AirlineStatus status) throws Exception;

    List<AirlineDropdownItem> getAirlineDropdown();

}
