package DSA.CircularLinkedList;

public class CircularLinkedList{
    protected CLLNode tail;
    protected int length;
    // Constructs a new circular list
    public CircularLinkedList(){
        tail = null;
        length = 0;
    }
    // Adds data to beginning of list.
    public void add(int data){
        addToHead(data);
    }
    // Adds element to head of list
    public void addToHead(int data){
        CLLNode temp = new CLLNode(data);
        if (tail == null) { // first data added
            tail = temp;
            tail.next = tail;
        } else { // element exists in list
            temp.next = tail.next;
            tail.next = temp;
        }
        length++;
    }
    // Adds element to tail of list
    public void addToTail(int data){
        // new entry:
        addToHead(data);
        tail = tail.next;
    }
    // Returns data at head of list
    public int peek(){
        return tail.next.data;
    }
    // Returns data at tail of list
    public int tailPeek(){
        return tail.data;
    }
    // Returns and removes data from head of list
    public int removeFromHead(){
        CLLNode temp = tail.next; // ie. the head of the list
        if (tail == tail.next) {
            tail = null;
        } else {
            tail.next = temp.next;
            temp.next = null; // helps clean things up; temp is free
        }
        length--;
        return temp.data;
    }
    // Returns and removes data from tail of list
    public int removeFromTail(){
        if (isEmpty()){
            return Integer.MIN_VALUE;
        }
        CLLNode finger = tail;
        while (finger.next != tail) {
            finger = finger.next;
        }
        // finger now points to second-to-last data
        CLLNode temp = tail;
        if (finger == tail) {
            tail = null;

        } else {
            finger.next = tail.next;
            tail = finger;
        }
        length--;
        return temp.data;
    }
    // Returns true if list contains data, else false
    public boolean contains(int data){
        if (tail == null)
            return false;
        CLLNode finger;
        finger = tail.next;
        while (finger != tail && (!(finger.data == data))){
            finger = finger.next;
        }
        return finger.data == data;
    }
    // Removes and returns element equal to data, or null
    public int remove(int data){
        if (tail == null)
            return Integer.MIN_VALUE;
        CLLNode finger = tail.next;
        CLLNode previous = tail;
        int compares;
        for (compares = 0; compares < length && (!(finger.data == data)); compares++) {
            previous = finger;
            finger = finger.next;
        }
        if (finger.data == data) {
            // an example of the pigeon-hole principle
            if (tail == tail.next) {
                tail = null; }
            else {
                if (finger == tail)
                    tail = previous;
                previous.next = previous.next.next;
            }
            // finger data free
            finger.next = null;  // to keep things disconnected
            length--;             // fewer elements
            return finger.data;
        }
        else return Integer.MIN_VALUE;
    }
    // Return the length of the CLL.
    public int length() {
        return length;
    }
    // Returns true if no elements in list
    public boolean isEmpty(){
        return tail == null;
    }
    // Remove everything from the CLL.
    public void clear(){
        length = 0;
        tail = null;
    }
    // Return a string representation of this collection, in the form: ["str1","str2",...].
    public String toString(){
        String result = "[";
        if (tail == null) {
            return result+"]";
        }
        result = result + tail.data;
        CLLNode temp = tail.next;
        while (temp != tail) {
            result = result + "," + temp.data;
            temp = temp.next;
        }
        return result + "]";

    }

}