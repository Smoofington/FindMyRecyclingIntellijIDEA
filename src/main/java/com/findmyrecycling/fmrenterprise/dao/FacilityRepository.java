package com.findmyrecycling.fmrenterprise.dao;

import com.findmyrecycling.fmrenterprise.dto.Facility;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface FacilityRepository extends CrudRepository<Facility, Long>{
}
