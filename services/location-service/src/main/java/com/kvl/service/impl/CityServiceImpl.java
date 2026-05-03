package com.kvl.service.impl;


import com.kvl.mapper.CityMapper;
import com.kvl.model.City;
import com.kvl.payload.request.CityRequest;
import com.kvl.payload.response.CityResponse;
import com.kvl.repository.CityRepository;
import com.kvl.service.CityService;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.NativeQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public CityResponse createCity(CityRequest request) throws Exception {

        if(cityRepository.existsByCityCode(request.getCityCode())){
            throw new Exception("City with given code already exists");
        }
        City city = CityMapper.toEntity(request);
        City result = cityRepository.save(city);

        return  CityMapper.toResponse(result);
    }

    @Override
    public CityResponse getCityById(Long id) throws Exception {
        City city = cityRepository.findById(id).orElseThrow(
                ()-> new Exception("CITY NOT EXIST BY GIVEN ID")
        );

        return CityMapper.toResponse(city);

    }

    @Override
    public CityResponse updateCity(Long id, CityRequest request) throws Exception {
        City city = cityRepository.findById(id).orElseThrow(
                ()-> new Exception("city not exist with given id")
        );
        if(cityRepository.existsByCityCode(request.getCityCode())){
            throw new Exception(("city with given code already exist"));
        }
        City updateCity = cityRepository.save(CityMapper.updateEntity(city,request));
        return CityMapper.toResponse((updateCity));

    }

    @Override
    public void deleteCity(Long id) throws Exception {
        City city = cityRepository.findById(id).orElseThrow(
                ()->new Exception("city not exist with given id")
        );

        cityRepository.delete(city);

    }

    @Override
    public Page<CityResponse> getAllCities(Pageable pageable) {
        return cityRepository.findAll(pageable).map(CityMapper::toResponse);
    }

    @Override
    public Page<CityResponse> searchCities(String keyword, Pageable pageable) {
        return cityRepository.searchBykeyword(keyword,pageable).
                map(CityMapper::toResponse);
    }

    @Override
    public Page<CityResponse> getCitiesByCountryCode(String countryCode, Pageable pageable) {
        return cityRepository.findByCountryCodeIgnoreCase(countryCode,pageable).
                map(CityMapper::toResponse);
    }

    @Override
    public boolean cityExists(String cityCode) {
        return cityRepository.existsByCityCode(cityCode);
    }

//    @Override
//    public boolean validateCityCode(String cityCode) {
//        return false;
//    }
}
