/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gatherers;

/**
 *
 * @author Tim
 */
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class TemperatureGatherer {

    //TODO
    String URL = "193.191.187.14:xxx/API/temp";

    public double getTempMeasurement() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(URL);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        return Double.parseDouble(response);
    }
}
