package org.example;

public class LeaseContract extends Contract {
    private int leaseId;
    private double expectedEndingValue;
    private double leaseFee;
    private double monthlyPayment;

    public LeaseContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicle, int leaseId, double expectedEndingValue, double leaseFee, double monthlyPayment) {
        super(dateOfContract, customerName, customerEmail, vehicle);
        this.leaseId = leaseId;
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = leaseFee;
        this.monthlyPayment = monthlyPayment;
    }

    public LeaseContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicle) {
        super(dateOfContract, customerName, customerEmail, vehicle);
    }

    public int getLeaseId() {
        return leaseId;
    }

    public void setLeaseId(int leaseId) {
        this.leaseId = leaseId;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    @Override
    public double getTotalPrice() {
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    @Override
    public String toString() {
        return "LeaseContract{" +
                "leaseId=" + leaseId +
                ", expectedEndingValue=" + expectedEndingValue +
                ", leaseFee=" + leaseFee +
                ", monthlyPayment=" + monthlyPayment +
                '}';
    }
}