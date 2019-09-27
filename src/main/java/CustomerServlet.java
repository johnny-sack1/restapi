import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerServlet extends HttpServlet {
    private Gson gson = new Gson();
    private CustomerRepository repository = new CustomerRepository();

    private Integer getUriIndex(String URI) {
        String[] splittedURI = URI.split("/");
        if (splittedURI.length < 3) return null;
        else return Integer.parseInt(splittedURI[2]);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer customerId = getUriIndex(req.getRequestURI());

        Customer customer = repository.getCustomerById(customerId);
        resp.getWriter().write(gson.toJson(customer));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = this.repository.getSize() + 1;
        String name = req.getParameter("name");
        String city = req.getParameter("city");
        String street = req.getParameter("street");
        String zipcode = req.getParameter("zipcode");

        this.repository.addCustomer(id, name, city, street, zipcode);

        resp.getWriter().write("Customer added.");
    }
}
