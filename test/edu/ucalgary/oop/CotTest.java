/*
Copyright Ann Barcomb and Khawla Shnaikat, 2024-2025
Licensed under GPL v3
See LICENSE.txt for more information.
*/
package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

public class CotTest {
    private Cot cot;
    private Location location = new Location("University of Calgary", "50 University Dr");
    private DisasterVictim victim = new DisasterVictim("John", "2025-05-18");

    @Before
    public void setUp() {
        cot = new Cot(11, "B8");
    }

    @Test
    public void testObjectCreation() {
        assertNotNull("Cot should be instantiated", cot);
        assertFalse("Cot currently should not be allocated", cot.isAllocated());
    }

    @Test
    public void testCotAllocationAndDeallocationToLocation() {
        cot.allocate(location);
        assertTrue("Cot should now be allocated", cot.isAllocated());
        cot.deallocate();
        assertFalse("Cot should now be deallocated", cot.isAllocated());
    }

    @Test
    public void testCotAllocationAndDeallocationToDisasterVictim() {
        cot.allocate(victim);
        assertTrue("Cot should now be allocated", cot.isAllocated());
        cot.deallocate();
        assertFalse("Cot should now be deallocated", cot.isAllocated());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testLocationAllocatedBlanketAllocationToLocation() {
        Cot cotOne = new Cot("1", "A1");
        cotOne.allocate(location);
        Location newLocation = new Location("Mount Royal", "50 Mount Royal St");
        cotOne.allocate(newLocation);
        //Expecting IllegalArgumentException, cot is already allocated
    }

    @Test (expected = IllegalArgumentException.class)
    public void testLocationAllocatedCotAllocationToVictim() {
        Cot cotTwo = new Cot("1", "A1");
        cotTwo.allocate(location);
        DisasterVictim newVictim = new DisasterVictim("April", "2025-12-25");
        cotTwo.allocate(newVictim);
        //Expecting IllegalArgumentException, cot is already allocated
    }

    @Test (expected = IllegalArgumentException.class)
    public void testVictimAllocatedCotAllocationToLocation() {
        Cot cotThree = new Cot("1", "A1");
        cotThree.allocate(victim);
        Location newLocation = new Location("Mount Royal", "50 Mount Royal St");
        cotThree.allocate(newLocation);
        //Expecting IllegalArgumentException, cot is already allocated
    }

    @Test (expected = IllegalArgumentException.class)
    public void testVictimAllocatedCotAllocationToVictim() {
        Cot cotFour = new Cot("1", "A1");
        cotFour.allocate(victim);
        DisasterVictim newVictim = new DisasterVictim("April", "2025-12-25");
        cotFour.allocate(newVictim);
        //Expecting IllegalArgumentException, cot is already allocated
    }

    @Test
    public void testGetSupplyID() {
        assertEquals("getSupplyID() should properly retrieve the cot's ID", "C1", cot.getSupplyID());
    }

    @Test
    public void testGetAllocationLocation() {
        cot.allocate(location);
        assertNotNull("Allocation should be retrieved properly", cot.getAllocation());
        cot.deallocate();
    }

    @Test
    public void testGetAllocationVictim() {
        cot.allocate(victim);
        assertNotNull("Allocation should be retrieved properly", cot.getAllocation());
        cot.deallocate();
    }

    @Test
    public void testSetAndGetRoom() {
        cot.setRoom(12);
        assertEquals("setRoom should modify and getRoom retrieve room properly", 12, cot.getRoom());
    }

    @Test
    public void testSetAndGetGridLocation() {
        cot.setGridLocation("A9");
        assertEquals("setGridLocation should modify and getGridLocation retrieve gridLocation properly", "A9", cot.getGridLocation());
    }

}
