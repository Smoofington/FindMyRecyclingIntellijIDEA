package com.findmyrecycling.fmrenterprise.dao;

import com.findmyrecycling.fmrenterprise.dto.Facility;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FacilityDAO implements IFacilityDAO{
    /**
     * Saves a new facility
     * @param facility
     * @return returns the facility?
     */
    @Override
    public Facility save(Facility facility) {
        return null;
    }
    /**
     *
     * @return all facilities
     */
    @Override
    public List<Facility> fetchAll() {
        return null;
    }

    /**
     *
     * @param id
     * @return the facility with the ID or null
     */
    @Override
    @Nullable
    public Facility fetchById(int id) {
        return null;
    }
    /**
     * Deletes the facility with the id
     * @param id
     */
    @Override
    public void delete(int id) {

    }
    /**
     *
     * @param term
     * @return a list of facilities by the term
     */
    @Override
    public List<Facility> fetchByGlobalSearch(String term) {
        return null;
    }
}
