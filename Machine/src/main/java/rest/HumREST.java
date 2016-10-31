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
@Path("hum")
public class HumREST {

    private MeasurementService service;

    /**
     * Creates a new instance of HumRESTResource
     */
    public HumREST() {
        this.service = new MeasurementService();
    }

    /**
     * Retrieves representation of an instance of strawberrypi.machine.HumRESTResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCurrentHumInJSON() {
        Gson gson = new Gson();
        double hum = this.service.getCurrentHum();
        return gson.toJson(hum);
    }
}
