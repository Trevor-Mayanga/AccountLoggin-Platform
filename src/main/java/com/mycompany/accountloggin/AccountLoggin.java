/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.accountloggin;

import java.util.regex.Pattern;
import java.util.HashMap;


/**
 *
 * @author lab_services_student
 */
public class AccountLoggin {
    
    // where the details will stored [password & username]
private static HashMap<String, String[]> userDatabase = new HashMap<>();

    
  // Check usernamm: must contain _ and maximum of 8 charectors 
    
public static boolean checkUsername(String username ){
    return username.contains("_")&& username.length()<=5;
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
    String regex = ("^\\+27[0-9]{9}$");
    return Pattern.matches(regex,phone);
    
    };

// Registering the usre 

 public static String registerUser(String username, String surname, String password, String phone) {
        if (!checkUsername(username)) {
            return "Username incorrectly formatted, please ensure that your username contains an underscore and is no more than 5 characters long.";
        }
        if (!checkPasswordComplexity(password.toCharArray())) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        }
        if (!checkCellPhoneNumber(phone)) {
            return "The cellphone number is incorrectly formatted.";
        }

        // Store user: Username is the key, [password, surname] is the value
        userDatabase.put(username, new String[]{password, surname});
        return "Registration successful.";
   }
 //Method to login user
 
 public static boolean loginUser(String username,String password){
     if (userDatabase.containsKey(username)){
            return userDatabase.get(username)[0].equals(password);}
     return false;
 }
 
 
 // Method to return loggin status
 
 public static String returnLoginStatus(String username, String password){
     if  (loginUser(username,password)) {
          String surname = userDatabase.get(username)[1];
         return "WELCOME " + username + " " + surname + " IT IS NICE TO SEE YOU AGAIN";
     }else {
         return "USERNAME OR PASSWORD INCORRECT PLEASE TRY AGAIN";
         }
     
     
   
  
 
 }
 
public static void main(String[] args) {
          
    AccountLoggin app = new AccountLoggin();

    // 1. Register a user
    System.out.println(app.registerUser("u_1", "Smith", "P@ssw0rd", "+27821234567"));

    // 2. Try to login
    System.out.println(app.returnLoginStatus("u_1", "P@ssw0rd"));
}

    
    }

