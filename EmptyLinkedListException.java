// a custom exception to be thrown when an operation requiring a non-empty
// linked list is tried on an empty one
public class EmptyLinkedListException  extends RuntimeException {
    public EmptyLinkedListException(String messageThrown) {
        super(messageThrown);
    }
}
