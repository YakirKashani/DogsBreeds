package com.example.dogbreedslib;

public class BreedAndUrlModel {
    private String breed_name;
    private String url_pic;

    public BreedAndUrlModel() {
    }

    public BreedAndUrlModel(String breed_name, String url_pic) {
        this.breed_name = breed_name;
        this.url_pic = url_pic;
    }

    public String getBreed_name() {
        return breed_name;
    }

    public void setBreed_name(String breed_name) {
        this.breed_name = breed_name;
    }

    public String getUrl_pic() {
        return url_pic;
    }

    public void setUrl_pic(String url_pic) {
        this.url_pic = url_pic;
    }
}
