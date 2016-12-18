/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entities.User;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Base64;
import java.util.List;
import java.util.StringTokenizer;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;

/**
 *
 * @author Sander_2
 */
public class AuthenticationFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext req) throws IOException {
        String authCredentials = req.getHeaderString("Authorization");
        boolean authenticated = authenticate(authCredentials);
        if(!authenticated){
            req.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("no valid authentication").build());
        }

    }

    public boolean authenticate(String authCredentials) {
        if (null == authCredentials) {
            return false;
        }
        // header value format will be "Basic encodedstring" for Basic
        // authentication. Example "Basic YWRtaW46YWRtaW4="
        final String encodedUserPassword = authCredentials.replaceFirst("Basic"+ " ", "");
        String usernameAndPassword = null;
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(encodedUserPassword);
            usernameAndPassword = new String(decodedBytes, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
        final String username = tokenizer.nextToken();
        final String password = tokenizer.nextToken();
        
        User auth = new User(username, password);
        
        ClassLoader loader = getClass().getClassLoader();
        InputStream is = loader.getResourceAsStream("users.json");
        
        Type listType = new TypeToken<List<User>>() {}.getType();
        List<User> users = new Gson().fromJson(is.toString(), listType);
        
        for(User u : users){
            if(u.equals(auth)){
                return true;
            }
        }
        return false;
    }
}
