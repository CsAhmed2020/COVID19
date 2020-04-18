package com.example.covid19.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.covid19.API.RetrofitAPI;
import com.example.covid19.Model.Country;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EgyptViewModel extends ViewModel {

    MutableLiveData<Country> egypt;
    MutableLiveData<Boolean> isLoading=new MutableLiveData<>();
    MutableLiveData<Boolean> isError=new MutableLiveData<>();

    public MutableLiveData<Country> getEgypt() {
        if (egypt==null){
            egypt=new MutableLiveData<>();
            getNewCases();
        }
        return egypt;
    }

    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public MutableLiveData<Boolean> getIsError() {
        return isError;
    }

    private void getNewCases(){
        isError.postValue(false);
        isLoading.postValue(true);
        Call<Country> call = RetrofitAPI.getInstance().getEgyptCases();
        call.enqueue(new Callback<Country>() {
            @Override
            public void onResponse(Call<Country> call, Response<Country> response) {
                isLoading.postValue(false);
                if(response.isSuccessful()){
                    egypt.postValue(response.body());
                }else {
                    isLoading.postValue(true);
                }
            }

            @Override
            public void onFailure(Call<Country> call, Throwable t) {
                isLoading.postValue(false);
                isError.postValue(true);
            }
        });
    }

    public void refresh(){
        getNewCases();
    }
    public void reset(){
        isLoading.postValue(false);
        isError.postValue(false);
    }


}
