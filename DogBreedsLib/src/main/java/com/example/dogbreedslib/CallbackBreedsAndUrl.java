package com.example.dogbreedslib;

import java.util.List;

public interface CallbackBreedsAndUrl {
    void readyGetBreedsAndUrls(List<BreedAndUrlModel> breedAndUrlModels);
    void failed(String message);
}
