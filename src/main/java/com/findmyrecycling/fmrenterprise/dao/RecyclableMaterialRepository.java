package com.findmyrecycling.fmrenterprise.dao;

import com.findmyrecycling.fmrenterprise.dto.RecyclableMaterial;
import org.springframework.data.repository.CrudRepository;

public interface RecyclableMaterialRepository extends CrudRepository<RecyclableMaterial, Long> {
}
