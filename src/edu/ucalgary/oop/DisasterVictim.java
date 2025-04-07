package edu.ucalgary.oop;

import java.sql.SQLException;
import java.util.ArrayList;

public class DisasterVictim extends Person {
    private String birthDate;
    private Gender gender;
    private final int VICTIM_ID;
    private FamilyGroup family;
    private ArrayList<MedicalRecord> medicalRecords = new ArrayList<>();
    private ArrayList<Supply> supplies;
    private final String ENTRY_DATE;
    private String comments;
    DatabaseConnector dbConnector = new DatabaseConnector();

    public DisasterVictim(String firstName, String lastName, String birthDate, Gender gender, String comments, String ENTRY_DATE) throws IllegalArgumentException {
        super(firstName, lastName);
        if (Utility.isInvalidDate(ENTRY_DATE)) { throw new IllegalArgumentException("Invalid date for entry date."); }
        this.ENTRY_DATE = ENTRY_DATE;
        if (Utility.isInvalidDate(birthDate)) { throw new IllegalArgumentException("Invalid date for date of birth."); }
        if (Utility.isBirthAfterEntry(ENTRY_DATE, birthDate)) { throw new IllegalArgumentException("Birthdate must be the same as or before entry date"); }
        this.birthDate = birthDate;
        this.gender = gender;
        this.comments = comments;

        dbConnector.createConnection();
        this.VICTIM_ID = dbConnector.insertNewPerson(firstName, lastName, birthDate, gender, comments, null, family.getID());
        dbConnector.close();
    }

    //function to create a Family for the created Victim
    public void findFamilyGroup() {
        //iterate through family groups, c
    }

    public String getBirthDate() { return birthDate; }

    public void setBirthDate(String dateOfBirth) throws IllegalArgumentException {
        if (Utility.isInvalidDate(dateOfBirth)) { throw new IllegalArgumentException("Invalid date for date of birth."); }
        if (Utility.isBirthAfterEntry(ENTRY_DATE, dateOfBirth)) { throw new IllegalArgumentException("Birthdate must be the same as or before entry date"); }
        this.birthDate = dateOfBirth;
    }

    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }

    public int getVictimID() { return VICTIM_ID; }

    public FamilyGroup getFamily() { return family;}

    public ArrayList<MedicalRecord> getMedicalRecords() { return medicalRecords; }
    public void setMedicalRecords(ArrayList<MedicalRecord> records) {
        this.medicalRecords.clear();
        for (MedicalRecord newRecord : records) { addMedicalRecord(newRecord); }
    }
    public ArrayList<Supply> getSupplies() { return supplies; }
    public void setSupplies(ArrayList<Supply> belongings) {
        this.supplies.clear();
        for (Supply newSupply : belongings) { addSupply(newSupply); }
    }

    public void addMedicalRecord(MedicalRecord record) { medicalRecords.add(record); }
    public void addSupply(Supply supply) { supplies.add(supply); }

    public String getEntryDate() { return ENTRY_DATE; }

    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments =  comments; }
   
}





