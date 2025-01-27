package com.example.dogbreedslib;

import java.util.List;

public interface CallbackAllDogsData {
    void readyGetAllData(List<DogModel> dogs);
    void failed(String message);
}
