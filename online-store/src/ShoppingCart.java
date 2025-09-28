import java.util.Map;
import java.util.HashMap;

public class ShoppingCart {
    private Map<String, Item> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    public void add(String product, int price) {
        if (this.items.containsKey(product)) {
            this.items.get(product).increaseQuantity();
        } else {
            this.items.put(product, new Item(product, 1, price));
        }
    }

    // total price for cart
    public int getPrice() {
        int total = 0;
        for (Item item : this.items.values()) {
            total += item.getPrice();
        }
        return total;
    }

    public void print() {
        for (Item item : this.items.values()) {
            System.out.println(item);
        }
    }
}
