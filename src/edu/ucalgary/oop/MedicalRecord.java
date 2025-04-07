package edu.ucalgary.oop;

public class MedicalRecord {
    private int locationID;
    private int victimID;
    private String treatmentDetails;
    private String dateOfTreatment;
    DatabaseConnector dbConnector = new DatabaseConnector();

    public MedicalRecord(Location location, DisasterVictim injuredVictim, String treatmentDetails, String dateOfTreatment) throws IllegalArgumentException {
        this.locationID = location.getLocationID();
        this.victimID = injuredVictim.getVictimID();
        this.treatmentDetails = treatmentDetails;
        if (Utility.isInvalidDate(dateOfTreatment)) { throw new IllegalArgumentException("Invalid date for treatment details."); }
        this.dateOfTreatment = dateOfTreatment;

        dbConnector.createConnection();
        dbConnector.insertNewMedicalRecord(locationID, victimID, dateOfTreatment, treatmentDetails);
        dbConnector.close();
    }

    public int getLocationID() {
        return locationID;
    }
    public void setLocation(int locationID) {
        this.locationID = locationID;
    }

    public int getVictimID() { return victimID; }
    public void setVictim(int victimID) { this.victimID = victimID; }

    public String getTreatmentDetails() {
        return treatmentDetails;
    }
    public void setTreatmentDetails(String treatmentDetails) { this.treatmentDetails = treatmentDetails; }

    public String getDateOfTreatment() {
        return dateOfTreatment;
    }
    public void setDateOfTreatment(String dateOfTreatment) throws IllegalArgumentException {
        if (Utility.isInvalidDate(dateOfTreatment)) { throw new IllegalArgumentException("Invalid date for treatment details."); }
        this.dateOfTreatment = dateOfTreatment;
    }
}
