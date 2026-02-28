package DSA.CircularLinkedList;

public class Main {
    public static void main(String[] args) {
        CircularLinkedList cl=new CircularLinkedList();
        cl.addToHead(100);
        cl.addToHead(200);
        cl.addToTail(400);
        cl.removeFromHead();
        cl.addToHead(300);
        System.out.println(cl);
    }
}
