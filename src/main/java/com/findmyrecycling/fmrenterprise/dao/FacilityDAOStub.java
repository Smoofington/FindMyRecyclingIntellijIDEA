package com.findmyrecycling.fmrenterprise.dao;

import com.findmyrecycling.fmrenterprise.dto.Facility;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FacilityDAOStub implements IFacilityDAO{

    private List<Facility> facilities = new ArrayList<>() {
        {
            add(new Facility(1L, 1L, "Facility", "Photo", "4 Carpenters Run, Blue Ash, OH 45241"));
            add(new Facility(2L, 2L, "Facility2", "Photo", "6905 Plainfield Rd, Silverton, OH 45236"));
            add(new Facility(3L, 3L, "Facility3", "Photo", "8041 Hosbrook Rd # 115, Cincinnati, OH 45236"));
        }
    };
    /**
     * Saves a new facility
     * @param facility
     * @return returns the facility?
     */
    @Override
    public Facility save(Facility facility) {
        facilities.add(facility);
        return facility;
    }
    /**
     *
     * @return all facilities
     */
    @Override
    public List<Facility> fetchAll() {
        return facilities;
    }
    /**
     *
     * @param id
     * @return the facility with the ID or null
     */
    @Override
    @Nullable
    public Facility fetchById(int id) {
        for(Facility facility: facilities) {
            if (facility.getFacilityId() == id){
                return facility;
            }
        }
        return null;
    }
    /**
     * Deletes the facility with the id
     * @param id
     */
    @Override
    public void delete(int id) {
        int i = 0;
        for(Facility facility: facilities) {
            if (facility.getFacilityId() == id) {
                facilities.remove(i);
                return;
            }
            i++;
        }
    }
    /**
     *
     * @param term
     * @return a list of facilities by the term
     */
    @Override
    public List<Facility> fetchByGlobalSearch(String term) {
        List<Facility> matchingFacilities = new ArrayList<>();
        for(Facility facility: facilities) {
            if(facility.toString().contains(term)) {
                matchingFacilities.add(facility);
            }
        }
        return matchingFacilities;
    }
}
