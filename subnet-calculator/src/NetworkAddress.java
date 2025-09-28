import java.util.InputMismatchException;

public class NetworkAddress {
    private final String ipAddress;
    private final int prefixSubnetMask;
    private final int subnettingValue;

    public NetworkAddress(String ipAddress, int prefixSubnetMask, int subnettingValue) {
        this.ipAddress = ipAddress;
        this.prefixSubnetMask = prefixSubnetMask;
        this.subnettingValue = subnettingValue;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public int getPrefixSubnetMask() {
        return prefixSubnetMask;
    }

    public int getSubnettingValue() {
        return subnettingValue;
    }

    
    public static void validate(String ipAddress, int prefixSubnetMask, int subnettingValue)
            throws InputMismatchException {
        if (ipAddress == null || ipAddress.isEmpty()) {
            throw new InputMismatchException("IP address is required.");
        }
        String[] parts = ipAddress.split("\\.");
        if (parts.length != 4) {
            throw new InputMismatchException("IP must have 4 octets.");
        }
        for (String p : parts) {
            int v;
            try { v = Integer.parseInt(p); } catch (NumberFormatException e) { throw new InputMismatchException("Invalid IP octet."); }
            if (v < 0 || v > 255) throw new InputMismatchException("IP octet out of range.");
        }
        if (prefixSubnetMask < 0 || prefixSubnetMask > 32) {
            throw new InputMismatchException("Prefix must be 0..32.");
        }
        if (subnettingValue < 0 || subnettingValue > 32) {
            throw new InputMismatchException("Subnetting bits must be 0..32.");
        }
        if (prefixSubnetMask + subnettingValue > 32) {
            throw new InputMismatchException("Prefix + subnetting > 32.");
        }
    }
}
