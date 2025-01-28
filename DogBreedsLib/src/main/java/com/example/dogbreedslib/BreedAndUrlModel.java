package com.example.dogbreedslib;

public class BreedAndUrlModel {
    private String breed_name;
    private String pic_url;

    public BreedAndUrlModel() {
    }

    public BreedAndUrlModel(String breed_name, String pic_url) {
        this.breed_name = breed_name;
        this.pic_url = pic_url;
    }

    public String getBreed_name() {
        return breed_name;
    }

    public void setBreed_name(String breed_name) {
        this.breed_name = breed_name;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }
}
