package org.cjug.presentations.cordova.cordova.controller;

/**
 * Created by freddy on 2/17/2018.
 */
public class PhoneInfo {
    String name;
    String price;
    String image;

    public PhoneInfo() {
    }

    public PhoneInfo(String name, String price, String image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }
}
