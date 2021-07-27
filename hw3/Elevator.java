public class Elevator {
    // Constants
    final int IDLE = 0;
    final int TO_SOURCE = 1;
    final int TO_DESTINATION = 2;
    // member variables 
    private int currentFloor;
    private int elevatorState;
    private Request request;

    // constructor
    public Elevator() {
        request = null;
        elevatorState = IDLE;
        currentFloor = 1;
    }

    //accessor methods
    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getElevatorState() {
        return elevatorState;
    }

    public Request getRequest() {
        return request;
    }

    // mutator methods
    public void setCurrentFloor(int a) {
        currentFloor = a;
    }

    public void setElevatorState(int a) {
        elevatorState = a;
    }

    public void setRequest(Request a) {
        request = a;
    }

    //helper methods
    public boolean isIDLE() {
        return (getElevatorState() == IDLE);
    }

    public boolean isHeadedSource() {
        return (getElevatorState() == TO_SOURCE);
    }

    public boolean isHeadedDestination() {
        return (getElevatorState() == TO_DESTINATION);
    }

    public String toString() {
        String state = "";
        String directions = "---";
        if(getElevatorState() == IDLE) {
            state = "IDLE";
        }
        else if(getElevatorState() == TO_SOURCE) {
            state = "TO_SOURCE";
            directions = getRequest().toString();
        }
        else {
            state = "TO_DESTINATION";
            directions = getRequest().toString();
        }
        String ans = String.format("[Floor %d, %s, %s]", getCurrentFloor(), state, directions);
        return ans; 
    }
    
}
