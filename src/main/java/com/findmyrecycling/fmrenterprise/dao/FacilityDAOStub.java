package com.findmyrecycling.fmrenterprise.dao;

import com.findmyrecycling.fmrenterprise.dto.Facility;
import com.findmyrecycling.fmrenterprise.dto.RecyclableMaterial;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FacilityDAOStub implements IFacilityDAO{

    private final List<Facility> facilities = new ArrayList<>() {
        {
            add(new Facility(1L, new RecyclableMaterial(1L, "Metal"), "Facility", new ArrayList<>(), "4 Carpenters Run, Blue Ash, OH 45241"));
            add(new Facility(2L, new RecyclableMaterial(2L, "Glass"), "Facility2", new ArrayList<>(), "6905 Plainfield Rd, Silverton, OH 45236"));
            add(new Facility(3L, new RecyclableMaterial(3L, "Paper"), "Facility3", new ArrayList<>(), "8041 Hosbrook Rd # 115, Cincinnati, OH 45236"));
        }
    };

    @Override
    public Facility save(Facility facility) {
        facilities.add(facility);
        return facility;
    }

    @Override
    public List<Facility> fetchAll() {
        return facilities;
    }

    @Override
    public Facility fetchById(long id) {
        for(Facility facility: facilities) {
            if (facility.getFacilityId() == id){
                return facility;
            }
        }
        return null;
    }

    @Override
    public void delete(long id) {
        int i = 0;
        for(Facility facility: facilities) {
            if (facility.getFacilityId() == id) {
                facilities.remove(i);
                return;
            }
            i++;
        }
    }

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
