/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.accountloggin;

import java.util.regex.Pattern;

/**
 *
 * @author lab_services_student
 */
public class AccountLoggin {
    
    // Check usernamm: must contain _ and maximum of 8 charectors 
    
public static boolean checkusername(String username ){
    return username.contains("_")&& username.length()<=8;
            }
//check password: must contain: a cap latter + a num + a special charector

public static boolean cheackpassword(char[] password){
    if (password == null) return false;
    String passW=new String(password);
    // regex: at least has one digit + one cap letter + one special charector
    String regex = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&*(),.?\":{}|<>]).{8,}$";
        return Pattern.matches(regex, passW);
   
     
    }



    
    
    
    
    
    
    
    public static void main(String[] args) {
        
    }
}
