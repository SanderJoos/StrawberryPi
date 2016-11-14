/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package python.reader;

import entities.Measurement;
import java.util.Random;

/**
 *
 * @author Tim
 */
public class TestReader implements IPythonReader {

    
    @Override
    //returns a randomly generated measurement with temperature ranging between -10 and +30
    //and humidity between 0 and 100 (because humidity is a percentage)
    public Measurement getCurrentMeasurement() {
        Random rngTemp=new Random();
        double randomTemp=(rngTemp.nextDouble()*40-10);
        Random rngHum=new Random();
        double randomHum=(rngHum.nextDouble()*100);
        return new Measurement(randomTemp, randomHum);
    }
    
}
