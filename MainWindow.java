//import java.util.ArrayList;
//import java.util.List;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.util.stream.Collectors;
//public class MainWindow extends JFrame {
//    private JList<Customer> customerList;
//    private DefaultListModel<Customer> listModel;
//    private JTextField searchField;
//    private Bank bank;
//
//    public MainWindow() {
//        bank = Bank.getBank();
//
//        setTitle("Bank Program");
//        setSize(600, 300);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(new BorderLayout());
//
//        listModel = new DefaultListModel<>();
//        customerList = new JList<>(listModel);
//        add(new JScrollPane(customerList), BorderLayout.CENTER);
//
//        JPanel panel = new JPanel();
//        panel.setLayout(new FlowLayout());
//
//        searchField = new JTextField(20);
//        panel.add(searchField);
//
//        JButton addButton = new JButton("ADD");
//        addButton.addActionListener(this::addCustomer);
//        panel.add(addButton);
//
//        JButton delButton = new JButton("DEL");
//        delButton.addActionListener(this::deleteCustomer);
//        panel.add(delButton);
//
//        JButton searchButton = new JButton("SEARCH");
//        searchButton.addActionListener(this::searchCustomer);
//        panel.add(searchButton);
//
//        JButton sortButton = new JButton("SORT");
//        sortButton.addActionListener(this::sortCustomers);
//        panel.add(sortButton);
//
//        add(panel, BorderLayout.SOUTH);
//        updateCustomerList();
//    }
//
//    private void addCustomer(ActionEvent e) {
//        String searchName = searchField.getText();
//// 将输入的姓名按空格分割成数组
//        String[] names = searchName.split(" ");
//// 最后一个元素作为lastName
//        String lastName = names[names.length - 1];
//// 其余的部分（包括中间名）合并作为firstName
//        StringBuilder firstNameBuilder = new StringBuilder();
//        for (int i = 0; i < names.length - 1; i++) {
//            firstNameBuilder.append(names[i]);
//            if (i < names.length - 2) { // 在最后一个名字之前添加空格
//                firstNameBuilder.append(" ");
//            }
//        }
//        String firstName = firstNameBuilder.toString();
//        if (lastName != null) {
//            bank.addCustomer(firstName, lastName);
//            updateCustomerList();
//            bank.saveCustomers();
//        }
//    }
//
//    private void deleteCustomer(ActionEvent e) {
//        if (customerList.getSelectedIndex() != -1) {
//            int index = customerList.getSelectedIndex();
//            Customer customer = customerList.getSelectedValue();
//            bank.getCustomers().remove(index);
//            updateCustomerList();
//            bank.saveCustomers();
//        }
//    }
//
//    private void searchCustomer(ActionEvent e) {
//        String searchName = searchField.getText();
//        if (searchName != null && !searchName.isEmpty()) {
//            List<Customer> foundCustomers = bank.searchCustomers(searchName);
//            updateCustomerList(foundCustomers);
//        } else {
//            updateCustomerList(bank.getCustomers());
//        }
//    }
//
//    private void sortCustomers(ActionEvent e) {
//        bank.sortCustomer();
//        updateCustomerList(bank.getCustomers());
//    }
//
//    private void updateCustomerList(List<Customer> customers) {
//        listModel.clear();
//        for (Customer customer : customers) {
//            listModel.addElement(customer);
//        }
//    }
//
//    private void updateCustomerList() {
//        listModel.clear();
//        for (Customer customer : bank.getCustomers()) {
//            listModel.addElement(customer);
//        }
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> new MainWindow().setVisible(true));
//    }
//}
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {
    private JList<Customer> customerList;
    private DefaultListModel<Customer> listModel;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private Bank bank;

    public MainWindow() {
        bank = Bank.getBank();

        setTitle("Bank Program");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        listModel = new DefaultListModel<>();
        customerList = new JList<>(listModel);
        JScrollPane customerScrollPane = new JScrollPane(customerList);
        add(customerScrollPane, BorderLayout.WEST);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(createTextFieldPanel(), BorderLayout.NORTH);
        rightPanel.add(createButtonPanel(), BorderLayout.SOUTH);

        add(rightPanel, BorderLayout.EAST);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, customerScrollPane, rightPanel);
        splitPane.setDividerLocation(400);
        splitPane.setResizeWeight(0.5);

        add(splitPane);
        updateCustomerList();
    }

    private JPanel createTextFieldPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(new JLabel("First Name:"));
        firstNameField = new JTextField(20);
        panel.add(firstNameField);

        panel.add(new JLabel("Last Name:"));
        lastNameField = new JTextField(20);
        panel.add(lastNameField);

        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addButton = new JButton("ADD");
        addButton.addActionListener(this::addCustomer);
        panel.add(addButton);

        JButton delButton = new JButton("DEL");
        delButton.addActionListener(this::deleteCustomer);
        panel.add(delButton);

        JButton searchButton = new JButton("SEARCH");
        searchButton.addActionListener(this::searchCustomer);
        panel.add(searchButton);

        JButton sortButton = new JButton("SORT");
        sortButton.addActionListener(this::sortCustomers);
        panel.add(sortButton);

        return panel;
    }

    private void addCustomer(ActionEvent e) {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        if (!firstName.isEmpty() && !lastName.isEmpty()) {
            bank.addCustomer(firstName, lastName);
            updateCustomerList();
            bank.saveCustomers();
        }
    }

    private void deleteCustomer(ActionEvent e) {
        if (customerList.getSelectedIndex() != -1) {
            int index = customerList.getSelectedIndex();
            Customer customer = customerList.getSelectedValue();
            bank.getCustomers().remove(index);
            updateCustomerList();
            bank.saveCustomers();
        }
        String searchFirstName = firstNameField.getText();
        String searchLastName = lastNameField.getText();
    }

    private void searchCustomer(ActionEvent e) {
        String searchFirstName = firstNameField.getText();
        String searchLastName = lastNameField.getText();
        if (searchFirstName != null &&searchLastName != null ) {
            List<Customer> foundCustomers = bank.searchCustomers(searchFirstName,searchLastName);
            updateCustomerList(foundCustomers);
        } else {
            updateCustomerList(bank.getCustomers());
        }
    }

    private void sortCustomers(ActionEvent e) {
        bank.sortCustomer();
        updateCustomerList(bank.getCustomers());
    }

    private void updateCustomerList(List<Customer> customers) {
        listModel.clear();
        for (Customer customer : customers) {
            listModel.addElement(customer);
        }
    }

    private void updateCustomerList() {
        listModel.clear();
        for (Customer customer : bank.getCustomers()) {
            listModel.addElement(customer);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainWindow().setVisible(true));
    }
}