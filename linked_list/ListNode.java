package linked_list;

public class ListNode {
    public int data;
    public ListNode next;
    public ListNode(int data){
        this.data = data;
    }
//    public void setData(int data){
//        this.data = data;
//    }
//    public int getData(){
//        return data;
//    }
//    public void setNext(ListNode next){
//        this.next = next;
//    }
//    public ListNode getNext(){
//        return this.next;
//    }
//
//    public int length(ListNode headNode) {
//        int length = 0;
//        ListNode currentNode = headNode;
//
//        while(currentNode != null){
//            length++;
//            System.out.print("->");
//            System.out.print(currentNode.getData());
//            currentNode = currentNode.next;
//
//        }
//        System.out.println();
//        return length;
//    }

//    public static void main(String[] args) {
//        ListNode n1=new ListNode(100);
//        ListNode n2=new ListNode(200);
//        ListNode n3=new ListNode(300);
//
//        n1.setNext(n2);
//        n2.setNext(n3);
//        System.out.println(n1.getData());
//        System.out.println(n1.getNext().getData());
//        System.out.println(n2.getNext().getData());
//        System.out.println(n1.length(n1));
//
//    }
}