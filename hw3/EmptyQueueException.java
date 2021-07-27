// a custom exception to be thrown when an operation requiring a non-empty
// queue is called on an empty queue 
public class EmptyQueueException  extends RuntimeException {
    public EmptyQueueException() {
        super("The Request Queue is empty");
    }
}
