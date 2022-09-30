package com.findmyrecycling.fmrenterprise;

import com.findmyrecycling.fmrenterprise.dto.Facility;
import com.findmyrecycling.fmrenterprise.service.IFacilityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class FmRenterpriseApplicationTests {

    @Autowired
    private IFacilityService facilityService;
    private List<Facility> facility;

    @Test
    void contextLoads() {
    }
    @Test
    void fetchLocationByZipCode_returns45236AsObject()
    {
        givenFacilityDataIsAvailable();
        whenSearchLocationWithAddressZipCode45236();
        thenReturnListOfFacilitiesFor45236();

    }

    private void givenFacilityDataIsAvailable() {
    }

    private void whenSearchLocationWithAddressZipCode45236() {
        facility = facilityService.fetchByAddress("45236");
    }

    private void thenReturnListOfFacilitiesFor45236() {
        boolean AllFacilitiesAreIn45236 = true;
        for (Facility i: facility)
        {
             if(i.getFacilityAddress().indexOf("45236") == -1)
             {
                 AllFacilitiesAreIn45236 = false;
             }
        }
        assertTrue(AllFacilitiesAreIn45236);
    }
}
