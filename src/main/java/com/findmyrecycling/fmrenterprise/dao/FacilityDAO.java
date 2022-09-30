package com.findmyrecycling.fmrenterprise.dao;

import com.findmyrecycling.fmrenterprise.dto.Facility;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FacilityDAO implements IFacilityDAO{
    @Override
    public Facility save(Facility facility) {
        return null;
    }

    @Override
    public List<Facility> fetchAll() {
        return null;
    }

    @Override
    public List<Facility> fetchByParams(@Nullable String facilityName, @Nullable String facilityDetails, @Nullable String facilityAddress, String facilityCoordinates) {
        return null;
    }

    @Override
    public Facility fetch(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
