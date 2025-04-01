package edu.ucalgary.oop;

public class ExternalInquirer extends Person{
    private String phoneNumber;
    private String location;

    public ExternalInquirer(String firstName, String lastName, String gender, String phoneNumber, String location) {
        super(firstName, lastName, gender);
        this.phoneNumber = phoneNumber;
        this.location = location;
    }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
