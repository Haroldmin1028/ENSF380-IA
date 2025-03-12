/*
Copyright Ann Barcomb and Khawla Shnaikat, 2024-2025
Licensed under GPL v3
See LICENSE.txt for more information.
*/
package edu.ucalgary.oop;


import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FamilyGroupTest {
    private FamilyGroup familyOne;
    private DisasterVictim personOne;

    @Before
    public void setUp() {
        personOne = new DisasterVictim("John", "2025-01-19");
        familyOne = new FamilyGroup(personOne);
    }

    @Test
    public void testObjectCreation() {
        assertNotNull(familyOne);
    }

    @Test
    public void testIsFamilyMemberTrue() {
        assertTrue("The victim should be a family member", familyOne.isFamilyMember(personOne));
    }

    @Test
    public void testIsFamilyMemberFalse() {
        DisasterVictim personTwo = new DisasterVictim("Connor", "2025-03-09");
        assertFalse("The victim should not be a family member", familyOne.isFamilyMember(personTwo));
    }

    @Test
    public void testAddFamilyMember() {
        DisasterVictim personThree = new DisasterVictim("Jane", "2025-02-20");
        familyOne.addFamilyMember(personThree);
        assertTrue("addFamilyMember should add the victim to the family", familyOne.isFamilyMember(personThree));
    }

    @Test
    public void testAddDuplicateFamilyMember() {
        DisasterVictim personFour = new DisasterVictim("Jannik", "2025-01-01");
        familyOne.addFamilyMember(personFour);
        int currentSize = familyOne.getFamilyMembers().size();
        familyOne.addFamilyMember(personFour);
        assertEquals("The family should not contain duplicates and remain the same size", currentSize, familyOne.getFamilyMembers().size());
    }

    @Test
    public void testGetFamilyMembers() {
        DisasterVictim one = new DisasterVictim("Ana", "2024-12-25");
        DisasterVictim two =  new DisasterVictim("Bob", "2024-12-26");
        DisasterVictim three = new DisasterVictim("Cale", "2024-12-27");
        FamilyGroup familyTwo = new FamilyGroup(one);
        assertEquals("Family should have 3 members", 3, familyTwo.getfamilyMembers().size());
        assertTrue("Family should contain Ana", familyTwo.isFamilyMember(one));
        assertTrue("Family should contain Bob", familyTwo.isFamilyMember(two));
        assertTrue("Family should contain Cale", familyTwo.isFamilyMember(three));
    }

    @Test
    public void testRemoveFamilyMember() {
        familyOne.removeFamilyMember(personOne);
        assertFalse("personOne should be no longer be part of the family", familyOne.isFamilyMember(personOne));
    }

    @Test
    public void testRemovePersonNotInFamily() {
        DisasterVictim personFive = new DisasterVictim("Sidney", "2025-04-04");
        int currentSize = familyOne.getFamilyMembers().size();
        familyOne.removeFamilyMember(personFive);
        assertEquals("Removing a DisasterVictim not in the family should do nothing", currentSize, familyOne.getFamilyMembers().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDisasterVictimToTwoFamilyGroups() {
        DisasterVictim victimOne = new DisasterVictim("Carlos", "2025-07-04");
        DisasterVictim victimTwo = new DisasterVictim("Meryl", "2025-07-05");
        DisasterVictim victimThree = new DisasterVictim("Leo", "2025-05-05");

        FamilyGroup one = new FamilyGroup(victimOne);
        FamilyGroup two = new FamilyGroup(victimTwo);
        one.addFamilyMember(victimThree);
        two.addFamilyMember(victimThree);
        //Expecting IllegalArgumentException, each person can be a member of only one family
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTwoSingleMemberConstructorsWithSameDisasterVictim() {
        DisasterVictim victimOne = new DisasterVictim("Carlos", "2025-07-04");
        FamilyGroup one = new FamilyGroup(victimOne);
        FamilyGroup two = new FamilyGroup(victimOne);
        //Expecting IllegalArgumentException, each person can be a member of only one family
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTwoDoubleMemberConstructorsWithOneDisasterVictimInCommon() {
        DisasterVictim victimOne = new DisasterVictim("Carlos", "2025-07-04");
        DisasterVictim victimTwo = new DisasterVictim("Meryl", "2025-07-05");
        DisasterVictim victimThree = new DisasterVictim("Leo", "2025-05-05");
        FamilyGroup one = new FamilyGroup(victimOne, victimTwo);
        FamilyGroup two = new FamilyGroup(victimTwo, victimThree);
        //Expecting IllegalArgumentException, each person can be a member of only one family
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTwoDoubleMemberConstructorsWithTwoDisasterVictimsInCommon() {
        DisasterVictim victimOne = new DisasterVictim("Carlos", "2025-07-04");
        DisasterVictim victimTwo = new DisasterVictim("Meryl", "2025-07-05");
        FamilyGroup one = new FamilyGroup(victimOne, victimTwo);
        FamilyGroup two = new FamilyGroup(victimTwo, victimOne);
        //Expecting IllegalArgumentException, each person can be a member of only one family
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSingleMemberAndDoubleMemberConstructorsWithDisasterVictimInCommon() {
        DisasterVictim victimOne = new DisasterVictim("Carlos", "2025-07-04");
        DisasterVictim victimTwo = new DisasterVictim("Meryl", "2025-07-05");
        FamilyGroup one = new FamilyGroup(victimOne);
        FamilyGroup two = new FamilyGroup(victimOne, victimTwo);
        //Expecting IllegalArgumentException thrown by double member constructor
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDoubleAndSingleMemberConstructorsWithDisasterVictimInCommon() {
        DisasterVictim victimOne = new DisasterVictim("Carlos", "2025-07-04");
        DisasterVictim victimTwo = new DisasterVictim("Meryl", "2025-07-05");
        FamilyGroup one = new FamilyGroup(victimOne, victimTwo);
        FamilyGroup two = new FamilyGroup(victimOne);
        //Expecting IllegalArgumentException thrown by single member constructor
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSingleMemberAndTripleMemberConstructorsWithDisasterVictimInCommon() {
        DisasterVictim victimOne = new DisasterVictim("Carlos", "2025-07-04");
        DisasterVictim victimTwo = new DisasterVictim("Meryl", "2025-07-05");
        DisasterVictim victimThree = new DisasterVictim("Leo", "2025-05-05");
        FamilyGroup one = new FamilyGroup(victimOne);
        FamilyGroup two = new FamilyGroup(victimOne, victimTwo, victimThree);
        //Expecting IllegalArgumentException thrown by triple member constructor
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTripleMemberAndSingleMemberConstructorsWithDisasterVictimInCommon() {
        DisasterVictim victimOne = new DisasterVictim("Carlos", "2025-07-04");
        DisasterVictim victimTwo = new DisasterVictim("Meryl", "2025-07-05");
        DisasterVictim victimThree = new DisasterVictim("Leo", "2025-05-05");
        FamilyGroup one = new FamilyGroup(victimOne, victimTwo, victimThree);
        FamilyGroup two = new FamilyGroup(victimOne);
        //Expecting IllegalArgumentException thrown by single member constructor
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDoubleMemberAndTripleMemberConstructorsWithTwoDisasterVictimsInCommon() {
        DisasterVictim victimOne = new DisasterVictim("Carlos", "2025-07-04");
        DisasterVictim victimTwo = new DisasterVictim("Meryl", "2025-07-05");
        DisasterVictim victimThree = new DisasterVictim("Leo", "2025-05-05");
        FamilyGroup one = new FamilyGroup(victimOne, victimTwo);
        FamilyGroup two = new FamilyGroup(victimOne, victimTwo, victimThree);
        //Expecting IllegalArgumentException thrown by triple member constructor
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTripleMemberAndDoubleMemberConstructorsWithTwoDisasterVictimsInCommon() {
        DisasterVictim victimOne = new DisasterVictim("Carlos", "2025-07-04");
        DisasterVictim victimTwo = new DisasterVictim("Meryl", "2025-07-05");
        DisasterVictim victimThree = new DisasterVictim("Leo", "2025-05-05");
        FamilyGroup one = new FamilyGroup(victimOne, victimTwo, victimThree);
        FamilyGroup two = new FamilyGroup(victimOne, victimTwo);
        //Expecting IllegalArgumentException thrown by double member constructor
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTwoTripleMemberConstructorsWithOneDisasterVictimInCommon() {
        DisasterVictim victimOne = new DisasterVictim("Carlos", "2025-07-04");
        DisasterVictim victimTwo = new DisasterVictim("Meryl", "2025-07-05");
        DisasterVictim victimThree = new DisasterVictim("Leo", "2025-05-05");
        DisasterVictim victimFour = new DisasterVictim("Elena", "2025-05-08");
        DisasterVictim victimFive = new DisasterVictim("Iga", "2025-05-25");
        FamilyGroup one = new FamilyGroup(victimOne, victimTwo, victimFive);
        FamilyGroup two = new FamilyGroup(victimTwo, victimThree, victimFour);
        //Expecting IllegalArgumentException, each person can be a member of only one family
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTwoTripleMemberConstructorsWithTwoDisasterVictimsInCommon() {
        DisasterVictim victimOne = new DisasterVictim("Carlos", "2025-07-04");
        DisasterVictim victimTwo = new DisasterVictim("Meryl", "2025-07-05");
        DisasterVictim victimThree = new DisasterVictim("Leo", "2025-05-05");
        DisasterVictim victimFour = new DisasterVictim("Elena", "2025-05-08");
        FamilyGroup one = new FamilyGroup(victimOne, victimTwo, victimThree);
        FamilyGroup two = new FamilyGroup(victimTwo, victimThree, victimFour);
        //Expecting IllegalArgumentException, each person can be a member of only one family
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTwoTripleMemberConstructorsWithThreeDisasterVictimsInCommon() {
        DisasterVictim victimOne = new DisasterVictim("Carlos", "2025-07-04");
        DisasterVictim victimTwo = new DisasterVictim("Meryl", "2025-07-05");
        DisasterVictim victimThree = new DisasterVictim("Leo", "2025-05-05");
        FamilyGroup one = new FamilyGroup(victimOne, victimTwo, victimThree);
        FamilyGroup two = new FamilyGroup(victimTwo, victimThree, victimOne);
        //Expecting IllegalArgumentException, each person can be a member of only one family
    }
}
