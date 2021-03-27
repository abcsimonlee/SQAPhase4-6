package MasterBankAccountFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//this class handles reading the necessary file names for the bank account transaction files
public class ReadMBA { 
    public File mba;
    
    public boolean runReadMBA() {
        if (getFileName()) {
            if (readMasterBankAccounts()) {
                return true;
            }
        }
        return false;
    }

    public boolean getFileName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Master Bank Account file name: ");

        String filename = scanner.nextLine();
        mba = new File(filename);
        //scanner.close();
        return true;
    }

    public boolean readMasterBankAccounts() {
        try {
            Scanner myReader = new Scanner(mba);
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
