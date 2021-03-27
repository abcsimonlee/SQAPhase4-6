package MergedBankAccountTransactions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//this class handles reading the necessary file names for the bank account transaction files
public class ReadMBAT { 
    public File mbat;

    public boolean runReadMBAT() {
        if (getFileName()) {
            if (readMasterBankAccounts()) {
                return true;
            }
        }
        return false;
    }

    public boolean getFileName() {
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Enter Merged Bank Account Transaction file name: ");

        String filename2 = scanner2.nextLine();
        mbat = new File(filename2);
        scanner2.close();
        return true;
    }

    public boolean readMasterBankAccounts() {
        try {
            Scanner myReader = new Scanner(mbat);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                // apply transactions and produce new master bank account file
                System.out.println(data);
            }
            myReader.close();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: FILE NOT FOUND");
            return false;
        }
    }
}
