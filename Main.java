import MasterBankAccountFile.ReadMBA;
import MergedBankAccountTransactions.ReadMBAT;

public class Main {
    public static void main(String[] args) {
        ReadMBA mbaf = new ReadMBA();
        ReadMBAT mbatf = new ReadMBAT();
        
        if (mbaf.RunReadMBA()) {
            if (mbatf.RunReadMBAT()) {
                System.out.println("Complete");
            }
        }
        // Read in master bank account file
        // Read in merged bank account file
        // Produce new master bank accounts file
        // Produce new current bank accounts file
        // Calculate daily cost of transaction
    }
}