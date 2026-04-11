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
    
public static boolean checkUsername(String username ){
    return username.contains("_")&& username.length()<=8;
            }
//check password: must contain: a cap latter + a num + a special charector

public static boolean checkPasswordComplexity(char[] password){
    if (password == null) return false;
    String passW=new String(password);
    // regex: at least has one digit + one cap letter + one special charector
    String regex = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&*(),.?\":{}|<>]).{8,}$";
        return Pattern.matches(regex, passW);
}
        
//check cellphone number: must be south african
 
public static boolean checkCellPhoneNumber(String phone){
    String phone1=new String(phone);
    String regex = ("^\\+27[0-9]{9}$");
    return Pattern.matches(regex,phone1);
    
    };


        
        
   
     
    



    
    
    
    
    
    
    
    public static void main(String[] args) {
        
    }
};
