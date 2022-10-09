import java.util.ArrayList;
import java.util.List;

public class Calc {
    int peopleCount;
    List<Product> products = new ArrayList<Product>();

    public Calc(int count) {
        this.peopleCount = count;
    }

    public void add(Product product) {
        products.add(product);
    }

    public String getAllProductNames() {
        StringBuilder res = new StringBuilder();

        for(int i = 0; i < products.size(); i++) {
            Product product = products.get(i);

            if (i > 0) res.append(" ");

            res.append(product.name);
        }

        return res.toString();
    }

    public double getTotalPrice() {
        double res = 0;

        for(int i = 0; i < products.size(); i++) {
            Product product = products.get(i);

            res += product.price;
        }

        return res;
    }

    public double getPricePerPerson() {
        return getTotalPrice() / peopleCount;
    }
}
