package com.rapidzz.project.Model;

/**
 * Created by Khan on 3/27/2016.
 */

public class Items {
    private String itemName,itemImage;
    private int itemId,catId;
    private double item_price;

    public Items(String itemName, String itemImage,double item_price ,int itemId,int catId) {
        this.itemName = itemName;
        this.itemImage = itemImage;
        this.itemId = itemId;
        this.catId = catId;
        this.item_price=item_price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public double getItem_price() {
        return item_price;
    }

    public void setItem_price(double item_price) {
        this.item_price = item_price;
    }
}