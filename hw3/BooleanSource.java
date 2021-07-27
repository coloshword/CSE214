public class BooleanSource {
    private double probability;
    
    /**
     * Constructor for the BooleanSource class
     * @param a the double to be assigned to the probability variable
     */
    public BooleanSource(double a) throws IllegalArgumentException {
        if(a < 0.0 || a > 1.0) {
            throw new IllegalArgumentException("Probability has to be positive and less than or equal to 1.0");
        }
        probability = a;
    }

    public boolean requestArrived() {
        return (Math.random() < getProbability());
    }

    public double getProbability() {
        return probability;
    }
}
