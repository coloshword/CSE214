import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TreeDriver {
    private Tree questionTree;

    // constructor
    public TreeDriver() {
        questionTree = new Tree();
    }
    public static void main(String[] args) throws FileNotFoundException{
        boolean running = true;
        while(running) {
            TreeDriver questionDriver = new TreeDriver();
            Scanner input = new Scanner(System.in);
            prompt();
            String entered = input.next();
            interpret(questionDriver, entered, input);
        }
    }

    public static void prompt() {
        System.out.println("L - Load a Tree.");
        System.out.println("H - Begin a Help Session.");
        System.out.println("T - Traverse the Tree in preorder.");
        System.out.println("Q - Quit");
        System.out.print("Choice> ");
    }

    public static void interpret(TreeDriver questionDriver, String entered, Scanner input) throws FileNotFoundException{
        if(entered.equalsIgnoreCase("L")) {
            System.out.print("\nEnter the file name> ");
            String fileName = input.next();
            File fileBody = new File(fileName);
            Scanner readFile = new Scanner(fileBody);
            int skipLineCounter = 0;
            while(readFile.hasNextLine()) {
                String parentLabel;
                String label = removeWhiteSpace(readFile.nextLine());
                String prompt = removeWhiteSpace(readFile.nextLine());
                String message = removeWhiteSpace(readFile.nextLine());
                if(skipLineCounter == 0 && readFile.hasNextLine()) {
                    // we are going to read the line and see how many lines we need to skip
                    String line = removeWhiteSpace(readFile.nextLine());
                    skipLineCounter = Integer.parseInt(line.charAt(line.length() - 1) + "");
                }
                // figure out the parentLabel
                if(label.equalsIgnoreCase("root")) {
                    System.out.println("wow");
                    parentLabel = null;
                }
                else if(label.length() == 1) {
                    parentLabel = "root";
                }
                else {
                    parentLabel = label.substring(0, label.length() - 2);
                }
                System.out.println(label);
                System.out.println(prompt);
                System.out.println(message);
                questionDriver.questionTree.addNode(label, prompt, message, parentLabel);
                skipLineCounter--;
            }
            // create the tree
            System.out.println("\nTree created Successfully");
            questionDriver.questionTree.customTraverse();
            // Test traverse
        }
        if(entered.equalsIgnoreCase("H")) {
            questionDriver.questionTree.customTraverse();
        }
    }

    public static String removeWhiteSpace(String a) {
        //removes the white Space from the end 
        int endIndex = a.length() - 1;
        while(true) {
            if(a.charAt(endIndex) != ' ') {
                break;
            }
            else {
                endIndex--;
            }
        }
        return a.substring(0, endIndex + 1);
    }
}
