public class Account {
    protected double balance;

    public Account(double initBalance) {
        this.balance = initBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amt) {
        if (amt > 0) {
            balance += amt;
            return true;
        }
        return false;
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