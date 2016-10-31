/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Sander_2
 */
public class Measurement {
    
    double temp;
    double hum;
    LocalDate date;
    LocalTime time;
    
    public Measurement(){
        
    }
    
    public Measurement(double temp, double hum){
        this(temp, hum, LocalDate.now(), LocalTime.now());
    }
    
    public Measurement(double temp, double hum, LocalDate date, LocalTime time){
        this.setTemp(temp);
        this.setHum(hum);
        this.setDate(date);
        this.setTime(time);
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getHum() {
        return hum;
    }

    public void setHum(double hum) {
        this.hum = hum;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
    
    
    
}
