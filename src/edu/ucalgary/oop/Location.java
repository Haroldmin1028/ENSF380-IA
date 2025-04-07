package edu.ucalgary.oop;

import java.sql.SQLException;

public class Location {
    private String name;
    private String address;
    private final int LOCATION_ID;
    DatabaseConnector dbConnector = new DatabaseConnector();

    public Location(String name, String address) {
        this.name = name;
        this.address = address;
        dbConnector.createConnection();
        this.LOCATION_ID = dbConnector.insertNewLocation(name, address);
        dbConnector.close();
    }

    public int getLocationID() { return LOCATION_ID; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
