package com.saikat1102.cfood;

import java.util.List;

public class Order {
    String address, phone_number, total_price, food;

    public Order() {
    }

    public Order(String address, String phone_number, String total_price, String food) {
        this.address = address;
        this.phone_number = phone_number;
        this.total_price = total_price;
        this.food = food;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }
}
