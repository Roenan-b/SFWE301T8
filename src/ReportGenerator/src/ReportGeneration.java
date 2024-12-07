import java.io.*;
import java.util.*;

public class ReportGeneration {

    /*************************************************************************************************************/
    /* Functions for generating the reports */
    /*************************************************************************************************************/

    // Generates the inventory report by calling the helper function 'getAllData'
    public static String[] InventoryReport() throws IOException {
        String inventoryFilePath = "StockLevels.csv";  // File path for inventory data
        int columnNums = 9;  // Number of expected columns in the CSV file
        return getAllData(inventoryFilePath, columnNums);  // Fetch all data from the file
    }

    // Generates the sales report by calling the helper function 'getAllData'
    public static String[] SalesReport() throws IOException {
        String salesFilePath = "Pharmacy_Sales_Report.csv";  // File path for sales data
        int columnNums = 4;  // Number of expected columns in the CSV file
        return getAllData(salesFilePath, columnNums);  // Fetch all data from the file
    }

    // Generates the drug usage report by calling the helper function 'getAllData'
    public static String[] DrugUsageReport() throws IOException {
        String drugFilePath = "DrugUsage.csv";  // File path for drug usage data
        int columnNums = 6;  // Number of expected columns in the CSV file
        return getAllData(drugFilePath, columnNums);  // Fetch all data from the file
    }

    // Generates the turnover rate report by calling the helper function 'getAllData'
    public static String[] TurnoverRateReport() throws IOException {
        String turnoverFilePath = "TurnoverRates.csv";  // File path for turnover rate data
        int columnNums = 6;  // Number of expected columns in the CSV file
        return getAllData(turnoverFilePath, columnNums);  // Fetch all data from the file
    }

    // Generates the insurance claim report by calling the helper function 'getAllData'
    public static String[] InsuranceClaimReport() throws IOException {
        String insuranceFilePath = "Insurance_Claim_Report.csv";  // File path for insurance claim data
        int columnNums = 16;  // Number of expected columns in the CSV file
        return getAllData(insuranceFilePath, columnNums);  // Fetch all data from the file
    }

    // Generates the fill history report by calling the helper function 'getAllData'
    public static String[] FillHistoryReport() throws IOException {
        String fillFilePath = "Fill_History_Report.csv";  // File path for fill history data
        int columnNums = 18;  // Number of expected columns in the CSV file
        return getAllData(fillFilePath, columnNums);  // Fetch all data from the file
    }

    // Generates the user activity report by calling the helper function 'getAllData'
    public static String[] UserActivityReport() throws IOException {
        String filePath = "User_Activity_Report.csv";  // File path for user activity data
        int columnNums = 11;  // Number of expected columns in the CSV file
        return getAllData(filePath, columnNums);  // Fetch all data from the file
    }

    // Generates the prescription report by calling the helper function 'getAllData'
    public static String[] PrescriptionReport() throws IOException {
        String prescriptionFilePath = "Prescription_Report.csv";  // File path for prescription data
        int columnNums = 14;  // Number of expected columns in the CSV file
        return getAllData(prescriptionFilePath, columnNums);  // Fetch all data from the file
    }

    // Generates the expiration waste report by calling the helper function 'getAllData'
    public static String[] ExpirationWasteReport() throws IOException {
        String expirationFilePath = "ExpirationWaste.csv";  // File path for expiration waste data
        int columnNums = 7;  // Number of expected columns in the CSV file
        return getAllData(expirationFilePath, columnNums);  // Fetch all data from the file
    }

    // Generates the supply chain report by calling the helper function 'getAllData'
    public static String[] SupplyChainReport() throws IOException {
        String supplyFilePath = "SupplyChain.csv";  // File path for supply chain data
        int columnNums = 7;  // Number of expected columns in the CSV file
        return getAllData(supplyFilePath, columnNums);  // Fetch all data from the file
    }

    // Generates the financial overview report by calling the helper function 'getAllData'
    public static String[] FinancialOverviewReport() throws IOException {
        String financialFilePath = "FinancialOverview.csv";  // File path for financial overview data
        int columnNums = 7;  // Number of expected columns in the CSV file
        return getAllData(financialFilePath, columnNums);  // Fetch all data from the file
    }

    // Generates the compliance information report by calling the helper function 'getAllData'
    public static String[] ComplianceInfoReport() throws IOException {
        String complianceFilePath = "ComplianceInfo.csv";  // File path for compliance data
        int columnNums = 7;  // Number of expected columns in the CSV file
        return getAllData(complianceFilePath, columnNums);  // Fetch all data from the file
    }

