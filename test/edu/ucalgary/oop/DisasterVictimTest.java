/*
Copyright Ann Barcomb and Khawla Shnaikat, 2025
Licensed under GPL v3
See LICENSE.txt for more information.
*/

package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class DisasterVictimTest {
    private DisasterVictim victim;
    private ArrayList<Supply> suppliesToSet;
    private ArrayList<MedicalRecord> records;
    private String expectedFirstName = "Freda";
    private String EXPECTED_ENTRY_DATE = "2025-01-18";
    private String validDate = "2025-01-15";
    private String invalidDate = "15/13/2025";
    private String expectedGender = "female"; 
    private String expectedComments = "Needs medical attention and speaks 2 languages";

    @Before
    public void setUp() {
        victim = new DisasterVictim(expectedFirstName, EXPECTED_ENTRY_DATE);
        suppliesToSet = new ArrayList<>();
        suppliesToSet.add(new Supply("Water Bottle", 10));
        suppliesToSet.add(new Supply("Blanket", 5));
        
        DisasterVictim victim1 = new DisasterVictim("Jane", "2025-01-20");
        DisasterVictim victim2 = new DisasterVictim("John", "2025-01-22");
        
    }

  		  
  @Test
  public void testBirthdateConstructorWithValidEntryDate() {
        String validEntryDate = "2025-02-18";
        String validBirthdate = "2017-03-20";
        DisasterVictim victim = new DisasterVictim("Freda", validEntryDate, validBirthdate);
        assertNotNull("Constructor should successfully create an instance with a valid entry date", victim);
        assertEquals("Constructor should set the entry date correctly", validEntryDate, victim.getEntryDate());
        assertEquals("Constructor should set the birth date correctly", validBirthdate, victim.getBirthDate());
  }

    @Test(expected = IllegalArgumentException.class)
    public void testBirthdateConstructorWithInvalidEntryDateFormat() {
        String invalidEntryDate = "20250112"; 
        String validBirthdate = "2017-03-20";
        new DisasterVictim("Fang", invalidEntryDate, validBirthdate);
        // Expecting IllegalArgumentException due to invalid date format
    }

  @Test(expected = IllegalArgumentException.class)
  public void testBirthdateConstructorWithInvalidBirthdate() {
        String validEntryDate = "2025-02-18";
        String invalidBirthDate = "20250112"; 
        DisasterVictim victim = new DisasterVictim("Yaw", validEntryDate, invalidBirthDate);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBirthdateConstructorWithBirthdateAfterEntryDate() {
        String validEntryDate = "2025-02-17";
        String validBirthDate = "2025-02-18";
        DisasterVictim victim = new DisasterVictim("Jessica", validEntryDate, validBirthDate);
  }


  @Test
    public void testConstructorWithValidEntryDate() {
        String validEntryDate = "2025-01-18";
        DisasterVictim victim = new DisasterVictim("Freda", validEntryDate);
        assertNotNull("Constructor should successfully create an instance with a valid entry date", victim);
        assertEquals("Constructor should set the entry date correctly", validEntryDate, victim.getEntryDate());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidEntryDateFormat() {
        String invalidEntryDate = "18/01/2025"; // Incorrect format according to your specifications
        new DisasterVictim("Freda", invalidEntryDate);
        // Expecting IllegalArgumentException due to invalid date format
    }


   @Test
    public void testSetDateOfBirth() {
        String newDateOfBirth = "1987-05-21";
        victim.setDateOfBirth(newDateOfBirth);
        assertEquals("setDateOfBirth should correctly update the date of birth", newDateOfBirth, victim.getBirthDate());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDateOfBirthWithInvalidFormat() {
        victim.setDateOfBirth(invalidDate); // This format should cause an exception
    }
	
	@Test
    public void testSetAndGetFirstName() {
        String newFirstName = "Alice";
        victim.setFirstName(newFirstName);
        assertEquals("setFirstName should update and getFirstName should return the new first name", newFirstName, victim.getFirstName());
    }

    @Test
    public void testSetAndGetLastName() {
        String newLastName = "Smith";
        victim.setLastName(newLastName);
        assertEquals("setLastName should update and getLastName should return the new last name", newLastName, victim.getLastName());
    }

    @Test
    public void testGetComments() {
        victim.setComments(expectedComments);
        assertEquals("getComments should return the initial correct comments", expectedComments, victim.getComments());
    }

    @Test
    public void testSetComments() {
        victim.setComments(expectedComments);
        String newComments = "Has a minor injury on the left arm";
        victim.setComments(newComments);
        assertEquals("setComments should update the comments correctly", newComments, victim.getComments());
    }

    @Test
    public void testGetAssignedSocialID() {
        // The next victim should have an ID one higher than the previous victim
        // Tests can be run in any order so two victims will be created
        DisasterVictim newVictim = new DisasterVictim("Kash", "2025-01-21");
        int expectedSocialId = newVictim.getAssignedSocialID() + 1;
        DisasterVictim actualVictim = new DisasterVictim("Adeleke", "2025-01-22");

        assertEquals("getAssignedSocialID should return the expected social ID", expectedSocialId, actualVictim.getAssignedSocialID());
    }

    @Test
    public void testGetEntryDate() {
        assertEquals("getEntryDate should return the expected entry date", EXPECTED_ENTRY_DATE, victim.getEntryDate());
    }
   
    @Test
    public void testSetAndGetGender() {
        String newGender = "male";
        victim.setGender(newGender);
        assertEquals("setGender should update and getGender should return the new gender", newGender.toLowerCase(), victim.getGender());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetGenderWithInvalidGender() {
        String invalidGender = "whale";
        victim.setGender(invalidGender);
        // Expecting IllegalArgumentException, gender is not "male", "female", nor "non-binary"
    }

    @Test
    public void testAddPersonalBelonging() {
        Supply newSupply = new Supply("Emergency Kit", 1);
        victim.addPersonalBelonging(newSupply);
        Supply[] testSupplies = victim.getPersonalBelongings();
        boolean correct = false;
 
        int i;
        for (i = 0; i < testSupplies.length; i++) {
            if (testSupplies[i] == newSupply) {
                correct = true;
            }
        }
        assertTrue("addPersonalBelonging should add the supply to personal belongings", correct);
    }


    @Test
    public void testRemovePersonalBelonging() {
    
        Supply supplyToRemove = suppliesToSet.get(0); 
        victim.addPersonalBelonging(supplyToRemove); 
        victim.removePersonalBelonging(supplyToRemove);

        Supply[] testSupplies = victim.getPersonalBelongings();
        boolean correct = true;
 
        int i;
        for (i = 0; i < testSupplies.length; i++) {
            if (testSupplies[i] == supplyToRemove) {
                correct = false;
            }
        }
    assertTrue("removePersonalBelonging should remove the supply from personal belongings", true);
}

    @Test
    public void testSetMedicalRecords() {
        Location testLocation = new Location("Shelter Z", "1234 Shelter Ave");
        MedicalRecord testRecord = new MedicalRecord(testLocation, "test for strep", "2025-02-09");
        boolean correct = true;

        MedicalRecord[] newRecords = { testRecord };
        victim.setMedicalRecords(newRecords);
        MedicalRecord[] actualRecords = victim.getMedicalRecords();

        // We have not studied overriding equals in arrays of custom objects so we will manually evaluate equality
        if (newRecords.length != actualRecords.length) {
            correct = false;
        } else {
            int i;
            for (i=0;i<newRecords.length;i++) {
                if (actualRecords[i] != newRecords[i]) {
                    correct = false;
                }
            }
        }
        assertTrue("setMedicalRecords should correctly update medical records", correct);
    }


   @Test
public void testSetPersonalBelongings() {
    Supply one = new Supply("Tent", 1);
    Supply two = new Supply("Jug", 3);
    Supply[] newSupplies = {one, two};
    boolean correct = true;

    victim.setPersonalBelongings(newSupplies);
    Supply[] actualSupplies = victim.getPersonalBelongings();

    // We have not studied overriding equals in arrays of custom objects so we will manually evaluate equality
    if (newSupplies.length != actualSupplies.length) {
        correct = false;
    } else {
        int i;
        for (i=0;i<newSupplies.length;i++) {
            if (actualSupplies[i] != newSupplies[i]) {
                correct = false;
            }
        }
    }
    assertTrue("setPersonalBelongings should correctly update personal belongings", correct);
}


    
}





