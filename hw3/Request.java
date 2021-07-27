public class Request {
    private int sourceFloor;
    private int destinationFloor;
    private int timeEntered;
    
    /**
     * Constructor for the Request class
     * @param a the number of floors in the building used to determine the values of sourceFloor and destinationFloor
     */
    public Request(int a) {
        //create a random number between 1 and the number of floors, inclusive
        sourceFloor = (int)(Math.random() * a + 1);
        while(true) {
            destinationFloor =  (int)(Math.random() * a + 1);
            if(destinationFloor != sourceFloor) {
                break;
            }
        }
    }
    
    // Acessor methods 
    /**
     * Access method of sourceFloor variable 
     * @return The value of the sourceFloor variable 
     */
    public int getSourceFloor() {
        return sourceFloor;
    }

    /**
     * Access method of the destinationFloor variable
     * @return the value of the destinationFloor variable 
     */
    public int getDestinationFloor() {
        return destinationFloor;
    }

    /**
     * Access method of the timeEntered variable
     * @return the value of the destinationFloor variable 
     */
    public int getTimeEntered() {
        return timeEntered;
    }

    //Mutator methods
    /**
     * Mutator method for the sourceFloor variable
     * @param a the int to be assigned to the sourceFloor variable 
     */
    public void setSourceFloor(int a) {
        sourceFloor = a;
    }

    /**
     * Mutator method of the destinationFloor variable
     * @param a the int to be assigned to the destinationFloor variable
     */
    public void setDestinationFloor(int a) {
        destinationFloor = a;
    }

    /**
     * Mutator method for the timeEntered variable
     * @param a the int to be assigned to the timeEntered variable
     */
    public void setTimeEntered(int a) {
        timeEntered = a;
    }

    // helper methods 
    /**
     * toString method to print the directions of request 
     * @return a string with sourceFloor, destinationFloor, and timeEntered
     */
    public String toString() {
        return String.format("(%d, %d, %d)", getSourceFloor(), getDestinationFloor(), getTimeEntered());
    }
}