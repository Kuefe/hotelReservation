package model;

import java.util.regex.Pattern;

public class Customer {
    private String emailRegex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    private final Pattern pattern = Pattern.compile(emailRegex);

    private String firstName;
    private String lastName;
    private String email;

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (!pattern.matcher(email).matches()){
            throw new IllegalArgumentException("Please enter a correct email-address");
        } else {
            this.email = email;
        }
    }

    @Override
    public String toString() {
        return "Firstname: " + firstName + " LastName: " + lastName + " Email: " + email;
    }

}