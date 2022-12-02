package com.findmyrecycling.fmrenterprise.dao;

import com.findmyrecycling.fmrenterprise.dto.Photo;

public interface IPhotoDAO {
    /**
     *
     * @param photo photo to save
     * @return the photo that was saved
     */
    Photo save(Photo photo);

    /**
     *
     * @param id the id of the photo to retrieve
     * @return a photo with id provided in the params or null if no photo exists
     */
    Photo fetchById(int id);

    /**
     *
     * @param id the id of the photo to be deleted
     */
    void delete(int id);
}