    /*************************************************************************************************************/

    // Helper function to read all data from a CSV file and return it as an array of strings
    private static String[] getAllData(String filePath, int columnNums) throws IOException {
        try {
            // Read CSV file and store data in a list of strings
            List<String[]> data = readCSV(filePath, columnNums);
            List<String> report = new ArrayList<>();

            // Concatenate each row into a single string and add to the report list
            for (String[] row : data) {
                report.add(String.join(", ", row)); // Combine columns in a row with commas
            }
            return report.toArray(new String[0]); // Convert list to array and return
        } catch (IOException e) {
            // If there's an error, return an array with the error message
            return new String[]{"Error: " + e.getMessage()};
        }
    }

    // Helper function to read the contents of a CSV file and return the data as a list of string arrays
    private static List<String[]> readCSV(String filePath, int columnNum) throws IOException {
        List<String[]> data = new ArrayList<>();
        int expectedColumnCount = columnNum; // Number of expected columns

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;

            // Read each line from the file
            while ((line = br.readLine()) != null) {
                lineNumber++;
                String[] values = line.split(","); // Split each line by commas

                // For the first line, determine the expected column count
                if (lineNumber == 1) {
                    expectedColumnCount = values.length;
                }

                // Validate if the number of columns is as expected
                if (values.length != expectedColumnCount) {
                    // If there's a mismatch, throw an error indicating the line number
                    throw new IOException("Malformed row at line " + lineNumber +
                            ": expected " + expectedColumnCount + " columns but found " + values.length);
                }

                // Add the values of the current row to the data list
                data.add(values);
            }
        }
        return data; // Return the list of rows
    }

    // Main method to run the report generation program
    public static void main(String[] args) {
        boolean programOn = true; // Control variable for the program loop
        int reportChoice = 0; // User's choice for which report to generate
        Scanner scanner = new Scanner(System.in); // Scanner object to read user input
        System.out.println("Welcome to the Report Generator");

        try {
            // Fetch data for all available reports
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

            // Display a menu for the user to select the report they want to generate
            while (programOn) {
                System.out.println("\n\nSelect a report");
                System.out.println("1. Inventory");
                System.out.println("2. Sales");
                System.out.println("3. Drug Usage");
                System.out.println("4. Turnover Rate");
                System.out.println("5. Insurance Claim");
                System.out.println("6. Fill History");
                System.out.println("7. User Activity");
                System.out.println("8. Prescription");
                System.out.println("9. Expiration Waste");
                System.out.println("10. Supply Chain");
                System.out.println("11. Financial Overview");
                System.out.println("12. Compliance");
                System.out.println("0. Exit\n");
                System.out.print("Report: ");
                reportChoice = scanner.nextInt(); // Read the user's choice

                // Switch statement to determine which report to print based on user's choice
                switch (reportChoice) {
                    case 1:
                        printReport("Inventory Report", inventoryData);
                        break;
                    case 2:
                        printReport("Sales Report", salesData);
                        break;
                    case 3:
                        printReport("Drug Usage Report", drugUsageData);
                        break;
                    case 4:
                        printReport("Turnover Rate Report", turnoverData);
                        break;
                    case 5:
                        printReport("Insurance Claim Report", insuranceData);
                        break;
                    case 6:
                        printReport("Fill History Report", fillHistoryData);
                        break;
                    case 7:
                        printReport("User Activity Report", userActivityData);
                        break;
                    case 8:
                        printReport("Prescription Report", prescriptionData);
                        break;
                    case 9:
                        printReport("Expiration Waste Report", expirationWasteData);
                        break;
                    case 10:
                        printReport("Supply Chain Report", supplyChainData);
                        break;
                    case 11:
                        printReport("Financial Overview Report", financialOverviewData);
                        break;
                    case 12:
                        printReport("Compliance Report", complianceData);
                        break;
                    case 0:
                        // If the user selects 0, exit the program
                        System.out.println("Exiting.....");
                        programOn = false; // Set programOn to false to exit the loop
                        break;
                }
            }

        } catch (IOException e) {
            // Catch and print any errors related to file processing
            System.err.println("Error processing files: " + e.getMessage());
        }

    }

    // Method to print a report to the console
    private static void printReport(String reportName, String[] data) {
        System.out.println("\n===== " + reportName + " =====");
        for (String row : data) {
            System.out.println(row); // Print each row of the report
        }
    }
}
