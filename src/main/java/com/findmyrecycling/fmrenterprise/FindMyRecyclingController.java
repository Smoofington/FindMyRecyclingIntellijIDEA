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
import java.util.ArrayList;
import java.util.List;

@Controller
public class FindMyRecyclingController {

    @Autowired
    IFacilityService facilityService;

    @RequestMapping("/")
    public String index(Model model) {
        //try {
            RecyclableMaterial recyclableMaterial = new RecyclableMaterial();
            Facility facility = new Facility();
            recyclableMaterial.setMaterialName("");
            facility.setFacilityAddress("4433 Cooper Rd, Blue Ash, OH 45242");
            facility.setFacilityName("Blue Ash Recreation Center");
            model.addAttribute(recyclableMaterial);
            model.addAttribute(facility);
            return "index";
//        } catch (Exception e) {
//            return "error";
//            // return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
//        }

    }

    @RequestMapping("/facility/add")
    public String addFacilityPage(Model model) {
        //try {
            Facility facility = new Facility();
            facility.setFacilityName("Bob's Junk-Yard");
            facility.setFacilityPhotos(new ArrayList<>());
            facility.setFacilityAddress("5764 Hills Drive");
            facility.setFacilityId(110L);
            model.addAttribute(facility);
            return "add-facility";
//        } catch (Exception e) {
//            return "error";
//            // return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
    }

    @RequestMapping("/saveFacility")
    public String saveFacility(Facility facility) {
        try {
            facilityService.save(facility);
            return "index";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }

    }

    @GetMapping("/facility/")
    public String fetchAllFacilities(@RequestParam(value="searchTerm", required = false, defaultValue = "None") String searchTerm, Model model) {
        try {
            List<Facility> facilities = facilityService.fetchAll();
            model.addAttribute("facilities", facilities);
            return "facilities";
        } catch (Exception e) {
            return "error";
            // return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/facility/{id}/")
    public ResponseEntity fetchFacilityById(@PathVariable("id") int id) {
        try {
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(value = "/facility/search/{term}/", produces = "application/json")
    public List<Facility> fetchFacilitiesByTerm(@PathVariable("term") String term
    ) throws IOException {
        List<Facility> facilities = facilityService.fetchByGlobalSearch(term);
        return facilities;
    }

    @DeleteMapping("/facility/{id}/")
    public ResponseEntity deleteFacilityById(@PathVariable("id") int id) {
        try {
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/facility/{id}/")
    public ResponseEntity updateFacilityById(@RequestBody Facility facility, @PathVariable("id") int id
    ) {
        try {
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/facility/")
    public ResponseEntity createFacility(@RequestBody Facility facility
    ) {
        try {
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
