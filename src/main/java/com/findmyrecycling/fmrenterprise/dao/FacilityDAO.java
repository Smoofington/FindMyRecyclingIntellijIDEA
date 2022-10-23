package com.findmyrecycling.fmrenterprise.dao;

import com.findmyrecycling.fmrenterprise.dto.Facility;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FacilityDAO implements IFacilityDAO{
    @Override
    public Facility save(Facility facility) {
        return facility;
    }

    @Override
    public List<Facility> fetchAll() {
        return null;
    }

    @Override
    @Nullable
    public Facility fetchById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Facility> fetchByGlobalSearch(String term) {
        return null;
    }
}
