package com.findmyrecycling.fmrenterprise;

import com.findmyrecycling.fmrenterprise.dto.Facility;
import com.findmyrecycling.fmrenterprise.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FindMyRecyclingController {

    @Autowired
    IFacilityService facilityService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/AddFacility.html")
    public String addFacilityPage() {
        return "AddFacility";
    }

    @GetMapping("/facility/")
    public ResponseEntity fetchAllFacilities() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/facility/{id}/")
    public ResponseEntity fetchFacilityById(@PathVariable("id") int id) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/facility/params/", produces = "application/json")
    public List<Facility> fetchFacilitiesByParam(@RequestParam(required = false, name = "facilityName") String facilityName,
                                           @RequestParam(required = false, name = "facilityDetails") String facilityDetails,
                                           @RequestParam(required = false, name = "facilityAddress") String facilityAddress,
                                           @RequestParam(required = false, name = "facilityCoordinates") String facilityCoordinates
    ) {
        List<Facility> facilities = facilityService.fetchByParam(facilityName,facilityDetails,facilityAddress,facilityCoordinates);
        return facilities;
    }

    @DeleteMapping("/facility/{id}/")
    public ResponseEntity deleteFacilityById(@PathVariable("id") int id) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @PatchMapping("/facility/{id}/")
    public ResponseEntity updateFacilityById(@RequestBody Facility facility, @PathVariable("id") int id
    ) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/facility/")
    public ResponseEntity createFacility(@RequestBody Facility facility
    ) {
        return new ResponseEntity(HttpStatus.OK);
    }
}
