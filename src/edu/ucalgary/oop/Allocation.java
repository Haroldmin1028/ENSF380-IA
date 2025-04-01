package edu.ucalgary.oop;

public class Allocation {
    private DisasterVictim victim;
    private Location location;

    public Allocation(DisasterVictim victim) {
        this.victim = victim;
        this.location = null;
    }

    public Allocation(Location location) {
        this.location = location;
        this.victim = null;
    }

    public DisasterVictim getVictim() {return victim;}

    public Location getLocation() {return location;}
}
