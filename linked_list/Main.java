package linked_list;

public class Main {
    public static void main(String[] args) {
        LinkedList ll=new LinkedList();

        ll.insert(100,1);
        ll.insert(200,2);

        ListNode n1=new ListNode(300);
        ll.insertAtBegin(n1);

        ListNode n2=new ListNode(400);
        ll.insertAtEnd(n2);
        ll.remove(2);
       System.out.println(ll.getPosition(100));
        System.out.println(ll.getHead().data);

        System.out.println(ll.length());

    }
}
