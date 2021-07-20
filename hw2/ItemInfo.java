public class ItemInfo {
    private String rfidTagNumber;
    private String originalLocation;
    private String currentLocation;
    
    /**
     * Arg constructor for the ItemInfo class 
     * @param a
     * @param b
     * @param c
     */
    public ItemInfo(String a, String b, String c) {
        rfidTagNumber = a;
        originalLocation = b;
        currentLocation = c;
    }

    // accessor methods
    public String getRfidTagNumber() {
        return rfidTagNumber;
    }

    public String getOriginalLocation() {
        return originalLocation;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    // mutator methods
    public void setRfidTagNumber(String a) {
        rfidTagNumber = a;
    }

    public void setOriginalLocation(String a) {
        originalLocation = a;
    }

    public void setCurrentLocation(String a) {
        currentLocation = a;
    }
}
