package edu.ucalgary.oop;

import java.util.ArrayList;

public final class Utility {
    private Utility() {}
    public static boolean isInvalidDate(String date) {
        String dateFormatPattern = "^\\d{4}-\\d{2}-\\d{2}$";
        if (!date.matches(dateFormatPattern)) {return true;}

        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(4, 6));
        int day = Integer.parseInt(date.substring(6, 8));

        if (month < 1 || month > 12) {return true;}
        if (day < 1 || day > 31) {return true;}

        if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day > 30) {return true;}
        }

        if (month == 2) {
            // leap years
            if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                if (day > 29) {return true;}
            }
            else {
                if (day > 28) {return true;}
            }
        }

        return false;
    }

    public static boolean isInvalidGender(String gender) {
        ArrayList<String> validGenderList = new ArrayList<>();
        validGenderList.add("male");
        validGenderList.add("female");
        validGenderList.add("non-binary");
        return !validGenderList.contains(gender.toLowerCase());
    }

    // not needed?
    public static int convertDateStringToInt(String date) {
        String formattedDate = date.replaceAll("-", "");
        return Integer.parseInt(formattedDate);
    }

    public static String generateID() {
        int counter = 0; //wrong, just wrote it
        //ID format: letter code + number
        //e.g. 3rd DisasterVictim in system: D3
        return ("D" + counter);
    }
}
