package com.findmyrecycling.fmrenterprise.dao;

import com.findmyrecycling.fmrenterprise.dto.Facility;
import org.springframework.lang.Nullable;

import java.util.List;

public interface IFacilityDAO {
    /**
     * Saves a new facility
     * @param facility
     * @return returns the facility?
     */
    Facility save(Facility facility);

    /**
     *
     * @return all facilities
     */
    List<Facility> fetchAll();

    /**
     *
     * @param id
     * @return the facility with the ID or null
     */
    @Nullable
    Facility fetchById(int id);

    /**
     * Deletes the facility with the id
     * @param id
     */
    void delete(int id);

    /**
     *
     * @param term
     * @return a list of facilities by the term
     */
    List<Facility> fetchByGlobalSearch(String term);
}
