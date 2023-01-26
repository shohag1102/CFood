package com.saikat1102.cfood;

import java.util.List;

public class FoodOrdered {
    String phone_number, address, total_price;
    List<Cart> foods;

    public FoodOrdered() {
    }

    public FoodOrdered(String phone_number, String address, List<Cart> foods, String total_price) {
        this.phone_number = phone_number;
        this.address = address;
        this.foods = foods;
        this.total_price = total_price;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Cart> getFoods() {
        return foods;
    }

    public void setFoods(List<Cart> foods) {
        this.foods = foods;
    }
}
