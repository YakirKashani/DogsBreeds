package com.example.dogbreedslib;

import java.util.List;

public interface CallbackDogData {
    void readyGetDogModel(DogModel dog);
    void failed(String message);
}
