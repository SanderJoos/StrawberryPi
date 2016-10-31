package python.reader;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import entities.Measurement;

/**
 *
 * @author Sander_2
 */
public interface IPythonReader {
    
    public Measurement getCurrentMeasurement();
    
}
