package com.rapidzz.project;

import java.util.ArrayList;

/**
 * Created by Khan on 3/27/2016.
 */

public class Order {
    private String tablePerson;
    int tableId;
    private ArrayList<Dishes> orderItems;
    public Order(int tableId, String tablePerson,ArrayList<Dishes> orderItems) {
        this.tableId = tableId;
        this.tablePerson = tablePerson;
        this.orderItems = orderItems;
        this.tableId =tableId;
    }


    public String getTablePerson() {
        return tablePerson;
    }

    public void setTablePerson(String tablePerson) {
        this.tablePerson = tablePerson;
    }

    public ArrayList<Dishes> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ArrayList<Dishes> orderItems) {
        this.orderItems = orderItems;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }
}
