package service;

import model.Customer;

import java.util.Collection;

public class CustomerService {
    private static CustomerService INSTANCE;

    public CustomerService() {
    }

    public static CustomerService getInstance() {
        if (INSTANCE == null){
            INSTANCE = new CustomerService();
        }
        return INSTANCE;
    }

    public void addCustomer(String email, String firstName, String lastName) {

    }

    public Customer getCustomer(String customerEmail) {

        return null;
    }

    public Collection<Customer> getAllCustomers(){
        return null;
    }
}
