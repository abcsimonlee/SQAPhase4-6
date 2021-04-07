import MasterBankAccountFile.ReadMBA;
import MergedBankAccountTransactions.ReadMBAT;
import UserAccounts.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

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
    
    List<String> changedaccounts = new ArrayList<>();
    List<String> normalaccounts = new ArrayList<>();
    List<String> masteraccounts = new ArrayList<>();
                    
    //this method will read the merged bank accounts transactions file and pass in each line to readTransaction
    public void readMBAT(String fileName) {
        File mbat = new File(fileName);
        try {
            Scanner myReader = new Scanner(mbat);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                readTransaction(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: FILE NOT FOUND");
        }
    }

    // Reads in master bank account file, adds to arraylist of bank accounts    
    public void readMBA(String fileName) {
        File mba = new File(fileName);
        try {
            Scanner myReader = new Scanner(mba);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                normalaccounts.add(data);
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
        // Determines the balance and account number of the account (based on transaction file)
        String transactionAmount = transactionCode.charAt(30) + "" + transactionCode.charAt(31) + "" + transactionCode.charAt(32) + "" + transactionCode.charAt(33) 
                + "" + transactionCode.charAt(34) + "" + transactionCode.charAt(35) + "" + transactionCode.charAt(36) 
                + "" + transactionCode.charAt(37);
        String accountNum = transactionCode.charAt(24) + "" + transactionCode.charAt(25) + "" + transactionCode.charAt(26) + "" + transactionCode.charAt(27) + "" + transactionCode.charAt(28);
        float ftransactionAmount = Float.parseFloat(transactionAmount);
        
        // Checks to see whether the code is for withdraw, transfer, or paybill. All of these subtract from account balance
        // which makes the transaction amount negative
        if (code == 1 || code == 2 || code == 3) {
            ftransactionAmount = -ftransactionAmount;
        }
        
        // Checks whether the plan has been changed from non-student to student
        else if (code == '8') {
            // If plan is student, add 5 cents instead of 10 to balance
            ftransactionAmount -= 0.05; //since 10 cents is added later subtract the amount            
            // Pass information of accounts changed and what the new balance is in order to create a new master bank account file
            //makeNewMBA(accountNum, balance);
        }
        
        /*else {
            System.out.println("Invalid Transaction Code");
            // float fbalance = Float.parseFloat(balance);
            // //System.out.println(fbalance);
            // fbalance += 0.10;
            // balance = String.valueOf(fbalance);
            // //System.out.println(fbalance);
            // //System.out.println(balance.length());
            // if (balance.length() == 3) {
            //     balance = "0000" + balance + "0";
            // }
            // if (balance.length() == 4) {
            //     balance = "0000" + balance + "0";
            // }
            // if (balance.length() == 5) {
            //     balance = "000" + balance;
            // }
            // if (balance.length() == 6) {
            //     balance = "00" + balance;
            // }
            // if (balance.length() == 7) {
            //     balance = "0" + balance + "0";
            // }
            // //System.out.println(balance);
            // //makeNewMBA(accountNum, balance);
            
        }*/
        ftransactionAmount += 0.10;
        transactionAmount = String.valueOf(ftransactionAmount);
        String balance = "";
        for (int i = 0; i < 9 - transactionAmount.length(); i++) { //a more efficient way of doing code below
            balance += "0";
        }
        balance += transactionAmount;
        
        /*if (balance.length() == 4) {
            balance = "0000" + balance;
        }
        else if (balance.length() == 5) {
            balance = "000" + balance;
        }
        else if (balance.length() == 6) {
            balance = "00" + balance;
        }
        else if (balance.length() == 7) {
            balance = "0" + balance;
        } else {
            balance = "" + balance;
        }*/
        makeNewMBA(accountNum, balance);
    }

    //this method will make the new bank account code and add to the list of changed bank accounts
    public void makeNewMBA(String accountNum, String data) {
        File mba = new File("masterbankaccount.txt");
        try {
            Scanner myReader = new Scanner(mba);
            while (myReader.hasNextLine()) {
                String account = myReader.nextLine();
                // Determines the bank account number and balance
                String oldaccountNum = account.charAt(0) + "" + account.charAt(1) + ""
                        + account.charAt(2) + "" + account.charAt(3) + ""
                        + account.charAt(4);
                String oldbalance = account.charAt(29) + "" + account.charAt(30) + "" + account.charAt(31) + ""
                        + account.charAt(32) + "" + account.charAt(33) + "" + account.charAt(34) + ""
                        + account.charAt(35) + "" + account.charAt(36);
                // Checks whether the account numbers match
                if (oldaccountNum.equals(accountNum)) {
                    // Changes the balance of the bank account if the account numbers do match
                    float foldbalance = Float.parseFloat(oldbalance);
                    float faddbalance = Float.parseFloat(data);
                    float fnewbalance = foldbalance + faddbalance;
                    String tempnewbalance = String.valueOf(fnewbalance);
                    String newbalance = "";

                    for (int i = 0; i < 7 - newbalance.length(); i++) { //a more efficient way of doing code below
                        newbalance += "0";
                    }
                    newbalance += tempnewbalance;
                    /*if (newbalance.length() == 3) {
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
                    }*/
                    account = account.replace(oldbalance, newbalance);
                    // Adds to the changedaccounts list
                    changedaccounts.add(account);
                }
                
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: FILE NOT FOUND");
        }
    }

    // This method writes the new master bank account file which includes the bank accounts that were changed
    public void writeNewMBA() {
        // Goes through both the normal accounts list and the changed accounts list, if account numbers match, add to master bank account list
        for (int i = 0; i < normalaccounts.size(); i++) {
            String oneaccountnum = normalaccounts.get(i).charAt(0) + "" + normalaccounts.get(i).charAt(1) + "" + normalaccounts
                    .get(i).charAt(2) + ""
                    + normalaccounts.get(i).charAt(3) + "" + normalaccounts.get(i).charAt(4);
            for (int j = 0; j < changedaccounts.size(); j++) {
                String twoaccountnum = changedaccounts.get(j).charAt(0) + "" + changedaccounts.get(j).charAt(1) + ""
                        + changedaccounts.get(j).charAt(2) + "" + changedaccounts.get(j).charAt(3) + ""
                        + changedaccounts.get(j).charAt(4);
                if (twoaccountnum.equals(oneaccountnum)) {
                    masteraccounts.add(changedaccounts.get(j));
                }
            }
            masteraccounts.add(normalaccounts.get(i));
        }
        // Go through master bank account list, look for duplicates, remove unchanged account line (so that only the changed balance of the account is kept)
        for (int l = 0; l < masteraccounts.size(); l++) {
            String onefinalaccountnum = masteraccounts.get(l).charAt(0) + "" + masteraccounts.get(l).charAt(1) + ""
                    + masteraccounts.get(l).charAt(2) + "" + masteraccounts.get(l).charAt(3) + ""
                    + masteraccounts.get(l).charAt(4);
            String twofinalaccountnum = masteraccounts.get(l + 1).charAt(0) + "" + masteraccounts.get(l + 1).charAt(1) + ""
                    + masteraccounts.get(l + 1).charAt(2) + "" + masteraccounts.get(l + 1).charAt(3) + ""
                    + masteraccounts.get(l + 1).charAt(4);
            //System.out.println(masteraccounts.get(l));
            if (onefinalaccountnum.equals(twofinalaccountnum)) {
                masteraccounts.remove(l+1);
            }
            //System.out.println(masteraccounts.get(l));
        }
        // Write to new master bank account file
        try {
            FileWriter myWriter = new FileWriter("newmasterbankaccount.txt");
            for (int i = 0; i < masteraccounts.size(); i++) {
                myWriter.write(masteraccounts.get(i));
                myWriter.write("\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("ERROR: FILE NOT FOUND");
        }
    }
    
    //this method creates the new current bank accounts file
    public void writeCBA() {

    }
}
