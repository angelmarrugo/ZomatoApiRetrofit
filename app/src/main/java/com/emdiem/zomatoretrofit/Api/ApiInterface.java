package com.emdiem.zomatoretrofit.Api;

import com.emdiem.zomatoretrofit.model.Establishments;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("establishments")
    Call<Establishments> establishments(
            @Query("city_id") int city
    );
}
