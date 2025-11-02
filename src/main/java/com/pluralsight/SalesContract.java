package com.pluralsight;

public class SalesContract extends Contract {

    private boolean financeOption;
    private double salesTaxAmount;
    private double recordingFee;
    private double processingFee;

    public SalesContract(String contractDate, String customerName, String customerEmail, Vehicle vehicleSold ,
                         boolean financeOption) {
        super(contractDate, customerName, customerEmail, vehicleSold);
        this.financeOption = financeOption;
        this.salesTaxAmount = vehicleSold.getPrice() * 0.05;
        this.recordingFee = 100.00;
        if (getVehicleSold().getPrice() > 1000) {
        this.processingFee = 495;
    } else{
        this.processingFee = 295;
        this.financeOption = financeOption;
}

    }

    public boolean isFinanceOption() {
        return financeOption;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public double getProcessingFee() {
        return processingFee;
    }


    @Override
    public double getTotalPrice() {
        return getVehicleSold().getPrice() + salesTaxAmount + recordingFee + processingFee;
    }


    @Override
    public double getMonthlyPayment() {
        int numberOfPayments = 0;
        double interestRate = 0;
        if (financeOption) {
            if (getVehicleSold().getPrice() >= 10000) {
                numberOfPayments = 48;
                interestRate = 4.25 / 1200;
            } else {
                numberOfPayments = 24;
                interestRate = 5.25 / 1200;
            }

            double monthlyPayment = getTotalPrice() * (interestRate * Math.pow(1 + interestRate, numberOfPayments)) / (Math.pow(1 + interestRate, numberOfPayments) - 1);
            monthlyPayment = Math.round(monthlyPayment * 100);
            monthlyPayment /= 100;
            return monthlyPayment;
        } else {
            return 0.0;
        }
    }
}
