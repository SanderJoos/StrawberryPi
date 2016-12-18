/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import filter.Authenticate;
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
@Path("hum")
public class HumHistoryREST {

    @Inject
    public CentralService service; 
    
    public HumHistoryREST() {
    }

    @GET
    @Authenticate
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllHumidityMeasurements() {
        Gson gson = new Gson();
        return gson.toJson(service.getAllHumMeasurements());
    }

    @GET
    @Authenticate
    @Path("on-{dateString}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getHumMeasurementsOnDate(@PathParam("dateString")String dateString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateString, formatter);
        return new Gson().toJson(service.getAllHumMeasurementsOnDate(date));
    }
    
    @GET
    @Authenticate
    @Path("before-{dateString}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getHumMeasurementsBeforeDate(@PathParam("dateString")String dateString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateString, formatter);
        return new Gson().toJson(service.getAllHumMeasurementsBeforeDate(date));
    }
    
    @GET
    @Authenticate
    @Path("after-{dateString}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getHumMeasurementsAfterDate(@PathParam("dateString")String dateString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateString, formatter);
        return new Gson().toJson(service.getAllHumMeasurementsAfterDate(date));
    }
}
