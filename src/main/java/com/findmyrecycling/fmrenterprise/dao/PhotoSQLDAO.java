package com.findmyrecycling.fmrenterprise.dao;

import com.findmyrecycling.fmrenterprise.dto.Photo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PhotoSQLDAO implements IPhotoDAO{

    @Autowired
    PhotoRepository photoRepository;

    @Override
    public Photo save(Photo photo) {
        Photo savedPhoto = photoRepository.save(photo);
        return savedPhoto;
    }

    @Override
    public Photo fetchById(int id) {
        Optional<Photo> retrievedPhoto = photoRepository.findById(id);
        return retrievedPhoto.orElse(null);
    }

    @Override
    public void delete(int id) {
        photoRepository.deleteById(id);
    }
}
