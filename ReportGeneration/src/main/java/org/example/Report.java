package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Report {

    public static String[] BranchFill() throws IOException {
        String resourceFilePath = "BranchFill.csv";
        return getAllData(resourceFilePath);
    }

    public static String[] MedRecall() throws IOException {
        String resourceFilePath = "MedicationRecall.csv";
        return getAllData(resourceFilePath);
    }

    public static String[] Transaction() throws IOException {
        String resourceFilePath = "Transactions.csv";
        return getAllData(resourceFilePath);
    }

    public static String[] BranchWaste() throws IOException {
        String resourceFilePath = "BranchWaste.csv";
        return getAllData(resourceFilePath);
    }

    public static String[] BranchUsage() throws IOException {
        String resourceFilePath = "BranchUsage.csv";
        return getAllData(resourceFilePath);
    }

    public static String[] BranchInventory() throws IOException {
        String resourceFilePath = "BranchInventory.csv";
        return getAllData(resourceFilePath);
    }

    public static String[] Waste() throws IOException {
        String resourceFilePath = "WasteReport.csv";
        return getAllData(resourceFilePath);
    }

    public static String[] Financial() throws IOException {
        String resourceFilePath = "Financial.csv";
        return getAllData(resourceFilePath);
    }

    private static String[] getAllData(String filePath) throws IOException {
        List<String[]> data = readCSV(filePath);
        List<String> report = new ArrayList<>();

        for (String[] row : data) {
            report.add(String.join(", ", row));
        }

        return report.toArray(new String[0]);
    }

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
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nAvailable Reports:");
            System.out.println("1. Branch Fill");
            System.out.println("2. Medication Recall");
            System.out.println("3. Transaction Report");
            System.out.println("4. Branch Waste Report");
            System.out.println("5. Branch Usage Report");
            System.out.println("6. Branch Inventory Report");
            System.out.println("7. Waste Report");
            System.out.println("8. Financial Report");
            System.out.println("Type 'quit' or any other key to exit.");

            System.out.print("Enter the number of the report you want to view: ");
            String choice = scanner.nextLine();

            try {
                switch (choice.toLowerCase()) {
                    case "1":
                        printReport("Branch Fill", BranchFill());
                        break;
                    case "2":
                        printReport("Medication Recall", MedRecall());
                        break;
                    case "3":
                        printReport("Transaction Report", Transaction());
                        break;
                    case "4":
                        printReport("Branch Waste Report", BranchWaste());
                        break;
                    case "5":
                        printReport("Branch Usage Report", BranchUsage());
                        break;
                    case "6":
                        printReport("Branch Inventory Report", BranchInventory());
                        break;
                    case "7":
                        printReport("Waste Report", Waste());
                        break;
                    case "8":
                        printReport("Financial Report", Financial());
                        break;
                    case "quit":
                        running = false;
                        System.out.println("Exiting the program. Goodbye!");
                        break;
                    default:
                        running = false;
                        System.out.println("Exiting the program. Goodbye!");
                }
            } catch (IOException e) {
                System.err.println("Error processing files: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static void printReport(String reportName, String[] data) {
        System.out.println("\n===== " + reportName + " =====");
        for (String row : data) {
            System.out.println(row);
        }
    }
}
