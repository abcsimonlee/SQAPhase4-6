import MasterBankAccountFile.ReadMBA;
import MergedBankAccountTransactions.ReadMBAT;
import UserAccounts.User;

public class Main {
    public static void main(String[] args) {
        ReadMBA mbaf = new ReadMBA();
        ReadMBAT mbatf = new ReadMBAT();
        WriteFiles wfile = new WriteFiles();
        /*
        if (mbaf.runReadMBA()) { // Read in master bank account file
            if (mbatf.runReadMBAT()) { // Read in merged bank account file
                System.out.println("Complete");
            }
        }*/

        wfile.readMBAT("mergedbankaccounttransactions.txt");
        wfile.readMBA("masterbankaccount.txt");
        wfile.writeNewMBA();
        // Produce new master bank accounts file
        // Produce new current bank accounts file
        // Calculate daily cost of transaction
    }
}