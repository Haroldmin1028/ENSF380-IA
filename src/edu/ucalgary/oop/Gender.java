package edu.ucalgary.oop;

public enum Gender {
    MALE("Man"), FEMALE("Woman"), NON_BINARY("Non-binary person");
    private final String genderData;
    Gender(String genderData) { this.genderData = genderData; }
    public String getGenderData() { return genderData; }
}
