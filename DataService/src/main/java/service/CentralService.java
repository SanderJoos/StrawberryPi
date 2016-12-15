/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Measurement;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Sander_2
 */
//TODO EJB
public class CentralService {
    
    @Inject
    public MeasurementDBService service;
    
    public void storeMeasurement(Measurement measurement){
        service.storeMeasurement(measurement);
    }
    
    public List<Measurement> getAllMeasurements(){
        return service.getAllMeasurements();
    }
    
}
