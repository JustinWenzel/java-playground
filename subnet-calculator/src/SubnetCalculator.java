public class SubnetCalculator {

    public void calculate(NetworkAddress na) {
        
        int newPrefix = na.getPrefixSubnetMask() + na.getSubnettingValue();

        // Parse dotted IP to 32-bit
        String[] parts = na.getIpAddress().split("\\.");
        int w = Integer.parseInt(parts[0]);
        int x = Integer.parseInt(parts[1]);
        int y = Integer.parseInt(parts[2]);
        int z = Integer.parseInt(parts[3]);
        long ip = ((long) w << 24) | ((long) x << 16) | ((long) y << 8) | (long) z;

        long mask = (newPrefix == 0) ? 0 : (0xFFFFFFFFL << (32 - newPrefix)) & 0xFFFFFFFFL;
        long networkId = ip & mask;

        System.out.println("IP: " + na.getIpAddress());
        System.out.println("Base prefix: /" + na.getPrefixSubnetMask());
        System.out.println("Subnetting bits: " + na.getSubnettingValue());
        System.out.println("New prefix: /" + newPrefix);
        System.out.println("Subnet mask: " + toDotted(mask));
        System.out.println("Network ID: " + toDotted(networkId) + "/" + newPrefix);
    }

    private static String toDotted(long value) {
        long a = (value >>> 24) & 0xFF;
        long b = (value >>> 16) & 0xFF;
        long c = (value >>> 8)  & 0xFF;
        long d = value & 0xFF;
        return a + "." + b + "." + c + "." + d;
    }
}
