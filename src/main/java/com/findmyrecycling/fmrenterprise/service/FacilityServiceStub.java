package com.findmyrecycling.fmrenterprise.service;

import com.findmyrecycling.fmrenterprise.Decimal;
import com.findmyrecycling.fmrenterprise.dto.Facility;
import org.springframework.stereotype.Component;

@Component
public class FacilityServiceStub implements IFacilityService{
    @java.lang.Override
    public List<Facility> fetchAll() {
        return null;
    }

    @java.lang.Override
    public Facility fetchById(int id) {
        return null;
    }

    @java.lang.Override
    public void sendToMaps(Facility facility) {

    }

    @java.lang.Override
    public Facility save(Facility facility) {
        return null;
    }

    @java.lang.Override
    public void delete(int id) {

    }


    @java.lang.Override
    public List<Facility> fetchByAddress(String address) {
        List<Facility> facilities = new List<Facility>();
        Facility facility = new Facility( new Long(1), new Long(1), "Facility", "Photo", "4 Carpenters Run, Blue Ash, OH 45241", new Decimal());
        Facility facility2 = new Facility( new Long(2), new Long(2), "Facility2", "Photo", "6905 Plainfield Rd, Silverton, OH 45236", new Decimal());
        Facility facility3 = new Facility( new Long(3), new Long(3), "Facility3", "Photo", "8041 Hosbrook Rd # 115, Cincinnati, OH 45236", new Decimal());
        facilities.add(facility);
        facilities.add(facility2);
        facilities.add(facility3);
        return facilities;
    }

}
