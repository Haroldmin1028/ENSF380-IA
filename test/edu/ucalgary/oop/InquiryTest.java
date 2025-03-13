/*
Copyright Ann Barcomb and Khawla Shnaikat, 2024-2025
Licensed under GPL v3
See LICENSE.txt for more information.
*/
package edu.ucalgary.oop;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class InquiryTest {
    
/* 
Define the values which will be used for tests
*/
private final DisasterVictim TEST_VICTIM = new DisasterVictim("", "2025-06-19");
private final ExternalInquirer TEST_EXTERNAL_INQUIRER = new ExternalInquirer("Alex", "Ovechkin", "333-4444", "Ottawa, Canada");
private String expectedMessage = "looking for my family members";
private Inquiry inquiry = new Inquirer(expectedFirstName, expectedLastName, expectedPhoneNumber, expectedMessage);


    @Test
    public void testObjectCreation() {
        assertNotNull(inquirer);
    }


    @Test
    public void testGetFirstName() {
        assertEquals("getFirstName() should return inquirer's first name", expectedFirstName, inquirer.getFirstName());
    }
	

    @Test
    public void testGetLastName() {
        assertEquals("getLastName() should return inquirer's last name", expectedLastName, inquirer.getLastName());
    }
	

    @Test
    public void testGetServicesPhoneNum() {

        assertEquals("getServicesPhoneNum() should return the correct Services Number",expectedPhoneNumber, inquirer.getServicesPhoneNum());
    }
	

    @Test
    public void testGetInfo() {
        assertEquals("getInfo() should return the inquirer message", expectedMessage,inquirer.getInfo());
    }

}

