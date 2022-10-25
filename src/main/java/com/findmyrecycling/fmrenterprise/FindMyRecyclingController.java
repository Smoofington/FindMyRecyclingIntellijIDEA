package com.findmyrecycling.fmrenterprise;

import com.findmyrecycling.fmrenterprise.dto.Facility;
import com.findmyrecycling.fmrenterprise.dto.RecyclableMaterial;
import com.findmyrecycling.fmrenterprise.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class FindMyRecyclingController {

    @Autowired
    IFacilityService facilityService;

    @RequestMapping("/")
    public String index(Model model) {
        RecyclableMaterial recyclableMaterial = new RecyclableMaterial();
        Facility facility = new Facility();
        recyclableMaterial.setMaterialName("");
        facility.setFacilityAddress("4433 Cooper Rd, Blue Ash, OH 45242");
        facility.setFacilityName("Blue Ash Recreation Center");
        model.addAttribute(recyclableMaterial);
        model.addAttribute(facility);
        return "index";
    }

    @RequestMapping("/add-facility")
    public String addFacilityPage(Model model) {
        Facility facility = new Facility();
        facility.setFacilityName("Bob's Junk-Yard");
        facility.setFacilityPhotos("");
        facility.setFacilityAddress("5764 Hills Drive");
        facility.setFacilityId(110);
        facility.setMaterialId(50);
        model.addAttribute(facility);
        return "add-facility";
    }

    @RequestMapping("/saveFacility")
    public String saveFacility(Facility facility) {
        facilityService.save(facility);
        return "index";
    }

    @RequestMapping(value="/error", method = RequestMethod.GET)
    public String errorPage(){
        return "error";
    }
    @GetMapping("/facility/")
    public String fetchAllFacilities(@RequestParam(value="searchTerm", required = false, defaultValue = "None") String searchTerm, Model model) {
        List<Facility> facilities = facilityService.fetchAll(searchTerm);
        model.addAttribute("facilities", facilities);
        return "facilities";
    }

    @GetMapping("/facility/{id}/")
    public ResponseEntity fetchFacilityById(@PathVariable("id") int id) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/facility/search/{term}/", produces = "application/json")
    public List<Facility> fetchFacilitiesByTerm(@PathVariable("term") String term
    ) throws IOException {
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
