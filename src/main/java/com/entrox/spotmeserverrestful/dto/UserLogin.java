
package com.entrox.spotmeserverrestful.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserLogin {
    
    public String emailOrUsername;
    
    public String pw;
    
    
    public UserLogin (){
        
    }
    
    public UserLogin(String un_mail, String pw){
        this.emailOrUsername = un_mail;
        
        this.pw = pw;
    }
    
}
