import model.Customer;

public class Driver {
    public static void main(String[] args){
        Customer customer = new Customer("first", "second", "j@gmail.com");
        System.out.println(customer);
        customer = new Customer("first", "second", "email");
        System.out.println(customer);
    }
}
