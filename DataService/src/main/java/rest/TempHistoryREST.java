/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import service.CentralService;

/**
 * REST Web Service
 *
 * @author Tim
 */
@Path("TempHistory")
public class TempHistoryREST {

    @Inject
    public CentralService service;
    
    public TempHistoryREST() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllTemperatureMeasurements() {
        Gson gson = new Gson();
        return gson.toJson(service.getAllTemperatureMeasurements());
    }

    @GET
    @Path("on-{dateString}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTempMeasurementsOnDate(@PathParam("dateString")String dateString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateString, formatter);
        return new Gson().toJson(service.getAllTemperatureMeasurementsOnDate(date));
    }
    
    @GET
    @Path("before-{dateString}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTempMeasurementsBeforeDate(@PathParam("dateString")String dateString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateString, formatter);
        return new Gson().toJson(service.getAllTemperatureMeasurementsBeforeDate(date));
    }
    
    @GET
    @Path("after-{dateString}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTempMeasurementsAfterDate(@PathParam("dateString")String dateString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateString, formatter);
        return new Gson().toJson(service.getAllTemperatureMeasurementsAfterDate(date));
    }
}
