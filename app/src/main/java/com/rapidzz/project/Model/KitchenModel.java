package com.rapidzz.project.Model;

/**
 * Created by Talhazk on 11-Mar-16.
 */
public class KitchenModel {
    public String head,desc,price;

    public KitchenModel(String desc, String head, String price) {
        this.desc = desc;
        this.head = head;
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
