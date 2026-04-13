/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.accountloggin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lab_services_student
 */
public class AccountLogginTest {
    
  @Test
  // test to see if kyl_1 works(which should) 
  
  public void testUsernameWithUnderscorIsValid(){
      boolean result = AccountLoggin.checkUsername("kyl_1");
      assertTrue(result);
  }
  
 @Test
 // test to see if kyle works (it should not work)
 
 public void testUsernameWithoutUnderscorIsValid(){
     boolean result = AccountLoggin.checkUsername("kyle!!!!!!!");
     assertFalse(result);
 }
  
@Test
// test to see if Ch&&sec@ke99!meets the requirments(it should work)

public void testPasswordThatMeetsTheRequirments(){                
    boolean result = AccountLoggin.checkPasswordComplexity("Ch&&sec@ke99!".toCharArray());
    assertTrue(result);
}

@Test
// test to see if "password" Meets the requirmets (which will not)

public void testPasswordThatDoesNotMeetTheRequirmets(){
    boolean result = AccountLoggin.checkPasswordComplexity("password".toCharArray());
    assertFalse(result);

}

@Test
// test the validity of the the cellphone number"+27 838 968 976" 

public void testCellphoneWithBothCorrectLengthAndInternationalCode(){
    boolean result = AccountLoggin.checkCellPhoneNumber("+27838968976");
    assertTrue(result);

}

@Test 
// test the validity of the cellphone numbet"089 665 53"

public void testCellPhoneWithoutAnyConditionsMet(){
        boolean result = AccountLoggin.checkCellPhoneNumber("03866553");
        assertFalse(result);
                
}

@Test 
// successful registration

public void testingASuccessfulRegistration(){
    AccountLoggin.registerUser("kyl_1", "Mayanga", "Ch&&sec@ke99!", "+27838968976");
    
    
   // successful loggin
    boolean result = AccountLoggin.loginUser("kyl_1", "Ch&&sec@ke99!");
    
    assertTrue(result);
}

@Test 
// testing if the loggin status can be returned

// 1 register the user

public void tstingReturnLogginStatus(){
    AccountLoggin.registerUser("kyl_1", "Mayanga", "Ch&&sec@ke99!", "+27838968976");
    
    // 2 return the status
    String result = AccountLoggin.returnLoginStatus("kyl_1","Ch&&sec@ke99!" );
    
    // 3 
    
     String expected = "WELCOME kyl_1 Mayanga IT IS NICE TO SEE YOU AGAIN";
    assertEquals(expected, result);
    
    
}
}

