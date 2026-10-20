package COLLECTION.LIST;

//Basic Definition (Interview Perfect):
// LinkedList is a linear data structure that implements both the List and Deque (Double Ended Queue) interfaces. Unlike ArrayList, which stores elements in contiguous memory (side-by-side), a LinkedList stores elements as independent, scattered objects called Nodes. Each node securely holds your data and contains reference pointers to both the previous node and the next node in the chain.
//
// Concept Upgradation:
// ArrayList requires a massive block of continuous, uninterrupted memory. If your memory is fragmented, allocating a huge array can be problematic. Furthermore, inserting an element in the middle of an array requires shifting potentially millions of elements. LinkedList upgrades this insertion problem. Because the nodes are linked purely by pointers, you can insert or delete a node in the middle of a massive list without shifting anything. You simply break two pointer links and reattach them to the new node.
//
// Core Mechanics & Sub-topics:
// Doubly Linked Nodes:
// In Java's implementation, it is specifically a doubly linked list. Every node has three parts: prev (a pointer to the node before it), item (the actual data), and next (a pointer to the node after it). The very first node (Head) has a prev of null, and the last node (Tail) has a next of null.
//
// Insertion & Removal Speed ($O(1)$ vs $O(N)$):
// The actual insert/remove action - $O(1)$: If you already have a reference to a specific node, inserting a new node next to it is instant. It just requires changing the prev and next pointers of the surrounding nodes. No elements are shifted.
// Finding the spot - $O(N)$: If you say list.add(500, "New Data"), the LinkedList must start at index 0 and follow the next pointers 500 times to find the correct spot. This traversal is slow.
//
// Traversal ($O(N)$):Unlike ArrayList, which can jump straight to memory address [500], a LinkedList cannot do math to find an index. To get the 100th element, it must "walk" the chain from the 1st, to the 2nd, to the 3rd, all the way to 100.
// List & Queue Operations:Because it implements Deque, you get special methods that ArrayList doesn't have, like addFirst(), addLast(), removeFirst(), and removeLast().
//
//
// Advantages & Disadvantages (Compared to ArrayList)
// Advantages:
// Fast Ends: Adding or removing from the absolute beginning (addFirst) or the absolute end (addLast) is instant ($O(1)$).
// No Resizing Overhead: It never has to "resize" or copy data. It just creates a new node in memory and links it.
//
// Disadvantages:
// Terrible Read Speed: Fetching an element by index (get(i)) is $O(N)$ because of sequential traversal.
// High Memory Consumption: Every single piece of data requires extra memory to store the prev and next object pointers.
// Cache Unfriendly: Because nodes are scattered randomly across RAM, the CPU cache cannot predict what memory to load next, making it slower in practical hardware terms than an ArrayList.
//
//
// Real-World Code ExampleImagine the "Back" and "Forward" buttons on a web browser. You constantly add new pages to the "front" of your history, and you can instantly step backward to the previous page.


import java.util.*;

public class LinkedListClass {
    public static void main(String[] args) {
        // Instantiating as a LinkedList to get access to Deque methods
        LinkedList<String> browserHistory = new LinkedList<>();

        // Simulating visiting web pages
        browserHistory.addLast("google.com");
        browserHistory.addLast("stackoverflow.com");
        browserHistory.addLast("github.com");

        System.out.println("Current History: " + browserHistory);

        // User hits the "Back" button (removes the last page visited instantly)
        // O(1) time - no elements need to be shifted!
        String removedPage = browserHistory.removeLast();
        System.out.println("Went back from: " + removedPage);

        // User opens a new tab and prepends a homepage
        // O(1) time - instant insert at the head!
        browserHistory.addFirst("my-start-page.com");

        System.out.println("Final History: " + browserHistory);

        // Fetching by index is O(N) because it has to traverse the pointers
        System.out.println("Page at index 1: " + browserHistory.get(1));
        browserHistory.addFirst("linkedIn.com");

        System.out.println("History: " + browserHistory);
    }
}
