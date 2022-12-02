package com.findmyrecycling.fmrenterprise.service;

import com.findmyrecycling.fmrenterprise.dao.IRecyclableMaterialDAO;
import com.findmyrecycling.fmrenterprise.dto.RecyclableMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecyclableMaterialService implements IRecyclableMaterialService{

    @Autowired
    IRecyclableMaterialDAO recyclableMaterialDAO;

    @Override
    public List<RecyclableMaterial> fetchAll() {
        return recyclableMaterialDAO.fetchAll();
    }

    @Override
    public RecyclableMaterial fetchById(long id) {
        return recyclableMaterialDAO.fetchById(id);
    }

    @Override
    public RecyclableMaterial save(RecyclableMaterial recyclableMaterial) {
        return recyclableMaterialDAO.save(recyclableMaterial);
    }

    @Override
    public void delete(int id) throws Exception {
        recyclableMaterialDAO.delete(id);
    }
}
