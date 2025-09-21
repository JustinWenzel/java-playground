import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;
    private final SubnetCalculator calculator;

    public UserInterface(Scanner scanner, SubnetCalculator calculator) {
        this.scanner = scanner;
        this.calculator = calculator;
    }

    public void startProgram() {
        boolean running = true;
        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1: Exit program");
            System.out.println("2: Calculate subnets");
            String choice = scanner.nextLine().trim();

            if ("1".equals(choice)) {
                running = false;
            } else if ("2".equals(choice)) {
                handleCalculation();
            } else {
                System.out.println("Unknown option. Try again.");
            }
        }
        System.out.println("Bye!");
    }

    private void handleCalculation() {
        System.out.println("Give your IP address (e.g., 192.168.1.0):");
        String ip = scanner.nextLine().trim();

        System.out.println("Give your prefix (CIDR, e.g., 24):");
        int prefix;
        try { prefix = Integer.parseInt(scanner.nextLine().trim()); }
        catch (NumberFormatException e) { System.out.println("Invalid number."); return; }

        System.out.println("Give your desired subnetting bits (e.g., 2):");
        int subBits;
        try { subBits = Integer.parseInt(scanner.nextLine().trim()); }
        catch (NumberFormatException e) { System.out.println("Invalid number."); return; }

        try {
            NetworkAddress.validate(ip, prefix, subBits);
            NetworkAddress na = new NetworkAddress(ip, prefix, subBits);
            calculator.calculate(na);
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }
}
