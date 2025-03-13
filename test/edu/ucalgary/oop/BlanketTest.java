/*
Copyright Ann Barcomb and Khawla Shnaikat, 2024-2025
Licensed under GPL v3
See LICENSE.txt for more information.
*/
package edu.ucalgary.oop;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BlanketTest {
    private Blanket blanket = new Blanket();

    @Test
    public void testObjectCreation() {
        assertNotNull(blanket);
    }


}
