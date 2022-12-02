package com.findmyrecycling.fmrenterprise.dao;

import com.findmyrecycling.fmrenterprise.dto.Facility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Primary
@Repository("facilitySQLDAO")
public class FacilitySQLDAO implements IFacilityDAO{

    @Autowired
    FacilityRepository facilityRepository;

    /**
     * @see IFacilityDAO#save(Facility) saveFacility
     */
    @Override
    public Facility save(Facility facility) {
        Facility createdFacility = facilityRepository.save(facility);
        return createdFacility;
    }

    /**
     * @see IFacilityDAO#fetchAll() fetchAllFacilities
     */
    @Override
    public List<Facility> fetchAll() {
        List<Facility> allFacilitiesList = new ArrayList<>();
        Iterable<Facility> allFacilities = facilityRepository.findAll();
        for(Facility facility : allFacilities) {
            allFacilitiesList.add(facility);
        }
        return allFacilitiesList;
    }

    /**
     * @see IFacilityDAO#fetchById(long) fetchFacilitiesById 
     */
    @Override
    public Facility fetchById(long id) {
        Optional<Facility> retrievedFacility = facilityRepository.findById(id);
        return retrievedFacility.orElse(null);
    }

    /**
     * @see IFacilityDAO#delete(long) deleteFacilityById 
     */
    @Override
    public void delete(long id) {
        facilityRepository.deleteById(id);
    }

    /**
     * @see IFacilityDAO#fetchByGlobalSearch(String) fetchFacilityByGlobalSearch
     */
    @Override
    public List<Facility> fetchByGlobalSearch(String term) throws IOException {
        List<Facility> matchingFacilities = new ArrayList<>();
        Iterable<Facility> allFacilities = facilityRepository.findAll();
        for(Facility facility : allFacilities) {
            if (facility.toString().contains(term)) {
                matchingFacilities.add(facility);
            }
        }
        return matchingFacilities;
    }
}
