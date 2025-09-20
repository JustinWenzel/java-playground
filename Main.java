import java.util.Scanner;

public class SubnetCaculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SubnetCaculator calculator = new SubnetCaculator();

        UserInterface interface = new UserInterface(scanner, calculator);
        interface.startProgram;
    }
}       

       

        




    private static void ipv4Berechnung(Scanner scanner) {
        

        if (präfixSubnetzmaske < 0 || präfixSubnetzmaske > 32) {
            System.out.println("Fehler: Ungültige Subnetzmaske. Bitte gib einen Wert zwischen 0 und 32 ein.");
            return;
        }


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

    
}
