package com.findmyrecycling.fmrenterprise.service;

import com.findmyrecycling.fmrenterprise.dto.Facility;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FacilityService implements IFacilityService{

    @Override
    public List<Facility> fetchAll() {
        return null;
    }

    @Override
    public Facility fetchById(int id) {
        return null;
    }

    @Override
    public void sendToMaps(Facility facility) {

    }

    @Override
    public Facility save(Facility facility) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Facility> fetchByAddress(String address) {
        return null;
    }

    @Override
    public List<Facility> fetchByParam(String facilityName, String facilityDetails, String facilityAddress, String facilityCoordinates) {
        return null;
    }
}
