package com.example.model;

import androidx.annotation.NonNull;

public class Toy {

    private String name;
    private double price;

    public Toy() {
    }

    public Toy(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() { return price; }


    public void setPrice(double price) {
        this.price = price;
    }
}
