/*
Copyright Ann Barcomb and Khawla Shnaikat, 2024-2025
Licensed under GPL v3
See LICENSE.txt for more information.
*/
package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlanketTest {
    private Blanket blanket;
    private Location location = new Location("University of Calgary", "50 University Dr");
    private DisasterVictim victim = new DisasterVictim("John", "2025-05-18");

    @Before
    public void setUp() {
        blanket = new Blanket();
    }

    @Test
    public void testObjectCreation() {
        assertNotNull("Blanket should be instantiated", blanket);
        assertFalse("Blanket currently should not be allocated", blanket.isAllocated());
    }

    @Test
    public void testBlanketAllocationAndDeallocationToLocation() {
        blanket.allocate(location);
        assertTrue("Blanket should now be allocated", blanket.isAllocated());
        blanket.deallocate();
        assertFalse("Blanket should now be deallocated", blanket.isAllocated());
    }

    @Test
    public void testBlanketAllocationAndDeallocationToDisasterVictim() {
        blanket.allocate(victim);
        assertTrue("Blanket should now be allocated", blanket.isAllocated());
        blanket.deallocate();
        assertFalse("Blanket should now be deallocated", blanket.isAllocated());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testLocationAllocatedBlanketAllocationToLocation() {
        Blanket blanketOne = new Blanket();
        blanketOne.allocate(location);
        Location newLocation = new Location("Mount Royal", "50 Mount Royal St");
        blanketOne.allocate(newLocation);
        //Expecting IllegalArgumentException, blanket is already allocated
    }

    @Test (expected = IllegalArgumentException.class)
    public void testLocationAllocatedBlanketAllocationToVictim() {
        Blanket blanketTwo = new Blanket();
        blanketTwo.allocate(location);
        DisasterVictim newVictim = new DisasterVictim("April", "2025-12-25");
        blanketTwo.allocate(newVictim);
        //Expecting IllegalArgumentException, blanket is already allocated
    }

    @Test (expected = IllegalArgumentException.class)
    public void testVictimAllocatedBlanketAllocationToLocation() {
        Blanket blanketThree = new Blanket();
        blanketThree.allocate(victim);
        Location newLocation = new Location("Mount Royal", "50 Mount Royal St");
        blanketThree.allocate(newLocation);
        //Expecting IllegalArgumentException, blanket is already allocated
    }

    @Test (expected = IllegalArgumentException.class)
    public void testVictimAllocatedBlanketAllocationToVictim() {
        Blanket blanketFour = new Blanket();
        blanketFour.allocate(victim);
        DisasterVictim newVictim = new DisasterVictim("April", "2025-12-25");
        blanketFour.allocate(newVictim);
        //Expecting IllegalArgumentException, blanket is already allocated
    }

    @Test
    public void testGetSupplyID() {
        assertEquals("getSupplyID() should properly retrieve the blanket's ID", "B1", blanket.getSupplyID());
    }

    @Test
    public void testGetAllocationLocation() {
        blanket.allocate(location);
        assertNotNull("Allocation should be retrieved properly", blanket.getAllocation());
        blanket.deallocate();
    }

    @Test
    public void testGetAllocationVictim() {
        blanket.allocate(victim);
        assertNotNull("Allocation should be retrieved properly", blanket.getAllocation());
        blanket.deallocate();
    }
}
