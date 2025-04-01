package edu.ucalgary.oop;

public class PersonalBelonging extends Supply{
    private String description;

    public PersonalBelonging(DisasterVictim victim, String description) {
        super();
        this.allocate(victim);
        this.description = description;
    }

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
}
