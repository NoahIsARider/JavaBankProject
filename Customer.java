import java.util.ArrayList;
import java.util.List;
import java.lang.Comparable;
import java.io.Serializable;
// 客户类
class Customer implements Comparable<Customer>,Serializable
{
    protected String firstName;
    protected String lastName;
    protected List<Account> accounts;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public Account getAccount(int index) {
        if (index >= 0 && index < accounts.size()) {
            return accounts.get(index);
        }
        return null;
    }

    public int getNumOfAccounts(){
        return accounts.size();
    }

    @Override
    //注意String类型本身有一个compareTo方法
    public int compareTo(Customer other) {
        int last_name_comparison = this.lastName.compareTo(other.lastName);
        if (last_name_comparison != 0) {
            return last_name_comparison;
        }
        return this.firstName.compareTo(other.firstName);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}