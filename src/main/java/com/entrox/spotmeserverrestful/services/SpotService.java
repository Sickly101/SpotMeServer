package com.entrox.spotmeserverrestful.services;

import com.entrox.spotmeserverrestful.dto.Spot;
import com.entrox.spotmeserverrestful.model.AccessManager;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.ws.rs.ext.MessageBodyWriter;


@Path("/spot")
public class SpotService {

    @GET
    @Path("/all")
    @Produces("application/json")
    public String spots() {
        String spots = null;
        ArrayList<Spot> spotList = new ArrayList<Spot>();
        try {
            spotList = new AccessManager().getSpots();
            Gson gson = new Gson();
            spots = gson.toJson(spotList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return spots;
    }
    

    
@GET
@Path("/{id}")
@Produces("application/json")
    public String getSpotById(@PathParam("id") int id) {
        String spot = null;
        Spot spotObj = new Spot();
        try {
            spotObj = new AccessManager().getSpotById(id);
            Gson gson = new Gson();
            spot = gson.toJson(spotObj);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return spot;
    }
    
@DELETE
@Path("/{id}")
@Produces("text/plain")
    public Response deleteSpot(@PathParam("id") int id){
        String result = null;
        AccessManager am = new AccessManager();
        int spotid = id;
        try {
            result = am.deleteSpot(id);
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
    
    public Response syncSpots(@QueryParam("lastmodified") long lastmodified){
        String result = null;
        String spots = null;
        System.out.println("QueryParam: " + lastmodified);
       
        AccessManager am = new AccessManager();
        ArrayList<Spot> spotList = new ArrayList<Spot>();
        Gson gson = new Gson();
        
        try{
            
            
            spotList = am.syncSpots(lastmodified);    
            spots = gson.toJson(spotList);
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return Response.status(200).entity(spots).build();
    }

    @POST
    @Consumes("applicatino/json")
    public Response insertSpot(InputStream data){
        String response = "";
        Spot spot = new Spot();
        Gson gson = new Gson();      
        BufferedReader br = new BufferedReader(new InputStreamReader(data));
        gson.fromJson(br, Spot.class);
        
        response = new AccessManager().insertSpot(spot);
        
        return Response.status(Response.Status.CREATED).entity(response).build();
    }
}
