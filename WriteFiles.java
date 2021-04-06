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
                //writeNewMBA(data);
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
        String accountNum = transactionCode.charAt(24) + "" + transactionCode.charAt(25) + "" + transactionCode.charAt(26) + "" + transactionCode.charAt(27) + "" + transactionCode.charAt(28);
        //System.out.println(accountNum);
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
            writeNewMBA(accountNum, balance);
            //System.out.println(balance);
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
    public void writeNewMBA(String accountNum, String data) {
        File mba = new File("masterbankaccount.txt");
        try {
            Scanner myReader = new Scanner(mba);
            while (myReader.hasNextLine()) {
                String account = myReader.nextLine();
                String oldaccountNum = account.charAt(0) + "" + account.charAt(1) + ""
                        + account.charAt(2) + "" + account.charAt(3) + ""
                        + account.charAt(4);
                String oldbalance = account.charAt(29) + "" + account.charAt(30) + "" + account.charAt(31) + ""
                        + account.charAt(32) + "" + account.charAt(33) + "" + account.charAt(34) + ""
                        + account.charAt(35) + "" + account.charAt(36);
                //System.out.println(oldaccountNum + " " + accountNum);
                if (oldaccountNum.equals(accountNum)) {
                    float foldbalance = Float.parseFloat(oldbalance);
                    float faddbalance = Float.parseFloat(data);
                    float fnewbalance = foldbalance + faddbalance;
                    String newbalance = String.valueOf(fnewbalance);
                    if (newbalance.length() == 3) {
                        newbalance = "0000" + newbalance + "0";
                    }
                    if (newbalance.length() == 4) {
                        newbalance = "0000" + newbalance;
                    }
                    if (newbalance.length() == 5) {
                        newbalance = "000" + newbalance;
                    }
                    if (newbalance.length() == 5) {
                        newbalance = "00" + newbalance;
                    }
                    if (newbalance.length() == 6) {
                        newbalance = "00" + newbalance;
                    }
                    //System.out.println(newbalance);
                    //System.out.println(oldbalance + " " + data);
                    account = account.replace(oldbalance, newbalance);
                    System.out.println(account);
                }
                
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: FILE NOT FOUND");
        }
    }
    
    //this method creates the new current bank accounts file
    public void writeCBA() {

    }
}
