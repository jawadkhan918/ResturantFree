package com.rapidzz.project;

/**
 * Created by Talhazk on 21-Mar-16.
 */
public class CategoriesModel {
    public String catName,itemName;
    public int catId,itemPrice;

    public CategoriesModel(int catId, String catName) {
        this.catId = catId;
        this.catName = catName;
    }

    public CategoriesModel(int catId, String itemName, int itemPrice) {
        this.catId = catId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public CategoriesModel(int catId, String catName, String itemName, int itemPrice) {
        this.catId = catId;
        this.catName = catName;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }
}
