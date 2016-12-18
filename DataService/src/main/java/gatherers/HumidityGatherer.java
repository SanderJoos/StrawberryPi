/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gatherers;

import com.google.gson.Gson;
import entities.Measurement;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Tim
 */
public class HumidityGatherer {

    //TODO
    String URL = "http://193.191.187.14:11378/StrawberryPi-Machine/API/hum";

    public double getHumidityMeasurement() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(URL);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        return Double.parseDouble(response);
    }
}
