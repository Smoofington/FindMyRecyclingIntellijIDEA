package com.findmyrecycling.fmrenterprise.service;

import com.findmyrecycling.fmrenterprise.dao.IFacilityDAO;
import com.findmyrecycling.fmrenterprise.dto.Facility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FacilityService implements IFacilityService{

    @Autowired
    IFacilityDAO facilityDAO;

    public FacilityService() {

    }

    public FacilityService(IFacilityDAO facilityDAO) {
        this.facilityDAO = facilityDAO;
    }

    @Override
    @Cacheable("facilities")
    public List<Facility> fetchAll() {
        return facilityDAO.fetchAll();
    }

    @Override
    @Cacheable("facility")
    public Facility fetchById(int id) {
        return facilityDAO.fetchById(id);
    }

    @Override
    public Facility save(Facility facility) {
        return facilityDAO.save(facility);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    @Cacheable("areas")
    public List<Facility> fetchByGlobalSearch(String term) throws IOException {
        return facilityDAO.fetchByGlobalSearch(term);
    }
}
