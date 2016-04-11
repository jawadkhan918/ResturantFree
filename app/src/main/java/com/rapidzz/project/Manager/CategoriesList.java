package com.rapidzz.project.Manager;

import com.rapidzz.project.Model.Categories;

import java.util.ArrayList;
import java.util.List;

public class CategoriesList {

	private List<Categories> mCatrgories;
	private static CategoriesList sCategoriesList;

	private CategoriesList() {
		mCatrgories = new ArrayList<Categories>();
	}

	public static CategoriesList get() {
		if (sCategoriesList == null) {
			sCategoriesList = new CategoriesList();
		}
		return sCategoriesList;
	}

	public List<Categories> getCategories() {
		return mCatrgories;
	}

	public Boolean getCat(String cat) {

		for (Categories m : mCatrgories) {
			if (m.getMfvrt().equals(cat))
				return true;
		}
		return false;
	}

	public Categories getCat(int id ) {

		for (Categories m : mCatrgories) {
			if (m.getId()==id)
				return m;
		}
		return null;
	}
	
	public void addCategories(Categories newCat) {
		mCatrgories.add(newCat);
	}

	public void clearCategories() {

		mCatrgories.clear();

	}

}
