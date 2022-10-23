package com.findmyrecycling.fmrenterprise;

import com.findmyrecycling.fmrenterprise.dao.FacilityDAO;
import com.findmyrecycling.fmrenterprise.dao.FacilityDAOStub;
import com.findmyrecycling.fmrenterprise.dao.IFacilityDAO;
import com.findmyrecycling.fmrenterprise.dto.Facility;
import com.findmyrecycling.fmrenterprise.service.FacilityService;
import com.findmyrecycling.fmrenterprise.service.IFacilityService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@SpringBootTest
class FmRenterpriseApplicationTests {

    @MockBean @Qualifier("FacilityDAO")
    private IFacilityDAO facilityDAO;
    private IFacilityService facilityService;
    private List<Facility> facilities;
    private Facility testFacility = new Facility(4L, 5L, "Recyclers", "Photos", "123 Road Drive, Loveland, Ohio 45140");



    @Test
    void contextLoads() {
    }
    @Test
    void fetchLocationByZipCode_returns45236AsObject() throws IOException {
        givenFacilityDataIsAvailable();
        whenSearchLocationWithAddressZipCode45236();
        thenReturnListOfFacilitiesInZipcode45236();
    }

    private void givenFacilityDataIsAvailable() {
        facilityService = new FacilityService(new FacilityDAOStub());
    }

    private void whenSearchLocationWithAddressZipCode45236() throws IOException {
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
        whenUserCreatesANewFacilityAndSaves();
        thenFacilityShouldBeAddedToSavedFacilities();
    }

    private void whenUserCreatesANewFacilityAndSaves() {

    }

    private void thenFacilityShouldBeAddedToSavedFacilities() {
        Mockito.when(facilityDAO.save(testFacility)).thenReturn(testFacility);
        facilityService = new FacilityService(facilityDAO);

        Facility createdFacility = facilityService.save(testFacility);
        assertEquals(createdFacility, testFacility);
        verify(facilityDAO, atLeastOnce()).save(testFacility);
    }

    private void thenReturnFacilityWithID4() {
        int idToFetch = 4;
        Mockito.when(facilityDAO.fetchById(idToFetch)).thenReturn(testFacility);
        facilityService = new FacilityService(facilityDAO);

        Facility fetchedFacility = facilityService.fetchById(4);
        assertEquals(fetchedFacility.getFacilityId(), idToFetch);
        verify(facilityDAO, atLeastOnce()).fetchById(idToFetch);
    }

}
