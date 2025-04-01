/*
Copyright Ann Barcomb and Khawla Shnaikat, 2024-2025
Licensed under GPL v3
See LICENSE.txt for more information.
*/

package edu.ucalgary.oop;

import java.util.ArrayList;


public class DisasterVictim extends Person {
    private String firstName;
    private String lastName;
    private String gender;
    private String dateOfBirth;
    private final String VICTIM_ID;
    private ArrayList<MedicalRecord> medicalRecords = new ArrayList<>();
    private ArrayList<Supply> personalBelongings;
    private final String ENTRY_DATE;
    private String comments;

    public DisasterVictim(String firstName, String ENTRY_DATE) throws IllegalArgumentException {
        super(firstName);
        if (Utility.isInvalidDate(ENTRY_DATE)) {
            throw new IllegalArgumentException("Invalid date for entry date.");
        }
        this.ENTRY_DATE = ENTRY_DATE;
        this.VICTIM_ID = Utility.generateID();
    }

    // didn't modify fully cuz maybe i don't need this extra constructor that only takes in an extra birthdate?
    public DisasterVictim(String firstName, String ENTRY_DATE, String dateOfBirth) throws IllegalArgumentException {
        this.firstName = firstName;
        if (Utility.isInvalidDate(ENTRY_DATE)) {
            throw new IllegalArgumentException("Invalid date for entry date.");
        }
        this.ENTRY_DATE = ENTRY_DATE;
        this.VICTIM_ID = Utility.generateID();
        if (Utility.isInvalidDate(dateOfBirth)) {
            throw new IllegalArgumentException("Invalid date for birth date.");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) throws IllegalArgumentException {
        if (Utility.isInvalidDate(dateOfBirth)) {
            throw new IllegalArgumentException("Invalid date for date of birth.");
        }

        // A person cannot be born after entering a centre
        int entryDate = convertDateStringToInt(ENTRY_DATE);
        int birthDate = convertDateStringToInt(dateOfBirth);
        if (birthDate > entryDate) {
            throw new IllegalArgumentException("Birthdate must be the same as or before entry date");
        }
        
        this.dateOfBirth = dateOfBirth;
    }

    public String getVictimID() {
        return VICTIM_ID;
    }

    public FamilyGroup getFamily() {}

    public MedicalRecord[] getMedicalRecords() {
        return medicalRecords.toArray(new MedicalRecord[0]);
    }

    public Supply[] getPersonalBelongings() {
        return this.personalBelongings;
    }




    public void setMedicalRecords(MedicalRecord[] records) {
        this.medicalRecords.clear();
        for (MedicalRecord newRecord : records) {
            addMedicalRecord(newRecord);
        }
    }

    public void setPersonalBelongings(Supply[] belongings) {
        this.personalBelongings = belongings;
    }






    public void addMedicalRecord(MedicalRecord record) {
        medicalRecords.add(record);
    }


    public String getEntryDate() {
        return ENTRY_DATE;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments =  comments;
    }
   
}





