package edu.ucalgary.oop;

public abstract class Supply {
    private final int SUPPLY_ID;
    private final String TYPE;
    private Allocation allocation;
    DatabaseConnector dbConnector = new DatabaseConnector();

    public Supply(String TYPE, String comments) {
        dbConnector = new DatabaseConnector();
        this.SUPPLY_ID = dbConnector.insertNewSupply(TYPE, comments);
        this.TYPE = TYPE;
    }

    public void allocate(DisasterVictim victim) {
        if (isNotAllocated()) {
            this.allocation = new Allocation(victim);
        }
    }

    public void allocate(Location location) {
        if (isNotAllocated()) {
            this.allocation = new Allocation(location);
        }
    }

    public void deallocate() {
        this.allocation = null;
    }

    public String getType() { return TYPE; }

    public int getSupplyID() {return SUPPLY_ID;}

    public Allocation getAllocation() {return allocation;}

    boolean isNotAllocated() {
        return (this.allocation == null);
    }

}
