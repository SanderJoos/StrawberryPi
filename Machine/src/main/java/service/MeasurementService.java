/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import python.service.IPythonService;
import entities.Measurement;
import python.service.PythonService;

/**
 *
 * @author Tim
 */
public class MeasurementService implements IHumService, ITempService, IMeasurementService{
    
    private IPythonService service;
    
    public MeasurementService(){
        this.service = new PythonService();
    }

    @Override
    public double getCurrentHum() {
        return this.service.getCurrentMeasurement().getHum();
    }

    @Override
    public double getCurrentTemp() {
        return this.service.getCurrentMeasurement().getTemp();
    }

    @Override
    public Measurement getCurrentMeasurement() {
        return this.service.getCurrentMeasurement();
    }
    
}
