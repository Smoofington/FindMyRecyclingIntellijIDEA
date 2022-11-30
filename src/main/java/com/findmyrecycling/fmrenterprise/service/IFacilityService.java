package com.findmyrecycling.fmrenterprise.service;

import com.findmyrecycling.fmrenterprise.dto.Facility;

import java.io.IOException;
import java.util.List;

public interface IFacilityService {
    /**
     * Fetch all facilities
     * @return list of facilities or null if none
     */
    List<Facility> fetchAll();

    /**
     * Fetch facility using an ID
     * @param id a unique identifier for a facility
     * @return facility or null if none
     */
    Facility fetchById(int id);

    /**
     * Save facility
     * @param facility is a Facility object
     * @return the facility that was saved
     */
    Facility save(Facility facility);

    /**
     * Delete the record of the facility
     * @param id is a unique identifier for the facility
     */
    void delete(int id) throws Exception;

    /**
     * Fetch the facilities by given params.
     * @param term String to check against all params of facilities
     * @return a list of facilities that match the params
     */
    List<Facility> fetchByGlobalSearch(String term) throws IOException;
}