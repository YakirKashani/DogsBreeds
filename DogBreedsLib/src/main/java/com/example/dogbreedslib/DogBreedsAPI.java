package com.example.dogbreedslib;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DogBreedsAPI {
    @GET("/dogs_data/all")
    Call<List<DogModel>> loadBreeds();

    @GET("/dogs_data/BreedsAndUrl")
    Call<List<BreedAndUrlModel>> loadBreedsAndUrls();

    @GET("/dogs_data/{breed_name}/{gender}/{age}")
    Call<DogModel> loadBreedDataBy_Breed_Gender_Age(
            @Path(value = "breed_name", encoded = true) String breed,
            @Path(value = "gender",encoded = true) String gender,
            @Path(value = "age") String age
    );
}
