import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Warehouse {
    private Map<String, Integer> prices;
    private Map<String, Integer> stocks;

    public Warehouse() {
        this.prices = new HashMap<>();
        this.stocks = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        this.prices.put(product, price);
        this.stocks.put(product, stock);
    }

    // accessors following Java naming conventions
    public int getPrice(String product) {
        return this.prices.getOrDefault(product, -99);
    }

    public int getStock(String product) {
        return this.stocks.getOrDefault(product, 0);
    }

    public boolean take(String product) {
        int current = this.stocks.getOrDefault(product, 0);
        if (current > 0) {
            this.stocks.put(product, current - 1);
            return true;
        }
        return false;
    }

    public Set<String> getProducts() {
        return this.prices.keySet();
    }
}
