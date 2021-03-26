package MasterBankAccountFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadMBA {
    public File mba;
    
    public boolean RunReadMBA() {
        if (GetFileName()) {
            if (ReadMasterBankAccounts()) {
                return true;
            }
        }
        return false;
    }

    public boolean GetFileName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Master Bank Account file name: ");

        String filename = scanner.nextLine();
        mba = new File(filename);
        //scanner.close();
        return true;
    }

    public boolean ReadMasterBankAccounts() {
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
