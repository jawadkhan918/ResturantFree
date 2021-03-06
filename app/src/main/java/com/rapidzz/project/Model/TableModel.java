package com.rapidzz.project.Model;
/**
 * Created by Talhazk on 18-Mar-16.
 */
public class TableModel {
    int status,table_id,table_numperson,table_status,table_active;
    String table_name="",table_number;
    Boolean occupied;

    public TableModel(int status, int table_id , String table_number,  int table_numperson, String table_name   , int table_status,int table_active) {
        this.status = status;
        this.table_active = table_active;
        this.table_id = table_id;
        this.table_name = table_name;
        this.table_number = table_number;
        this.table_numperson = table_numperson;
        this.table_status = table_status;
        occupied = true;

    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTable_active() {
        return table_active;
    }

    public void setTable_active(int table_active) {
        this.table_active = table_active;
    }

    public int getTable_id() {
        return table_id;
    }

    public void setTable_id(int table_id) {
        this.table_id = table_id;
    }

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    public String getTable_number() {
        return table_number;
    }

    public void setTable_number(String table_number) {
        this.table_number = table_number;
    }

    public int getTable_numperspn() {
        return table_numperson;
    }

    public void setTable_numperspn(int table_numperson) {
        this.table_numperson = table_numperson;
    }

    public int getTable_status() {
        return table_status;
    }

    public void setTable_status(int table_status) {
        this.table_status = table_status;
    }

    public int getTable_numperson() {
        return table_numperson;
    }

    public void setTable_numperson(int table_numperson) {
        this.table_numperson = table_numperson;
    }

    public Boolean getOccupied() {
        return occupied;
    }

    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
    }
}
