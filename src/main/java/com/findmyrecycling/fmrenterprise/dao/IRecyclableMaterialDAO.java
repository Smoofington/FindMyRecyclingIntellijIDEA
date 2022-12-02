package com.findmyrecycling.fmrenterprise.dao;

import com.findmyrecycling.fmrenterprise.dto.RecyclableMaterial;

import java.util.List;

public interface IRecyclableMaterialDAO {
    /**
     *
     * @param recyclableMaterial material to save
     * @return the material that was saved
     */
    RecyclableMaterial save(RecyclableMaterial recyclableMaterial);

    /**
     *
     * @param id the id of the material to retrieve
     * @return the material with the id requested or null if no material exists
     */
    RecyclableMaterial fetchById(long id);

    /**
     *
     * @param id the id of the material to delete
     */
    void delete(long id);

    /**
     *
     * @return all materials in the database
     */
    List<RecyclableMaterial> fetchAll();
}
