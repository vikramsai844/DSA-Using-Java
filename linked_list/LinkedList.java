package linked_list;

public class LinkedList {
    // This class has a default constructor:
    public LinkedList() {
        length = 0;
    }
    ListNode head;

    // Length of the linked list
    private int length = 0;

    // Return the first node/head in the list
    public synchronized ListNode getHead() {
        return head;
    }

    // Insert a node at the beginning of the list
    public synchronized void insertAtBegin(ListNode node) {
        node.next = head;
        head = node;
        length ++;
    }

    // Insert a node at the end of the list
    public synchronized void insertAtEnd(ListNode node) {
        if (head == null)
            head = node;
        else {
            ListNode p, q;
            for(p = head; (q = p.next) != null; p = q);
            p.next = node;
        }
        length ++;
    }

    // Add a new value to the list at a given position. All values at that position to the end move over to make room.
    public void insert(int data, int position) {
        // fix the position
        if (position < 0) {
            position = 0;
        }
        if (position > length) {
            position = length;
        }
        // if the list is empty, make it be the only element
        if (head == null) {
            head = new ListNode(data);
        }
        // if adding at the front of the list...
        else if (position == 0) {
            ListNode temp = new ListNode(data);
            temp.next = head;
            head = temp;
        }
        // else find the correct position and insert
        else {
            ListNode temp = head;
            for (int i=1; i<position; i+=1) {
                temp = temp.next;
            }
            ListNode newNode = new ListNode(data);
            newNode.next = temp.next;
            temp.next = newNode;
        }
        // the list is now one value longer
        length += 1;
    }

    // Remove and return the node at the head of the list
    public synchronized ListNode removeFromBegin() {
        ListNode node = head;
        if (node != null) {
            head = node.next;
            node.next = null;
        }
        return node;
    }

    // Remove and return the node at the end of the list
    public synchronized ListNode removeFromEnd() {
        if (head == null)
            return null;
        ListNode p = head, q = null, next = head.next;
        if (next == null) {
            head = null;
            return p;
        }
        while((next = p.next) != null) {
            q = p;
            p = next;
        }
        q.next = null;
        return p;
    }

    // Remove a node matching the specified node from the list.
    // Use equals() instead of == to test for a matched node.
    public synchronized void removeMatched(ListNode node) {
        if (head == null)
            return;
        if (node.equals(head)) {
            head = head.next;
            return;
        }
        ListNode p = head, q = null;

        while((q = p.next) != null) {
            if (node.equals(q)) {
                p.next = q.next;
                return;
            }
            p = q;
        }
    }

    // Remove the value at a given position.
    // If the position is less than 0, remove the value at position 0.
    // If the position is greater than 0, remove the value at the last position.
    public void remove(int position) {
        // fix position
        if (position < 0) {
            position = 0;
        }

        if (position >= length) {
            position = length-1;
        }

        // if nothing in the list, do nothing
        if (head == null)
            return;

        // if removing the head element...
        if (position == 0) {
            head = head.next;
        }

        // else advance to the correct position and remove
        else {
            ListNode temp = head;

            for (int i=1; i<position; i+=1) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        // reduce the length of the list
        length -= 1;
    }
    // Return a string representation of this collection, in the form ["str1","str2",...].
    public String toString() {
        String result = "[";
        if (head == null) {
            return result+"]";
        }
        result = result + head.data;
        ListNode temp = head.next;;

        while (temp != null) {
            result = result + "," + temp.data;
            temp = temp.next;
        }
        return result + "]";
    }
    // Return the current length of the list.
    public int length() {
        return length;
    }

    // Find the position of the first value that is equal to a given value.
    // The equals method is used to determine equality.
    public int getPosition(int data) {
        // go looking for the data
        ListNode temp = head;
        int pos = 0;

        while (temp != null) {
            if (temp.data == data) {
                // return the position if found
                return pos;
            }
            pos += 1;
            temp = temp.next;
        }
        // else return some large value
        return Integer.MIN_VALUE;
    }

    // Remove everything from the list.
    public void clearList(){
        head = null;
        length = 0;
        System.out.println("list cleared");
    }



}