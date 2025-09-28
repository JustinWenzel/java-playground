import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SubnetCalculator calculator = new SubnetCalculator();
        UserInterface ui = new UserInterface(scanner, calculator);
        ui.startProgram();
    }
}

