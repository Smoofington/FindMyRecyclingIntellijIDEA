package com.findmyrecycling.fmrenterprise.dao;

import com.findmyrecycling.fmrenterprise.dto.Facility;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface IFacilityRetrofitDAO {

    //TODO update method when we get an actual endpoint
    @GET("/FMRJSONdata.md")
    Call<List<Facility>> getFacility(@Query("Name") String facilityName);

}
