import java.util.ArrayList;
import java.util.List;

// Decision and loop coverage for writeNewMBA()
public class JUnit2 {
    WriteFiles wfile = new WriteFiles();
    // Decision coverage
    public void decisionTest1() {
        List<String> changedaccounts = new ArrayList<>();
        List<String> normalaccounts = new ArrayList<>();
        changedaccounts.add("00002_ John_________________D_16672.26_0005");
        normalaccounts.add("00002_ John_________________D_16672.26_0005");
        wfile.testWriteNewMBA(changedaccounts, normalaccounts);
    }

    public void decisionTest2() {
        List<String> changedaccounts = new ArrayList<>();
        List<String> normalaccounts = new ArrayList<>();
        changedaccounts.add("00002_ John_________________D_16672.26_0005");
        normalaccounts.add("00001_John_Smith___________A_00000.00_0003");
        wfile.testWriteNewMBA(changedaccounts, normalaccounts);
    }

    public void decisionTest3() {
        List<String> changedaccounts = new ArrayList<>();
        List<String> normalaccounts = new ArrayList<>();
        changedaccounts.add("00002_ John_________________D_16672.26_0005");
        normalaccounts.add("00002_ John_________________D_16672.26_0005");
        wfile.testWriteNewMBA(changedaccounts, normalaccounts);
    }

    public void decisionTest4() {
        List<String> changedaccounts = new ArrayList<>();
        List<String> normalaccounts = new ArrayList<>();
        changedaccounts.add("00002_ John_________________D_16672.26_0005");
        normalaccounts.add("00001_John_Smith___________A_00000.00_0003");
        wfile.testWriteNewMBA(changedaccounts, normalaccounts);
    }
    // Loop coverage
    public void loop1Test1() {
        List<String> changedaccounts = new ArrayList<>();
        List<String> normalaccounts = new ArrayList<>();
        wfile.testWriteNewMBA(changedaccounts, normalaccounts);
    }

    public void loop1Test2() {
        List<String> changedaccounts = new ArrayList<>();
        List<String> normalaccounts = new ArrayList<>();
        normalaccounts.add("00001_John_Smith___________A_00000.00_0003");
        wfile.testWriteNewMBA(changedaccounts, normalaccounts);
    }

    public void loop1Test3() {
        List<String> changedaccounts = new ArrayList<>();
        List<String> normalaccounts = new ArrayList<>();
        normalaccounts.add("00001_John_Smith___________A_00000.00_0003");
        normalaccounts.add("00002_John_________________D_16672.26_0005");
        wfile.testWriteNewMBA(changedaccounts, normalaccounts);
    }

    public void loop1Test4() {
        List<String> changedaccounts = new ArrayList<>();
        List<String> normalaccounts = new ArrayList<>();
        normalaccounts.add("00001_John_Smith___________A_00000.00_0003");
        normalaccounts.add("00002_John_________________D_16672.26_0005");
        normalaccounts.add("00003_John_Doe_____________D_00000.00_0010");
        normalaccounts.add("00004_George_Ty____________A_39154.94_0001");
        wfile.testWriteNewMBA(changedaccounts, normalaccounts);
    }

    public void loop2Test1() {
        List<String> changedaccounts = new ArrayList<>();
        List<String> normalaccounts = new ArrayList<>();
        normalaccounts.add("00001_John_Smith___________A_00000.00_0003");
        wfile.testWriteNewMBA(changedaccounts, normalaccounts);
    }

    public void loop2Test2() {
        List<String> changedaccounts = new ArrayList<>();
        List<String> normalaccounts = new ArrayList<>();
        normalaccounts.add("00001_John_Smith___________A_00000.00_0003");
        changedaccounts.add("00002_ John_________________D_16672.26_0005");
        wfile.testWriteNewMBA(changedaccounts, normalaccounts);
    }

    public void loop2Test3() {
        List<String> changedaccounts = new ArrayList<>();
        List<String> normalaccounts = new ArrayList<>();
        normalaccounts.add("00001_John_Smith___________A_00000.00_0003");
        changedaccounts.add("00002_ John_________________D_16672.26_0005");
        changedaccounts.add("00003_John_Doe_____________D_00000.00_0010");
        wfile.testWriteNewMBA(changedaccounts, normalaccounts);
    }

