/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entrox.spotmeserverrestful.services;

import com.entrox.spotmeserverrestful.dto.Grade;
import com.entrox.spotmeserverrestful.model.AccessManager;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Path("/grades")
public class GradeService {
    @GET
    @Path("/all")
    @Produces("application/json")
    public String getGrades(){
        String grades = null;
        ArrayList<Grade> gradeList = new ArrayList<Grade>();
        try {
            gradeList = new AccessManager().getGrade();
            Gson gson = new Gson();
            grades = gson.toJson(gradeList);
            System.out.println("com.entrox.spotmeserverrestful.services.UserService.users()");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return grades;
    }
    
    @POST
    @Path("/insert")
    @Consumes("application/json")
    public Response addGrade(InputStream data) throws Exception{
        Gson gson = new Gson();
        Grade gradeObj= null;
        BufferedReader br =new BufferedReader(new InputStreamReader(data));
        
        gradeObj = gson.fromJson(br, Grade.class);
        new AccessManager().insertGrade(gradeObj);
        String result = "Grade eingefügt";
        return Response.status(201).entity(result).build(); 
    }
    
    
    
}
