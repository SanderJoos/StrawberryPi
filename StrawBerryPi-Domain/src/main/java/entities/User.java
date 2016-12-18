/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
/**
 *
 * @author Sander_2
 */
public class User {
    
    private String username;
    private String password;
    
    public User(){
        
    }
    
    public User(String username, String password){
        this.setPassword(password);
        this.setUsername(username);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof User){
            User u = (User) o;
            return u.getPassword().equals(this.getPassword()) && u.getUsername().equals(this.getUsername());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (this.getPassword().hashCode() + this.getUsername().hashCode()) % 64;
    }
    
    
    
}
