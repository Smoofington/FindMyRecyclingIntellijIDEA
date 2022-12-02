package com.findmyrecycling.fmrenterprise.service;

import com.findmyrecycling.fmrenterprise.dto.Facility;
import com.findmyrecycling.fmrenterprise.dto.RecyclableMaterial;

import java.io.IOException;
import java.util.List;

public interface IRecyclableMaterialService {
    /**
     * Fetch all materials
     * @return list of materials or null if none
     */
    List<RecyclableMaterial> fetchAll();

    /**
     * Fetch material using an ID
     * @param id a unique identifier for a material
     * @return material or null if none
     */
    RecyclableMaterial fetchById(long id);

    /**
     * Save facility
     * @param recyclableMaterial is a recycleableMaterial object
     * @return the material that was saved
     */
    RecyclableMaterial save(RecyclableMaterial recyclableMaterial);

    /**
     * Delete the record of the material
     * @param id is a unique identifier for the material
     */
    void delete(int id) throws Exception;
}
