/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import entities.Measurement;
import java.util.List;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
        em.getTransaction().begin();
        em.persist(measurement);
        em.flush();
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Measurement> getAllMeasurements(){
        try{
            return em.createQuery("select m from measurement m").getResultList();
        }
        finally{
            em.close();
        }
    }
}
