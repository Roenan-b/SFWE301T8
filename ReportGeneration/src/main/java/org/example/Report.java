package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Report {


    public static String[] BranchFill() throws IOException {
        String resourceFilePath = "BranchFill.csv"; // Just the file name, no full path
        return getAllData(resourceFilePath);
    }
    public static String[] MedRecall() throws IOException {
        String resourceFilePath = "MedicationRecall.csv"; // Just the file name, no full path
        return getAllData(resourceFilePath);
    }
    public static String[] Transaction() throws IOException {
        String resourceFilePath = "Transactions.csv"; // Just the file name, no full path
        return getAllData(resourceFilePath);
    }
    public static String[] BranchWaste() throws IOException {
        String resourceFilePath = "BranchWaste.csv"; // Just the file name, no full path
        return getAllData(resourceFilePath);
    }
    public static String[] BranchUsage() throws IOException {
        String resourceFilePath = "BranchUsage.csv"; // Just the file name, no full path
        return getAllData(resourceFilePath);
    }
    public static String[] BranchInventory() throws IOException {
        String resourceFilePath = "BranchInventory.csv"; // Just the file name, no full path
        return getAllData(resourceFilePath);
    }
    public static String[] Waste() throws IOException {
        String resourceFilePath = "WasteReport.csv"; // Just the file name, no full path
        return getAllData(resourceFilePath);
    }
    public static String[] Financial() throws IOException {
        String resourceFilePath = "Financial.csv"; // Just the file name, no full path
        return getAllData(resourceFilePath);
    }




    private static String[] getAllData(String filePath) throws IOException {
        List<String[]> data = readCSV(filePath);
        List<String> report = new ArrayList<>();

        for (String[] row : data) {
            report.add(String.join(", ", row)); // Concatenate all columns in a row
        }

        return report.toArray(new String[0]);
    }

    // Helper function to read CSV files and return data as List of String arrays
    private static List<String[]> readCSV(String filePath) throws IOException {
        List<String[]> data = new ArrayList<>();
        try (InputStream inputStream = Report.class.getClassLoader().getResourceAsStream(filePath);
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

            if (inputStream == null) {
                throw new IOException("Resource not found: " + filePath);
            }

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values);
            }
        }
        return data;
    }

    public static void main(String[] args) {
        try {
            String[] branchfill = BranchFill();
            String[] medrecall = MedRecall();
            String[] transactions = Transaction();
            String[] branchwaste = BranchWaste();
            String[] branchusage = BranchUsage();
            String[] branchinventory = BranchInventory();
            String[] waste = Waste();
            String[] financial = Financial();


            printReport("Branch Fill", branchfill);
            printReport("Medication Recall", medrecall);
            printReport("Transaction Report", transactions);
            printReport("Branch Waste Report", branchwaste);
            printReport("Branch Usage Report", branchusage);
            printReport("Branch Inventory Report", branchinventory);
            printReport("Waste Report", waste);
            printReport("Financial Report", financial);



        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
        }
    }


    private static void printReport(String reportName, String[] data) {
        System.out.println("\n===== " + reportName + " =====");
        for (String row : data) {
            System.out.println(row);
        }
    }
}