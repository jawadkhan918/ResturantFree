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

	public ArrayList<Order> getItems() {
		return mOrders;
	}

	public Boolean getCat(String cat) {

			return false;
	}

	public Categories getCat(int id ) {

			return null;
	}

	public void addCategories(Order newCat) {
		mOrders.add(newCat);
	}

	public void clearCategories() {

		mOrders.clear();

	}

}
