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

    /**
     * index page
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /**
     *
     * @return facility page
     */
    @RequestMapping("/AddFacility.html")
    public String addFacilityPage() {
        return "AddFacility";
    }

    /**
     * Get all facilities
     * @return all facilities and a 200 code
     */
    @GetMapping("/facility/")
    public ResponseEntity fetchAllFacilities() {
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return returns the facility with the id 'id'
     */
    @GetMapping("/facility/{id}/")
    public ResponseEntity fetchFacilityById(@PathVariable("id") int id) {
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     *
     * @param term term to search for facilities by
     * @return list of facilities that use the term
     */
    @GetMapping(value = "/facility/search/{term}/", produces = "application/json")
    public List<Facility> fetchFacilitiesByTerm(@PathVariable("term") String term
    ) {
        List<Facility> facilities = facilityService.fetchByGlobalSearch(term);
        return facilities;
    }

    /**
     * Deletes the facility with that id
     * @param id id of facility to delete
     * @return 200 if id Exists
     */
    @DeleteMapping("/facility/{id}/")
    public ResponseEntity deleteFacilityById(@PathVariable("id") int id) {
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Updates the facility
     * @param facility new facility
     * @param id id of the facility to update
     * @return 200 if the facility exists
     */
    @PatchMapping("/facility/{id}/")
    public ResponseEntity updateFacilityById(@RequestBody Facility facility, @PathVariable("id") int id
    ) {
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Creates the facility
     * @param facility
     * @return returns 200 http status
     */
    @PutMapping("/facility/")
    public ResponseEntity createFacility(@RequestBody Facility facility
    ) {
        return new ResponseEntity(HttpStatus.OK);
    }
}
