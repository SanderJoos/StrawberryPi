/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import entities.User;
import java.io.IOException;
import java.util.Base64;
import java.util.StringTokenizer;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;

/**
 *
 * @author Sander_2
 */

@Authenticate
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
        System.out.println("entered Authentication");
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
        
        if(auth.equals(new User("Sander","t")) ||auth.equals(new User("Tim","t"))||auth.equals(new User("Kemme","t"))){
            return true;
        }

        return false;
    }
}
