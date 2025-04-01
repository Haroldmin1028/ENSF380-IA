/*
Copyright Ann Barcomb and Khawla Shnaikat, 2024-2025
Licensed under GPL v3
See LICENSE.txt for more information.
*/

package edu.ucalgary.oop;

public abstract class Supply {
    private final String SUPPLY_ID;
    private Allocation allocation;

    public Supply() {
        this.SUPPLY_ID = Utility.generateID();
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

    public String getSupplyID() {return SUPPLY_ID;}

    public Allocation getAllocation() {return allocation;}

    boolean isNotAllocated() {
        return (this.allocation == null);
    }

}
