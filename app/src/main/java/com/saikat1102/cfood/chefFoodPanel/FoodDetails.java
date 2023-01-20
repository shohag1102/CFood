package com.saikat1102.cfood.chefFoodPanel;

public class FoodDetails {

    public String dishes,quantity,price,description,imageURL,randomUID,cid;
    // Alt+insert


    public FoodDetails(String dishes, String quantity, String price, String description, String imageURL, String randomUID, String cid) {
        this.dishes = dishes;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.imageURL = imageURL;
        this.randomUID = randomUID;
        this.cid = cid;
    }

    public FoodDetails() {
    }

    public String getDishes() {
        return dishes;
    }

    public void setDishes(String dishes) {
        this.dishes = dishes;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getRandomUID() {
        return randomUID;
    }

    public void setRandomUID(String randomUID) {
        this.randomUID = randomUID;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
}