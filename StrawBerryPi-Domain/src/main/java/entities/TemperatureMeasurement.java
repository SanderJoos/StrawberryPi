package entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Sander_2
 */

public class TemperatureMeasurement implements Serializable{
    
    double temp;
    LocalDate date;
    LocalTime time;
 
    public TemperatureMeasurement(){
        
    }
    
    public TemperatureMeasurement(double temp){
        this(temp, LocalDate.now(), LocalTime.now());
    }
    
    public TemperatureMeasurement(double temp, LocalDate date, LocalTime time){
        this.setTemp(temp);
        this.setDate(date);
        this.setTime(time);
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
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
