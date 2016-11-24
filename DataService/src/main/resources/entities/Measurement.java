/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Sander_2
 */
@Entity
public class Measurement implements Serializable{
    
    double temp;
    double hum;
    LocalDate date;
    LocalTime time;
    
    @Id
    @GeneratedValue
    private Long id;
    
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
}
