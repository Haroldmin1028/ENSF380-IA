/*
Copyright Ann Barcomb and Khawla Shnaikat, 2024-2025
Licensed under GPL v3
See LICENSE.txt for more information.
*/
package edu.ucalgary.oop;

import org.junit.Test;

public class WaterTest {
	int expectedQuantity = 5;


    @Test
    public void testConstructor() {
        Blanket blanket = new Blanket();
    }
	
    @Test
    public void testDisasterVictimConstructor() {
        DisasterVictim victim = new DisasterVictim();
        Blanket blanket = new Blanket( , victim);
    }

    @Test
    public void testLocationConstructor() {
        Location location = new Location();
        Blanket blanket = new Blanket( , location);
    }

}
