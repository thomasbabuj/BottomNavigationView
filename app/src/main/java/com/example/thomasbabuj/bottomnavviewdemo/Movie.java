package com.example.thomasbabuj.bottomnavviewdemo;

/**
 * Created by thomasbabuj on 30/12/17.
 */

public class Movie {
    String title;
    String image;
    String price;

    public Movie(String title, String image, String price) {
        this.title = title;
        this.image = image;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getPrice() {
        return price;
    }
}
