package com.findmyrecycling.fmrenterprise.dao;

import com.findmyrecycling.fmrenterprise.dto.Facility;

import java.io.IOException;
import java.util.List;

public interface IFacilityDAO {
    Facility save(Facility facility);
    List<Facility> fetchAll();
    Facility fetchById(long id);
    void delete(long id);
    List<Facility> fetchByGlobalSearch(String term) throws IOException;
}
