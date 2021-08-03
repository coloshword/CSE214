import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Tree myTree = new Tree();
        System.out.println(myTree.addNode("root", "Root Node", "What Model is the washing machine?", null));
        System.out.println(myTree.addNode("1", "WM200", "What is the problem?", "root"));
        System.out.println(myTree.addNode("1-1", "No Water", "Is the hose attached", "1"));
        System.out.println(myTree.addNode("1-1-1", "Yes, but the hose is broken", "Purchase a new hose", "1-1"));
        myTree.traverseTreeLeft();
    }   
}
