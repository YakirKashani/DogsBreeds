package com.example.dogbreedslib;

import android.content.Context;
import android.util.Log;

import java.util.List;

public class DogData {
    private static final DogBreedsController DOG_BREEDS_CONTROLLER = new DogBreedsController();

    public interface Callback_Data<T>{
        void data(T value);
    }

    public static void getDogByBreedGenderAge(Context context, String breed,String gender,String age, Callback_Data<DogModel> callback){
        if(callback == null)
            return;
        DOG_BREEDS_CONTROLLER.fetchDogByBreedGenderAndAge(breed,gender,age,new CallbackDogData() {
            @Override
            public void readyGetDogModel(DogModel dog) {
                callback.data(dog);
            }

            @Override
            public void failed(String message) {
                Log.d("Error", "failed: " + message);
            }
        });
    }

    public static void getAllDogsAndUrls(Context context, Callback_Data<List<BreedAndUrlModel>> callback){
        if(callback == null)
            return;

        DOG_BREEDS_CONTROLLER.fetchAllBreedsAndUrls(new CallbackBreedsAndUrl() {
            @Override
            public void readyGetBreedsAndUrls(List<BreedAndUrlModel> breedAndUrlModels) {
                callback.data(breedAndUrlModels);
            }

            @Override
            public void failed(String message) {
                Log.d("Error", "failed: " + message);
            }
        });

    }

    public static void getAllDogsData(Context context, Callback_Data<List<DogModel>> callback){
        if(callback == null)
            return;

        DOG_BREEDS_CONTROLLER.fetchAllBreeds(new CallbackAllDogsData() {
            @Override
            public void readyGetAllData(List<DogModel> dogs) {
                callback.data(dogs);
            }

            @Override
            public void failed(String message) {
                Log.d("Error", "failed: " + message);
            }
        });
    }
}
