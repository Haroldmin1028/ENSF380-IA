/*
Copyright Ann Barcomb and Khawla Shnaikat, 2024-2025
Licensed under GPL v3
See LICENSE.txt for more information.
*/

package edu.ucalgary.oop;

public class MedicalRecord {
    private Location location;
    private String treatmentDetails;
    private String dateOfTreatment;

    public MedicalRecord(Location location, String treatmentDetails, String dateOfTreatment) throws IllegalArgumentException {
        setLocation(location);
        this.treatmentDetails = treatmentDetails;

        // Check if the treatmentDetails string matches the expected date format
        if (Utility.isInvalidDate(dateOfTreatment)) {
            throw new IllegalArgumentException("Invalid date for treatment details.");
        }
        this.dateOfTreatment = dateOfTreatment;
    }

    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }

    public String getTreatmentDetails() {
        return treatmentDetails;
    }
    public void setTreatmentDetails(String treatmentDetails) throws IllegalArgumentException {
        if (Utility.isInvalidDate(dateOfTreatment)) {
            throw new IllegalArgumentException("Invalid date for treatment details.");
        }
        this.treatmentDetails = treatmentDetails;
    }

    public String getDateOfTreatment() {
        return dateOfTreatment;
    }

    public void setDateOfTreatment(String dateOfTreatment) throws IllegalArgumentException {
        if (Utility.isInvalidDate(dateOfTreatment)) {
            throw new IllegalArgumentException("Invalid date format. Expected format: YYYY-MM-DD");
        }
        this.dateOfTreatment = dateOfTreatment;
    }

}
