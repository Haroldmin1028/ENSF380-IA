/*
Copyright Ann Barcomb and Khawla Shnaikat, 2024-2025
Licensed under GPL v3
See LICENSE.txt for more information.
*/

package edu.ucalgary.oop;

import java.util.ArrayList;

public class FamilyGroup {
    private ArrayList<DisasterVictim> familyMembers;

    public FamilyGroup(DisasterVictim victim) {
        ArrayList<DisasterVictim> familyMembers = new ArrayList<>();
        familyMembers.add(victim);
        this.familyMembers = familyMembers;
    }

    //added for now, but are these extra constructors necessary?
    //can't i just always start with one family member in the family then add
    public FamilyGroup(DisasterVictim victimOne, DisasterVictim victimTwo) {
        ArrayList<DisasterVictim> familyMembers = new ArrayList<>();
        familyMembers.add(victimOne);
        familyMembers.add(victimTwo);
        this.familyMembers = familyMembers;
    }

    public FamilyGroup(DisasterVictim victimOne, DisasterVictim victimTwo, DisasterVictim victimThree) {
        ArrayList<DisasterVictim> familyMembers = new ArrayList<>();
        familyMembers.add(victimOne);
        familyMembers.add(victimTwo);
        familyMembers.add(victimThree);
        this.familyMembers = familyMembers;
    }

    public boolean isFamilyMember(DisasterVictim victim) { return familyMembers.contains(victim); }
    public void addFamilyMember(DisasterVictim victim) { this.familyMembers.add(victim); }
    public void removeFamilyMember(DisasterVictim victim) { this.familyMembers.remove(victim); }
    public ArrayList<DisasterVictim> getFamilyMembers() { return familyMembers; }
}
