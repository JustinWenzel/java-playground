public class NetworkAdress{
    private String ipAdress;
    private double prefixSubnetMask;

    public NetworkAdress(String ipAdress, double prefixSubnetMask, subnettingValue){
        this.ipAdress = ipAdress;
        this.subnetMask = subnetMask;
    }


    public String getIPAdress(){
        return this.ipAdress;
    }

    public String getSubnetMask(){
        return this.subnetMask;
    }

    public boolean validate(String ipAdress, double prefixSubnetMask, double subnettingValue)
        if (prefixSubnetMask < 0 || prefixSubnetMask > 32) {
            System.out.println("Prefix of subnet mask can only be between 0 - 32!");
            return false;
        }
    
}