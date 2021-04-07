import MasterBankAccountFile.ReadMBA;
import MergedBankAccountTransactions.ReadMBAT;
import UserAccounts.User;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WriteFiles wfile = new WriteFiles();
        JUnit1 tests = new JUnit1();
        JUnit2 tests2 = new JUnit2();
        tests.test1();
        tests.test2();
        tests.test3();
        tests.test4();
        tests.test5();
        tests.test6();
        tests.test7();

        tests2.decisionTest1();
        tests2.decisionTest2();
        tests2.decisionTest3();
        tests2.decisionTest4();
        
        tests2.loop1Test1();
        tests2.loop1Test2();
        tests2.loop1Test3();
        tests2.loop1Test4();

        tests2.loop2Test1();
        tests2.loop2Test2();
        tests2.loop2Test3();
        tests2.loop2Test4();

        tests2.loop3Test1();
        tests2.loop3Test2();
        tests2.loop3Test3();
        tests2.loop3Test4();

        tests2.loop4Test1();
        tests2.loop4Test2();
        tests2.loop4Test3();
        tests2.loop4Test4();
        /*
        if (mbaf.runReadMBA()) { // Read in master bank account file
            if (mbatf.runReadMBAT()) { // Read in merged bank account file
                System.out.println("Complete");
            }
        }*/
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Merged Bank Account Transactions file name: ");

        String filename1 = scanner.nextLine();
        wfile.readMBAT(filename1);

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Enter Master Bank Accounts file name: ");

        String filename2 = scanner2.nextLine();
        wfile.readMBA(filename2);
        wfile.writeNewMBA();
        // Produce new master bank accounts file
        // Produce new current bank accounts file
        // Calculate daily cost of transaction
    }
}