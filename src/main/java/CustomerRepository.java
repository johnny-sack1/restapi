import java.util.HashMap;
import java.util.Map;

class CustomerRepository {
    private Map<Integer, Customer> customerRepository = new HashMap<>();

    int getSize() {
        return this.customerRepository.size();
    }

    void addCustomer(int id, String name, String city, String street, String zipcode) {
        this.customerRepository.put(id, new Customer(name, city, street, zipcode));
    }

    CustomerRepository() {
        addCustomer(1, "John", "New York", "Houston", "10-005");
        addCustomer(2, "Janusz", "Warsaw", "Jagiellonska", "20-006");
        addCustomer(3, "Pierre", "Paris", "Saint Vincent", "30-007");
        addCustomer(4, "Hans", "Berlin", "Heerstrasse", "40-008");
    }

    Customer getCustomerById(int id) {
        return this.customerRepository.get(id);
    }
}
