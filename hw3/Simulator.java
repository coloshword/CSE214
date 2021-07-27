public class Simulator {
    
    // constructor
    public Simulator() {}
    public static void Simulate(double probability, int numFloors, int numElevators, int timeSimulation) {
        //DEBUG VARIABLE
        boolean debug = true;
        // create the relevant classes
        RequestQueue queue = new RequestQueue();
        BooleanSource isTrue = new BooleanSource(probability);
        Elevator[] listElevators = new Elevator[numElevators];
        // create the list of elevators
        for(int i = 0; i < numElevators; i++) {
            listElevators[i] = new Elevator();
        }
        // run the simulation
        for(int i = 0; i < timeSimulation; i++) {
            // beginning of each time unit, chance that a new request will be placed
            if(isTrue.requestArrived()) {
                // that means we need to create a new request 
                Request newRequest = new Request(numFloors);
                if(debug) {
                    System.out.println("A request arrives from Floor " + newRequest.getSourceFloor() + " to Floor " + newRequest.getDestinationFloor());
                }
                // add the request to the queue
                queue.enqueue(newRequest);    
            }
            // now Each request time should be updated
            // Now if elevators are idle, give them a request
            for(int j = 0; j < listElevators.length; j++) {
                Elevator currentElevator = listElevators[j];
                if(currentElevator.isIDLE() && (!queue.isEmpty())) {
                    // give it a request if the currentElevator is idle and queue is not empty
                    currentElevator.setRequest(queue.dequeue());
                    currentElevator.setElevatorState(1);
                }
                Request currentRequest = currentElevator.getRequest();
                // each elevator will then move 1 floor closer if not idle, and timeEntered is incremented ONLY if its not equal to source floor and its going to source
                if(!currentElevator.isIDLE()) {
                    if(currentElevator.getCurrentFloor() != currentRequest.getSourceFloor() && currentElevator.isHeadedSource()) {
                        currentRequest.setTimeEntered(currentRequest.getTimeEntered() + 1);
                    }
                    // move toward destination
                    if(currentElevator.isHeadedDestination()) {
                        // if it is not at destination, move it toward destination
                        if(currentElevator.getCurrentFloor() == currentRequest.getDestinationFloor()) {
                            // set it to idle
                            currentElevator.setElevatorState(0);
                            // change Request to null
                            currentElevator.setRequest(null);
                        }
                        else {
                            // move it toward destination
                            if(currentElevator.getCurrentFloor() < currentRequest.getDestinationFloor()) {
                                currentElevator.setCurrentFloor(currentElevator.getCurrentFloor() + 1);
                            }
                            else {
                                currentElevator.setCurrentFloor(currentElevator.getCurrentFloor() - 1);
                            }
                        }
                    }
                    // move toward source 
                    if(currentElevator.isHeadedSource()) {
                        // if it is not at source yet, move it towards source 
                        if(currentElevator.getCurrentFloor() != currentRequest.getSourceFloor()) {
                            if(currentElevator.getCurrentFloor() > currentRequest.getSourceFloor()) {
                                currentElevator.setCurrentFloor(currentElevator.getCurrentFloor() - 1);
                            }
                            else {
                                currentElevator.setCurrentFloor(currentElevator.getCurrentFloor() + 1);
                            }
                        }
                        else { // its already at source, so set it to destination 
                            currentElevator.setElevatorState(2);
                        }
                    }

                }
            }

            // after main decision making
            queue.updateTimeEntered();
            // print the queue
            System.out.println(queue.toString());
            //print elevators
            printElevators(listElevators);
            System.out.println("-------------------------------");
        }
    }

    public static void printElevators(Elevator[] listElevators) {
        String ans = "Elevators: ";
        for(int i = 0; i < listElevators.length; i++) {
            Elevator currentElevator = listElevators[i];
            ans += currentElevator.toString();
        }
        System.out.println(ans);
    }
}
