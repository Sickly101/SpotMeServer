package com.entrox.spotmeserverrestful.dao;

import com.entrox.spotmeserverrestful.dto.Grade;
import com.entrox.spotmeserverrestful.dto.Route;
import com.entrox.spotmeserverrestful.dto.Scale;
import com.entrox.spotmeserverrestful.dto.Spot;
import com.entrox.spotmeserverrestful.dto.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Access {

    public ArrayList<User> getUsers(Connection con) throws SQLException {
        ArrayList<User> userList = new ArrayList<User>();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM users");
        ResultSet rs = stmt.executeQuery();
        try {
            while (rs.next()) {
                User userObj = new User();
                userObj.setId(rs.getInt("id"));
                userObj.setUsername(rs.getString("username"));
                userObj.setEmail(rs.getString("email"));
                userObj.setPw(rs.getString("pw"));
                userObj.setPicture(rs.getBytes("picture"));
                userObj.setLastmodified(rs.getLong("lastmodified"));

                userList.add(userObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public ArrayList<Spot> getSpots(Connection con) throws SQLException {
        ArrayList<Spot> spotList = new ArrayList<Spot>();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM spots");
        ResultSet rs = stmt.executeQuery();
        try {
            while (rs.next()) {
                Spot spotObj = new Spot();
                spotObj.setId(rs.getInt("id"));
                spotObj.setLatitude(rs.getDouble("latitude"));
                spotObj.setLongitude(rs.getDouble("longitude"));
                spotObj.setPicture(rs.getBytes("picture"));
                spotObj.setUser_id(rs.getInt("user_id"));
                spotObj.setLastmodified(rs.getLong("lastmodified"));

                spotList.add(spotObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return spotList;
    }

    public Spot getSpotById(Connection con, int id) throws SQLException {
        Spot spot = new Spot();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM spots WHERE id= ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (!rs.isBeforeFirst()) {
            return spot;
        } else {
            rs.first();

            spot.setId(rs.getInt("id"));
            spot.setLatitude(rs.getDouble("latitude"));
            spot.setLongitude(rs.getDouble("longitude"));
            spot.setPicture(rs.getBytes("picture"));
            spot.setUser_id(rs.getInt("user_id"));
            spot.setLastmodified(rs.getLong("lastmodified"));
        }

        return spot;
    }

    public User getUserById(Connection con, int id) throws SQLException {
        User userObj = new User();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM users WHERE id= ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        rs.first();

        userObj.setId(rs.getInt("id"));
        userObj.setUsername(rs.getString("username"));
        userObj.setEmail(rs.getString("email"));
        userObj.setPw(rs.getString("pw"));
        userObj.setPicture(rs.getBytes("picture"));
        userObj.setLastmodified(rs.getLong("lastmodified"));

        return userObj;
    }

    public User getUserForLogin(Connection con, String login) throws SQLException {
        User userObj = new User();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM users WHERE username= ? OR email= ?");
        stmt.setString(1, login);
        stmt.setString(2, login);
        ResultSet rs = stmt.executeQuery();
        if (rs.isBeforeFirst()) {
            rs.first();

            userObj.setId(rs.getInt("id"));
            userObj.setUsername(rs.getString("username"));
            userObj.setEmail(rs.getString("email"));
            userObj.setPw(rs.getString("pw"));
            userObj.setPicture(rs.getBytes("picture"));
            userObj.setLastmodified(rs.getLong("lastmodified"));

        } else {
            userObj = null;
        }

        return userObj;
    }

    public ArrayList<Grade> getGrades(Connection con) throws SQLException {
        ArrayList<Grade> gradeList = new ArrayList<Grade>();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM grades");
        ResultSet rs = stmt.executeQuery();
        try {
            while (rs.next()) {
                Grade gradeObj = new Grade();
                gradeObj.setId(rs.getInt("id"));
                gradeObj.setScale_id(rs.getInt("scale_id"));
                gradeObj.setDifficulty(rs.getString("difficulty"));
                gradeObj.setColor(rs.getInt("color"));

                gradeObj.setLastmodified(rs.getDate("lastmodified"));

                gradeList.add(gradeObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gradeList;
    }

    public ArrayList<Route> getRoutes(Connection con) throws SQLException {
        ArrayList<Route> routeList = new ArrayList<Route>();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM routes");
        ResultSet rs = stmt.executeQuery();
        try {
            while (rs.next()) {
                Route routeObj = new Route();
                routeObj.setId(rs.getInt("id"));
                routeObj.setDescription(rs.getString("description"));
                routeObj.setGrade_id(rs.getInt("grade_id"));
                routeObj.setSpot_id(rs.getInt("spot_id"));
                routeObj.setLastmodified(rs.getLong("lastmodified"));

                routeList.add(routeObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return routeList;
    }

    public Route getRouteById(Connection con, int id) throws SQLException {
        Route routeObj = new Route();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM routes WHERE id= ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        rs.first();

        routeObj.setId(rs.getInt("id"));
        routeObj.setDescription(rs.getString("description"));
        routeObj.setGrade_id(rs.getInt("grade_id"));
        routeObj.setSpot_id(rs.getInt("spot_id"));
        routeObj.setLastmodified(rs.getLong("lastmodified"));

        return routeObj;
    }

    public ArrayList<Scale> getScales(Connection con) throws SQLException {
        ArrayList<Scale> scaleList = new ArrayList<Scale>();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM scales");
        ResultSet rs = stmt.executeQuery();
        try {
            while (rs.next()) {
                Scale scaleObj = new Scale();
                scaleObj.setId(rs.getInt("id"));
                scaleObj.setName(rs.getString("name"));

                scaleObj.setLastmodified(rs.getLong("lastmodified"));

                scaleList.add(scaleObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scaleList;
    }

    public Scale getScaleById(Connection con, int id) throws SQLException {
        Scale scaleObj = new Scale();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM scales WHERE id= ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        rs.first();

        scaleObj.setId(rs.getInt("id"));
        scaleObj.setName(rs.getString("name"));
        scaleObj.setLastmodified(rs.getLong("lastmodified"));

        return scaleObj;
    }

    //Insert
    public boolean insertUser(Connection con, User user) {
        boolean returnValue = false;
        Date date = new Date();
        String query = "insert into spotme.users (username, email, pw, picture, lastmodified) "
                + "SELECT * FROM (SELECT ?, ?, ?, ?, ?) AS tmp "
                + "WHERE NOT EXISTS ( SELECT username FROM spotme.users WHERE username = ? "
                + "AND email = ? AND pw = ?) LIMIT 1;";

        try {
            // PreparedStatement can work with variables
            // create the mysql insert preparedstatement
            PreparedStatement prepStmt = con.prepareStatement(query);
            prepStmt.setString(1, user.getUsername());
            prepStmt.setString(2, user.getEmail());
            prepStmt.setString(3, user.getPw());
            prepStmt.setBytes(4, user.getPicture());
            prepStmt.setLong(5, date.getTime());
            prepStmt.setString(6, user.getUsername());
            prepStmt.setString(7, user.getEmail());
            prepStmt.setString(8, user.getPw());

            // execute the preparedstatement
            int anz = prepStmt.executeUpdate();

            if (anz == 0) {
                returnValue = true;
            } else {
                returnValue = false;
            }

        } catch (SQLException e) {
            System.out.println("Error:" + e.getSQLState());
        }
        
        return returnValue;
    }
    
    public String insertSpot(Connection con, Spot spot){
        String response = "";
        String query = "INSERT INTO spotme.spots ( latitude, longitude, user_id, picture, description, name, scale_id, lastmodified)" +
                "values (?,?,?,?,?,?,?,?)";
        PreparedStatement prepStmt = null;
        try{
            prepStmt = con.prepareStatement(query);
            
            prepStmt.setDouble(1, spot.getLatitude());
            prepStmt.setDouble(2, spot.getLongitude());
            prepStmt.setInt(3, spot.getUser_id());
            prepStmt.setBytes(4, spot.getPicture());
            prepStmt.setString(5, spot.getDescrpition());
            prepStmt.setString(6, spot.getName());
            prepStmt.setInt(7, spot.getScale_id());
            prepStmt.setLong(8, spot.getLastmodified());
            
            int anz = prepStmt.executeUpdate();
            
            if(anz == 0){
                response = "Kein Spot eingefügt";
            }else{
                response = "Spot erfolgreich eingefügt";
            }
        }catch(SQLException e){
            response = e.getSQLState();
        }finally{
            try {
                prepStmt.close();
            } catch (SQLException ex) {
               response = ex.getSQLState();
            }finally{
                try {
                    prepStmt.close();
                } catch (SQLException ex) {
                    response = ex.getSQLState();
                }
            }
        }
        return response;
    }
    
    public String insertRoute(Connection con, Route route){
        String response = "";
        String query = "INSERT INTO spotme.routes ( name, description, spot_id, grade_id,  lastmodified)" +
                "values (?,?,?,?,?)";
        PreparedStatement prepStmt = null;
        try{
            prepStmt = con.prepareStatement(query);
            
            prepStmt.setString(1, route.getName());
            prepStmt.setString(2, route.getDescription());
            prepStmt.setInt(3, route.getSpot_id());
            prepStmt.setInt(4, route.getGrade_id());
            prepStmt.setLong(5, route.getLastmodified());
            
            int anz = prepStmt.executeUpdate();
            
            if(anz == 0){
                response = "Keine Route eingefügt";
            }else{
                response = "Route erfolgreich eingefügt";
            }
        }catch(SQLException e){
            response = e.getSQLState();
        }finally{
            try {
                prepStmt.close();
            } catch (SQLException ex) {
               response = ex.getSQLState();
            }finally{
                try {
                    prepStmt.close();
                } catch (SQLException ex) {
                    response = ex.getSQLState();
                }
            }
        }
        return response;
    }

    public void insertScale(Connection con, Scale scale) {
        String query = "insert into spotme.scales (id, name, lastmodified)"
                + "values (?, ?, ?)";
        try {
            // PreparedStatement can work with variables
            // create the mysql insert preparedstatement
            PreparedStatement prepStmt = con.prepareStatement(query);
            prepStmt.setInt(1, scale.getId());
            prepStmt.setString(2, scale.getName());
            prepStmt.setLong(3, scale.getLastmodified());

            // execute the preparedstatement
            prepStmt.execute();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getSQLState());
        }
    }

    public void insertGrade(Connection con, Grade grade) {
        String query = "insert into spotme.grades (id, scale_id, difficulty, color, lastmodified)"
                + "values (?, ?, ?, ?, ?)";
        try {
            // PreparedStatement can work with variables
            // create the mysql insert preparedstatement
            PreparedStatement prepStmt = con.prepareStatement(query);
            prepStmt.setInt(1, grade.getId());
            prepStmt.setInt(2, grade.getScale_id());
            prepStmt.setString(3, grade.getDifficulty());
            prepStmt.setInt(4, grade.getColor());
            prepStmt.setDate(5, grade.getLastmodified());

            // execute the preparedstatement
            prepStmt.execute();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getSQLState());
        }
    }

    public void insertTestUser(Connection con) throws FileNotFoundException {
        Date date = new Date(2015, 11, 25);
        String query = "insert into users (username, mail, pw, picture, lastmodified)"
                + "values (?, ?, ?, ?, ?)";
        FileInputStream fis = null;
        try {
            File file = new File("/home/sickly/cat.jpg");
            fis = new FileInputStream(file);
            // PreparedStatement can work with variables
            // create the mysql insert preparedstatement
            PreparedStatement prepStmt = con.prepareStatement(query);

            prepStmt.setString(1, "Test2");
            prepStmt.setString(2, "Test@test.te");
            prepStmt.setString(3, "powwow");
            prepStmt.setBinaryStream(4, fis);
            //prepStmt.setDate(5, date);

            // execute the preparedstatement
            prepStmt.execute();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getSQLState());
            System.out.println("Error:" + e.getErrorCode());
        }
    }

    public void insertBase64(Connection con) throws FileNotFoundException, IOException {

        String query = "insert into test (pic)"
                + "values (?)";
        FileInputStream fis = null;
        try {
            File file = new File("/home/sickly/cat.jpg");
            fis = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            fis.read(bytes);
            String encode = new String(bytes);
            // PreparedStatement can work with variables
            // create the mysql insert preparedstatement
            PreparedStatement prepStmt = con.prepareStatement(query);

            prepStmt.setString(1, encode);

            // execute the preparedstatement
            prepStmt.execute();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getSQLState());
            System.out.println("Error:" + e.getErrorCode());
        }
    }

    //Delete
    public String deleteSpot(Connection con, int id) {
        String result = "";
        PreparedStatement stmt;
        int db_result = 0;
        try {
            stmt = con.prepareStatement("DELETE FROM spotme.spots WHERE id = ?");
            stmt.setInt(1, id);
            db_result = stmt.executeUpdate();
        } catch (SQLException ex) {
            result = ex.getSQLState();
        }
        if (db_result == 0) {
            result = "Es wurde nichts entfernt. DB_Result: " + db_result;
        }else result ="Spot mit id: "+id+" erfolgreich entfernt!";
        return result;
    }

    public String deleteRoute(Connection con, int id) {
        String result = "";
        PreparedStatement stmt;
        int db_result = 0;
        try {
            stmt = con.prepareStatement("DELETE FROM routes WHERE id= ?");
            stmt.setInt(1, id);
            db_result = stmt.executeUpdate();
        } catch (SQLException ex) {
            result = ex.getSQLState();
        }
        if (db_result == 0) {
            result = "Es wurde nichts entfernt. DB_Result: " + db_result;
        }else result ="Route mit id: "+id+" erfolgreich entfernt!";
        return result;
    }

    //Sync
    public ArrayList<Spot> syncSpots(Connection con, long lastmodified) {
        ArrayList<Spot> spotList = new ArrayList<Spot>();
        String result = "";

        PreparedStatement stmt = null;
        int db_result = 0;
        ResultSet rs = null;
        String sql_query = "SELECT * FROM spots WHERE lastmodified >= ?";
        try {
            stmt = con.prepareStatement(sql_query);
            stmt.setLong(1, lastmodified);
            rs = stmt.executeQuery();
            db_result = stmt.getUpdateCount();
            if (!rs.isBeforeFirst() || db_result == 0) {
                return spotList;
            } else {
                
                while (rs.next()) {
                    Spot spotObj = new Spot();
                spotObj.setId(rs.getInt("id"));
                spotObj.setLatitude(rs.getDouble("latitude"));
                spotObj.setLongitude(rs.getDouble("longitude"));
                spotObj.setPicture(rs.getBytes("picture"));
                spotObj.setUser_id(rs.getInt("user_id"));
                spotObj.setScale_id(rs.getInt("scale_id"));
                spotObj.setName(rs.getString("name"));
                spotObj.setDescrition(rs.getString("description"));
                spotObj.setLastmodified(rs.getLong("lastmodified"));


                    spotList.add(spotObj);
                }
            }
        } catch (SQLException ex) {
            result = ex.getSQLState();
        }finally{
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(Access.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return spotList;
    }
    
    public ArrayList<Route> syncRoutes(Connection con, long lastmodified) {
        ArrayList<Route> routeList = new ArrayList<>();
        String result = "";

        PreparedStatement stmt;
        int db_result = 0;
        ResultSet rs = null;
        String sql_query = "SELECT * FROM routes WHERE lastmodified >= ?";
        try {
            stmt = con.prepareStatement(sql_query);
            stmt.setLong(1, lastmodified);
            rs = stmt.executeQuery();
            db_result = stmt.getUpdateCount();
            if (!rs.isBeforeFirst() || db_result == 0) {
                return routeList;
            } else {
                
                while (rs.next()) {
                    Route routeObj = new Route();
                routeObj.setId(rs.getInt("id"));
                routeObj.setDescription(rs.getString("description"));
                routeObj.setGrade_id(rs.getInt("grade_id"));
                routeObj.setSpot_id(rs.getInt("spot_id"));
                routeObj.setLastmodified(rs.getLong("lastmodified"));

                routeList.add(routeObj);
                }
            }
        } catch (SQLException ex) {
            result = ex.getSQLState();
        }

        return routeList;
    }
}
