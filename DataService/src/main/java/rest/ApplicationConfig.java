/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import filter.AuthenticationFilter;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Sander_2
 */
@javax.ws.rs.ApplicationPath("API")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        resources.add(AuthenticationFilter.class);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(rest.HumHistoryREST.class);
        resources.add(rest.MeasurementREST.class);
        resources.add(rest.TempHistoryREST.class);
    }
    
}
