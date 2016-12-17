/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import entities.Measurement;
import java.sql.Date;
import java.util.List;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Tim
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class MeasurementDBService {
    
    @PersistenceContext (unitName="StrawberryPi_StrawberryPi-DataService_war_1.0PU")
    EntityManager em;
    
    public void storeMeasurement(Measurement measurement){
        em.persist(measurement);
        em.flush();
    }
    
    public List<Measurement> getAllMeasurements(){
        return em.createQuery("select m from Measurement m").getResultList();
    }

    public void deleteMeasurement(long id) {
        Measurement m=em.find(Measurement.class, id);
        em.remove(m);
        em.flush();
    }
    
    public List<Measurement> getAllMeasurementsAfterDate(Date date){
        Query q= em.createQuery("select m from Measurement m where m.date > :date");
        q.setParameter("date", date);
        return q.getResultList();
    }
    
    public List<Measurement> getAllMeasurementsOfDate(Date date){
        Query q= em.createQuery("select m from Measurement m where m.date = :date");
        q.setParameter("date", date);
        return q.getResultList();
    }
}
