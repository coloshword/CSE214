//Acero Liang Li
//113805800
//Recitation 30

public class Tree {
    private TreeNode root;
    //constructor
    public Tree() {
        root = null;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    // inserting a new node
    public boolean addNode(String label, String prompt, String message, String parentLabel) {
        TreeNode cursor;
        boolean added = false;
        // create the new Node
        TreeNode newNode = new TreeNode();
        newNode.setLabel(label); 
        newNode.setMessage(message);
        newNode.setPrompt(prompt);
        // if the tree is empty, set this node to the root
        if(this.isEmpty()) {
            this.setRoot(newNode);
            added = true;
        }
        else {
            // we have to traverse the tree based on parent Label
            cursor = root;
            int[] directions = getParentLabel(parentLabel);
            for(int i = 1; i < directions.length; i++) {
                if(cursor == null || directions[i] == 0) {
                    break;
                }
                switch(directions[i]) {
                    case 1:
                        cursor = root.getLeft();
                    case 2:
                        cursor = root.getMiddle();
                    case 3: 
                        cursor = root.getRight();
                }
            }
            if(cursor != null) {
                // we made it to the parent node, now we just add 
                int path = Integer.parseInt(label.charAt(label.length() - 1) + "");
                switch(path) {
                    case 1: 
                        // add to the left 
                        cursor.setLeft(newNode);
                        break;
                    case 2:
                        cursor.setMiddle(newNode);
                        System.out.println("Added a middle nODE");
                        break;
                    case 3:
                        cursor.setRight(newNode);
                        System.out.println("Added a right nODE");
                        break;
                }
                added = true;
            }
        }   
        return added;
    }

    public void customTraverse() {
        TreeNode cursor = root;
        System.out.println(cursor.getMessage());
        cursor = cursor.getLeft();
        System.out.println(cursor.getMessage());
        cursor = cursor.getRight();
        System.out.println(cursor.getMessage());
    }

    // accessor methods
    public TreeNode getRoot() {
        return root;
    }

    // mutator methods
    public void setRoot(TreeNode a) {
        root = a; 
    }

    // static helper method
    public static int[] getParentLabel(String label) {
        int[] ans = new int[3];
        if(label.equals("root")) {
            return ans;
        }
        int index = 0;
        for(int i = 0; i < label.length(); i++) {
            if(label.charAt(i) != '-') {
                ans[index] = Integer.parseInt(label.charAt(i) + "");
                index++;
            }
        }
        return ans;
    }
}
