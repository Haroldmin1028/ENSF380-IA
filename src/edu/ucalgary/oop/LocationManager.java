package edu.ucalgary.oop;

import java.util.ArrayList;

public class LocationManager {
    private Location location;
    private ArrayList<DisasterVictim> occupants;
    private ArrayList<Supply> supplies;

    public LocationManager(Location location) {
        this.location = location;
        occupants = new ArrayList<>();
        supplies = new ArrayList<>();
    }

    public Location getLocation() { return location; }
    public ArrayList<DisasterVictim> getOccupants() { return occupants; }
    public void setOccupants(ArrayList<DisasterVictim> occupants) {
        this.occupants = occupants;
        //incorrect, just forgot how to assign properly
    }
    public ArrayList<Supply> getSupplies() { return supplies; }
    public void setSupplies(ArrayList<Supply> supplies) {
        this.supplies = supplies;
        // again incorrect
    }

    public void addOccupant(DisasterVictim occupant) { this.occupants.add(occupant); }
    public void removeOccupant(DisasterVictim occupant) { this.occupants.remove(occupant); }
    public void addSupply(Supply supply) { this.supplies.add(supply); }
    public void removeSupply(Supply supply) { this.supplies.remove(supply); }
}
