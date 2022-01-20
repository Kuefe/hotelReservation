package service;

import model.Customer;

import java.util.Collection;

public class CustomerService {
    // Static variable reference of single_instance
    // of type Singleton
    private static CustomerService customerService = null;

    public CustomerService() {
    }

    // Static method
    // Static method to create instance of Singleton class
    public static CustomerService getInstance()
    {
        if (customerService == null)
            customerService = new CustomerService();

        return customerService;
    }

    public void addCustomer(String email, String firstName, String lastName) {

    }

    public void getCustomer(String customerEmail) {

    }

    public Collection<Customer> getAllCustomers(){
        return null;
    }
}
