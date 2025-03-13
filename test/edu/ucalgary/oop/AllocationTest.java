/*
Copyright Ann Barcomb and Khawla Shnaikat, 2024-2025
Licensed under GPL v3
See LICENSE.txt for more information.
*/
package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AllocationTest {
    private Allocation allocationOne;
    private Allocation allocationTwo;

    @Before
    public void setUp() {
        Location location = new Location("University of Calgary", "50 University Dr");
        allocationOne = new Allocation(location);
        DisasterVictim victim = new DisasterVictim("John", "2025-05-18");
        allocationTwo = new ALlocation(victim);
    }

    @Test
    public void testObjectCreation() {
        assertNotNull("allocationOne should be instantiated", allocationOne);
        assertNotNull("allocationTwo should be instantiated", allocationTwo);
    }

    @Test
    public void testGetVictim() {
        DisasterVictim victimOne = allocationOne.getVictim();
        assertNotNull("getVictim() should retrieve victim properly", victimOne);
        DisasterVictim victimTwo = allocationTwo.getVictim();
        assertNull("getVictim() should return null when allocated to a Location", victimTwo);
    }

    @Test
    public void testGetLocation() {
        Location locationOne = allocationOne.getLocation();
        assertNull("getLocation() should return null when allocated to a DisasterVictim", locationOne);
        Location locationTwo = allocationTwo.getLocation();
        assertNotNull("getLocation() should retrieve location properly", locationTwo);
    }
}
