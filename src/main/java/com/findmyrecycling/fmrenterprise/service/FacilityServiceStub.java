package com.findmyrecycling.fmrenterprise.service;

import com.findmyrecycling.fmrenterprise.dao.IFacilityDAO;
import com.findmyrecycling.fmrenterprise.dto.Facility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FacilityServiceStub implements IFacilityService{

    @Autowired
    IFacilityDAO facilityDAO;

    public FacilityServiceStub() {

    }

    public FacilityServiceStub(IFacilityDAO facilityDAO) {
        this.facilityDAO = facilityDAO;
    }

    @Override
    @Cacheable("facilities")
    public List<Facility> fetchAll() {
        return facilityDAO.fetchAll();
    }

    @Override
    @Cacheable(value="facility", key="#id")
    public Facility fetchById(int id) {
        return facilityDAO.fetchById(id);
    }

    @Override
    public Facility save(Facility facility) {
        return facilityDAO.save(facility);
    }

    @Override
    @CacheEvict(value="facility", key="#id")
    public void delete(int id) throws Exception{
        facilityDAO.delete(id);
    }

    @Override
    @Cacheable("areas")
    public List<Facility> fetchByGlobalSearch(String term) throws IOException {
        return facilityDAO.fetchByGlobalSearch(term);
    }
}
