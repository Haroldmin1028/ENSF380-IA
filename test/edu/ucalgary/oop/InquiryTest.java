/*
Copyright Ann Barcomb and Khawla Shnaikat, 2024-2025
Licensed under GPL v3
See LICENSE.txt for more information.
*/
package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class InquiryTest {
    
/* 
Define the values which will be used for tests
*/
    private final DisasterVictim MISSING_VICTIM = new DisasterVictim("Jane", "2025-06-19");
    private final ExternalInquirer INQUIRER_ONE = new ExternalInquirer("Joseph", "Bouillon", "+1-123-456-7890", "Paris, France");
    private final DisasterVictim INQUIRER_TWO = new DisasterVictim("John", "2025-06-19");
    private Inquiry inquiry;
    private final String INQUIRY_INFO = "looking for my sister";
    private final String VALID_DATE = "2025-02-10";
    private final String INVALID_DATE = "2025/02/10";
    private final Location LOCATION = new Location("University of Calgary", "50 University Dr");

    @Before
    public void setUp() {
        inquiry = new Inquiry(INQUIRER_ONE, MISSING_VICTIM, INQUIRY_INFO, VALID_DATE, LOCATION);
    }

    @Test
    public void testObjectCreation() {
        assertNotNull(inquiry);
    }


    @Test (expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidDate() {
        Inquiry inquiryOne = new Inquiry(INQUIRER_ONE, MISSING_VICTIM, INQUIRY_INFO, INVALID_DATE, LOCATION);
        //expecting InvalidArgumentException due to invalid date
    }

    @Test
    public void testConstructorWithDisasterVictimInquirer() {
        Inquiry inquiryTwo = new Inquiry(INQUIRER_TWO, MISSING_VICTIM, INQUIRY_INFO, VALID_DATE, LOCATION);
    }

    @Test
    public void testSetAndGetStatus() {
        assertEquals("Initial status should be In Progress", "In Progress", inquiry.getStatus());
        inquiry.setStatus("Resolved");
        assertEquals("Status should be properly modified", "Resolved", inquiry.getStatus());
    }

    @Test
    public void testGetInquirer() {
        assertEquals("Inquirer should match the one set in setup", INQUIRER_ONE, inquiry.getInquirer());
    }

    @Test
    public void testGetMissingPerson() {
        assertEquals("Missing person should match the one set in setup", MISSING_VICTIM, inquiry.getMissingPerson());
    }

    @Test
    public void testGetInquiryDate() {
        assertEquals("Date of inquiry should match the one set in setup", VALID_DATE, inquiry.getInquiryDate());
    }

    @Test
    public void testGetInquiryInfo() {
        assertEquals("Info provided should match the one set in setup", INQUIRY_INFO, inquiry.getInquiryInfo());
    }

    @Test
    public void testGetLastKnownLocation() {
        assertEquals("Last known location should match the one set in setup", LOCATION, inquiry.getLastKnownLocation());
    }

}

