package com.findmyrecycling.fmrenterprise.service;

import com.findmyrecycling.fmrenterprise.Decimal;
import com.findmyrecycling.fmrenterprise.dto.Facility;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FacilityServiceStub implements IFacilityService{

    private List<Facility> createTestFacilities() {
        List<Facility> facilities = new ArrayList<>();
        Facility facility = new Facility(1L, 1L, "Facility", "Photo", "4 Carpenters Run, Blue Ash, OH 45241", new Decimal());
        Facility facility2 = new Facility(2L, 2L, "Facility2", "Photo", "6905 Plainfield Rd, Silverton, OH 45236", new Decimal());
        Facility facility3 = new Facility(3L, 3L, "Facility3", "Photo", "8041 Hosbrook Rd # 115, Cincinnati, OH 45236", new Decimal());
        facilities.add(facility);
        facilities.add(facility2);
        facilities.add(facility3);
        return facilities;
    }
    @java.lang.Override
    public List<Facility> fetchAll() {
        return null;
    }

    @java.lang.Override
    public Facility fetchById(int id) {
        return null;
    }

    @java.lang.Override
    public void sendToMaps(Facility facility) {

    }

    @java.lang.Override
    public Facility save(Facility facility) {
        return null;
    }

    @java.lang.Override
    public void delete(int id) {

    }


    @java.lang.Override
    public List<Facility> fetchByAddress(String address) {
        return createTestFacilities();
    }

    @Override
    public List<Facility> fetchByParam(String facilityName, String facilityDetails, String facilityAddress, String facilityCoordinates) {
        return createTestFacilities();
    }
}