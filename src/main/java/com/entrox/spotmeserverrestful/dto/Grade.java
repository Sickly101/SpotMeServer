/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entrox.spotmeserverrestful.dto;

import java.sql.Date;

/**
 *
 * @author Sickly
 */
public class Grade {
    private int id, scale_id, color;
    private String difficulty;
    private Date lastmodified;

    public Grade(int scale_id, String difficulty, int color) {
        this.scale_id = scale_id;
        this.color = color;
        this.difficulty = difficulty;
        
    }
    
    public Grade(){}

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScale_id() {
        return scale_id;
    }

    public void setScale_id(int scale_id) {
        this.scale_id = scale_id;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Date getLastmodified() {
        return lastmodified;
    }

    public void setLastmodified(Date lastmodified) {
        this.lastmodified = lastmodified;
    }
    
    
}
