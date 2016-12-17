/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gatherers;

import entities.Measurement;
import javax.inject.Inject;

/**
 *
 * @author Tim
 */
public class MeasurementGatherer {
    
    @Inject
    HumidityGatherer humgatherer;
    
    @Inject
    TemperatureGatherer tempgatherer;
    
    public Measurement getMeasurement(){
        return new Measurement(tempgatherer.getTempMeasurement(),humgatherer.getHumidityMeasurement());
    }
}
