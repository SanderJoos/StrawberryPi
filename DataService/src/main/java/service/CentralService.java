/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.*;
import gatherers.MeasurementGatherer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Sander_2
 */
//TODO EJB
@Stateless
public class CentralService {

    @Inject
    public MeasurementDBService service;

    @Inject
    public MeasurementGatherer gatherer;

    public void storeMeasurement(Measurement measurement) {
        service.storeMeasurement(measurement);
    }

    public List<Measurement> getAllMeasurements() {
        return service.getAllMeasurements();
    }

    public List<Measurement> getAllMeasurementsOnDate(LocalDate date) {
        List<Measurement> result = new ArrayList<>();
        for (Measurement m : this.getAllMeasurements()) {
            if (m.getDate().equals(date)) {
                result.add(m);
            }
        }
        return result;
    }

    public List<Measurement> getAllMeasurementsAfterDate(LocalDate date) {
        List<Measurement> result = new ArrayList<>();
        for (Measurement m : this.getAllMeasurements()) {
            if (m.getDate().isAfter(date)) {
                result.add(m);
            }
        }
        return result;
    }
    
    public List<Measurement> getAllMeasurementsBeforeDate(LocalDate date) {
        List<Measurement> result = new ArrayList<>();
        for (Measurement m : this.getAllMeasurements()) {
            if (m.getDate().isBefore(date)) {
                result.add(m);
            }
        }
        return result;
    }

    public boolean retrieveNewDate() {
        //Measurement m = this.gatherer.getMeasurement();
        Measurement m = new Measurement(33.33,55.55);
        if(m != null){
            this.service.storeMeasurement(m);
            return true;
        }
        return false;
    }

    public void deleteMeasurement(long id) {
        this.service.deleteMeasurement(id);
    }

    public List<HumidityMeasurement> getAllHumMeasurements() {
        List<HumidityMeasurement> hums = new ArrayList<>();
        HumidityMeasurement hum;
        for (Measurement m : this.getAllMeasurements()) {
            hum = new HumidityMeasurement(m.getHum(), m.getDate(), m.getTime());
            hums.add(hum);
        }
        return hums;
    }

    public List<HumidityMeasurement> getAllHumMeasurementsAfterDate(LocalDate date) {
        List<HumidityMeasurement> hums = new ArrayList<>();
        HumidityMeasurement hum;
        for (Measurement m : this.getAllMeasurements()) {
            if (m.getDate().isAfter(date)) {
                hum = new HumidityMeasurement(m.getHum(), m.getDate(), m.getTime());
                hums.add(hum);
            }
        }
        return hums;
    }
    
    public List<HumidityMeasurement> getAllHumMeasurementsOnDate(LocalDate date) {
        List<HumidityMeasurement> hums = new ArrayList<>();
        HumidityMeasurement hum;
        for (Measurement m : this.getAllMeasurements()) {
            if (m.getDate().equals(date)) {
                hum = new HumidityMeasurement(m.getHum(), m.getDate(), m.getTime());
                hums.add(hum);
            }
        }
        return hums;
    }
    
    public List<HumidityMeasurement> getAllHumMeasurementsBeforeDate(LocalDate date) {
        List<HumidityMeasurement> hums = new ArrayList<>();
        HumidityMeasurement hum;
        for (Measurement m : this.getAllMeasurements()) {
            if (m.getDate().isBefore(date)) {
                hum = new HumidityMeasurement(m.getHum(), m.getDate(), m.getTime());
                hums.add(hum);
            }
        }
        return hums;
    }
    
    public List<TemperatureMeasurement> getAllTemperatureMeasurements() {
        List<TemperatureMeasurement> temps = new ArrayList<>();
        TemperatureMeasurement temp;
        for (Measurement m : this.getAllMeasurements()) {
            temp = new TemperatureMeasurement(m.getTemp(), m.getDate(), m.getTime());
            temps.add(temp);
        }
        return temps;
    }

    public List<TemperatureMeasurement> getAllTemperatureMeasurementsAfterDate(LocalDate date) {
        List<TemperatureMeasurement> temps = new ArrayList<>();
        TemperatureMeasurement temp;
        for (Measurement m : this.getAllMeasurements()) {
            if (m.getDate().isAfter(date)) {
                temp = new TemperatureMeasurement(m.getTemp(), m.getDate(), m.getTime());
                temps.add(temp);
            }
        }
        return temps;
    }
    
    public List<TemperatureMeasurement> getAllTemperatureMeasurementsOnDate(LocalDate date) {
        List<TemperatureMeasurement> temps = new ArrayList<>();
        TemperatureMeasurement temp;
        for (Measurement m : this.getAllMeasurements()) {
            if (m.getDate().equals(date)) {
                temp = new TemperatureMeasurement(m.getTemp(), m.getDate(), m.getTime());
                temps.add(temp);
            }
        }
        return temps;
    }
    
    public List<TemperatureMeasurement> getAllTemperatureMeasurementsBeforeDate(LocalDate date) {
        List<TemperatureMeasurement> temps = new ArrayList<>();
        TemperatureMeasurement temp;
        for (Measurement m : this.getAllMeasurements()) {
            if (m.getDate().isBefore(date)) {
                temp = new TemperatureMeasurement(m.getTemp(), m.getDate(), m.getTime());
                temps.add(temp);
            }
        }
        return temps;
    }
    
    
}
