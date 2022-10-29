package com.findmyrecycling.fmrenterprise;

import com.findmyrecycling.fmrenterprise.dto.Facility;
import com.findmyrecycling.fmrenterprise.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
    public String addFacilityPage(Model model) {
        Facility facility = new Facility();
        model.addAttribute("facility", facility);
        return "facility";
    }

    /**
     * Create a facility.
     * @param facility facility to be created.
     * @return Redirects to the index.html page (home page).
     */
    @PostMapping(value = "/facility/add/", consumes = "application/json", produces = "application/json")
    public String saveFacility(@ModelAttribute("facility") Facility facility) {
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
    public ResponseEntity deleteFacilityById(
            @PathVariable("id") int id) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @PatchMapping("/facility/{id}/")
    public ResponseEntity updateFacilityById(
            @RequestBody Facility facility,
            @PathVariable("id") int id) {
        return new ResponseEntity(HttpStatus.OK);
    }
}
