
package com.bhanu.business;

import java.io.Serializable;



/**
 *
 * @author bhanu
 */

public class User implements Serializable{
     

      private String email;
      private String username;
      private String userpassword;
      
      private String usertype;

    public String getEmail() {
        return email;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

   
   
      
   

public User(){
    email="";
    username="";
    userpassword="";
    usertype="customer";
}
    
}
