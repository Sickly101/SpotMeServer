package com.entrox.spotmeserverrestful.services;

import com.entrox.spotmeserverrestful.dto.User;
import com.entrox.spotmeserverrestful.dto.UserLogin;
import com.entrox.spotmeserverrestful.model.AccessManager;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserService {

    @GET
    @Path("/all")
    @Produces("application/json")
    public String users() {
        String users = null;
        ArrayList<User> userList = new ArrayList<User>();
        try {
            userList = new AccessManager().getUsers();
            Gson gson = new Gson();
            users = gson.toJson(userList);
            System.out.println("com.entrox.spotmeserverrestful.services.UserService.users()");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public String getUserById(@PathParam("id") int id) {
        String user = null;
        User userObj = new User();
        try {
            userObj = new AccessManager().getUserById(id);
            Gson gson = new Gson();
            user = gson.toJson(userObj);
            System.out.println("com.entrox.spotmeserverrestful.services.UserService.users()");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @POST
    @Path("/login")
    @Consumes("application/json")
    public Response login1(InputStream data) {
        String result;
        Gson gson = new Gson();
        User userObj = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(data));
        System.out.println("login");
        UserLogin tempUser = gson.fromJson(br, UserLogin.class);
        System.out.println(tempUser.emailOrUsername);
        try {
            
                userObj = new AccessManager().getUserLogin(tempUser.emailOrUsername);

            

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (userObj != null && tempUser.pw.equals(userObj.getPw())) {
            String user;
            userObj.setPw("null");
            gson = new Gson();
            user = gson.toJson(userObj);
            return Response.status(200).entity(user).type("application/json").build();

        } else {
            return Response.status(401).entity("Check failed").build();
        }

    }

    @POST
    @Consumes("application/json")
    public Response registerUser(InputStream data) throws IOException  {
        User userObj = null;
        Gson gson = new Gson();      
        BufferedReader br = new BufferedReader(new InputStreamReader(data));
        
        
        String bla = br.readLine();
        System.out.println(bla);
        
        userObj  = gson.fromJson(bla, User.class);
        //System.out.println("username: " + userObj.getUsername());
        System.out.println("email =" + userObj.getEmail());
        System.out.println("pw =" + userObj.getPw());
        try {
            new AccessManager().insertUser(userObj);       
                  
        } catch (Exception ex) {
             ex.printStackTrace();
             
        }
       if(userObj.getUsername() != null){
           String result = "User erfolgeich angelegt";
            return Response.status(200).entity(result).build();
       }else return Response.status(401).entity("Register Failed").build();
        
    }
    
    
    
    
    @POST
    @Path("/test")
    @Consumes("application/json")
    public Response insertTest() throws Exception {

        new AccessManager().insertTestUser();
        String result = "new Test";
        return Response.status(201).entity(result).build();
    }

    @POST
    @Path("/base")
    @Consumes("application/json")
    public Response insertBase64() throws Exception {

        new AccessManager().insertBase64();
        String result = "base";
        return Response.status(201).entity(result).build();
    }

}
