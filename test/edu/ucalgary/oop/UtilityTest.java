/*
Copyright Ann Barcomb and Khawla Shnaikat, 2024-2025
Licensed under GPL v3
See LICENSE.txt for more information.
*/
package edu.ucalgary.oop;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.*;

public class UtilityTest {
    @Test
    public void testIsValidDateFormatWithValidFormat() {
        String validDate = "2025-02-17";
        assertTrue("The method should properly determine the date as valid", Utility.isValidDateFormat(validDate));
    }

    @Test
    public void testIsValidDateFormatWithInvalidFormat() {
        String invalidDate = "2025112";
        assertFalse("The method should properly determine the date as invalid", Utility.isValidDateFormat(invalidDate));
    }

    @Test
    public void testIsValidDateFormatWithAnotherInvalidFormat() {
        String invalidDate = "15/13/2025";
        assertFalse("The method should properly determine the date as invalid", Utility.isValidDateFormat(invalidDate));
    }

    @Test
    public void testIsValidDateFormatWithInvalidMonth() {
        String invalidDate = "2025-13-17";
        assertFalse("The method should properly determine the date as invalid", Utility.isValidDateFormat(invalidDate));
    }

    @Test
    public void testIsValidDateFormatWithInvalidDay() {
        String invalidDate = "2025-10-32";
        assertFalse("The method should properly determine the date as invalid", Utility.isValidDateFormat(invalidDate));
    }

    @Test
    public void testIsValidDateFormatWithValidDayInFebruary() {
        String validDate = "2025-02-28";
        assertTrue("The method should properly determine the date as valid", Utility.isValidDateFormat(validDate));
    }

    @Test
    public void testIsValidDateFormatWithInvalidDayInFebruary() {
        String invalidDate = "2025-02-30";
        assertFalse("The method should properly determine the date as invalid", Utility.isValidDateFormat(invalidDate));
    }

    @Test
    public void testConvertDateStringToInt() {
        String validDate = "2025-02-17";
        assertEquals("The method should properly convert the date into an int", 20250217, Utility.convertDateStringToInt(validDate));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertInvalidDateStringToInt() {
        String invalidDate = "2025112";
        Utility.convertDateStringToInt(invalidDate);
        //Expecting IllegalArgumentException, date is invalid and cannot be parsed into int
    }


    @Test
    public void testGenerateID() {
        List<String> IDList = new ArrayList<>();
        DisasterVictim victimOne = new DisasterVictim();
        DisasterVictim victimTwo = new DisasterVictim();

    }
}
