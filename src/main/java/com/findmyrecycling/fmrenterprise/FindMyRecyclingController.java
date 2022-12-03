package com.findmyrecycling.fmrenterprise;

import com.findmyrecycling.fmrenterprise.dto.Facility;
import com.findmyrecycling.fmrenterprise.dto.Photo;
import com.findmyrecycling.fmrenterprise.dto.RecyclableMaterial;
import com.findmyrecycling.fmrenterprise.service.IFacilityService;
import com.findmyrecycling.fmrenterprise.service.IRecyclableMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
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
            facilityService.save(facility);
            mv.setViewName("index");
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            mv.setViewName("error");
            return mv;
        }

    }

    @GetMapping(value = "/materialJSON", produces = "application/json")
    public ResponseEntity fetchMaterialJSON() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        try {
            List<RecyclableMaterial> materials = recyclableMaterialService.fetchAll();
            for(RecyclableMaterial material : materials) {
                material.setFacility(null);
            }
            return new ResponseEntity(materials , headers, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity(headers, HttpStatus.INTERNAL_SERVER_ERROR);
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

    @GetMapping("/facility/delete/{id}/")
    public ModelAndView deleteFacilityById(@PathVariable("id") int id, Facility facility) {
        ModelAndView mv = new ModelAndView();
        try {
            facilityService.delete(id);
            mv.setViewName("index");
        } catch (Exception e) {
            mv.setViewName("error");
        }
        return mv;
    }

    @GetMapping("/facility/{id}/")
    public ModelAndView getFacilityById(@PathVariable("id") int id
    ) {
        ModelAndView mv = new ModelAndView();
        try {
            List<RecyclableMaterial> allMaterials = recyclableMaterialService.fetchAll();
            Facility facility = facilityService.fetchById(id);
            mv.addObject(facility);
            mv.addObject(allMaterials);
            mv.setViewName("edit");
        } catch (Exception e) {
            mv.setViewName("error");
        }
        return mv;
    }

    @PostMapping("/facility/{id}/")
    public ModelAndView updateFacility(@PathVariable("id") Long id, MultipartFile file, Facility facility
    ) {
        ModelAndView mv = new ModelAndView();
        try {
            byte[] byteData = file.getBytes();
            String base64String = Base64.getEncoder().encodeToString(byteData);
            facility.getPhoto().setBase64(base64String);
            facility.setFacilityId(id);
            facilityService.save(facility);
            mv.setViewName("index");
        } catch (Exception e) {
            e.printStackTrace();
            mv.setViewName("error");
        }
        return mv;
    }
}
