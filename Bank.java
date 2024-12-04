import java.util.ArrayList;
import java.util.List;
//
//public class Bank {
//    private List<Customer> customers;
//    private static int customerCount = 0;
//    public Bank getBank(){
//        return new Bank();
//    }
//    public Bank() {
//        customers = new ArrayList<>();
//    }
//
//    public void addCustomer(String f, String l) {
//        Customer newCustomer = new Customer(f, l);
//        customers.add(newCustomer);
//        customerCount++;
//    }
//
//    public int getNumOfCustomers() {
//        return customers.size();
//    }
//
//    public Customer getCustomer(int index) {
//        if (index >= 0 && index < customers.size()) {
//            return customers.get(index);
//        }
//        return null;
//    }
//}
//
//import java.util.ArrayList;
//import java.util.List;
//
//// 银行类 - 单例类
//class Bank {
//    private static Bank instance;
//    private List<Customer> customers;
//    private Bank() {
//        customers = new ArrayList<>();
//    }
//
//    // 提供一个公共的静态方法来获取实例
//    public static Bank getBank() {
//        if (instance == null) {
//            instance = new Bank();
//        }
//        return instance;
//    }
//
//    public void addCustomer(Customer customer) {
//        customers.add(customer);
//    }
//
//    public void addCustomer(String f, String l) {
//        Customer newCustomer = new Customer(f, l);
//        customers.add(newCustomer);
//    }
//
//    public int getNumOfCustomers() {
//        return customers.size();
//    }
//    public List<Customer> getCustomers() {
//        return customers;
//    }
//
//    public Customer getCustomer(int index) {
//        if (index >= 0 && index < customers.size()) {
//            return customers.get(index);
//        }
//        return null;
//    }
//
//    public void sortCustomer() {
//        customers.sort(null);
//    }
//
//    public List<Customer> searchCustomers(String name) {
//        List<Customer> foundCustomers = new ArrayList<>();
//        for (Customer customer : customers) {
//            if (customer.getFirstName().equals(name) || customer.getLastName().equals(name)) {
//                foundCustomers.add(customer);
//            }
//        }
//        return foundCustomers;
//    }
//}
// 文件路径: Bank.java

public class Bank {
    private static Bank instance;
    private List<Customer> customers;
    private CustomerDAO customerDAO;

    private Bank() {
        customers = new ArrayList<>();
        customerDAO = new CustomerDAO();
        customers = customerDAO.loadCustomers();
    }

    public static Bank getBank() {
        if (instance == null) {
            instance = new Bank();
        }
        return instance;
    }

    public void addCustomer(String f, String l) {
        Customer newCustomer = new Customer(f, l);
        customers.add(newCustomer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }


    public Customer getCustomer(int index) {
        if (index >= 0 && index < customers.size()) {
            return customers.get(index);
        }
        return null;
    }


    public void sortCustomer() {
        customers.sort(null);
    }

    public List<Customer> searchCustomers(String firstname,String lastname) {
        List<Customer> foundCustomers = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getFirstName().equals(firstname) && customer.getLastName().equals(lastname)) {
                foundCustomers.add(customer);
            }
        }
        return foundCustomers;
    }

    public int getNumOfCustomers() {
        return customers.size();
    }

    public void saveCustomers() {
        customerDAO.saveCustomers(customers);
    }
}