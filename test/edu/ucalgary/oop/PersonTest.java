/*
Copyright Ann Barcomb and Khawla Shnaikat, 2025
Licensed under GPL v3
See LICENSE.txt for more information.
*/

package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PersonTest {
    private Person person;
    private String expectedFirstName = "Freda";

    @Before
    public void setUp() {
        person = new Person(expectedFirstName);
    }

    @Test
    public void testObjectCreation() {
        assertNotNull("Constructor should successfully create an instance", person);
        assertEquals("Constructor should set the first name correctly", expectedFirstName, person.getFirstName());
    }

    @Test
    public void testLastNameGenderConstructor() {
        String expectedFirstName = "Jannik";
        String expectedLastName = "Sinner";
        String expectedGender = "male";
        person = new Person(expectedFirstName, expectedLastName, expectedGender);
        assertNotNull("Constructor should successfully create an instance", person);
        assertEquals("Constructor should set the first name correctly", expectedFirstName, person.getFirstName());
        assertEquals("Constructor should set the last name correctly", expectedLastName, person.getLastName());
        assertEquals("Constructor should correctly set the gender", expectedGender, person.getGender());
    }

	
	@Test
    public void testSetAndGetFirstName() {
        String newFirstName = "Alice";
        person.setFirstName(newFirstName);
        assertEquals("setFirstName should update and getFirstName should return the new first name", newFirstName, person.getFirstName());
    }

    @Test
    public void testSetAndGetLastName() {
        String newLastName = "Smith";
        person.setLastName(newLastName);
        assertEquals("setLastName should update and getLastName should return the new last name", newLastName, person.getLastName());
    }
   
    @Test
    public void testSetAndGetGender() {
        String newGender = "male";
        person.setGender(newGender);
        assertEquals("setGender should update and getGender should return the new gender", newGender.toLowerCase(), person.getGender());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetGenderWithInvalidGender() {
        String invalidGender = "whale";
        person.setGender(invalidGender);
        // Expecting IllegalArgumentException, gender is not "male", "female", nor "non-binary"
    }
}





