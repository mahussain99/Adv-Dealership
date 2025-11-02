package com.pluralsight;

import java.io.FileWriter;

import java.io.*;

public class ContractDataManager {
    private static final String FILE_PATH_NAME = "contracts.csv";

    public void saveContract(Contract contract) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH_NAME, true))) {


            if (contract instanceof SalesContract) {
                writer.write("SALE|" + contract.getContractDate() + "|" + contract.getCustomerName() + "|" + contract.getCustomerEmail() + "|" + contract.getvehicleSold().getVin() + "|" + contract.getvehicleSold().getYear() + "|" + contract.getvehicleSold().getMake()
                        + "|" + contract.getvehicleSold().getModel() + "|" + contract.getvehicleSold().getVehicleType() + "|" + contract.getvehicleSold().getColor() + "|" + contract.getvehicleSold().getOdometer() + "|" + contract.getvehicleSold().getPrice() + "|"
                        + ((SalesContract) contract).getSalesTaxAmount() + "|" + ((SalesContract) contract).getvehicleSold() + "|" + ((SalesContract) contract).getProcessingFee() + "|" + contract.getTotalPrice() + "|" + ((SalesContract) contract).isFinanceOption() + contract.getMonthlyPayment());

            } else if (contract instanceof LeaseContract) {
                writer.write("LEASE|" + contract.getContractDate() + "|" + contract.getCustomerName() + "|" + contract.getCustomerEmail() + "|" + contract.getvehicleSold().getVin() + "|" + contract.getvehicleSold().getYear() + "|" + contract.getvehicleSold().getMake()
                        + "|" + contract.getvehicleSold().getModel() + "|" + contract.getvehicleSold().getVehicleType() + "|" + contract.getvehicleSold().getColor() + "|" + contract.getvehicleSold().getOdometer() + "|" + contract.getvehicleSold().getPrice() + "|"
                        + ((LeaseContract) contract).getExpectedEndingValue() + "|" + ((LeaseContract) contract).getLeaseFee() + "|" + contract.getTotalPrice() + "|" + contract.getMonthlyPayment());
            }
        } catch (Exception e) {
            System.err.println("Contract file is not save.");
        }
    }
}

