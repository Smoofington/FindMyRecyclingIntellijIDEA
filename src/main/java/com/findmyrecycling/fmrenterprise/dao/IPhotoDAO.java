package com.findmyrecycling.fmrenterprise.dao;

import com.findmyrecycling.fmrenterprise.dto.Photo;

public interface IPhotoDAO {
    Photo save(Photo photo);
    Photo fetchById(int id);
    void delete(int id);
}
