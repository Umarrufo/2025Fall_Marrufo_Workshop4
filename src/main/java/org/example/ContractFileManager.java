package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContractFileManager
{
    public Contract getContract()
    {
        Contract contract = null;
        List<Contract> contracts = new ArrayList<>();

        try {
            FileReader fr = new FileReader("src/main/resources/contract.csv");
            BufferedReader reader = new BufferedReader(fr);

            String firstLine = reader.readLine();

            String line;

            reader.close();

        } catch (FileNotFoundException ex3) {
            System.out.println("Could not find the file");
        } catch (IOException ex2) {
            System.out.println("File had a problem with it");
        }

        return contract;
    }

    public void saveContract(Contract contract) {
        //File writer used when asking for user input
        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/contract .csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);



            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println("Something went wrong with the file, try again");
        }
    }
}