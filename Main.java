public class Main {
    public static void main(String[] args) {
        IntList newLL = new IntList();
        newLL.addHead(5);
        newLL.addHead(10);
        newLL.addHead(1);
        newLL.addHead(3);
        newLL.removeHead();
        System.out.println(newLL.toString());
    }
}
