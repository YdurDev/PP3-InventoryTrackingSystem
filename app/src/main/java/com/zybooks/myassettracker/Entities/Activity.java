package com.zybooks.myassettracker.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.zybooks.myassettracker.UTIL.ActivityType;

@Entity(tableName = "activities")
public class Activity {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String type;

    private String prodName;

    private long timestamp;

    //---------------------------------------- Constructor---------------------------------
    public Activity(int id, String type, String prodName, long timestamp) {
        this.id = id;
        this.type = type;
        this.prodName = prodName;
        this.timestamp = timestamp;
    }

    //---------------------------------------- Getter/Setters---------------------------------


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
