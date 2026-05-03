package com.kvl.service.impl;

import com.kvl.mapper.AirportMapper;
import com.kvl.model.Airport;
import com.kvl.model.City;
import com.kvl.payload.request.AirportRequest;
import com.kvl.payload.response.AirportResponse;
import com.kvl.repository.AirportRepository;
import com.kvl.repository.CityRepository;
import com.kvl.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AiportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;
    private final CityRepository cityRepository;


    @Override
    public AirportResponse createAirport(AirportRequest request) throws Exception {

        if(airportRepository.findByIataCode(request.getIataCode()).isPresent()){
            throw new Exception("Airport with this Iata Code Already Exists");

        }
        City city = cityRepository.findById(request.getCityId()).orElseThrow(
                ()-> new Exception("city not found")
        );
        Airport airport = AirportMapper.toEntity(request);
        airport.setCity(city);
        Airport savedAirport = airportRepository.save(airport);

        return AirportMapper.toResponse(savedAirport);

    }

    @Override
    public AirportResponse getAirportById(Long id) throws Exception {
        Airport airport =  airportRepository.findById(id).orElseThrow(
                ()->new Exception("airport not exists with provided id")
        );

        return AirportMapper.toResponse(airport);


    }

    @Override
    public List<AirportResponse> getAllAirport() {
        return airportRepository.findAll().stream().
                map(AirportMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AirportResponse updateAirport(Long id, AirportRequest request) throws Exception {
        Airport existingAirport = airportRepository.findById(id).orElseThrow(
                ()->new Exception("airport not exist with id" + id)
        );
        if(request.getIataCode()!=null
         && !existingAirport.getIataCode().equals(request.getIataCode())
            && airportRepository.findByIataCode(request.getIataCode()).isPresent()
        )
            AirportMapper.updateEntity(request,existingAirport);
        Airport updatedAirport = airportRepository.save(existingAirport);
           return AirportMapper.toResponse((updatedAirport));

    }

    @Override
    public void deleteAirport(Long id) throws Exception {
        Airport existingAirport = airportRepository.findById(id).orElseThrow(
                ()->new Exception("airport not exist with id" + id)
        );
        airportRepository.delete(existingAirport);
    }

    @Override
    public List<AirportResponse> getAirportByCityId(Long cityId) {
        return airportRepository.findByCityId(cityId).stream().
                map(AirportMapper::toResponse)
                .collect(Collectors.toList());

    }
}
