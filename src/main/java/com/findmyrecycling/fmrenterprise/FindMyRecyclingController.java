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

    @RequestMapping("/facility/add")
    public String addFacilityPage() {
        return "add-facility";
    }

    @GetMapping("/facility/")
    public ResponseEntity fetchAllFacilities() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/facility/{id}/")
    public ResponseEntity fetchFacilityById(@PathVariable("id") int id) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/facility/search/{term}/", produces = "application/json")
    public List<Facility> fetchFacilitiesByTerm(@PathVariable("term") String term
    ) {
        List<Facility> facilities = facilityService.fetchByGlobalSearch(term);
        return facilities;
    }

    /**
     * Delete a facility given an id
     * @param id unique id that is tied to a facility
     * @return
     */
    @DeleteMapping("/facility/{id}/")
    public ResponseEntity deleteFacilityById(@PathVariable("id") int id) {
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Update a facility given an id
     * @param id unique id that is tied to a facility
     * @return
     */
    @PatchMapping("/facility/{id}/")
    public ResponseEntity updateFacilityById(@RequestBody Facility facility, @PathVariable("id") int id
    ) {
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Create a facility
     * @param facility
     * @return
     */
    @PutMapping("/facility/")
    public ResponseEntity createFacility(@RequestBody Facility facility
    ) {
        return new ResponseEntity(HttpStatus.OK);
    }
}
