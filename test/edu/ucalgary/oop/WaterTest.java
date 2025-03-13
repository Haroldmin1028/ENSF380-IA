/*
Copyright Ann Barcomb and Khawla Shnaikat, 2024-2025
Licensed under GPL v3
See LICENSE.txt for more information.
*/
package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WaterTest {
    private Water water;
    private Location location = new Location("University of Calgary", "50 University Dr");
    private DisasterVictim victim = new DisasterVictim("John", "2025-05-18");

    @Before
    public void setUp() {
        water = new Water("2025-05-21", "2028-05-21");
    }

    @Test
    public void testObjectCreation() {
        assertNotNull("Cot should be instantiated", water);
        assertFalse("Cot currently should not be allocated", water.isAllocated());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidAllocationDate() {
        Water water = new Water("20250521", "2028-05-21");
        //expecting IllegalArgumentException
    }

    @Test (expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidExpiryDate() {
        Water water = new Water("2025-05-21", "20280521");
        //expecting IllegalArgumentException
    }

    @Test (expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidExpiryAndAllocationDate() {
        Water water = new Water("20250521", "20280521");
        //expecting IllegalArgumentException
    }

    @Test
    public void testWaterAllocationAndDeallocationToLocation() {
        water.allocate(location);
        assertTrue("Cot should now be allocated", water.isAllocated());
        water.deallocate();
        assertFalse("Cot should now be deallocated", water.isAllocated());
    }

    @Test
    public void testWaterAllocationAndDeallocationToDisasterVictim() {
        water.allocate(victim);
        assertTrue("Cot should now be allocated", water.isAllocated());
        water.deallocate();
        assertFalse("Cot should now be deallocated", water.isAllocated());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testLocationAllocatedWaterAllocationToLocation() {
        Water waterOne = new Water("2025-05-21", "2028-05-21");
        waterOne.allocate(location);
        Location newLocation = new Location("Mount Royal", "50 Mount Royal St");
        waterOne.allocate(newLocation);
        //Expecting IllegalArgumentException, water is already allocated
    }

    @Test (expected = IllegalArgumentException.class)
    public void testLocationAllocatedWaterAllocationToVictim() {
        Water waterTwo = new Water("2025-05-21", "2028-05-21");
        waterTwo.allocate(location);
        DisasterVictim newVictim = new DisasterVictim("April", "2025-12-25");
        waterTwo.allocate(newVictim);
        //Expecting IllegalArgumentException, water is already allocated
    }

    @Test (expected = IllegalArgumentException.class)
    public void testVictimAllocatedWaterAllocationToLocation() {
        Water waterThree = new Water("2025-05-21", "2028-05-21");
        waterThree.allocate(victim);
        Location newLocation = new Location("Mount Royal", "50 Mount Royal St");
        waterThree.allocate(newLocation);
        //Expecting IllegalArgumentException, water is already allocated
    }

    @Test (expected = IllegalArgumentException.class)
    public void testVictimAllocatedCotAllocationToVictim() {
        Water waterFour = new Water("2025-05-21", "2028-05-21");
        waterFour.allocate(victim);
        DisasterVictim newVictim = new DisasterVictim("April", "2025-12-25");
        waterFour.allocate(newVictim);
        //Expecting IllegalArgumentException, water is already allocated
    }

    @Test
    public void testGetSupplyID() {
        assertEquals("getSupplyID() should properly retrieve the water's ID", "W1", water.getSupplyID());
    }

    @Test
    public void testGetAllocationLocation() {
        water.allocate(location);
        assertNotNull("Allocation should be retrieved properly", water.getAllocation());
        water.deallocate();
    }

    @Test
    public void testGetAllocationVictim() {
        water.allocate(victim);
        assertNotNull("Allocation should be retrieved properly", water.getAllocation());
        water.deallocate();
    }

    @Test
    public void testSetAndGetExpiryDate() {
        water.setExpiryDate("2028-09-03");
        assertEquals("setExpiryDate should modify and getExpiryDate retrieve expiry date properly", "2028-09-03", water.getExpiryDate());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetInvalidExpiryDate() {
        water.setExpiryDate("2028/0903");
        //expecting IllegalArgumentException, date is invalid
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetExpiryDateBeforeAllocationDate() {
        water.setExpiryDate("2024-04-28");
        //expecting IllegalArgumentException, expiry date is earlier than allocation date
    }

    @Test
    public void testGetExpiryDateLocation() {
        Water water = new Water("2025-03-01", "2028-03-01");
        water.allocate(location);
        assertNull("Water allocated to a location should not have an expiry date", water.getExpiryDate());
    }

    @Test
    public void testGetExpiryDateDisasterVictim() {
        Water water = new Water("2025-03-01", "2028-03-01");
        water.allocate(victim);
        assertNotNull("Water allocated to a location should have an expiry date", water.getExpiryDate());
    }

    @Test
    public void testGetAllocationDate() {
        assertEquals("getGridLocation should retrieve allocation date properly", "2025-05-21", water.getAllocationDate());
    }


}
