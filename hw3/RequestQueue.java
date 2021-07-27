import java.util.ArrayList;


public class RequestQueue extends ArrayList{
    int front;
    int rear;
    int size;
    /**
     * Constructor for the RequestQueue Class
     */
    public RequestQueue() {
        front = -1;
        rear = -1;
    }

    /**
     * Enqueue, adds a Request object to the back of the queue 
     * @param item Request to be added to the queue
     */
    public void enqueue(Request item) {
        if(front == -1) {// queue is empty 
            front = 0;
            rear = 0;
        }
        else {
            rear++;
        }
        this.add(item); 
        size++;
    }

    /**
     * Dequeue, removes a Request object from the front
     * @return Request Object from the front of queue. 
     */
    public Request dequeue() throws EmptyQueueException{
        if(front == -1) {// the queue is empty 
            throw new EmptyQueueException();
        }
        Request get = (Request)this.get(front);
        if(front == rear) { // popping will result in an empty queue
            front = rear = -1;
        }
        else {
            front ++;
        }
        size--;
        return get;
    } 

    /**
     * Tells if he RequestQueue is empty
     * @return boolean based on whether queue is empty. True if empty, false otherwise. 
     */
    public boolean isEmpty() {
        return (front == -1);
    }

    /**
     * Returns the size of RequestQueue
     * @return int of size variable
     */
    public int size() {
        return size;
    }

    /**
     * Returns a string with every request in the queue
     * @return String with the state of queue
     */
    public String toString() {
        String ans = "Requests: ";
        for(int i = front; i < rear; i++) {
            Request currentRequest = (Request)get(i);
            ans += String.format("(%d, %d, %d)", currentRequest.getSourceFloor(), currentRequest.getDestinationFloor(), currentRequest.getTimeEntered());
        }
        return ans;
    }

    /**
     * A void method that incremets each queue item's timeEntered by 1
     */
    public void updateTimeEntered() {
        for(int i = front; i < rear; i++) {
            Request currentRequest = (Request)get(i);
            currentRequest.setTimeEntered(currentRequest.getTimeEntered() + 1);
        }
    }
}
