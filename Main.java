import MasterBankAccountFile.ReadMBA;
import MergedBankAccountTransactions.ReadMBAT;
import UserAccounts.User;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WriteFiles wfile = new WriteFiles();
        /*
        if (mbaf.runReadMBA()) { // Read in master bank account file
            if (mbatf.runReadMBAT()) { // Read in merged bank account file
                System.out.println("Complete");
            }
        }*/
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Merged Bank Account Transactions file name: ");

        String filename1 = scanner.nextLine();
        wfile.readMBAT(filename1);

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Enter Master Bank Accounts file name: ");

        String filename2 = scanner2.nextLine();
        wfile.readMBA(filename2);
        wfile.writeNewMBA();
        // Produce new master bank accounts file
        // Produce new current bank accounts file
        // Calculate daily cost of transaction
    }
}