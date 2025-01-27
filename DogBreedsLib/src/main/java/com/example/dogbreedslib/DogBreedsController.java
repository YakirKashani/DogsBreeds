package com.example.dogbreedslib;

import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DogBreedsController {
    private static final String BASE_URL = "https://dogs-breeds-api.vercel.app";

    private DogBreedsAPI getAPI(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(
                        GsonConverterFactory.create(
                                new GsonBuilder()
                                        .setLenient()
                                        .create()
                        )
                )
                .build();
        return retrofit.create(DogBreedsAPI.class);
    }

    public void fetchDogByBreedGenderAndAge(String breed, String gender, String age, CallbackDogData callbackDogData){
        Call<DogModel> call = getAPI().loadBreedDataBy_Breed_Gender_Age(breed,gender,age);
        call.enqueue(new Callback<DogModel>() {
            @Override
            public void onResponse(Call<DogModel> call, Response<DogModel> response) {
                callbackDogData.readyGetDogModel(response.body());
            }

            @Override
            public void onFailure(Call<DogModel> call, Throwable throwable) {
                callbackDogData.failed(throwable.getMessage());
            }
        });
    }

    public void fetchAllBreedsAndUrls(CallbackBreedsAndUrl callbackBreedsAndUrl){
        Call<List<BreedAndUrlModel>> call = getAPI().loadBreedsAndUrls();
        call.enqueue(new Callback<List<BreedAndUrlModel>>() {
            @Override
            public void onResponse(Call<List<BreedAndUrlModel>> call, Response<List<BreedAndUrlModel>> response) {
                callbackBreedsAndUrl.readyGetBreedsAndUrls(response.body());
            }

            @Override
            public void onFailure(Call<List<BreedAndUrlModel>> call, Throwable throwable) {
                callbackBreedsAndUrl.failed(throwable.getMessage());
            }
        });
    }

    public void fetchAllBreeds(CallbackAllDogsData callbackAllDogsData){
        Call<List<DogModel>> call = getAPI().loadBreeds();
        call.enqueue(new Callback<List<DogModel>>() {
            @Override
            public void onResponse(Call<List<DogModel>> call, Response<List<DogModel>> response) {
                callbackAllDogsData.readyGetAllData(response.body());
            }

            @Override
            public void onFailure(Call<List<DogModel>> call, Throwable throwable) {
                callbackAllDogsData.failed((throwable.getMessage()));
            }
        });
    }


}
