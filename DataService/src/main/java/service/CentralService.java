/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Measurement;
import gatherers.MeasurementGatherer;
import java.time.LocalDate;
import java.util.ArrayList;
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
    
    @Inject
    public MeasurementGatherer gatherer;
    
    public void storeMeasurement(Measurement measurement){
        service.storeMeasurement(measurement);
    }
    
    public List<Measurement> getAllMeasurements(){
        return service.getAllMeasurements();
    }
    
    public List<Measurement> getAllMeasurementsForDate(LocalDate date){
        List<Measurement> result = new ArrayList<>();
        for(Measurement m : this.getAllMeasurements()){
            if(m.getDate().equals(date)){
                result.add(m);
            }
        }
        return result;
    }
    
    public List<Measurement> getAllMeasurementsAfterDate(LocalDate date){
        List<Measurement> result = new ArrayList<>();
        for(Measurement m : this.getAllMeasurements()){
            if(m.getDate().isAfter(date)){
                result.add(m);
            }
        }
        return result;
    }
    
    public void retrieveNewDate(){
        Measurement m = this.gatherer.getMeasurement();
        this.service.deleteMeasurement(m);
    }
    
}
