/*
Copyright Ann Barcomb and Khawla Shnaikat, 2024-2025
Licensed under GPL v3
See LICENSE.txt for more information.
*/
package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonalBelongingTest {
    private PersonalBelonging belonging;
    private DisasterVictim victim = new DisasterVictim("John", "2025-05-18");

    @Before
    public void setUp() {
        belonging = new PersonalBelonging(victim, "green bag");
    }

    @Test
    public void testObjectCreation() {
        assertNotNull("Belonging should be instantiated", belonging);
        assertTrue("Personal belongings should intially be allocated", belonging.isAllocated());
    }

    @Test
    public void testAllocateBelongingVictim() {
        DisasterVictim sister = new DisasterVictim("Jill", "2025-05-18");
        belonging.deallocate();
        belonging.allocate(sister);
        assertTrue("Belonging should be allocated", belonging.isAllocated());
        assertNotNull("New allocation should be instantiated", belonging.getAllocation());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAllocateBelongingLocation() {
        Location location = new Location("University of Calgary", "50 University Dr");
        belonging.deallocate();
        belonging.allocate(location);
        //expecting IllegalArgumentException, personal belongings can not be allocated to a location
    }

    @Test
    public void testGetAndSetDescription() {
        belonging.setDescription("dirty green bag");
        assertEquals("SetandGet Description should set and get description correctly", "dirty green bag", belonging.getDescription());
    }

    @Test
    public void testGetSupplyID() {
        assertEquals("getSupplyID() should properly retrieve the belonging's ID", "P1", water.getSupplyID());
    }

}
