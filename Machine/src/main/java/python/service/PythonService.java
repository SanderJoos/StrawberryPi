/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package python.service;

import python.service.IPythonService;
import entities.Measurement;
import python.reader.IPythonReader;
import python.reader.PythonReader;
import python.reader.TestReader;

/**
 *
 * @author Sander_2
 */
public class PythonService implements IPythonService {
    
    private IPythonReader reader;
    
    public PythonService(){
        this.reader = new PythonReader();
    }

    @Override
    public Measurement getCurrentMeasurement() {
        return this.reader.getCurrentMeasurement();
    }
    
}
