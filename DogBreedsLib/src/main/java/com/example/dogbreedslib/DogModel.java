package com.example.dogbreedslib;

public class DogModel {
    private String _id;
    private String breed_name;
    private String gender;
    private String from_age;
    private String to_age;
    private String avg_height_min;
    private String avg_height_max;
    private String avg_weight_min;
    private String avg_weight_max;
    private String avg_drink;
    private String avg_food;
    private String created_at;
    private String updated_at;
    private String pic_url;

    public DogModel() {
    }

    public DogModel(String _id, String breed_name, String gender, String from_age, String to_age, String avg_height_min, String avg_height_max, String avg_weight_min, String avg_weight_max, String avg_drink, String avg_food, String created_at, String updated_at, String pic_url) {
        this._id = _id;
        this.breed_name = breed_name;
        this.gender = gender;
        this.from_age = from_age;
        this.to_age = to_age;
        this.avg_height_min = avg_height_min;
        this.avg_height_max = avg_height_max;
        this.avg_weight_min = avg_weight_min;
        this.avg_weight_max = avg_weight_max;
        this.avg_drink = avg_drink;
        this.avg_food = avg_food;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.pic_url = pic_url;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getBreed_name() {
        return breed_name;
    }

    public void setBreed_name(String breed_name) {
        this.breed_name = breed_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFrom_age() {
        return from_age;
    }

    public void setFrom_age(String from_age) {
        this.from_age = from_age;
    }

    public String getTo_age() {
        return to_age;
    }

    public void setTo_age(String to_age) {
        this.to_age = to_age;
    }

    public String getAvg_height_min() {
        return avg_height_min;
    }

    public void setAvg_height_min(String avg_height_min) {
        this.avg_height_min = avg_height_min;
    }

    public String getAvg_height_max() {
        return avg_height_max;
    }

    public void setAvg_height_max(String avg_height_max) {
        this.avg_height_max = avg_height_max;
    }

    public String getAvg_weight_min() {
        return avg_weight_min;
    }

    public void setAvg_weight_min(String avg_weight_min) {
        this.avg_weight_min = avg_weight_min;
    }

    public String getAvg_weight_max() {
        return avg_weight_max;
    }

    public void setAvg_weight_max(String avg_weight_max) {
        this.avg_weight_max = avg_weight_max;
    }

    public String getAvg_drink() {
        return avg_drink;
    }

    public void setAvg_drink(String avg_drink) {
        this.avg_drink = avg_drink;
    }

    public String getAvg_food() {
        return avg_food;
    }

    public void setAvg_food(String avg_food) {
        this.avg_food = avg_food;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }
}
