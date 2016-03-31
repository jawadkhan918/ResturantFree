package com.rapidzz.project;

import java.util.ArrayList;

public class ItemList {

	private ArrayList<Items> mCatrgories;
	private static ItemList sCategoriesList;

	private ItemList() {
		mCatrgories = new ArrayList<Items>();
	}

	public static ItemList get() {
		if (sCategoriesList == null) {
			sCategoriesList = new ItemList();
		}
		return sCategoriesList;
	}

	public ArrayList<Items> getItems() {
		return mCatrgories;
	}

	public Boolean getCat(String cat) {

			return false;
	}

	public Categories getCat(int id ) {

			return null;
	}

	public void addCategories(Items newCat) {
		mCatrgories.add(newCat);
	}

	public void clearCategories() {

		mCatrgories.clear();

	}

}
