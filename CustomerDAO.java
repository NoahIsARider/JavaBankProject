
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private static final String FILE_NAME = "customers.dat";

    public void saveCustomers(List<Customer> customers) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(customers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> loadCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            customers = (List<Customer>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return customers;
    }
}

