import java.util.Scanner;

public class TerminalUI {
    private final Warehouse warehouse;
    private final Scanner scanner;

    public TerminalUI(Warehouse warehouse, Scanner scanner) {
        this.warehouse = warehouse;
        this.scanner = scanner;
    }

    public void start(String customer) {
        ShoppingCart cart = new ShoppingCart();
        System.out.println("Welcome, " + customer + "!");
        System.out.println("Type 'help' to see available commands.");
        boolean running = true;
        while (running) {
            System.out.print("> ");
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] parts = line.split("\\s+", 2);
            String cmd = parts[0].toLowerCase();
            String arg = parts.length > 1 ? parts[1] : "";
            switch (cmd) {
                case "help":
                    printHelp();
                    break;
                case "list":
                    listProducts();
                    break;
                case "add":
                    if (!arg.isEmpty()) addToCart(cart, arg);
                    else System.out.println("Usage: add <product>");
                    break;
                case "cart":
                    cart.print();
                    break;
                case "total":
                    System.out.println("Total: " + cart.price());
                    break;
                case "checkout":
                    System.out.println("your shoppingcart contents:");
                    cart.print();
                    System.out.println("total: " + cart.price());
                    running = false;
                    break;
                case "stock":
                    listProducts();
                    break;
                case "quit":
                case "exit":
                    running = false;
                    break;
                default:
                    System.out.println("Unknown command");
            }
        }
    }

    private void printHelp() {
        System.out.println("help");
        System.out.println("list");
        System.out.println("add <product>");
        System.out.println("cart");
        System.out.println("total");
        System.out.println("stock");
        System.out.println("checkout");
        System.out.println("quit | exit");
    }

    private void listProducts() {
        for (String product : warehouse.products()) {
            System.out.println(product + " (price: " + warehouse.price(product) + ", stock: " + warehouse.stock(product) + ")");
        }
    }

    private void addToCart(ShoppingCart cart, String product) {
        int unitPrice = warehouse.price(product);
        if (unitPrice == -99) {
            System.out.println("No such product: " + product);
            return;
        }
        if (!warehouse.take(product)) {
            System.out.println("Out of stock: " + product);
            return;
        }
        cart.add(product, unitPrice);
        System.out.println("Added: " + product);
    }
}
