package com.example.covid19.API;


import com.example.covid19.Model.AllCases;
import com.example.covid19.Model.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface COVID19CLIENT {

    @GET("/v2/all")
    Call<AllCases> getAllCases();

    @GET("/v2/countries/egy")
    Call<Country> getEgyptCases();

    @GET("/v2/countries?sort=totalCases")
    Call<List<Country>> getAllCountries();
}
