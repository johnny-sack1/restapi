import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<String> address = new ArrayList<>();

    public Customer(String name, String city, String street, String zipcode) {
        this.name = name;
        this.address.add(city);
        this.address.add(street);
        this.address.add(zipcode);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }
}
