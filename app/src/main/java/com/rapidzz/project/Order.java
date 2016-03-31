package com.rapidzz.project;

import java.util.ArrayList;

/**
 * Created by Khan on 3/27/2016.
 */

public class Order {
    private String tableId,tablePerson;
    private ArrayList<Dishes> orderItems;
    public Order(String tableId, String tablePerson,ArrayList<Dishes> orderItems) {
        this.tableId = tableId;
        this.tablePerson = tablePerson;
        this.orderItems = orderItems;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
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
}
