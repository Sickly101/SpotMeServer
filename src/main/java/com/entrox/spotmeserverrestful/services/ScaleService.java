/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entrox.spotmeserverrestful.services;

import com.entrox.spotmeserverrestful.dto.Grade;
import com.entrox.spotmeserverrestful.dto.Scale;
import com.entrox.spotmeserverrestful.model.AccessManager;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author Sickly
 */
@Path("/scale")
public class ScaleService {
    @GET
    @Produces("application/json")
    public String getScales(){
        String scales = null;
        ArrayList<Scale> scaleList = new ArrayList<Scale>();
        try {
            scaleList = new AccessManager().getScales();
            Gson gson = new Gson();
            scales =  gson.toJson(scaleList);
            System.out.println("com.entrox.spotmeserverrestful.services.UserService.users()");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scales;
    }
    
   @POST
    @Path("/insert")
    @Consumes("application/json")
    public Response insert(InputStream data) throws Exception{
        Gson gson = new Gson();
        Scale scaleObj = null;
        BufferedReader br =new BufferedReader(new InputStreamReader(data));
        
        scaleObj = gson.fromJson(br, Scale.class);
        new AccessManager().insertScale(scaleObj);
        String result = "Scale fertig";
        return Response.status(201).entity(result).build(); 
    }

}
