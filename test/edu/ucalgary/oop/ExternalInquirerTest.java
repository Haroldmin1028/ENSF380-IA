/*
Copyright Ann Barcomb and Khawla Shnaikat, 2024-2025
Licensed under GPL v3
See LICENSE.txt for more information.
*/
package edu.ucalgary.oop;

import org.junit.*;
import static org.junit.Assert.*;


public class ExternalInquirerTest {
    
/* 
Define the values which will be used for tests
*/
private String expectedFirstName = "Joseph";
private String expectedLastName = "Bouillon";
private String expectedPhoneNumber = "+1-123-456-7890";
private String expectedLocation = "Paris, France";

private ExternalInquirer inquirer = new ExternalInquirer(expectedFirstName, expectedLastName, expectedPhoneNumber, expectedLocation);

/*
testObjectCreation -> means testing ExternalInquirer constructor:
   - What we need: To verify that an "ExternalInquirer" object is successfully created.
   - Actual result: The name "Joseph Bouillon", the services phone number "+1-123-456-7890", and the provided location is "Paris, France".
   - Expected Result: The test checks that the ExternalInquirer object is not null, confirming successful object creation.
*/
    @Test
    public void testObjectCreation() {
        assertNotNull(inquirer);
    }

    @Test (expected=IllegalArgumentException.class)
    public void testConstructorWithInvalidPhoneNumber() {
        String invalidPhoneNumber = "abc-123-456-7890";
        ExternalInquirer inquirer = new ExternalInquirer(expectedFirstName, expectedLastName, invalidPhoneNumber, expectedLocation);
        //Expecting IllegalArgumentException, invalidPhoneNumber contains characters other than 0-9, -, +,()
    }

    @Test (expected=IllegalArgumentException.class)
    public void testConstructorWithInvalidLocation() {
        String invalidLocation = "12!A, France";
        ExternalInquirer inquirer = new ExternalInquirer(expectedFirstName, expectedLastName, expectedPhoneNumber, invalidLocation);
        //Expecting IllegalArgumentException, invalidLocation contains characters other than A-Z, a-z, comma
    }

    @Test (expected=IllegalArgumentException.class)
    public void testConstructorWithInvalidPhoneNumberAndLocation() {
        String invalidPhoneNumber = "abc-123-456-7890";
        String invalidLocation = "12!A,  France";
        ExternalInquirer inquirer = new ExternalInquirer(expectedFirstName, expectedLastName, invalidPhoneNumber, invalidLocation);
        //Expecting IllegalArgumentException, invalidPhoneNumber contains characters other than 0-9, -, +,(), invalidLocation contains characters other than A-Z, a-z, comma
    }

/*
testSetAndGetFirstName**:
   - What we need: To ensure the "setFirstName()" modifies and "getFirstName()" method correctly returns the actual inquirer's first name.
   - Actual result: "Josef".
   - Expected result: "inquirer.getFirstName()" should return "Josef".
   */
    @Test
    public void testSetAndGetFirstName() {
        String newFirstName = "Josef";
        inquirer.setFirstName(newFirstName);
        assertEquals("setFirstName() should update and getFirstName() should return inquirer's first name", newFirstName, inquirer.getFirstName());
    }

/*
testSetAndGetLastName:
   - What we need: To confirm that the "setLastName()" modifies and "getLastName()" method accurately returns inquirer's last name.
   - Actual result:"Bwion".
   - Expected result: "inquirer.getLastName()" should return "Bwion".
*/
    @Test
    public void testSetAndGetLastName() {
        String newLastName = "Bwion";
        inquirer.setLastName(newLastName);
        assertEquals("setLastName() should update and getLastName() should return inquirer's last name", newLastName, inquirer.getLastName());
    }
	
/*
testSetAndGetPhoneNumber**:
   - What we need: To confirm that "setPhoneNumber()" modifies and "getPhoneNumber()" method correctly returns the inquirer's phone number.
   - Actual result: "+1-123-456-7890".
   - Expected result: "inquirer.PhoneNumber()" should return "+1-123-456-7890".
*/
    @Test
    public void testSetAndGetPhoneNumber() {
        String newPhoneNumber = "+1-908-765-4321";
        inquirer.setPhoneNumber(newPhoneNumber);
        assertEquals("setPhoneNumber() should update and getPhoneNumber() should return inquirer's phone number", newPhoneNumber, inquirer.getPhoneNumber());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetPhoneNumberWithInvalidCharacters() {
        String invalidPhoneNumber = "abcd-efgh";
        inquirer.setPhoneNumber(invalidPhoneNumber);
        //Expecting IllegalArgumentException, invalidPhoneNumber contains characters other than 0-9, -, +,()
    }
	
/*
testSetAndGetLocation:
   - What we need: To confirm that "setLocation()" modifies "getLocation()" method retrieves the correct information string.
   - Actual result: "Paris, France".
   - Expected result: "inquirer.getLocation()" should return the string "Paris, France".
*/
    @Test
    public void testSetAndGetLocation() {
        String newLocation = "Cancun, Mexico";
        inquirer.setLocation(newLocation);
        assertEquals("getLocation() should return the inquirer's location", newLocation, inquirer.getLocation());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetLocationWithInvalidCharacters() {
        String invalidLocation = "&^frw12?";
        inquirer.setPhoneNumber(invalidPhoneNumber);
        //Expecting IllegalArgumentException, invalidLocation contains characters other than A-Z, a-z, comma
    }
}
