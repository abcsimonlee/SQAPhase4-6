package UserAccounts;

public class User { // This class stores all the data relevant to a single user
    private String accountname;
    private String accountnum;
    private String paymentplan;

    public float balance;

    public User(String accountname, String accountnum, String paymentplan) {
        this.accountname = accountname;
        this.accountnum = accountnum;
        this.paymentplan = paymentplan;
    }

    public String getAccountName() {
        return accountname;
    }

    public String getAccountNum() {
        return accountnum;
    }

    public String getPaymentPlan() {
        return paymentplan;
    }

    public void calculateDailyCost() {
        if (this.paymentplan == "NP") {
            balance += 0.10;
        }

        else if (this.paymentplan == "SP") {
            balance += 0.05;
        }
    }

    

}
