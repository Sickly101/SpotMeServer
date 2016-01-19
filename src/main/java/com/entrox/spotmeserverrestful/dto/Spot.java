
package com.entrox.spotmeserverrestful.dto;





public class Spot {
    private int id, user_id, scale_id;
    private double latitude, longitude;
    private byte[] picture;
    private long lastmodified;
    private String name, description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public long getLastmodified() {
        return lastmodified;
    }

    public void setLastmodified(long lastmodified) {
        this.lastmodified = lastmodified;
    }

    public int getScale_id() {
        return scale_id;
    }

    public void setScale_id(int scale_id) {
        this.scale_id = scale_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrpition() {
        return description;
    }

    public void setDescrition(String description) {
        this.description = description;
    }
    
    
   
    
}
