package edu.ucalgary.oop;

public class Inquiry {
    private final Person INQUIRER;
    private final DisasterVictim MISSING_PERSON;
    private final String INQUIRY_INFO;
    private final String INQUIRY_DATE;
    private final Location LAST_KNOWN_LOCATION;
    private String status;
    DatabaseConnector dbConnector = new DatabaseConnector();

    public Inquiry(Person INQUIRER, DisasterVictim MISSING_PERSON, String INQUIRY_INFO, String INQUIRY_DATE, Location LAST_KNOWN_LOCATION) throws IllegalArgumentException {
        this.INQUIRER = INQUIRER;
        this.MISSING_PERSON = MISSING_PERSON;
        this.INQUIRY_INFO = INQUIRY_INFO;
        if (Utility.isInvalidDate(INQUIRY_DATE)) { throw new IllegalArgumentException("Invalid date for inquiry date."); }
        this.INQUIRY_DATE = INQUIRY_DATE;
        this.LAST_KNOWN_LOCATION = LAST_KNOWN_LOCATION;

        dbConnector.createConnection();

        dbConnector.close();
    }

    public Person getInquirer() { return INQUIRER; }
    public DisasterVictim getMissingPerson() { return MISSING_PERSON; }
    public String getInquiryInfo() { return INQUIRY_INFO; }
    public String getInquiryDate() { return INQUIRY_DATE; }
    public Location getLastKnownLocation() { return LAST_KNOWN_LOCATION; }

    //not sure if i need status, after looking at the database
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
