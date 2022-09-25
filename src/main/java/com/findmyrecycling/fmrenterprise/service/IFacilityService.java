package com.findmyrecycling.fmrenterprise.service;

import com.findmyrecycling.fmrenterprise.dto.Facility;

import java.util.List;

public interface IFacilityService {
    /**
     * Fetch all facilities
     * @return list of facilities or null if none
     */
    List<Facility> fetchAll();
    /**
     * Fetch all facilities using an ID
     * @param id a unique identifier for a facility
     * @return list of facilities or null if none
     */
    Facility fetchById(int id);
    /**
     * Show location of facility on map
     * @param facility is a facility containing a lat and long
     */
    void sendToMaps(Facility facility);
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
    void delete(int id);

    List<Facility> fetchByAddress(String i);
}
