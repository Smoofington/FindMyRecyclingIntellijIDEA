package com.findmyrecycling.fmrenterprise.dao;

import com.findmyrecycling.fmrenterprise.dto.Facility;

import java.io.IOException;
import java.util.List;

public interface IFacilityDAO {
    /**
     *
     * @param facility the facility to save
     * @return the facility that was saved
     */
    Facility save(Facility facility);

    /**
     *
     * @return a list of all the facilities that are saved
     */
    List<Facility> fetchAll();

    /**
     *
     * @param id the id of the facility to retrieve
     * @return the facility or null if there is none
     */
    Facility fetchById(long id);

    /**
     *
     * @param id the id of the facility to delete
     */
    void delete(long id);

    /**
     *
     * @param term the string to perform the search of facilities on
     * @return a list of facilities that contain the search term
     * @throws IOException when user input is not able to be processed
     */
    List<Facility> fetchByGlobalSearch(String term) throws IOException;
}
