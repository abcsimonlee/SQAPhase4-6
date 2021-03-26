package MergedBankAccountTransactions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadMBAT {
    public File mba = new File("mergedbankaccounttransactions.txt");
    public void ReadMasterBankAccounts() {
        try {
            Scanner myReader = new Scanner(mba);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                // apply transactions and produce new master bank account file
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: FILE NOT FOUND");
            e.printStackTrace();
        }
    }
}
