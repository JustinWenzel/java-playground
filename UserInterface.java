public class UserInterface{
    private Scanner scanner;
    private SubnetCalculator calculator;
    private NetworkAdress networkAdress;

    public UserInterface(Scanner scanner, SubnetCalculator calculator){
        this.scanner = scanner;
        this.calculator = calculator;
    }


    public void startProgram(){
        while (true){
            
            System.out.println("Choose an option:");
            System.out.println("1: Exit program");
            System.out.println("2: Calculate a IPv4 Adress");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
            case 1:
                System.println("Exiting program")
                break;
            case 2:
                this.defineIP();

            default:
                System.out.println("Please choose one of the options!");
                continue;
        }

        

        

        

        }

    }

    public void defineIP(){
        while (true){

            System.out.println("Give your IPv4Address:");
            String ipAdress = scanner.nextLine();

            System.out.println("Give the prefix of your subnet mask (/x):");
            double prefixSubnetMask = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Give your desired subnetting:");
            double subnettingValue = scanner.nextDouble();
            scanner.nextLine();

        
            try (this.networkAdress.validate(ipAdress, prefixSubnetMask, subnettingValue)){
                this.networkAdress = new NetworkAdress(ipAdress, prefix, subnettingValue);

            } catch (InputMissmatchException e){
                System.out.println(e);
                continue;
            }
        }
    }




    

}