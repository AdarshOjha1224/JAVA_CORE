package COLLECTION;

//Basic Definition (Interview Perfect)
//The Collection interface extends Iterable and is the root interface for standard data structures in Java. It defines the core behaviors that all generic groups of objects (like Lists, Sets, and Queues) must possess—such as adding, removing, checking size, and clearing elements. It acts as the lowest common denominator for manipulating groups of objects.
//
//Concept Upgradation
//Collection upgraded standard arrays. Standard arrays have a fixed size and lack built-in utility methods (you have to write manual code to check if an array contains a specific element or to "remove" an element by shifting others). Collection introduced a dynamic, flexible contract with built-in utility methods (contains(), remove(), clear()).
//
//Important Characteristics
//Universal Methods: Declares universally needed methods: add(E e), remove(Object o), size(), isEmpty(), contains(Object o), and clear().
//
//No Direct Retrieval: Noticeably missing from Collection is any get(index) method. Because Collection is the parent of Set (which is unordered and has no indexes), it cannot guarantee index-based access.
//
//Bulk Operations: Supports operating on entire groups at once (addAll, removeAll, retainAll).
//
//Advantages & Disadvantages
//Advantages:
//
//High Polymorphism: You can write methods that accept a Collection<String>, and it will happily accept a List, a Set, or a Queue without changing your code.
//
//Guarantees a baseline set of operations for almost every data structure in Java.
//
//Disadvantages:
//
//Too abstract for many specific use cases. Since it doesn't support indexing or keys, if you need to fetch the 3rd element, a plain Collection reference is useless. You must cast it or use a more specific child interface (like List).
//
//Real-World Code Example
//Imagine a shopping cart where you just need to drop items in, check how many items you have, and see if a specific item is already in the cart. We don't care about the order yet.

import java.util.*;

public class CollectionInterface {
    public static void main(String[] args) {
        // Using Collection polymorphically.
        // We use ArrayList under the hood, but restrict our view to just Collection features.
        Collection<String> shoppingCart = new ArrayList<>();

        // Universal Collection methods
        shoppingCart.add("Laptop");
        shoppingCart.add("Wireless Mouse");
        shoppingCart.add("Mechanical Keyboard");

        System.out.println("Total items in cart: " + shoppingCart.size()); // Output: 3

        // Easy checking without writing a loop manually
        if (shoppingCart.contains("Laptop")) {
            System.out.println("Laptop is ready for checkout.");
        }

        // Removing an item
        shoppingCart.remove("Wireless Mouse");

        System.out.println("Cart is empty? " + shoppingCart.isEmpty()); // Output: false

        // Cannot do this: shoppingCart.get(0); // ERROR: Collection has no index concept!
    }
}
