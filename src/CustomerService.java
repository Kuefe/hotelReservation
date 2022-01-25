import model.Customer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {
    Map<String, Customer> customers = new HashMap<String, Customer>();

    private static CustomerService INSTANCE;

    static CustomerService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CustomerService();
        }
        return INSTANCE;
    }

    void addCustomer(String email, String firstName, String lastName) {
        Customer customer = new Customer(firstName, lastName, email);
        customers.put(email, customer);
    }

    Customer getCustomer(String customerEmail) {
        return customers.get(customerEmail);
    }

    Collection<Customer> getAllCustomers() {
        return customers.values();
    }
}
