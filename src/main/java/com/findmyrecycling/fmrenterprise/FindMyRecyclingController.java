package com.findmyrecycling.fmrenterprise;

import com.findmyrecycling.fmrenterprise.dto.Facility;
import com.findmyrecycling.fmrenterprise.dto.Photo;
import com.findmyrecycling.fmrenterprise.dto.RecyclableMaterial;
import com.findmyrecycling.fmrenterprise.service.IFacilityService;
import com.findmyrecycling.fmrenterprise.service.IRecyclableMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Controller
public class FindMyRecyclingController {

    @Autowired
    IFacilityService facilityService;
    @Autowired
    IRecyclableMaterialService recyclableMaterialService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/facility/add")
    public String addFacility(Model model) {
        List<RecyclableMaterial> materials = recyclableMaterialService.fetchAll();
        Facility facility = new Facility();
        model.addAttribute(facility);
        model.addAttribute(materials);
        return "add-facility";
    }

    @PostMapping("/saveFacility")
    public ModelAndView saveFacility(@RequestParam("file") MultipartFile file, Facility facility){
        ModelAndView mv = new ModelAndView();
        try {
            byte[] byteData = file.getBytes();
            String base64String = Base64.getEncoder().encodeToString(byteData);
            Photo photo = new Photo();
            photo.setBase64(base64String);
            facility.setPhoto(photo);
        } catch (IOException e) {
            mv.setViewName("error");
            return mv;
        }
        try {
            facilityService.save(facility);

            mv.setViewName("index");
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

    @GetMapping(value = "/search")
    public ModelAndView search(@RequestParam(name = "searchTerm") String searchTerm) throws IOException {
        ModelAndView mv = new ModelAndView();
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
