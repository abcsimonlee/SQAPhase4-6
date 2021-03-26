package UserAccounts;

public class User {
    private String accountname;
    private String accountnum;
    private String paymentplan;

    public float balance;

    public User(String accountname, String accountnum, String paymentplan) {
        this.accountname = accountname;
        this.accountnum = accountnum;
        this.paymentplan = paymentplan;
    }

    public String GetAccountName() {
        return accountname;
    }

    public String GetAccountNum() {
        return accountnum;
    }

    public String GetPaymentPlan() {
        return paymentplan;
    }

    public void CalculateDailyCost() {
        if (this.paymentplan == "NP") {
            balance += 0.10;
        }

        else if (this.paymentplan == "SP") {
            balance += 0.05;
        }
    }

    

}
