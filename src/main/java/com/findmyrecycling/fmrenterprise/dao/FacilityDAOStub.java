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
    @Nullable
    public Facility fetchById(int id) {
        for(Facility facility: facilities) {
            if (facility.getFacilityId() == id){
                return facility;
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        int i = 0;
        for(Facility facility: facilities) {
            if (facility.getFacilityId() == id) {
                facilities.remove(i);
                break;
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
