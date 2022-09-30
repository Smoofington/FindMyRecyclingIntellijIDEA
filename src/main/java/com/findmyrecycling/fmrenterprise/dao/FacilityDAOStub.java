package com.findmyrecycling.fmrenterprise.dao;

import com.findmyrecycling.fmrenterprise.dto.Facility;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FacilityDAOStub implements IFacilityDAO{

    List<Facility> facilities = new ArrayList<>();

    @Override
    public Facility save(Facility facility) {
        facilities.add(facility);
        return facility;
    }

    @Override
    public List<Facility> fetchAll() {
        return facilities;
    }

    @Override
    public List<Facility> fetchByParams(@Nullable String facilityName, @Nullable String facilityDetails, @Nullable String facilityAddress, @Nullable String facilityCoordinates) {
        return null;
    }

    @Override
    public Facility fetch(int id) {
        for(Facility facility: facilities) {
            if (facility.getFacilityId() == id){
                return facility;
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
