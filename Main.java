import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wähle die IP-Version:");
        System.out.println("1: IPv4");
        System.out.println("2: IPv6");

        int auswahl = scanner.nextInt();
        scanner.nextLine();

        switch (auswahl) {
            case 1:
                ipv4Berechnung(scanner);
                break;
            case 2:
                ipv6Berechnung(scanner);
                break;
            default:
                System.out.println("Ungültige Auswahl.");
        }
    }




    private static void ipv4Berechnung(Scanner scanner) {
        System.out.println("Gebe deine Ausgangs-IPv4-Adresse an:");
        String ipAdresse = scanner.nextLine();

        System.out.println("Gebe deine Subnetzmaske /x an:");
        double präfixSubnetzmaske = scanner.nextDouble();
        scanner.nextLine();

        if (präfixSubnetzmaske < 0 || präfixSubnetzmaske > 32) {
            System.out.println("Fehler: Ungültige Subnetzmaske. Bitte gib einen Wert zwischen 0 und 32 ein.");
            return;
        }

        System.out.println("Gebe das gewünschte Subnetting an:");
        double subnettingWert = scanner.nextDouble();
        scanner.nextLine();

        double präfixMitSubnettingWert = präfixSubnetzmaske + subnettingWert;

        if (präfixMitSubnettingWert > 32) {
            System.out.println("Die resultierende Subnetzmaske überschreitet 32.");
            return;
        }

        String[] bitIp = ipAdresse.split("\\.");
        if (bitIp.length != 4) {
            System.out.println("Eine Netz-ID hat vier Oktette.");
        }

        double w = Double.parseDouble(bitIp[0]);
        double x = Double.parseDouble(bitIp[1]);
        double y = Double.parseDouble(bitIp[2]);
        double z = Double.parseDouble(bitIp[3]);

        long ipDeszimalInsgesamt = (long) (w * Math.pow(256, 3) + x * Math.pow(256, 2) + y * Math.pow(256, 1) + z);

        double hostBits = 32 - präfixMitSubnettingWert;
        double hostBitSpruenge = Math.pow(2, hostBits);
        double anzahlSubnetze = Math.pow(2, subnettingWert);

// Netz-ID-Prüfung. 32 Bit Zahl wird um Hostbits verschoben, sodass rechts nur Nullen stehen
        long bitsPrüfenmitSubnetzmaske = 0xFFFFFFFFL << (int) (32 - präfixSubnetzmaske);

        if ((ipDeszimalInsgesamt & bitsPrüfenmitSubnetzmaske) != ipDeszimalInsgesamt) {
            System.out.println("Keine gültige Netz-ID");
            return;
        } else {

            long[] netzIDsDezimal = new long[(int) anzahlSubnetze];

            System.out.println("Berechnete Subnetz-Adressen:");
            for (int i = 0; i < netzIDsDezimal.length; i++) {
                netzIDsDezimal[i] = ipDeszimalInsgesamt + (long) (i * hostBitSpruenge);

                long zahl = netzIDsDezimal[i];

                long oktett4 = zahl % 256;
                zahl = zahl / 256;

                long oktett3 = zahl % 256;
                zahl = zahl / 256;

                long oktett2 = zahl % 256;
                zahl = zahl / 256;

                long oktett1 = zahl % 256;

                System.out.println(oktett1 + "." + oktett2 + "." + oktett3 + "." + oktett4 + "/" + präfixMitSubnettingWert);
            }
        }
    }

    private static void ipv6Berechnung(Scanner scanner) {
        System.out.println("Gebe deine Ausgangs-IPv6-Adresse ein");
        String ipv6Adresse = scanner.nextLine();

        System.out.println("Gebe das Präfix an.");
        int praefix = scanner.nextInt();
        scanner.nextLine();

        if (praefix < 0 || praefix > 128) {
            System.out.println("Ungültiges Präfix.");
            return;
        }

        System.out.println("Gebe das gewünschte Subnetting an.");
        int subnetting = scanner.nextInt();
        scanner.nextLine();

        int neuesPraefix = praefix + subnetting;
        if (neuesPraefix > 128) {
            System.out.println("Die resultierende Präfixlänge überschreitet 128.");
            return;
        }



        String[] blocks = ipv6Adresse.split(":");
        int subnets = (int) Math.pow(2, subnetting);

        //Welcher Block
        int blockIndex = neuesPraefix / 16;


    }
}
