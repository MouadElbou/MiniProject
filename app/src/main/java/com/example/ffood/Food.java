package com.example.ffood;

import android.graphics.Bitmap;


public class Food {
    private String FoodName;
    private double FoodPrice;
    private String FoodDescription;
    private byte[] FoodImage;
    private int FoodID;

    public String getFoodName() {
        return FoodName;
    }

    public void setFoodName(String foodName) {
        this.FoodName = foodName;
    }

    public double getFoodPrice() {
        return FoodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.FoodPrice = foodPrice;
    }

    public String getFoodDescription() {
        return FoodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        this.FoodDescription = foodDescription;
    }

    public byte[] getFoodImage() {
        return FoodImage;
    }

    public void setFoodImage(byte[] foodImage) {
        this.FoodImage = foodImage;
    }

    public void setRestoID(int RestoID) {
        this.FoodID = RestoID;
    }

    public int getRestoID() {
        return FoodID;
    }

    public Food(String FoodName, double FoodPrice, String FoodDescription, byte[] FoodImage, int RestoID) {
        this.FoodName = FoodName;
        this.FoodPrice = FoodPrice;
        this.FoodDescription = FoodDescription;
        this.FoodImage = FoodImage;
        this.FoodID = RestoID;

    }
}