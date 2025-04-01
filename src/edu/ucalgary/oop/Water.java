package edu.ucalgary.oop;

public class Water extends Supply {
    private final String ALLOCATION_DATE;
    private String expiryDate;
    //prob add a boolean used variable

    public Water(String ALLOCATION_DATE, String expiryDate) throws IllegalArgumentException {
        super();
        if (Utility.isInvalidDate(ALLOCATION_DATE) || Utility.isInvalidDate(expiryDate)) {
            throw new IllegalArgumentException("Invalid date");
        }
        else {
            this.ALLOCATION_DATE = ALLOCATION_DATE;
            this.expiryDate = expiryDate;
        }
    }

    public boolean isUsed() {return true;};
    public String getAllocationDate() {return ALLOCATION_DATE;}
    public String getExpiryDate() {return expiryDate;}

    public void setExpiryDate(String expiryDate) throws IllegalArgumentException {
        if (Utility.isInvalidDate(expiryDate)) {throw new IllegalArgumentException("Invalid date");}
        else {this.expiryDate = expiryDate;}
    }
}