    public void loop2Test4() {
        List<String> changedaccounts = new ArrayList<>();
        List<String> normalaccounts = new ArrayList<>();
        normalaccounts.add("00001_John_Smith___________A_00000.00_0003");
        normalaccounts.add("00002_ John_________________D_16672.26_0005");
        normalaccounts.add("00003_John_Doe_____________D_00000.00_0010");
        normalaccounts.add("00004_George_Ty____________A_39154.94_0001");
        changedaccounts.add("00005_George_Wagner________D_36736.70_0007");
        changedaccounts.add("00006_Jack_________________D_17584.26_0013");
        changedaccounts.add("00007_Mark_________________D_11643.78_0004");
        changedaccounts.add("00008_Moore________________A_48056.23_0005");
        wfile.testWriteNewMBA(changedaccounts, normalaccounts);
    }

    public void loop3Test1() {
        List<String> changedaccounts = new ArrayList<>();
        List<String> normalaccounts = new ArrayList<>();;
        wfile.testWriteNewMBA(changedaccounts, normalaccounts);
    }

    public void loop3Test2() {
        List<String> changedaccounts = new ArrayList<>();
        List<String> normalaccounts = new ArrayList<>();
        normalaccounts.add("00001_John_Smith___________A_00000.00_0003");
        wfile.testWriteNewMBA(changedaccounts, normalaccounts);
    }
    
    public void loop3Test3() {
        List<String> changedaccounts = new ArrayList<>();
        List<String> normalaccounts = new ArrayList<>();
        normalaccounts.add("00001_John_Smith___________A_00000.00_0003");
        normalaccounts.add("00002_ John_________________D_16672.26_0005");
        wfile.testWriteNewMBA(changedaccounts, normalaccounts);
    }

    public void loop3Test4() {
        List<String> changedaccounts = new ArrayList<>();
        List<String> normalaccounts = new ArrayList<>();
        normalaccounts.add("00001_John_Smith___________A_00000.00_0003");
        normalaccounts.add("00002_ John_________________D_16672.26_0005");
        normalaccounts.add("00003_John_Doe_____________D_00000.00_0010");
        normalaccounts.add("00004_George_Ty____________A_39154.94_0001");
        changedaccounts.add("00001_John_Smith___________A_00000.00_0003");
        changedaccounts.add("00002_ John_________________D_16672.26_0005");
        changedaccounts.add("00005_George_Wagner________D_36736.70_0007");
        changedaccounts.add("00006_Jack_________________D_17584.26_0013");
        wfile.testWriteNewMBA(changedaccounts, normalaccounts);
    }

    public void loop4Test1() {
        List<String> changedaccounts = new ArrayList<>();
        List<String> normalaccounts = new ArrayList<>();
        wfile.testWriteNewMBA(changedaccounts, normalaccounts);
    }

    public void loop4Test2() {
        List<String> changedaccounts = new ArrayList<>();
        List<String> normalaccounts = new ArrayList<>();
        normalaccounts.add("00001_John_Smith___________A_00000.00_0003");
        wfile.testWriteNewMBA(changedaccounts, normalaccounts);
    }

    public void loop4Test3() {
        List<String> changedaccounts = new ArrayList<>();
        List<String> normalaccounts = new ArrayList<>();
        normalaccounts.add("00001_John_Smith___________A_00000.00_0003");
        normalaccounts.add("00002_ John_________________D_16672.26_0005");
        wfile.testWriteNewMBA(changedaccounts, normalaccounts);
    }

    public void loop4Test4() {
        List<String> changedaccounts = new ArrayList<>();
        List<String> normalaccounts = new ArrayList<>();
        normalaccounts.add("00001_John_Smith___________A_00000.00_0003");
        normalaccounts.add("00002_ John_________________D_16672.26_0005");
        normalaccounts.add("00003_John_Doe_____________D_00000.00_0010");
        normalaccounts.add("00004_George_Ty____________A_39154.94_0001");
        changedaccounts.add("00005_George_Wagner________D_36736.70_0007");
        changedaccounts.add("00006_Jack_________________D_17584.26_0013");
        changedaccounts.add("00007_Mark_________________D_11643.78_0004");
        changedaccounts.add("00008_Moore________________A_48056.23_0005");
        wfile.testWriteNewMBA(changedaccounts, normalaccounts);
    }
    
}
