public class OverdraftException extends Exception {
    double amt;
    double balance;
    public OverdraftException(double amt,double balance) {
        super();
        this.amt=amt;
        this.balance=balance;
    }

    public double getDeficit(){
        return amt-balance;
    }
}
