package LinkedList;

// A complete demonstration of a Singly Linked List in Java
public class linkedList {

    // 1. Define the Node structure
    // A node contains data and a reference (link) to the next node.
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null; // By default, a new node points to nowhere (null)
        }
    }


    // The head is the starting point of the linked list
    private Node head;
    private int size; // Keep track of how many elements are in the list

    public linkedList() {
        this.head = null;
        this.size = 0;
    }

    // ==========================================
    // INSERTION OPERATIONS
    // ==========================================

    // Insert a new node at the beginning (Head)
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head; // Point the new node to the current head
        head = newNode;      // Make the new node the new head
        size++;
        System.out.println("Inserted " + data + " at the beginning.");
    }

    // Insert a new node at the end (Tail)
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        // If the list is empty, the new node becomes the head
        if (head == null) {
            head = newNode;
            size++;
            System.out.println("Inserted " + data + " at the end (first element).");
            return;
        }

        // Otherwise, traverse to the last node
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        // Link the last node to the new node
        current.next = newNode;
        size++;
        System.out.println("Inserted " + data + " at the end.");
    }

    // Insert a new node at a specific position (0-indexed)
    public void insertAtPosition(int data, int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position!");
            return;
        }

        if (position == 0) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;

        // Traverse to the node just BEFORE the insertion point
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }

        // Re-wire the connections
        newNode.next = current.next;
        current.next = newNode;
        size++;
        System.out.println("Inserted " + data + " at position " + position + ".");
    }

    // ==========================================
    // DELETION OPERATIONS
    // ==========================================

    // Delete the first node
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        System.out.println("Deleted " + head.data + " from the beginning.");
        head = head.next; // Move the head pointer to the second node
        size--;
    }

    // Delete the last node
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        // If there's only one element
        if (head.next == null) {
            System.out.println("Deleted " + head.data + " from the end.");
            head = null;
            size--;
            return;
        }

        // Traverse to the SECOND TO LAST node
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        System.out.println("Deleted " + current.next.data + " from the end.");
        current.next = null; // Sever the link to the last node
        size--;
    }

    // ==========================================
    // UTILITY OPERATIONS
    // ==========================================

    // Search for a specific value
    public boolean search(int key) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data == key) {
                System.out.println("Found " + key + " at position " + index + ".");
                return true;
            }
            current = current.next;
            index++;
        }
        System.out.println(key + " not found in the list.");
        return false;
    }

    // Print all elements in the linked list
    public void display() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node current = head;
        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("NULL (Size: " + size + ")");
    }

    // ==========================================
    // MAIN METHOD (Testing the List)
    // ==========================================
    public static void main(String[] args) {
        linkedList list = new linkedList();

        System.out.println("--- Building the List ---");
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtBeginning(5);
        list.insertAtPosition(15, 2); // Insert 15 between 10 and 20
        list.display(); // Expected: 5 -> 10 -> 15 -> 20 -> NULL

        System.out.println("\n--- Searching ---");
        list.search(15);
        list.search(100);

        System.out.println("\n--- Deleting Elements ---");
        list.deleteFromBeginning();
        list.display(); // Expected: 10 -> 15 -> 20 -> NULL

        list.deleteFromEnd();
        list.display(); // Expected: 10 -> 15 -> NULL
    }
}
