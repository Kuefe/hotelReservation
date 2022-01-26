package model;

import java.util.Objects;
import java.util.regex.Pattern;

public class Customer {
    private final String emailRegex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    private final Pattern pattern = Pattern.compile(emailRegex);

    private String firstName;
    private String lastName;
    private String email;

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (!pattern.matcher(email).matches()) {
            throw new IllegalArgumentException("Please enter a correct email-address");
        } else {
            this.email = email;
        }
    }

    @Override
    public final String toString() {
        return "Firstname: " + firstName + " LastName: " + lastName + " Email: " + email;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final String getLastName() {
        return lastName;
    }

    public final String getEmail() {
        return email;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public final boolean equals(Object obj) {
        Customer customer = (Customer) obj;
        if (customer.equals(email)) {
            return true;
        } else{
            return false;
        }
    }

}