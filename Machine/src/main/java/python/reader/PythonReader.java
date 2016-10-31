/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package python.reader;

import entities.Measurement;

/**
 *
 * @author Sander_2
 */
public class PythonReader implements IPythonReader{

    @Override
    public Measurement getCurrentMeasurement() {
        Measurement measurement = new Measurement(0,0);
        return measurement;
    }
    
}
