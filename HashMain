package DSA;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class HashTable {
    ListNode[] table;
    int size;

    HashTable(int size) {
        this.size = size;
        table = new ListNode[size];
    }

 
    int hash(int data) {
        return data % size;
    }


    void insert(int data) {
        int index = hash(data);

        ListNode newNode = new ListNode(data);

        newNode.next = table[index];
        table[index] = newNode;
    }
    
    boolean search(int data) {
        int index = hash(data);

        ListNode temp = table[index];

        while (temp != null) {
            if (temp.data == data) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    void delete(int data) {
        int index = hash(data);

        ListNode temp = table[index];
        ListNode prev = null;

        while (temp != null) {
            if (temp.data == data) {
                if (prev == null) {
                    table[index] = temp.next;
                } else {
                    prev.next = temp.next;
                }
                System.out.println(data + " deleted");
                return;
            }
            prev = temp;
            temp = temp.next;
        }

        System.out.println(data + " not found");
    }

 
    void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + " -> ");
            ListNode temp = table[i];

            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }

            System.out.println("null");
        }
    }
}

public class HashMain {
    public static void main(String[] args) {
        HashTable ht = new HashTable(5);

        ht.insert(10);
        ht.insert(15);
        ht.insert(20);
        ht.insert(25);
        ht.insert(30);
        ht.insert(20);

        System.out.println("Hash Table:");
        ht.display();

        System.out.println("\nSearch 15: " + ht.search(15));
     
        ht.delete(15);

        System.out.println("\nAfter Deletion:");
        ht.display();
    }
}
