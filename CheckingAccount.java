public class CheckingAccount extends Account {
    private double overdraftProtection;

    public CheckingAccount(double balance) {
        super(balance);
        this.overdraftProtection = 0; // Default overdraft protection
    }
public CheckingAccount(double balance, double protect) {
    super(balance);
    this.overdraftProtection = protect;
}

public double getOverdraftProtection() {
    return overdraftProtection;
}

    public boolean withdraw(double amt) throws OverdraftException {
        if (amt > 0 && amt <= balance) {
            balance -= amt;
            return true;
        } else if (amt > balance) {
            throw new OverdraftException(amt,balance);
        }
        return false;
    }
}