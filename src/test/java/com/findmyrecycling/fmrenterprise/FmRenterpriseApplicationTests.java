package com.findmyrecycling.fmrenterprise;

import com.findmyrecycling.fmrenterprise.dao.FacilityDAOStub;
import com.findmyrecycling.fmrenterprise.dto.Facility;
import com.findmyrecycling.fmrenterprise.service.FacilityService;
import com.findmyrecycling.fmrenterprise.service.IFacilityService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class FmRenterpriseApplicationTests {

    private IFacilityService facilityService;
    private List<Facility> facilities;
    private Facility testFacility = new Facility(4L, 5L, "Recyclers", "Photos", "123 Road Drive, Loveland, Ohio 45140");

    @Test
    void contextLoads() {
    }
    @Test
    void fetchLocationByZipCode_returns45236AsObject()
    {
        givenFacilityDataIsAvailable();
        whenSearchLocationWithAddressZipCode45236();
        thenReturnListOfFacilitiesInZipcode45236();
    }

    private void givenFacilityDataIsAvailable() {
        facilityService = new FacilityService(new FacilityDAOStub());
    }

    private void whenSearchLocationWithAddressZipCode45236() {
        facilities = facilityService.fetchByGlobalSearch("45236");
    }

    private void thenReturnListOfFacilitiesInZipcode45236() {
        boolean AllFacilitiesAreIn45236 = true;
        for (Facility facility: facilities)
        {
             if(facility.getFacilityAddress().indexOf("45236") == -1)
             {
                 AllFacilitiesAreIn45236 = false;
             }
        }
        assertTrue(AllFacilitiesAreIn45236);
    }

    @Test
    void saveFacility()
    {
        givenFacilityDataIsAvailable();
        whenAttemptingToSaveNewFacility();
        thenFacilityShouldBeAddedToSavedFacilities();
    }

    private void whenAttemptingToSaveNewFacility() {
        facilityService.save(testFacility);
    }

    private void thenFacilityShouldBeAddedToSavedFacilities() {
        boolean facilityFound = false;
        facilities = facilityService.fetchAll(searchTerm);
        for(Facility facility: facilities) {
            if (facility == testFacility) {
                facilityFound = true;
            }
        }
        assertTrue(facilityFound);
    }
}
