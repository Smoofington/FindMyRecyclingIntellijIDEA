package com.findmyrecycling.fmrenterprise;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FindMyRecyclingController {

    /**
     * Handle the root (/) endpoint and return a start page.
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "start";
    }

    @GetMapping("/facility/")
    public ResponseEntity fetchAllFacilities() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/facility/{id}/")
    public ResponseEntity fetchFacilityById(@PathVariable("id") int id) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/facility/param/")
    public ResponseEntity fetchFacilityByParam(@RequestParam(required = false, name = "facilityName") String facilityName,
                                               @RequestParam(required = false, name = "facilityDetails") String facilityDetails,
                                               @RequestParam(required = false, name = "facilityAddress") String facilityAddress,
                                               @RequestParam(required = false, name = "facilityCoordinates") String facilityCoordinates
    ) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/facility/{id}/")
    public ResponseEntity deleteFacilityById(@PathVariable("id") int id) {
        return new ResponseEntity(HttpStatus.OK);
    }

//    @PutMapping("/facility/")
//    public ResponseEntity addFacility(@RequestBody Facility facility) {
//        return new ResponseEntity(HttpStatus.OK);
//    }
}
