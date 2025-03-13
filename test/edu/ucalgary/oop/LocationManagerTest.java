/*
Copyright Ann Barcomb and Khawla Shnaikat, 2024-2025
Licensed under GPL v3
See LICENSE.txt for more information.
*/
package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LocationManagerTest {
    private Location location;
    private DisasterVictim victim;
    private Supply supply;

    @Before
    public void setUp() {
        // Initializing test objects before each test method
        location = new Location("Shelter A", "1234 Shelter Ave");
        locationManager = new LocationManager(location);
        victim = new DisasterVictim("John Doe", "2025-01-01");
        supply = new Supply();
    }

    // Helper method to check if a supply is in the list
    private boolean containsSupply(ArrayList<Supply> supplies, Supply supplyToCheck) {
        return supplies.contains(supplyToCheck);
    }

    @Test
    public void testConstructor() {
        assertNotNull("Constructor should create a non-null Location object", locationManager);
    }

    @Test
    public void testGetLocation() {
        assertNotNull("getLocation should return a non-null Location", locationManager.getLocation());
    }

    @Test
    public void testAddOccupant() {
        locationManager.addOccupant(victim);
        assertTrue("addOccupant should add a disaster victim to the occupants list", locationManager.getOccupants().contains(victim));
    }

    @Test
    public void testRemoveOccupant() {
        locationManager.addOccupant(victim); // Ensure the victim is added first
        locationManager.removeOccupant(victim);
        assertFalse("removeOccupant should remove the disaster victim from the occupants list",locationManager.getOccupants().contains(victim));
    }

    @Test
    public void testSetAndGetOccupants() {
        ArrayList<DisasterVictim> newOccupants = new ArrayList<>();
        newOccupants.add(victim);
        location.setOccupants(newOccupants);
        assertTrue("setOccupants should replace the occupants list with the new list", locationManager.getOccupants().containsAll(newOccupants));
    }

    @Test
    public void testAddSupply() {
        locationManager.addSupply(supply);
        assertTrue("addSupply should add a supply to the supplies list", containsSupply(locationManager.getSupplies(), supply));
    }

    @Test
    public void testRemoveSupply() {
        locationManager.addSupply(supply); // Ensure the supply is added first
        locationManager.removeSupply(supply);
        assertFalse("removeSupply should remove the supply from the supplies list", containsSupply(locationManager.getSupplies(), supply));
    }

    @Test
    public void testSetAndGetSupplies() {
        ArrayList<Supply> newSupplies = new ArrayList<>();
        newSupplies.add(supply);
        locationManager.setSupplies(newSupplies);
        assertTrue("setSupplies should replace the supplies list with the new list", containsSupply(locationManager.getSupplies(), supply));
    }
}
