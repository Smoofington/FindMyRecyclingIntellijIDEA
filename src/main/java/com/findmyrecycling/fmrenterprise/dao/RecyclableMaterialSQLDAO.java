package com.findmyrecycling.fmrenterprise.dao;

import com.findmyrecycling.fmrenterprise.dto.RecyclableMaterial;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class RecyclableMaterialSQLDAO implements IRecyclableMaterialDAO {

    @Autowired
    RecyclableMaterialRepository materialRepository;

    @Override
    public RecyclableMaterial save(RecyclableMaterial recyclableMaterial) {
        RecyclableMaterial savedMaterial = materialRepository.save(recyclableMaterial);
        return savedMaterial;
    }

    @Override
    public RecyclableMaterial fetchById(long id) {
        Optional<RecyclableMaterial> retrievedMaterial = materialRepository.findById(id);
        return retrievedMaterial.orElse(null);
    }

    @Override
    public void delete(long id) {
        materialRepository.deleteById(id);
    }
}
