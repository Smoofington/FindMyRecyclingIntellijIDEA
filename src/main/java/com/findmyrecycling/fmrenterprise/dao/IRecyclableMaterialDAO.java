package com.findmyrecycling.fmrenterprise.dao;

import com.findmyrecycling.fmrenterprise.dto.RecyclableMaterial;

public interface IRecyclableMaterialDAO {
    RecyclableMaterial save(RecyclableMaterial recyclableMaterial);
    RecyclableMaterial fetchById(long id);
    void delete(long id);
}
