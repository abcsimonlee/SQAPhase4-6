package MergedBankAccountTransactions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadMBAT {
    public File mbat;

    public boolean RunReadMBAT() {
        if (GetFileName()) {
            if (ReadMasterBankAccounts()) {
                return true;
            }
        }
        return false;
    }

    public boolean GetFileName() {
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Enter Merged Bank Account Transaction file name: ");

        String filename2 = scanner2.nextLine();
        mbat = new File(filename2);
        scanner2.close();
        return true;
    }

    public boolean ReadMasterBankAccounts() {
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
