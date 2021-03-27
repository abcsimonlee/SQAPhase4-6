import MasterBankAccountFile.ReadMBA;
import MergedBankAccountTransactions.ReadMBAT;
import UserAccounts.User;

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
                    
    //this method will read the merged bank accounts transactions file and pass in each line to readTransaction
    public void readMBAT (String fileName){

    }
    //this method determines the transaction that is on the current line of the transactions file then edits
    //values of the respective account accordingly
    public void readTransaction(String transactionCode){

    }

    //this method will make the new bank account code and write it to the new MBA
    public void writeNewMBA(){

    }
    
    //this method creates the new current bank accounts file
    public void writeCBA(){

    }
}
