public class DoublyLinkedList{ 
    // properties 
    private DLLNode head; 
    private DLLNode tail; 
    private int length; 
    // Create a new empty list. 
    public DoublyLinkedList() { 
        head = new DLLNode(Integer.MIN_VALUE,null,null); 
        tail = new DLLNode(Integer.MIN_VALUE, head, null); 
        head.next = tail; 
        length = 0; 
    }  
 
    // Get the value at a given position. 
    public int get(int position) { 
        return Integer.MIN_VALUE; 
    } 
 
    // Find the position of the head value that is equal to a given value.
 // The equals method us used to determine equality. 
    public int getPosition(int data) { 
        DLLNode temp = head;        
        int pos = 0; 
        while (temp != null) {            // go looking for the data 
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
 
    // Return the current length of the DLL. 
    public int length() { 
        return length; 
    } 
 
    // Add a new value to the front of the list. 
    public void insert(int newValue) { 
        DLLNode newNode = new DLLNode(newValue, null, head.next); 
        newNode.next.prev = newNode; 
        head = newNode; 
        length += 1; 
    }  
 
    // Add a new value to the list at a given position. 
    // All values at that position to the end move over to make room. 
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
            head = new DLLNode(data); 
            tail = head; 
        } 
        // if adding at the front of the list... 
        else if (position == 0) { 
            DLLNode temp = new DLLNode(data); 
            temp.next = head; 
            head = temp; 
        } 
        // else find the correct position and insert 
        else { 
            DLLNode temp = head; 
            for (int i=1; i<position; i+=1) { 
              temp = temp.next; 
            } 
 
            DLLNode newNode = new DLLNode(data); 
            newNode.next = temp.next; 
            newNode.prev = temp; 
            newNode.next.prev = newNode; 
            temp.next = newNode; 
        } 
        // the list is now one value longer 
        length += 1; 
    }  
 
    // Add a new value to the rear of the list. 
    public void insertTail(int newValue) { 
        DLLNode newNode = new DLLNode(newValue,tail.prev,tail); 
        newNode.prev.next = newNode; 
        tail.prev = newNode; 
        length += 1; 

 } 
 
    // Remove the value at a given position. 
    // If the position is less than 0, remove the value at position 0. 
    // If the position is greater than 0, remove the value at the last position. 
    public void remove(int position) { 
        if (position < 0) { // fix position 
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
            if (head == null) 
                tail = null; 
        } else { // else advance to the correct position and remove 
            DLLNode temp = head; 
            for (int i=1; i<position; i+=1) { 
                temp = temp.next; 
            } 
            temp.next.prev = temp.prev; 
            temp.prev.next = temp.next; 
        } 
        // reduce the length of the list 
        length -= 1; 
    } 
 
    // Remove a node matching the specified node from the list.  Use equals() instead of == to test for a matched node. 
    public synchronized void removeMatched(DLLNode node) { 
        if (head == null) return; 
        if (node.equals(head)) {  
            head = head.next;  
            if (head == null) 
                tail = null; 
            return; 
        } 
 
        DLLNode p = head; 
        while(p != null) { 
            if (node.equals(p)) { 
                p.prev.next = p.next; 
                p.next.prev = p.prev; 
                return; 
            } 
        } 
    } 
 
    // Remove the head value from the list. If the list is empty, do nothing. 
    public int removeHead() { 
        if (length == 0) 
            return Integer.MIN_VALUE; 
        DLLNode save = head.next; 
        head.next = save.next; 
        save.next.prev = head; 
        length -= 1; 
        return save.data; 
    }  
 
    // Remove the tail value from the list. If the list is empty, do nothing. 
    public int removeTail() { 
        if (length == 0) 
            return Integer.MIN_VALUE; 
        DLLNode save = tail.prev; 
        tail.prev = save.prev; 
        save.prev.next = tail; 
        length -= 1; 
        return save.data; 
    } 

// Return a string representation of this collection, in the form: ["str1","str2",...]. 
public String toString() { 
String result = "[]"; 
if (length == 0) 
return result; 
result = "[" + head.next.data; 
DLLNode temp = head.next.next; 
while (temp != tail) { 
result += "," + temp.data; 
temp =  temp.next; 
} 
return result + "]"; 
}  
public void clearList(){   // Remove everything from the DLL 
head = null; 
tail = null; 
length = 0; 
} 
} 