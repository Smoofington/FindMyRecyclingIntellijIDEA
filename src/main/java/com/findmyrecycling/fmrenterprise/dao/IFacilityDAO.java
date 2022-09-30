package com.findmyrecycling.fmrenterprise.dao;

import com.findmyrecycling.fmrenterprise.dto.Facility;
import org.springframework.lang.Nullable;

import java.util.List;

public interface IFacilityDAO {
    Facility save(Facility facility);

    List<Facility> fetchAll();

    List<Facility> fetchByParams(@Nullable String facilityName, @Nullable String facilityDetails, @Nullable String facilityAddress, @Nullable String facilityCoordinates);

    Facility fetch(int id);

    void delete(int id);

}
