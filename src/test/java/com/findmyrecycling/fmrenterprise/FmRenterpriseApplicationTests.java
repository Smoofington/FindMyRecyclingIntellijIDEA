package com.findmyrecycling.fmrenterprise;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FmRenterpriseApplicationTests {


    @Test
    void contextLoads() {
    }
    @Test
    void fetchLocationByID_returns45236AsID()
    {
        givenFacilityDataIsAvailable();
        whenSearchLocationWithID45236();
        thenReturnListOfFacilitiesFor45236();

    }

    private void givenFacilityDataIsAvailable() {
    }

    private void whenSearchLocationWithID45236() {
    }

    private void thenReturnListOfFacilitiesFor45236() {
    }
}
