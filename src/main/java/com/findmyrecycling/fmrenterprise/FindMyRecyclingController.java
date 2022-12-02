package com.findmyrecycling.fmrenterprise;

import com.findmyrecycling.fmrenterprise.dao.FacilitySQLDAO;
import com.findmyrecycling.fmrenterprise.dto.Facility;
import com.findmyrecycling.fmrenterprise.dto.RecyclableMaterial;
import com.findmyrecycling.fmrenterprise.service.FacilityService;
import com.findmyrecycling.fmrenterprise.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FindMyRecyclingController {

//    @Autowired
    IFacilityService facilityService = new FacilityService(new FacilitySQLDAO());

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
    public ModelAndView saveFacility(Facility facility) {
        ModelAndView mv = new ModelAndView();
        try {
            RecyclableMaterial rm = new RecyclableMaterial();
            rm.setMaterialName("Iron");
            rm.setMaterialId(1L);
            facility.setRecyclableMaterial(rm);
            facilityService.save(facility);

            mv.setViewName("index");
            mv.addObject(rm);
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            mv.setViewName("error");
            return mv;
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

    @RequestMapping(value = "/search")
    public String search(Model model) {
        model.addAttribute(model);
        return "search";
    }

    @GetMapping(value = "/search")
    public ModelAndView search(@RequestParam(name = "searchTerm") String searchTerm) throws IOException {
        ModelAndView mv = new ModelAndView();
        System.out.println("Get");
        List<Facility> facilities = facilityService.fetchByGlobalSearch(searchTerm);
        mv.setViewName("search");
        mv.addObject(facilities);
        return mv;
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
