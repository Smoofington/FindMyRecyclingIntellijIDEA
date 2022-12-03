package com.findmyrecycling.fmrenterprise;

import com.findmyrecycling.fmrenterprise.dao.IFacilityDAO;
import com.findmyrecycling.fmrenterprise.dto.Facility;
import com.findmyrecycling.fmrenterprise.dto.Photo;
import com.findmyrecycling.fmrenterprise.dto.RecyclableMaterial;
import com.findmyrecycling.fmrenterprise.service.FacilityService;
import com.findmyrecycling.fmrenterprise.service.IFacilityService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@SpringBootTest
class FmRenterpriseApplicationTests {

    @MockBean
    @Qualifier("facilityDAO")
    private IFacilityDAO facilityDAO;
    private IFacilityService facilityService;
    private List<Facility> testFacilities = new ArrayList<>() {
    };
    private Facility testFacility = new Facility(4L, new RecyclableMaterial(1L, "Metal"), "Recyclers", new Photo(), "123 Road Drive, Loveland, Ohio 45140");



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
        facilityService = new FacilityService(facilityDAO);
        testFacilities.add(new Facility(1L, new RecyclableMaterial(1L, "Metal"), "Recycle Place", new Photo(), "Address 1"));
        testFacilities.add(new Facility(2L, new RecyclableMaterial(1L, "Metal"), "Center of Recycle", new Photo(), "Road 132"));
        testFacilities.add(new Facility(3L, new RecyclableMaterial(2L, "Glass"), "Batavia Recylcers", new Photo(), "Street 2893"));
        testFacilities.add(new Facility(4L, new RecyclableMaterial(1L, "Metal"), "Recycle Metal", new Photo(), "983 Drive, Blue Ash, Ohio 45236"));
    }

    private void whenSearchLocationWithAddressZipCode45236() throws IOException {
        testFacilities = facilityService.fetchByGlobalSearch("45236");
    }

    private void thenReturnListOfFacilitiesInZipcode45236() {
        boolean AllFacilitiesAreIn45236 = true;
        for (Facility facility: testFacilities)
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
        Facility createdFacility = facilityService.save(testFacility);
        assertEquals(createdFacility, testFacility);
        verify(facilityDAO, atLeastOnce()).save(testFacility);

    }

    @Test
    void fetchFacilityById_returnsFacilityWithRequestedId() {
        givenFacilityDataIsAvailable();
        whenUserRequestsFacilityWithId();
        thenReturnFacilityWithID4();
    }

    private void whenUserRequestsFacilityWithId() {

    }

    private void thenReturnFacilityWithID4() {
        int idToFetch = 4;
        Mockito.when(facilityDAO.fetchById(idToFetch)).thenReturn(testFacility);
        Facility fetchedFacility = facilityService.fetchById(4);
        assertEquals(fetchedFacility.getFacilityId(), idToFetch);
        verify(facilityDAO, atLeastOnce()).fetchById(idToFetch);
    }
    
    @Test
    void fetchAllFacilities()
    {
        givenFacilityDataIsAvailable();
        whenUserRequestsAllFacilities();
        thenAllFacilitiesShouldBeReturned();
    }

    private void whenUserRequestsAllFacilities() {
    }

    private void thenAllFacilitiesShouldBeReturned() {
        Mockito.when(facilityDAO.fetchAll()).thenReturn(testFacilities);
        List<Facility> allFacilities = facilityService.fetchAll();
        assertArrayEquals(allFacilities.toArray(), testFacilities.toArray());
        verify(facilityDAO, atLeastOnce()).fetchAll();
    }

}
