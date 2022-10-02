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

    @RequestMapping("/addfacility.html")
    public String addFacilityPage() {
        return "addfacility";
    }

    @RequestMapping("/index.html")
    public String returnIndex() {return "index";}

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
