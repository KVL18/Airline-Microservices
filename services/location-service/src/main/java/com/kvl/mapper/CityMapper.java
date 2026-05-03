package com.kvl.mapper;

import com.kvl.model.City;
import com.kvl.payload.request.CityRequest;
import com.kvl.payload.response.CityResponse;

public class CityMapper {

    public static City toEntity(CityRequest request){
        if(request == null) return null;

        return City.builder()
                .name(request.getName())
                .cityCode(request.getCityCode())
                .countryCode(request.getCountryCode())
                .countryName(request.getCountryName())
                .regionCode(request.getRegionCode())
                .timeZoneId(request.getTimeZoneOffset())
                .build();
    }

    public static CityResponse toResponse (City city){
        if(city ==null) return null;

        return CityResponse.builder()
                .id(city.getId())
                .name(city.getName())
                .cityCode(city.getCityCode())
                .countryCode(city.getCountryCode())
                .countryName(city.getCountryName())
                .regionCode(city.getRegionCode())
                .timeZoneOffset(city.getTimeZoneId())
                .build();

    }
    public static City updateEntity(City city ,CityRequest request){

            if (city == null || request == null) return city;

            if (request.getName() != null) {
                city.setName(request.getName().trim());
            }

            if (request.getCityCode() != null) {
                city.setCityCode(request.getCityCode().toUpperCase().trim());
            }

            if (request.getCountryCode() != null) {
                city.setCountryCode(request.getCountryCode().trim().toUpperCase());
            }

            if (request.getCountryName() != null) {
                city.setCountryName(request.getCountryName().toUpperCase().trim());
            }

            if (request.getRegionCode() != null) {
                city.setRegionCode(request.getRegionCode().toUpperCase().trim());
            }

            if (request.getTimeZoneOffset() != null) {
                city.setTimeZoneId(request.getTimeZoneOffset().toUpperCase().trim());
            }

            return city;
        }



}
