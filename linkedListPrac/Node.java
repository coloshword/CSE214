package linkedListPrac;

public class Node {
    private int data;
    private Node link;
    
    /**
     * Arg constructor
     * @param a integer to be stored in data varaible
     * @param b Node to be linkd 
     */
    public Node(int a, Node b) {
        data = a;
        link = b;
    }

    public int getData() {
        return data;
    }
    
    public Node getLink() {
        return link;
    }

    public void setData(int newData) {
        data = newData;
    }

    public void setLink(Node newLink) {
        link = newLink;
    }
}
