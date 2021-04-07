// Statement coverage for readTransaction(String transactionCode) method
public class JUnit1 {
    WriteFiles wfile = new WriteFiles();
    public void test1() {
        wfile.readTransaction("08_Carl_________________00009_00001.00___");
    }

    public void test2() {
        wfile.readTransaction("05_John_Holland_________00011_00200.86___");
    }

    public void test3() {
        wfile.readTransaction("08_Carl_________________00009_00001.00___");
    }

    public void test4() {
        wfile.readTransaction("08_John_Smith___________00001_00010.00___");
    }

    public void test5() {
        wfile.readTransaction("08_John_Doe_____________00003_00100.00___");
    }

    public void test6() {
        wfile.readTransaction("08_Garry_Holland________00015_01000.00___");
    }

    public void test7() {
        wfile.readTransaction("08_John_Holland_________00011_10000.00___");
    }
}
