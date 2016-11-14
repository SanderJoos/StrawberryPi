/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package python.reader;

import com.google.gson.Gson;
import entities.Measurement;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;

/**
 *
 * @author Sander_2 && Tim
 */
public class PythonReader implements IPythonReader{

    @Override
    public Measurement getCurrentMeasurement() {

        StringWriter writer = new StringWriter();

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptContext context = new SimpleScriptContext();

        context.setWriter(writer);
        ScriptEngine engine = manager.getEngineByName("python");
        try {
            engine.eval(new FileReader("/projects/readdata.py"), context);
        } catch (ScriptException | FileNotFoundException ex) {
            Logger.getLogger(PythonReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        Gson gson = new Gson();
        Measurement measurement=gson.fromJson(writer.toString(), Measurement.class);
        System.out.println(writer.toString());
        return measurement;
    }
    
}
