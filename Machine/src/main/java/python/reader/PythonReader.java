/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package python.reader;

import com.google.gson.Gson;
import entities.Measurement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Sander_2 && Tim
 */
public class PythonReader implements IPythonReader{

    @Override
    public Measurement getCurrentMeasurement() {
            String result = "";
        try {
            Runtime r = Runtime.getRuntime();                    

            Process p = r.exec("python /projects/readdata.py");

            BufferedReader in =new BufferedReader(new InputStreamReader(p.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("inputline="+inputLine);
                result += inputLine;
            }
            in.close();

        } catch (IOException e) {
            System.out.println(e);
        }
        Gson gson = new Gson();
        System.out.println(result);
        Measurement measurement=gson.fromJson(result, Measurement.class);
        return measurement;
    }
    
}
