package com.entrox.spotmeserverrestful.model;

import com.entrox.spotmeserverrestful.dao.Access;
import com.entrox.spotmeserverrestful.dao.Database;
import com.entrox.spotmeserverrestful.dto.Grade;
import com.entrox.spotmeserverrestful.dto.Route;
import com.entrox.spotmeserverrestful.dto.Scale;
import com.entrox.spotmeserverrestful.dto.Spot;
import com.entrox.spotmeserverrestful.dto.User;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccessManager {

    public ArrayList<User> getUsers() throws Exception {
        ArrayList<User> userList = new ArrayList<User>();
        Database db = new Database();
        Connection con = db.getConnection();
        Access access = new Access();
        userList = access.getUsers(con);
        return userList;
    }
    
    public ArrayList<Spot> getSpots() throws Exception {
        ArrayList<Spot> spotList = new ArrayList<Spot>();
        Database db = new Database();
        Connection con = db.getConnection();
        Access access = new Access();
        spotList = access.getSpots(con);
        return spotList;
    }
    
    public User getUserById(int id) throws Exception{
        User userObj = new User();
        Database db = new Database();
        Connection con = db.getConnection();
        Access access = new Access();
        userObj = access.getUserById(con, id);
        return userObj;
    }
    
    public Spot getSpotById(int id) throws Exception{
        Spot spotObj = new Spot();
        Database db = new Database();
        Connection con = db.getConnection();
        Access access = new Access();
        spotObj = access.getSpotById(con, id);
        return spotObj;
    }
    
    public User getUserLogin(String login) throws Exception{
        User userObj = new User();
        Database db = new Database();
        Connection con = db.getConnection();
        Access access = new Access();
        userObj = access.getUserForLogin(con, login);
        return userObj;
    }
    
    public ArrayList<Grade> getGrade() throws Exception {
        ArrayList<Grade> gradeList = new ArrayList<Grade>();
        Database db = new Database();
        Connection con = db.getConnection();
        Access access = new Access();
        gradeList = access.getGrades(con);
        return gradeList;
    }
    
    public ArrayList<Scale> getScales() throws Exception {
        ArrayList<Scale> scaleList = new ArrayList<Scale>();
        Database db = new Database();
        Connection con = db.getConnection();
        Access access = new Access();
        scaleList = access.getScales(con);
        return scaleList;
    }
    
     public ArrayList<Route> getRoutes() throws Exception {
        ArrayList<Route> routeList = new ArrayList<Route>();
        Database db = new Database();
        Connection con = db.getConnection();
        Access access = new Access();
        routeList = access.getRoutes(con);
        return routeList;
    }
     
     public Route getRouteById(int id) throws Exception{
        Route routeObj = new Route();
        Database db = new Database();
        Connection con = db.getConnection();
        Access access = new Access();
        routeObj = access.getRouteById(con, id);
        return routeObj;
    }
    
    //insert
    public void insertUser(User user) throws Exception {
        Database db = new Database();
        Connection con = db.getConnection();
        Access access = new Access();
        access.insertUser(con, user);
        
    }
    
    public void insertTestUser() throws Exception {
        Database db = new Database();
        Connection con = db.getConnection();
        Access access = new Access();
        access.insertTestUser(con);
        
    }
    
    public void insertBase64() throws Exception {
        Database db = new Database();
        Connection con = db.getConnection();
        Access access = new Access();
        access.insertBase64(con);
    }
    public void insertScale(Scale scale) throws Exception {
        Database db = new Database();
        Connection con = db.getConnection();
        Access access = new Access();
        access.insertScale(con, scale);
        
    }
    
    public String insertSpot(Spot spot){
        String response = "";
        Database db = new Database();
        Connection con = null;
        try {
            con = db.getConnection();
        } catch (Exception ex) {
            response = ex.getMessage();
        }
        Access access = new Access();
        response = access.insertSpot(con, spot);
        
        return response;
    }
    
    public String insertRoute(Route route){
        String response = "";
        Database db = new Database();
        Connection con = null;
        try {
            con = db.getConnection();
        } catch (Exception ex) {
            response = ex.getMessage();
        }
        Access access = new Access();
        response = access.insertRoute(con, route);
        
        return response;
    }
    
    public void insertGrade(Grade grade) throws Exception {
        Database db = new Database();
        Connection con = db.getConnection();
        Access access = new Access();
        access.insertGrade(con, grade);
        
    }
    
   /* public void insertStaticGrades() throws Exception{
         Database db = new Database();
        Connection con = db.getConnection();
        Access access = new Access();
        access.insertStaticGrades(con);
    }
*/
    
    //Delete
    public String deleteSpot(int id) throws Exception{
        String result ="";
        Database db = new Database();
        Connection con = db.getConnection();
        Access access = new Access();
        result = access.deleteSpot(con, id);
        
        return result;
    }
    
    public String deleteRoute(int id) throws Exception{
        String result ="";
        Database db = new Database();
        Connection con = db.getConnection();
        Access access = new Access();
        result = access.deleteRoute(con, id);
        
        return result;
    }
    
    //sync
    
    public ArrayList<Spot> syncSpots(long lastmodified) throws Exception{
        ArrayList<Spot> spotList = new ArrayList<Spot>();
        Database db = new Database();
        Connection con = db.getConnection();
        Access access = new Access();
        spotList = access.syncSpots(con, lastmodified);
        return spotList;
    }
    
    public ArrayList<Route> syncRoutes(long lastmodified) throws Exception{
        ArrayList<Route> routeList = new ArrayList<Route>();
        Database db = new Database();
        Connection con = db.getConnection();
        Access access = new Access();
        routeList = access.syncRoutes(con, lastmodified);
        return routeList;
    }
}
