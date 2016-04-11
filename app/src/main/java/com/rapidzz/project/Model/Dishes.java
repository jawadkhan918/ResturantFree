package com.rapidzz.project.Model;

/**
 * Created by Khan on 3/31/2016.
 */
public class Dishes {

    private int dishId;
    private double dishQty;
    private String dishAdd,dishReduction,dishRemarks,dishSize,dishName;


    public Dishes(int dishId, double dishQty, String dishAdd, String dishReduction, String dishRemarks, String dishSize,String dishName) {
        this.dishId = dishId;
        this.dishQty = dishQty;
        this.dishAdd = dishAdd;
        this.dishReduction = dishReduction;
        this.dishRemarks = dishRemarks;
        this.dishSize = dishSize;
        this.dishName = dishName;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public double getDishQty() {
        return dishQty;
    }

    public void setDishQty(double dishQty) {
        this.dishQty = dishQty;
    }

    public String getDishAdd() {
        return dishAdd;
    }

    public void setDishAdd(String dishAdd) {
        this.dishAdd = dishAdd;
    }

    public String getDishReduction() {
        return dishReduction;
    }

    public void setDishReduction(String dishReduction) {
        this.dishReduction = dishReduction;
    }

    public String getDishRemarks() {
        return dishRemarks;
    }

    public void setDishRemarks(String dishRemarks) {
        this.dishRemarks = dishRemarks;
    }

    public String getDishSize() {
        return dishSize;
    }

    public void setDishSize(String dishSize) {
        this.dishSize = dishSize;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }
}
