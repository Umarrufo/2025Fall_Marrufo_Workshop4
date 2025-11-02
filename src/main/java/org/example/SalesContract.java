package org.example;

public class SalesContract extends Contract
{
    private double salesTaxAmount = 0.05;
    private double recordingFee = 100;
    private double processingFee;
    private boolean wantToFinance;

    public SalesContract(String dateOfContract, String customerName, String customerDetail, Vehicle vehicle, double processingFee, boolean wantToFinance)
    {
        super(dateOfContract, customerName, customerDetail, vehicle);
        this.processingFee = processingFee;
        this.wantToFinance = wantToFinance;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee()
    {
        if(getVehicle().getPrice() < 10000)
        {
            return 295;
        }
        else
            return 495;
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
    public double getTotalPrice()
    {

        double totalPrice = 0;
        return totalPrice;
    }

    @Override
    public double getMonthlyPayment()
    {
        double interestRate;
        double months;
        double monthlyPayment;

        if(wantToFinance)
        {
            if(getVehicle().getPrice() > 10000)
            {
                interestRate = 0.0425;
                months = 48;
            }
            else
            {
                interestRate = 0.0525;
                months = 24;
            }

            monthlyPayment = 0;

        }
        else
        {
            monthlyPayment = 0;
        }
        return monthlyPayment;
    }
}
