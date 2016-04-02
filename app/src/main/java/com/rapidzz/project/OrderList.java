package com.rapidzz.project;

import java.util.ArrayList;

public class OrderList {

    private ArrayList<Order> mOrders;
    private static OrderList sOrderList;

    private OrderList() {
        mOrders = new ArrayList<Order>();
    }

    public static OrderList get() {
        if (sOrderList == null) {
            sOrderList = new OrderList();
        }
        return sOrderList;
    }

    public ArrayList<Order> getOrders() {
        return mOrders;
    }

    public Boolean getCat(String cat) {

        return false;
    }

    public Categories getCat(int id) {

        return null;
    }

    public void addOrder(Order newOrder) {
        mOrders.add(newOrder);
    }

    public void clearCategories() {

        mOrders.clear();

    }

    public Order getOrder(int tableName) {
		for(int i = 0;i < mOrders.size() ; i++){
            if(tableName == mOrders.get(i).getTableId()){
                return mOrders.get(i);
            }
        }
        return null;
    }

}
