package com.findmyrecycling.fmrenterprise.service;

import com.findmyrecycling.fmrenterprise.dto.Facility;
import org.springframework.lang.Nullable;

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

    /**
     * Fetch the facilities by the given address from the list
     * of facilities.
     * @param address a unique identifier for the full address.
     * @return the list of facilities based on the address, or null if no facilities found.
     */
    List<Facility> fetchByAddress(String address);

    /**
     * Fetch the facilities by given params.
     * @param facilityName Optional param that is the name of the facility
     * @param facilityDetails Optional param that is the details linked to the facility
     * @param facilityAddress Optional param that is the address of the facility
     * @param facilityCoordinates Optional param that is the coordinates of the facility
     * @return a list of facilities that match the params
     */
    List<Facility> fetchByParam( @Nullable String facilityName, @Nullable String facilityDetails, @Nullable String facilityAddress, @Nullable String facilityCoordinates);
}