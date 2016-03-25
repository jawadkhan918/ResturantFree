package com.rapidzz.project;

/**
 * Created by Talhazk on 21-Mar-16.
 */
public class ItemModel {

        public  int catId;
        public String itemName;
        public int itemPrice;

        public ItemModel(int catId, String itemName, int itemPrice) {
                this.catId = catId;
                this.itemName = itemName;
                this.itemPrice = itemPrice;
        }

        public int getCatId() {
                return catId;
        }

        public void setCatId(int catId) {
                this.catId = catId;
        }

        public String getItemName() {
                return itemName;
        }

        public void setItemName(String itemName) {
                this.itemName = itemName;
        }

        public int getItemPrice() {
                return itemPrice;
        }

        public void setItemPrice(int itemPrice) {
                this.itemPrice = itemPrice;
        }

}
