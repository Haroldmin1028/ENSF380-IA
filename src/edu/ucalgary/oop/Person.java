package edu.ucalgary.oop;

public abstract class Person {
    private String firstName;
    private String lastName;
    private String gender;

    public Person(String firstName) {
        this.firstName = firstName;
    }

    public Person(String firstName, String lastName, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (Utility.isInvalidGender(gender)) { throw new IllegalArgumentException("Invalid gender"); }
        else { this.gender = gender; }
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getGender() { return gender; }
    public void setGender(String gender) throws IllegalArgumentException {
         //edge case: non binary, nonbinary, etc
        if (Utility.isInvalidGender(gender)) { throw new IllegalArgumentException("Invalid gender"); }
        else { this.gender = gender; }
    }
}
