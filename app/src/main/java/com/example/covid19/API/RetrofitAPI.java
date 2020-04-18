package com.example.covid19.API;

import com.example.covid19.Model.AllCases;
import com.example.covid19.Model.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAPI {

    private static RetrofitAPI instance;
    private static Retrofit baseURL;
    private static COVID19CLIENT covidClient;

    public static RetrofitAPI getInstance() {
        if(instance==null){
            instance=new RetrofitAPI();
        }
        return instance;
    }

    private RetrofitAPI() {
        //https://corona.lmao.ninja
        //https://corona.lmao.ninja/v2/countries
        baseURL=new Retrofit.Builder().baseUrl("https://corona.lmao.ninja").addConverterFactory(GsonConverterFactory.create()).build();
        covidClient=baseURL.create(COVID19CLIENT.class);
    }

    public Call<AllCases> getAllCases(){
        return covidClient.getAllCases();
    }
    public Call<Country> getEgyptCases(){
        return covidClient.getEgyptCases();
    }
    public Call<List<Country>> getAllCountries(){
        return covidClient.getAllCountries();
    }
}
