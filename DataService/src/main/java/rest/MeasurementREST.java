/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import service.CentralService;
import com.google.gson.Gson;
import filter.Authenticate;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author Sander_2
 */
@Path("measurement")
@RequestScoped
public class MeasurementREST {
    
    @Inject
    private CentralService service;

    public MeasurementREST() {
    }

    @GET
    @Authenticate
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllMeasurements() {
        Gson gson = new Gson();
        return gson.toJson(service.getAllMeasurements());
    }

    @PUT
    @Authenticate
    @Path("new")
    @Produces(MediaType.APPLICATION_JSON)
    public String getNewMeasurement() {
        Gson gson = new Gson();
        return gson.toJson(service.retrieveNewDate());
    }
    
    @DELETE
    @Authenticate
    @Path("delete-{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteMeasurement(@PathParam("id")long id){
        service.deleteMeasurement(id);
    }
    
    @GET
    @Authenticate
    @Path("on-{dateString}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMeasurementsOnDate(@PathParam("dateString")String dateString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateString, formatter);
        return new Gson().toJson(service.getAllMeasurementsOnDate(date));
    }
    
    @GET
    @Authenticate
    @Path("before-{dateString}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMeasurementsBeforeDate(@PathParam("dateString")String dateString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateString, formatter);
        return new Gson().toJson(service.getAllMeasurementsBeforeDate(date));
    }
    
    @GET
    @Authenticate
    @Path("after-{dateString}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMeasurementsAfterDate(@PathParam("dateString")String dateString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateString, formatter);
        return new Gson().toJson(service.getAllMeasurementsAfterDate(date));
    }
}
