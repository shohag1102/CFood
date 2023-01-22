package com.saikat1102.cfood;

public class UpdateDishModel {

    String dishes,randomUID,description,quantity,price,imageURL,chefId;

    // Press Alt+insert

    public UpdateDishModel(){

    }

    public UpdateDishModel(String dishes, String randomUID, String description, String quantity, String price, String imageURL, String chefId) {
        this.dishes = dishes;
        this.randomUID = randomUID;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.imageURL = imageURL;
        this.chefId = chefId;
    }

    public String getDishes() {
        return dishes;
    }

    public void setDishes(String dishes) {
        this.dishes = dishes;
    }

    public String getRandomUID() {
        return randomUID;
    }

    public void setRandomUID(String randomUID) {
        this.randomUID = randomUID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getChefId() {
        return chefId;
    }

    public void setChefId(String chefId) {
        this.chefId = chefId;
    }
}