package edu.ucalgary.oop;
import java.sql.*;

public class DatabaseConnector {
    private Connection dbConnect;
    private ResultSet results;

    public DatabaseConnector() {}

    public void createConnection() {
        try {
            dbConnect = DriverManager.getConnection("jdbc:postgresql://localhost/project", "oop", "ucalgary");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int insertNewPerson(String firstName, String lastName, String birthDate, Gender gender, String comments, String phoneNumber, FamilyGroup family) {
        int personID = -1;
        try {
            String query = "INSERT INTO Person (first_name, last_name, date_of_birth, gender, comments, phone_number, family_group) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);


            myStmt.setString(1, firstName);
            myStmt.setString(2, lastName);

            if (birthDate != null) {
                java.sql.Date birth = java.sql.Date.valueOf(birthDate);
                myStmt.setDate(3, birth);
            }
            else { myStmt.setNull(3, java.sql.Types.DATE); }

            if (gender != null) { myStmt.setString(4, gender.getGenderData()); }
            else { myStmt.setNull(4, java.sql.Types.VARCHAR); }

            if (comments != null) { myStmt.setString(5, comments); }
            else { myStmt.setNull(5, java.sql.Types.VARCHAR); }

            if (comments != null) { myStmt.setString(6, phoneNumber); }
            else { myStmt.setNull(6, java.sql.Types.VARCHAR); }

            //myStmt.setInt(7, );

            myStmt.executeUpdate();
            personID = myStmt.getGeneratedKeys().getInt(1);
            myStmt.close();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return personID;
    }

    public int insertNewLocation(String name, String address) {
        int locationID = -1;
        try {
            String query = "INSERT INTO Location (name, address) VALUES (?, ?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            myStmt.setString(1, name);
            myStmt.setString(2, address);
            myStmt.executeUpdate();
            locationID = myStmt.getGeneratedKeys().getInt(1);
            myStmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return locationID;
    }

    public void insertNewInquiryFromExternalInquirer(ExternalInquirer inquirer, DisasterVictim seeking, Location lastKnownLocation, String inquiryDate, String comments) {
        try {
            String query = "INSERT INTO Inquiry (inquirer_id, seeking_id, location_id, date_of_inquiry, comments) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            myStmt.setInt(1, inquirer.getInquirerID());
            myStmt.setInt(2, seeking.getVictimID());
            myStmt.setInt(3, lastKnownLocation.getLocationID());
            java.sql.Date dateOfInquiry = java.sql.Date.valueOf(inquiryDate);
            myStmt.setDate(4, dateOfInquiry);
            myStmt.setString(5, comments);

            myStmt.executeUpdate();
            myStmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertNewInquiryFromDisasterVictim(DisasterVictim inquirer, DisasterVictim seeking, Location lastKnownLocation, String inquiryDate, String comments) {
        try {
            String query = "INSERT INTO Inquiry (inquirer_id, seeking_id, location_id, date_of_inquiry, comments) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            myStmt.setInt(1, inquirer.getVictimID());
            myStmt.setInt(2, seeking.getVictimID());
            myStmt.setInt(3, lastKnownLocation.getLocationID());
            java.sql.Date dateOfInquiry = java.sql.Date.valueOf(inquiryDate);
            myStmt.setDate(4, dateOfInquiry);
            myStmt.setString(5, comments);

            myStmt.executeUpdate();
            myStmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int insertNewSupply(String type, String comments) {
        int supplyID = -1;
        try {
            String query = "INSERT INTO Supply (type, comments) VALUES (?, ?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            myStmt.setString(1, type);
            if (comments != null) { myStmt.setString(2, comments); }
            else { myStmt.setNull(2, java.sql.Types.VARCHAR); }

            myStmt.executeUpdate();
            supplyID = myStmt.getGeneratedKeys().getInt(1);
            myStmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return supplyID;
    }

    public void insertNewMedicalRecord(int locationID, int victimID, String treatmentDate, String treatmentDetails) {
        try {
            String query = "INSERT INTO MedicalRecord(location_id, person_id, date_of_treatment, treatment_details) VALUES (?, ?, ?, ?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            myStmt.setInt(1, locationID);
            myStmt.setInt(2, victimID);
            java.sql.Date dateOfTreatment = java.sql.Date.valueOf(treatmentDate);
            myStmt.setDate(3, dateOfTreatment);
            myStmt.setString(4, treatmentDetails);

            myStmt.executeUpdate();
            myStmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void allocateVictimToLocation(int victimID, int locationID) {
        try {
            String query = "INSERT INTO PersonLocation(person_id, location_id) VALUES (?, ?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            myStmt.setInt(1, victimID);
            myStmt.setInt(2, locationID);

            myStmt.executeUpdate();
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void allocateSupplyToLocation(int supplyID, int locationID, String allocationDate) {
        try {
            String query = "INSERT INTO SupplyAllocation(supply_id, person_id, location_id, allocation_date) VALUES (?, ?, ?, ?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            myStmt.setInt(1, supplyID);
            myStmt.setNull(2, Types.INTEGER);
            myStmt.setInt(3, locationID);
            java.sql.Date dateOfAllocation = java.sql.Date.valueOf(allocationDate);
            myStmt.setDate(4, dateOfAllocation);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void allocateSupplyToVictim(int supplyID, int victimID, String allocationDate) {
        try {
            String query = "INSERT INTO SupplyAllocation(supply_id, person_id, location_id, allocation_date) VALUES (?, ?, ?, ?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            myStmt.setInt(1, supplyID);
            myStmt.setInt(2, victimID);
            myStmt.setNull(3, Types.INTEGER);
            java.sql.Date dateOfAllocation = java.sql.Date.valueOf(allocationDate);
            myStmt.setDate(4, dateOfAllocation);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void close() {
        try {
            results.close();
            dbConnect.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
