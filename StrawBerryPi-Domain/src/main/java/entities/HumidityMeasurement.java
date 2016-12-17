package entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Sander_2
 */

public class HumidityMeasurement implements Serializable{
    
    double hum;
    LocalDate date;
    LocalTime time;
    
    public HumidityMeasurement(){
        
    }
    
    public HumidityMeasurement(double hum){
        this(hum, LocalDate.now(), LocalTime.now());
    }
    
    public HumidityMeasurement(double hum, LocalDate date, LocalTime time){
        this.setHum(hum);
        this.setDate(date);
        this.setTime(time);
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

