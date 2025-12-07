package dao;

import org.example.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao
{
    private final String dbURL;
    private final String dbUser;
    private final String dbPass;

    public VehicleDao(String dbURL, String dbUser, String dbPass)
    {
        this.dbURL = dbURL;
        this.dbUser = dbUser;
        this.dbPass = dbPass;
    }

    public List<Vehicle> getVehicleByPrice(double min, double max)
    {
        List<Vehicle> vehicles= new ArrayList<>();
        String sqlQuery= "Select * From Vehicles Where Price Between ? and ?";

        try(Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass))
        {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);

            ps.setDouble(1, min);
            ps.setDouble(2, max);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                int vin = rs.getInt("Vin");
                int year = rs.getInt("Year");
                String make = rs.getString("Make");
                String model = rs.getString("Model");
                String vehicleType = rs.getString("VehicleType");
                String color = rs.getString("Color");
                int odometer = rs.getInt("Odometer");
                double price = rs.getDouble("Price");
                boolean sold = rs.getBoolean("Sold");

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, sold);

                vehicles.add(vehicle);
            }
        }

        catch(SQLException ex)
        {
            System.out.println("\nThere was a problem with the db");
        }
        return vehicles;
    }

    public List<Vehicle> getVehicleByMakeModel(String make, String model)
    {
        String sqlQuery = "Select * From Vehicles Where Make = ? And Model = ?";
        List<Vehicle> vehicles = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass))
        {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);

            ps.setString(1, make);
            ps.setString(2, model);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                int vin = rs.getInt("Vin");
                int year = rs.getInt("Year");
                String dbMake = rs.getString("Make");
                String dbModel = rs.getString("Model");
                String vehicleType = rs.getString("VehicleType");
                String color = rs.getString("Color");
                int odometer = rs.getInt("Odometer");
                double price = rs.getDouble("Price");
                boolean sold = rs.getBoolean("Sold");

                Vehicle vehicle = new Vehicle(vin, year, dbMake, dbModel, vehicleType, color, odometer, price, sold);

                vehicles.add(vehicle);

            }
        }
        catch(SQLException ex)
        {
            System.out.println("\nSomething went wrong with the db");
        }
        return vehicles;
    }

    public List<Vehicle> getVehicleByYear(int min, int max)
    {
        String sqlQuery = "Select * From Vehicles Where Year Between ? and ?";
        List<Vehicle> vehicles = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass))
        {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);

            ps.setInt(1, min);
            ps.setInt(2, max);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                int vin = rs.getInt("Vin");
                int year = rs.getInt("Year");
                String make = rs.getString("Make");
                String model = rs.getString("Model");
                String vehicleType = rs.getString("VehicleType");
                String color = rs.getString("Color");
                int odometer = rs.getInt("Odometer");
                double price = rs.getDouble("Price");
                boolean sold = rs.getBoolean("Sold");

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, sold);

                vehicles.add(vehicle);

            }
        }
        catch(SQLException ex)
        {
            System.out.println("\nSomething went wrong with the db");
        }
        return vehicles;
    }

    public List<Vehicle> getVehicleByColor(String color)
    {
        String sqlQuery = "Select * From Vehicles Where Color = ?";
        List<Vehicle> vehicles = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass))
        {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);

            ps.setString(1, color);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                int vin = rs.getInt("Vin");
                int year = rs.getInt("Year");
                String make = rs.getString("Make");
                String model = rs.getString("Model");
                String vehicleType = rs.getString("VehicleType");
                String dbColor = rs.getString("Color");
                int odometer = rs.getInt("Odometer");
                double price = rs.getDouble("Price");
                boolean sold = rs.getBoolean("Sold");

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, dbColor, odometer, price, sold);

                vehicles.add(vehicle);

            }
        }
        catch(SQLException ex)
        {
            System.out.println("\nSomething went wrong with the db");
        }
        return vehicles;
    }
    public List<Vehicle> getVehicleByMileRange(int min, int max)
    {
        String sqlQuery = "Select * From Vehicles Where Odometer Between ? and ?";
        List<Vehicle> vehicles = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass))
        {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);

            ps.setInt(1, min);
            ps.setInt(2, max);

            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                int vin = rs.getInt("Vin");
                int year = rs.getInt("Year");
                String make = rs.getString("Make");
                String model = rs.getString("Model");
                String vehicleType = rs.getString("VehicleType");
                String color = rs.getString("Color");
                int dbOdometer = rs.getInt("Odometer");
                double price = rs.getDouble("Price");
                boolean sold = rs.getBoolean("Sold");

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color,dbOdometer, price, sold);

                vehicles.add(vehicle);
            }
        }
        catch(SQLException ex)
        {
            System.out.println("\nSomething went wrong with the db");
        }
        return vehicles;
    }

    public List<Vehicle> getVehicleByVehicleType(String vehicleType)
    {
        String sqlQuery = "Select * From Vehicles Where VehicleType = ?";
        List<Vehicle> vehicles = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass))
        {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);

            ps.setString(1, vehicleType);

            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                int vin = rs.getInt("Vin");
                int year = rs.getInt("Year");
                String make = rs.getString("Make");
                String model = rs.getString("Model");
                String dbVehicleType = rs.getString("VehicleType");
                String color = rs.getString("Color");
                int odometer = rs.getInt("Odometer");
                double price = rs.getDouble("Price");
                boolean sold = rs.getBoolean("Sold");

                Vehicle vehicle = new Vehicle(vin, year, make, model, dbVehicleType, color, odometer, price, sold);

                vehicles.add(vehicle);
            }
        }
        catch(SQLException ex)
        {
            System.out.println("\nSomething went wrong with the db");
        }
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle)
    {
        String sqlQuery = "Insert Into Vehicles(Vin, Year, Make, Model, VehicleType," +
                "Color, Odometer, Price, Sold)" +
                "Values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try(Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass))
        {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);

            ps.setInt(1, vehicle.getVin());
            ps.setInt(2, vehicle.getYear());
            ps.setString(3, vehicle.getMake());
            ps.setString(4, vehicle.getModel());
            ps.setString(5, vehicle.getVehicleType());
            ps.setString(6, vehicle.getColor());
            ps.setInt(7, vehicle.getOdometer());
            ps.setDouble(8, vehicle.getPrice());
            ps.setBoolean(9, vehicle.isSold());

            ps.executeUpdate();
        }
        catch(SQLException ex)
        {
            System.out.println("\nSomething went wrong with the db");
            ex.printStackTrace();
        }
    }

    public void removeVehicle(int vin)
    {
        String sqlQuery= "Delete From Vehicles Where Vin = ?";

        try(Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass))
        {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);

            ps.setInt(1, vin);

            ps.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println("\nThere was a problem with the database");
            ex.printStackTrace();
        }
    }

    public List<Vehicle> getAllVehicles()
    {
        List<Vehicle> vehicles = new ArrayList<>();
        String sqlQuery = "Select * From Vehicles";

        try(Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass))
        {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                int vin = rs.getInt("Vin");
                int year = rs.getInt("Year");
                String make = rs.getString("Make");
                String model = rs.getString("Model");
                String vehicleType = rs.getString("VehicleType");
                String color = rs.getString("Color");
                int odometer = rs.getInt("Odometer");
                double price = rs.getDouble("Price");
                boolean sold = rs.getBoolean("Sold");

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, sold);
                vehicles.add(vehicle);
            }
        }
        catch(SQLException ex)
        {
            System.out.println("\nThere was a problem with the database");
        }
        return vehicles;
    }
}
