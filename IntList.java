public class IntList {
    int size = 0;
    Node head;
    Node cursor;
    public IntList() {
        head = null;
        cursor = null;
    }

    public void addHead(int data) {
        // the head is a new Node initialized to our new data with a link that refers to the original head
        head = new Node(data, head);
    }

    public void removeHead() throws EmptyLinkedListException{
        // gets rid of a head
        // the head will simply refer to the node after the original head
        if(this.size == 0) {
            throw new EmptyLinkedListException("This Linked List is empty");
        }
        head = head.getLink();
    }

    // adds a noide after an element
    public void addIntAfter(int data) {
        // this means LL is empty
        Node newNode = new Node(data, null);
        // this means that the LL is empty
        if(cursor == null) {
            cursor = newNode;
            head = newNode;
        }
        // we want to add new Node after cursor
        else {
            newNode.setLink(cursor.getLink());
            cursor.setLink(newNode);
            // we also want to advance our cursor 
            cursor = newNode;
            // we want to check if the new node is at the end
            if(cursor.getLink() == null) {
                //tail = cursor; 
            }
        }
    }

    public void removeAfter() {
        // removes the node after the cursor
        cursor.setLink(cursor.getLink().getLink());
        // that means cursor is the tail 
        if(cursor.getLink() == null) {
            // tail = cursor;, tail is the last node
        }
    }

    public boolean advanceCursor() {
        if(cursor.getLink() != null) {
            cursor = cursor.getLink();
            return true;
        }
        else {
            return false; 
        }
    }

    public void resetCursor() {
        cursor = head;
    }

    public boolean isEmpty() {
        return (cursor == null);
    }

    // to get the length of a linked list
    public int listLength() {
        Node nodePtr = head;
        int size = 0;
        while(nodePtr.getLink() != null) {
            size++;
            // advance the pointer
            nodePtr = nodePtr.getLink();
        }
        return size;
    }

    // search a list
    public boolean listSearch(int target) {
        Node nodePtr = head;
        while(nodePtr.getLink() != null) {
            if(nodePtr.getData() == target) {
                // we should set cursor to the area where we found target
                cursor = nodePtr;
                return true;
            }
            // else advance
            nodePtr = nodePtr.getLink();
        }
        return false;
    }

    // set the cursor to a current posiiton
    public boolean listPosition(int position) throws IllegalArgumentException{
        // instead of actually moving the cursor, make a new pointer
        Node nodePtr = head;
        int i = 1;
        if(position <= 0) {
            throw new IllegalArgumentException("Position has to be non-negative");
        }
        while(i < position && nodePtr != null) {
            nodePtr = nodePtr.getLink();
            i++;
        }
        if(nodePtr != null) {
            cursor = nodePtr;
        }
        return (nodePtr == null);
    }

    // we need to transverse a linked List
    public String toString() {
        // prints the data
        Node nodePtr = head;
        String ans = "";
        while(nodePtr != null) {
            ans += nodePtr.getData() + " ";
            nodePtr = nodePtr.getLink();
        }
        return ans;
    }
}