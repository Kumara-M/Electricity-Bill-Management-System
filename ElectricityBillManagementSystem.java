package electricitybillmanagementsystem;

import javax.swing.JOptionPane;

public class ElectricityBillManagementSystem {

    static String customerName;
    static String meterNumber;
    static int previousReading;
    static int currentReading;
    static int units;
    static double billAmount;
    static boolean billGenerated = false;

    public static void main(String[] args) {

        while (true) {

            String choice = JOptionPane.showInputDialog(
                    "ELECTRICITY BILL MANAGEMENT SYSTEM\n\n"
                    + "1. Generate Bill\n"
                    + "2. View Bill\n"
                    + "3. Exit\n\n"
                    + "Enter your choice:"
            );

            if (choice == null) {
                break;
            }

            switch (choice) {

                case "1":
                    generateBill();
                    break;

                case "2":
                    viewBill();
                    break;

                case "3":
                    JOptionPane.showMessageDialog(null,
                            "Thank you for using Electricity Bill Management System!");
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null,
                            "Invalid choice! Please enter 1, 2 or 3.");
            }
        }
    }

    static void generateBill() {

        customerName = JOptionPane.showInputDialog(
                "Enter Customer Name:"
        );

        meterNumber = JOptionPane.showInputDialog(
                "Enter Meter Number:"
        );

        previousReading = Integer.parseInt(
                JOptionPane.showInputDialog(
                        "Enter Previous Reading:"
                )
        );

        currentReading = Integer.parseInt(
                JOptionPane.showInputDialog(
                        "Enter Current Reading:"
                )
        );

        units = currentReading - previousReading;

        // Simple tariff: ₹5 per unit
        billAmount = units *5.0;

        billGenerated = true;

        JOptionPane.showMessageDialog(null,
                "BILL GENERATED SUCCESSFULLY!\n\n"
                + "Customer Name: " + customerName + "\n"
                + "Meter Number: " + meterNumber + "\n"
                + "Units Consumed: " + units + "\n"
                + "Bill Amount: ₹" + billAmount
        );
    }

    static void viewBill() {

        if (!billGenerated) {

            JOptionPane.showMessageDialog(null,
                    "No bill has been generated yet!");

        } else {

            JOptionPane.showMessageDialog(null,
                    "ELECTRICITY BILL\n\n"
                    + "Customer Name: " + customerName + "\n"
                    + "Meter Number: " + meterNumber + "\n"
                    + "Previous Reading: " + previousReading + "\n"
                    + "Current Reading: " + currentReading + "\n"
                    + "Units Consumed: " + units + "\n"
                    + "Bill Amount: ₹" + billAmount
            );
        }
    }
}