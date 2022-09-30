package com.findmyrecycling.fmrenterprise.dao;

import com.findmyrecycling.fmrenterprise.dto.Facility;

import java.util.List;

public interface IFacilityDAO {
    Facility save(Facility facility);

    List<Facility> fetchAll();

    Facility fetch(int id);

    void delete(int id);

}
