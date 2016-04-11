package com.rapidzz.project.Manager;

import com.rapidzz.project.Model.Categories;
import com.rapidzz.project.Model.Order;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderList {

    private HashMap<Integer ,Order> mOrders;
    private static OrderList sOrderList;

    private OrderList() {
        mOrders = new HashMap<Integer,Order>();
    }

    public static OrderList get() {
        if (sOrderList == null) {
            sOrderList = new OrderList();
        }
        return sOrderList;
    }

    public HashMap<Integer ,Order> getOrders() {
        return mOrders;
    }

    public Boolean getCat(String cat) {

        return false;
    }

    public Categories getCat(int id) {

        return null;
    }

    public void addOrder(Order newOrder) {
        mOrders.put(newOrder.getTableId(),newOrder);
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
