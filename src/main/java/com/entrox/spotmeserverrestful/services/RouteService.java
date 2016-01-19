/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entrox.spotmeserverrestful.services;

import com.entrox.spotmeserverrestful.dto.Route;
import com.entrox.spotmeserverrestful.model.AccessManager;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author Sickly
 */
@Path("/route")
public class RouteService {
@GET
@Path("/{id}")
@Produces("application/json")
    public String getRouteById(@PathParam("id") int id) {
        String route = null;
        Route routeObj = new Route();
        try {
            routeObj = new AccessManager().getRouteById(id);
            Gson gson = new Gson();
            route = gson.toJson(routeObj);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return route;
    }
    
@GET
@Path("/all")
@Produces("application/json")
    public String allRoutes() {
        String routes = null;
        ArrayList<Route> routeList = new ArrayList<Route>();
        try {
            routeList = new AccessManager().getRoutes();
            Gson gson = new Gson();
            routes = gson.toJson(routeList);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return routes;
    }
    
    @DELETE
@Path("/{id}")
@Produces("text/plain")
    public Response deleteSpot(@PathParam("id") int id){
        String result = null;
        AccessManager am = new AccessManager();
        int spotid = id;
        try {
            result = am.deleteRoute(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if(result.isEmpty()){
            result = "Somthing went wrong! Result String is Empty";
            return Response.status(400).entity(result).build();
        }
        
        return Response.status(200).entity(result).build();
    }
    
    @GET
    @Produces("application/json")
    public Response syncRoutes(@QueryParam("lastmodified") long lastmodified){
        String result = null;
        String routes = null;
        System.out.println("QueryParam: " + lastmodified);
        AccessManager am = new AccessManager();
        ArrayList<Route> routeList = new ArrayList<Route>();
        Gson gson = new Gson();
        try{
            routeList = am.syncRoutes(lastmodified);
            routes = gson.toJson(routeList);
        }catch(Exception e){
            e.printStackTrace();
        }
       
        return Response.status(200).entity(routes).build();
    }
    
    @POST
    @Consumes("applicatino/json")
    public Response insertRoute(InputStream data){
        String response = "";
        Route route = new Route();
        Gson gson = new Gson();      
        BufferedReader br = new BufferedReader(new InputStreamReader(data));
        gson.fromJson(br, Route.class);
        
        response = new AccessManager().insertRoute(route);
        
        return Response.status(Response.Status.CREATED).entity(response).build();
    }
}
