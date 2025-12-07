package dao;

import org.example.SalesContract;

import java.sql.*;

public class SalesContractDao
{
    private final String dbURL;
    private final String dbUser;
    private final String dbPass;

    public SalesContractDao(String dbURL, String dbUser, String dbPass) {
        this.dbURL = dbURL;
        this.dbUser = dbUser;
        this.dbPass = dbPass;
    }

    public void addSalesContract(SalesContract salesContract) {
        String sqlQuery = "Insert Into Sales_Contract " +
                "(DateOfContract, CustomerName, CustomerEmail, ProcessingFee, WantToFinance, Vin) " +
                "Values (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass)) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, salesContract.getDateOfContract());
            ps.setString(2, salesContract.getCustomerName());
            ps.setString(3, salesContract.getCustomerEmail());
            ps.setDouble(4, salesContract.getProcessingFee());
            ps.setBoolean(5, salesContract.isWantToFinance());
            ps.setInt(6, salesContract.getVehicle().getVin());

            //Execute Update is when you do Insert or Updates
            int affectedRows = ps.executeUpdate();

            //If the number we get back is 0, it means our insert failed
            if(affectedRows > 0)
            {
                try(ResultSet generatedKeys = ps.getGeneratedKeys())
                {
                    if (generatedKeys.next())
                    {
                        salesContract.setSalesId(generatedKeys.getInt(1));
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
