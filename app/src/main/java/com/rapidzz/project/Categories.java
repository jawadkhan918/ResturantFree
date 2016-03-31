package com.rapidzz.project;

import java.util.List;

public class Categories {

	private int mId;
	private String mCat;
	private String mImage;

	public Categories(int id,String mCat , String mLink) {
		super();
		this.mCat = mCat;
		this.mImage = mLink;
		this.mId = id;
	}
	public String getMfvrt() {
		return mCat;
	}
	public void setMfvrt(String mfvrt) {
		this.mCat = mfvrt;
	}
	
	
	public int getId() {
		return mId;
	}
	public void setId(int id) {
		this.mId = id;
	}

	
	public String getCat() {
		return mCat;
	}

	public void setCat(String cat) {
		mCat = cat;
	}


    public String getmImage() {
        return mImage;
    }

    public void setmImage(String mImage) {
        this.mImage = mImage;
    }

    @Override
	public String toString() {
		return "Favorities [mfvrt=" + mCat +  "]";
	}

	
}
