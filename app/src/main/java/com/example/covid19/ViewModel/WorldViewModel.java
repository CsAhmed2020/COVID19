package com.example.covid19.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.covid19.API.RetrofitAPI;
import com.example.covid19.Model.AllCases;
import com.example.covid19.Model.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WorldViewModel extends ViewModel {

    MutableLiveData<List<Country>> countries;
    MutableLiveData<AllCases> allCases;
    MutableLiveData<Boolean> isLoading=new MutableLiveData<>();
    MutableLiveData<Boolean> isFirstLoading=new MutableLiveData<>();
    MutableLiveData<Boolean> isError=new MutableLiveData<>();

    public LiveData<List<Country>> getCountries() {
        if (countries==null){
            isLoading.postValue(true);
            isFirstLoading.postValue(true);
            countries=new MutableLiveData<>();
            getCountriesCases();
        }
        return countries;
    }

    public MutableLiveData<AllCases> getAllCases() {
        if (allCases==null){
            isFirstLoading.postValue(true);
            allCases=new MutableLiveData<>();
            getWorldCases();
        }
        return allCases;
    }

    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public MutableLiveData<Boolean> getIsFirstLoading() {
        return isFirstLoading;
    }

    public MutableLiveData<Boolean> getIsError() {
        return isError;
    }

    public void setIsFirstLoading(Boolean isFirstLoading) {
        this.isFirstLoading.postValue(isFirstLoading);
    }

    public void getWorldCases(){
        isError.postValue(false);
        isLoading.postValue(true);
        Call<AllCases> call= RetrofitAPI.getInstance().getAllCases();
        call.enqueue(new Callback<AllCases>() {
            @Override
            public void onResponse(Call<AllCases> call, Response<AllCases> response) {
                isFirstLoading.postValue(false);
                isLoading.postValue(false);
                if(response.isSuccessful()){
                    allCases.postValue(response.body());
                }else
                {
                    isError.postValue(true);
                }
            }

            @Override
            public void onFailure(Call<AllCases> call, Throwable t) {
                isError.postValue(true);
                isLoading.postValue(false);
                isFirstLoading.postValue(false);
            }
        });
    }

    public void getCountriesCases(){
        isLoading.postValue(true);
        isError.postValue(false);
        Call<List<Country>> call= RetrofitAPI.getInstance().getAllCountries();
        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                isFirstLoading.postValue(false);
                isLoading.postValue(false);
                if(response.isSuccessful()){
                    countries.postValue(response.body());
                }else {
                    isError.postValue(true);
                }
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                isError.postValue(true);
                isLoading.postValue(false);
                isFirstLoading.postValue(false);
            }
        });
    }

    public void refresh(){
        getWorldCases();
        getCountriesCases();
    }
}
