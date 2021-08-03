//Acero Liang Li
//113805800
//Recitation 30

public class TreeNode {
    private TreeNode left;
    private TreeNode middle;
    private TreeNode right;
    // the "name" of this TreeNode
    private String label;
    // the message thjat will be displayed to screen
    private String message;
    private String prompt;

    // constructor
    public TreeNode() {
        left = null;
        middle = null;
        right = null;
        label = "";
        message = "";
        prompt = "";
    }
    
    //accessor methods
    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getMiddle() {
        return middle;
    }

    public TreeNode getRight() {
        return right;
    }

    public String getLabel() {
        return label;
    }

    public String getMessage() {
        return message;
    }

    public String getPrompt() {
        return prompt;
    }

    //mutator methods
    public void setLeft(TreeNode a) {
        left = a;
    }

    public void setMiddle(TreeNode a) {
        middle = a;
    }

    public void setRight(TreeNode a) {
        right = a;
    }

    public void setLabel(String a) {
        label = a;
    }

    public void setMessage(String a) {
        message = a;
    }

    public void setPrompt(String a) {
        prompt = a;
    }
}