import MasterBankAccountFile.ReadMBA;
import MergedBankAccountTransactions.ReadMBAT;
import UserAccounts.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
MBA = Master Bank Accounts File
MBAT = Merged Bank Account Transactions File 
CBA = Current Bank Accounts File
*/

/* 
this class will line by line read transactions from the merged bank account transaction file and then
find the appropriate corresponding bank account using the old master bank accounts file, and then create 
both the new master bank accounts file and also make the new current bank accounts file.
*/
public class WriteFiles {
    String oldMBA; //The old master bank account file
                    //may possibly be changed from a string
    ReadMBA mba = new ReadMBA();
                    
    //this method will read the merged bank accounts transactions file and pass in each line to readTransaction
    public void readMBAT(String fileName) {
        File mbat = new File(fileName);
        try {
            Scanner myReader = new Scanner(mbat);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                // apply transactions and produce new master bank account file
                readTransaction(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: FILE NOT FOUND");
        }
    }

    public void readMBA(String fileName) {
        File mba = new File(fileName);
        try {
            Scanner myReader = new Scanner(mba);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                // apply transactions and produce new master bank account file
                writeNewMBA(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: FILE NOT FOUND");
        }
    }
    //this method determines the transaction that is on the current line of the transactions file then edits
    //values of the respective account accordingly
    public void readTransaction(String transactionCode) {
        char code = transactionCode.charAt(1);
        String balance = transactionCode.charAt(30) + "" + transactionCode.charAt(31) + "" + transactionCode.charAt(32) + "" + transactionCode.charAt(33) 
                + "" + transactionCode.charAt(34) + "" + transactionCode.charAt(35) + "" + transactionCode.charAt(36) 
                + "" + transactionCode.charAt(37);
        if (code == '8') {
            float fbalance = Float.parseFloat(balance);
            fbalance += 0.05;
            balance = String.valueOf(fbalance);
            if (balance.length() == 4) {
                balance = "0000" + balance;
            }
            if (balance.length() == 5) {
                balance = "000" + balance;
            }
            if (balance.length() == 6) {
                balance = "00" + balance;
            }
            if (balance.length() == 7) {
                balance = "0" + balance;
            }
            
            System.out.println(balance);
            writeNewMBA(balance);
        }
        /*
        else {
            float fbalance = Float.parseFloat(balance);
            fbalance += 0.10;
            balance = String.valueOf(fbalance);
            System.out.println(balance);
            System.out.println(balance.length());
            if (balance.length() == 3) {
                balance = "0000" + balance + "0";
            }
            if (balance.length() == 4) {
                balance = "0000" + balance + "0";
            }
            if (balance.length() == 5) {
                balance = "000" + balance + "0";
            }
            if (balance.length() == 6) {
                balance = "00" + balance + "0";
            }
            if (balance.length() == 7) {
                balance = "0" + balance + "0";
            }

            //System.out.println(balance);
        }*/
    }

    //this method will make the new bank account code and write it to the new MBA
    public void writeNewMBA(String data) {
       
    }
    
    //this method creates the new current bank accounts file
    public void writeCBA() {

    }
}