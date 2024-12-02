import java.io.*;
import java.util.*;

public class ReportGeneration {

    /*************************************************************************************************************/
    /* Functions for generating the reports */
    /*************************************************************************************************************/

    public static String[] InventoryReport() throws IOException {
        String inventoryFilePath = "StockLevels.csv";
        return getAllData(inventoryFilePath);
    }

    public static String[] SalesReport() throws IOException {
        String salesFilePath = "Pharmacy_Sales_Report.csv";
        return getAllData(salesFilePath);
    }

    public static String[] DrugUsageReport() throws IOException {
        String drugFilePath = "DrugUsage.csv";
        return getAllData(drugFilePath);
    }

    public static String[] TurnoverRateReport() throws IOException {
        String turnoverFilePath = "TurnoverRates.csv";
        return getAllData(turnoverFilePath);
    }

    public static String[] InsuranceClaimReport() throws IOException {
        String insuranceFilePath = "Insurance_Claim_Report.csv";
        return getAllData(insuranceFilePath);
    }

    public static String[] FillHistoryReport() throws IOException {
        String fillFilePath = "Fill_History_Report.csv";
        return getAllData(fillFilePath);
    }

    public static String[] UserActivityReport() throws IOException {
        String filePath = "User_Activity_Report.csv";
        return getAllData(filePath);
    }

    public static String[] PrescriptionReport() throws IOException {
        String prescriptionFilePath = "Prescription_Report.csv";
        return getAllData(prescriptionFilePath);
    }

    public static String[] ExpirationWasteReport() throws IOException {
        String expirationFilePath = "ExpirationWaste.csv";
        return getAllData(expirationFilePath);
    }

    public static String[] SupplyChainReport() throws IOException {
        String supplyFilePath = "SupplyChain.csv";
        return getAllData(supplyFilePath);
    }

    public static String[] FinancialOverviewReport() throws IOException {
        String financialFilePath = "FinancialOverview.csv";
        return getAllData(financialFilePath);
    }

    public static String[] ComplianceInfoReport() throws IOException {
        String complianceFilePath = "ComplianceInfo.csv";
        return getAllData(complianceFilePath);
    }

    /*************************************************************************************************************/

    // Helper function to read all data from a CSV file
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
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values);
            }
        }
        return data;
    }

    // Main method
    public static void main(String[] args) {
        try {
            //individual functions for each dataset
            String[] inventoryData = InventoryReport();
            String[] salesData = SalesReport();
            String[] drugUsageData = DrugUsageReport();
            String[] turnoverData = TurnoverRateReport();
            String[] insuranceData = InsuranceClaimReport();
            String[] fillHistoryData = FillHistoryReport();
            String[] userActivityData = UserActivityReport();
            String[] prescriptionData = PrescriptionReport();
            String[] expirationWasteData = ExpirationWasteReport();
            String[] supplyChainData = SupplyChainReport();
            String[] financialOverviewData = FinancialOverviewReport();
            String[] complianceData = ComplianceInfoReport();

            // Print results for each report
            printReport("Inventory Report", inventoryData);
            printReport("Sales Report", salesData);
            printReport("Drug Usage Report", drugUsageData);
            printReport("Turnover Rate Report", turnoverData);
            printReport("Insurance Claim Report", insuranceData);
            printReport("Fill History Report", fillHistoryData);
            printReport("User Activity Report", userActivityData);
            printReport("Prescription Report", prescriptionData);
            printReport("Expiration Waste Report", expirationWasteData);
            printReport("Supply Chain Report", supplyChainData);
            printReport("Financial Overview Report", financialOverviewData);
            printReport("Compliance Info Report", complianceData);

        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
        }
    }

    //method to print a report
    private static void printReport(String reportName, String[] data) {
        System.out.println("\n===== " + reportName + " =====");
        for (String row : data) {
            System.out.println(row);
        }
    }
}
