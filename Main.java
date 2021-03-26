import MasterBankAccountFile.ReadMBA;
import MergedBankAccountTransactions.ReadMBAT;

public class Main {
    public static void main(String[] args) {
        ReadMBA mbaf = new ReadMBA();
        ReadMBAT mbatf = new ReadMBAT();

        if (mbaf.RunReadMBA()) { // Read in master bank account file
            if (mbatf.RunReadMBAT()) { // Read in merged bank account file
                System.out.println("Complete");
            }
        }
        // Produce new master bank accounts file
        // Produce new current bank accounts file
        // Calculate daily cost of transaction
    }
}