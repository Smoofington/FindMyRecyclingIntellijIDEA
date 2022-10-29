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
    public String index() {
        return "index";
    }

    @RequestMapping("/AddFacility.html")
    public String addFacilityPage(Model model) {
        Facility facility = new Facility();
        facility.setFacilityName("Bob's Junk-Yard");
        facility.setFacilityPhotos("");
        facility.setFacilityAddress("5764 Hills Drive");
        facility.setFacilityId(110L);
        facility.setMaterialId(50L);
        model.addAttribute(facility);
        return "AddFacility";
    }

    @RequestMapping("/saveFacility")
    public String saveFacility(Facility facility) {
        facilityService.save(facility);
        return "index";
    }

    @GetMapping("/facilities/")
    public List<Facility> fetchAllFacilities() {
        return facilityService.fetchAll();
    }

    @PostMapping(value = "/facilities/search/", produces = "application/json")
    public String fetchFacilitiesByTerm(
            @PathParam("searchTerm") String searchTerm, Model model) throws IOException {
        model.addAttribute("searchTerm", searchTerm);
        model.addAttribute("facilityList", facilityService.fetchAll(searchTerm));
        return "index";
    }

    @GetMapping("/facility/{id}/")
    public ResponseEntity fetchFacilityById(@PathVariable("id") int id) {
        return new ResponseEntity(HttpStatus.OK);
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
