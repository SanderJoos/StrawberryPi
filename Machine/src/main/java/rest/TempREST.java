/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import service.MeasurementService;

/**
 * REST Web Service
 *
 * @author Tim
 */
@Path("temp")
public class TempREST {

    private MeasurementService service;

    /**
     * Creates a new instance of TempResource
     */
    public TempREST() {
        this.service = new MeasurementService();
    }

    /**
     * Retrieves representation of an instance of strawberrypi.machine.TempResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCurrentTempInJSON() {
       Gson gson = new Gson();
       return gson.toJson(service.getCurrentTemp());
    }
}
