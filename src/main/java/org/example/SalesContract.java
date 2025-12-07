package org.example;

public class SalesContract extends Contract {
    private int salesId;
    private double processingFee;
    private boolean wantToFinance;

    public SalesContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicle, int salesId, double processingFee, boolean wantToFinance) {
        super(dateOfContract, customerName, customerEmail, vehicle);
        this.salesId = salesId;
        this.processingFee = processingFee;
        this.wantToFinance = wantToFinance;
    }

    public SalesContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicle) {
        super(dateOfContract, customerName, customerEmail, vehicle);
    }

    public int getSalesId() {
        return salesId;
    }

    public void setSalesId(int salesId) {
        this.salesId = salesId;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isWantToFinance() {
        return wantToFinance;
    }

    public void setWantToFinance(boolean wantToFinance) {
        this.wantToFinance = wantToFinance;
    }

    @Override
    public double getTotalPrice() {
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }

    @Override
    public String toString() {
        return "SalesContract{" +
                "salesId=" + salesId +
                ", processingFee=" + processingFee +
                ", wantToFinance=" + wantToFinance +
                '}';
    }
}
