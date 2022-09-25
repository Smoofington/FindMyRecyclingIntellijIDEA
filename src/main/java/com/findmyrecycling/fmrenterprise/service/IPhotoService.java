package com.findmyrecycling.fmrenterprise.service;

import com.findmyrecycling.fmrenterprise.dto.Photo;


public interface IPhotoService {
    /**
     * Fetch photo using its ID
     * @param id a unique identifier for a photo
     * @return a photo
     */
    Photo fetchPhotoById(int id);
    /**
     * Display a photo on the screen
     * @param photo is a photo to be displayed
     */
    void display(Photo photo);
    /**
     * Save photo
     * @param photo is a photo object
     * @return the photo that was saved
     */
    Photo save(Photo photo);
    /**
     * Delete the record of the photo
     * @param id is a unique identifier for the photo
     */
    void delete(int id);
}
