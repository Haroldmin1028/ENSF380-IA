/*
Copyright Ann Barcomb and Khawla Shnaikat, 2024-2025
Licensed under GPL v3
See LICENSE.txt for more information.
*/
package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SupplyTest {
    private Supply supply;
    private Location location = new Location("University of Calgary", "50 University Dr");
    private DisasterVictim victim = new DisasterVictim("John", "2025-05-18");

    @Before
    public void setUp() {
        supply = new Supply();
    }

    @Test
    public void testObjectCreation() {
        assertNotNull("Supply should be instantiated", supply);
        assertFalse("Supply currently should not be allocated", supply.isAllocated());
    }

    @Test
    public void testSupplyAllocationAndDeallocationToLocation() {
        supply.allocate(location);
        assertTrue("Supply should now be allocated", supply.isAllocated());
        supply.deallocate();
        assertFalse("Supply should now be deallocated", supply.isAllocated());
    }

    @Test
    public void testSupplyAllocationAndDeallocationToDisasterVictim() {
        supply.allocate(victim);
        assertTrue("Supply should now be allocated", supply.isAllocated());
        supply.deallocate();
        assertFalse("Supply should now be deallocated", supply.isAllocated());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testLocationAllocatedSupplyAllocationToLocation() {
        Supply supplyOne = new Supply();
        supplyOne.allocate(location);
        Location newLocation = new Location("Mount Royal", "50 Mount Royal St");
        supplyOne.allocate(newLocation);
        //Expecting IllegalArgumentException, supply is already allocated
    }

    @Test (expected = IllegalArgumentException.class)
    public void testLocationAllocatedSupplyAllocationToVictim() {
        Supply supplyTwo = new Supply();
        supplyTwo.allocate(location);
        DisasterVictim newVictim = new DisasterVictim("April", "2025-12-25");
        supplyTwo.allocate(newVictim);
        //Expecting IllegalArgumentException, supply is already allocated
    }

    @Test (expected = IllegalArgumentException.class)
    public void testVictimAllocatedSupplyAllocationToLocation() {
        Supply supplyThree = new Supply();
        supplyThree.allocate(victim);
        Location newLocation = new Location("Mount Royal", "50 Mount Royal St");
        supplyThree.allocate(newLocation);
        //Expecting IllegalArgumentException, supply is already allocated
    }

    @Test (expected = IllegalArgumentException.class)
    public void testVictimAllocatedSupplyAllocationToVictim() {
        Supply supplyFour = new Supply();
        supplyFour.allocate(victim);
        DisasterVictim newVictim = new DisasterVictim("April", "2025-12-25");
        supplyFour.allocate(newVictim);
        //Expecting IllegalArgumentException, supply is already allocated
    }

    @Test
    public void testGetSupplyID() {
        assertEquals("getSupplyID() should properly retrieve the supply's ID", "B1", supply.getSupplyID());
    }

    @Test
    public void testGetAllocationLocation() {
        supply.allocate(location);
        assertNotNull("Allocation should be retrieved properly", supply.getAllocation());
        supply.deallocate();
    }

    @Test
    public void testGetAllocationVictim() {
        supply.allocate(victim);
        assertNotNull("Allocation should be retrieved properly", supply.getAllocation());
        supply.deallocate();
    }
}
