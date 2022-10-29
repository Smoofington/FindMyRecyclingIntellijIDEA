package com.findmyrecycling.fmrenterprise.dao;

import com.findmyrecycling.fmrenterprise.dto.Facility;
import org.springframework.lang.Nullable;

import java.io.IOException;
import java.util.List;

public interface IFacilityDAO {
    Facility save(Facility facility);

    List<Facility> fetchAll();

    List<Facility> fetchAll(String term) throws IOException;

    @Nullable
    Facility fetchById(int id);

    void delete(int id);
}
