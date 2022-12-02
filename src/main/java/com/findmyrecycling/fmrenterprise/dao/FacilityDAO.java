package com.findmyrecycling.fmrenterprise.dao;

import com.findmyrecycling.fmrenterprise.dto.Facility;
import org.springframework.stereotype.Repository;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

@Repository("facilityDAO")
public class FacilityDAO implements IFacilityDAO{
    @Override
    public Facility save(Facility facility) {
        return facility;
    }

    @Override
    public List<Facility> fetchAll() {
        return null;
    }

    @Override
    public Facility fetchById(long id) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<Facility> fetchByGlobalSearch(String term) throws IOException {
        Retrofit retrofitInstance = RetrofitClientInstance.getRetrofitInstance();
        IFacilityRetrofitDAO facilityRetrofitDAO = retrofitInstance.create(IFacilityRetrofitDAO.class);
        Call<List<Facility>> allFacilities = facilityRetrofitDAO.getFacility(term);
        Response<List<Facility>> execute = allFacilities.execute();
        List<Facility> facilities = execute.body();
        return facilities;
    }

}
