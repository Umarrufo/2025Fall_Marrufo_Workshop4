package dao;

import org.example.LeaseContract;

import java.sql.*;

public class LeaseContractDao
{
    private final String dbURL;
    private final String dbUser;
    private final String dbPass;

    public LeaseContractDao(String dbURL, String dbUser, String dbPass) {
        this.dbURL = dbURL;
        this.dbUser = dbUser;
        this.dbPass = dbPass;
    }

    public void addLeaseContract(LeaseContract leaseContract) {
        String sqlQuery = "Insert Into Lease_Contract " +
                "(DateOfContract, CustomerName, CustomerEmail, ExpectedEndingValue, LeaseFee, MonthlyPayment, Vin) " +
                "Values (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass)) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, leaseContract.getDateOfContract());
            ps.setString(2, leaseContract.getCustomerName());
            ps.setString(3, leaseContract.getCustomerEmail());
            ps.setDouble(4, leaseContract.getExpectedEndingValue());
            ps.setDouble(5, leaseContract.getLeaseFee());
            ps.setDouble(6, leaseContract.getMonthlyPayment());
            ps.setInt(7, leaseContract.getVehicle().getVin());

            //Execute Update is when you do Insert or Updates
            int affectedRows = ps.executeUpdate();

            //If the number we get back is 0, it means our insert failed
            if(affectedRows > 0)
            {
                try(ResultSet generatedKeys = ps.getGeneratedKeys())
                {
                    if (generatedKeys.next())
                    {
                        leaseContract.setLeaseId(generatedKeys.getInt(1));
                    }
                }
            }
        }
        catch (SQLException ex)
        {
            System.out.println("Something went wrong with the db");

            ex.printStackTrace();
        }
    }
}
