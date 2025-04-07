package edu.ucalgary.oop;

import java.sql.SQLException;

public class ExternalInquirer extends Person{
    private String phoneNumber;
    private final int INQUIRER_ID;
    DatabaseConnector dbConnector = new DatabaseConnector();


    public ExternalInquirer(String firstName, String lastName, String phoneNumber) {
        super(firstName, lastName);
        this.phoneNumber = phoneNumber;
        dbConnector.createConnection();
        this.INQUIRER_ID = dbConnector.insertNewPerson(firstName, lastName, null, null, null, phoneNumber, null);
        dbConnector.close();
    }

    public int getInquirerID() { return INQUIRER_ID; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}
