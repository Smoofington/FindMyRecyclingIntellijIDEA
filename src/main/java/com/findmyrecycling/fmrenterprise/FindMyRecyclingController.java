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

    /**
     * Returns index
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String index(Model model) {
        RecyclableMaterial recyclableMaterial = new RecyclableMaterial();
        Facility facility = new Facility();
        recyclableMaterial.setMaterialName("");
        facility.setFacilityAddress("");
        model.addAttribute(recyclableMaterial);
        return "index";
    }

    /**
     * Error Page Mapping
     * is this unnecessary?
     * @return
     */
    @RequestMapping(value="/error", method = RequestMethod.GET)
    public String errorPage(){
        return "error";
    }

    /**
     * Adds a facility
     * @param model
     * @return
     */
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

    /**
     * Saves the facility
     * @param facility
     * @return
     */
    @RequestMapping("/saveFacility")
    public String saveFacility(Facility facility) {
        facilityService.save(facility);
        return "index";
    }

    /**
     * gets all facilities with the search term
     * @param searchTerm
     * @param model
     * @return
     */
    @GetMapping("/facility/")
    public String fetchAllFacilities(@RequestParam(value="searchTerm", required = false, defaultValue = "None") String searchTerm, Model model) {
        List<Facility> facilities = facilityService.fetchAll(searchTerm);
        model.addAttribute("facilities", facilities);
        return "facilities";
    }

    /**
     * Gets the facility by ID
     * @param id
     * @return
     */
    @GetMapping("/facility/{id}/")
    public ResponseEntity fetchFacilityById(@PathVariable("id") int id) {
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Gets facilities with the term
     * @param term
     * @return
     * @throws IOException
     */
    @GetMapping(value = "/facility/search/{term}/", produces = "application/json")
    public List<Facility> fetchFacilitiesByTerm(@PathVariable("term") String term
    ) throws IOException {
        List<Facility> facilities = facilityService.fetchByGlobalSearch(term);
        return facilities;
    }

    /**
     * Delete facility with ID
     * @param id
     * @return
     */
    @DeleteMapping("/facility/{id}/")
    public ResponseEntity deleteFacilityById(@PathVariable("id") int id) {
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Updates the facility with the id
     * @param facility
     * @param id
     * @return
     */
    @PatchMapping("/facility/{id}/")
    public ResponseEntity updateFacilityById(@RequestBody Facility facility, @PathVariable("id") int id
    ) {
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Creates a facility
     * @param facility
     * @return
     */
    @PutMapping("/facility/")
    public ResponseEntity createFacility(@RequestBody Facility facility
    ) {
        return new ResponseEntity(HttpStatus.OK);
    }
}
