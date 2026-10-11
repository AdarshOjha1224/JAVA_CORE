package COLLECTION;

// Structure Plan: Java Collections & List Interface :

//Iterable (The absolute foundation of iteration)
//Collection (The root data-container interface)
//List Interface (Ordered, index-based collections)
//ArrayList (Dynamic arrays, the default choice)
//LinkedList (Node-based, doubly-linked structure)
//Vector (Legacy, synchronized dynamic arrays)
//Stack (Legacy, LIFO structure)


//Let's dive deeply into the foundation right now: Iterable and Collection.
//
//1. Iterable: The Root of Iteration
//Basic Definition (Interview Perfect)
//Iterable is the root interface of the entire Java Collection Framework. It does not store data itself; rather, it represents a guarantee that an object can provide an Iterator. If a class implements Iterable, it can be the target of Java's enhanced for-each loop, allowing its elements to be traversed one by one.
//
//Concept Upgradation
//Before Iterable and the enhanced for-loop (introduced in Java 5), developers had to manually manage indexes with standard for loops (e.g., for(int i=0; i<arr.length; i++)) or manually call iterator.hasNext() and iterator.next() using a while loop. Iterable upgraded this by abstracting away the loop mechanics, preventing off-by-one errors and making code much cleaner.
//
//Important Characteristics
//Single Abstract Method (Pre-Java 8): Historically, it only had one method: iterator(), which returns an Iterator<T>.
//Default Methods (Java 8+): It now includes forEach(Consumer action) for functional-style iteration and spliterator() for parallel processing.
//Directionality: The standard Iterator it provides is strictly one-way (forward-only).
//
//Advantages & Disadvantages
//Advantages:
//Provides a unified, clean syntax (for(Item i : items)) for traversing any data structure.
//Decouples the traversal logic from the underlying data structure (you iterate a Linked List the exact same way you iterate an Array List).
//
//Disadvantages:
//You cannot move backward.
//You cannot add or replace elements during iteration (though you can safely remove them if you use the underlying Iterator.remove() method, you cannot do this using the for-each loop syntax).
//
//Real-World Code Example
//Imagine a company's department roster. You don't care how the employees are stored (array, list, or set), you just want to announce their names.


import java.util.*;

public class IterableInterface {
    public static void main(String[] args) {
        // A Collection implements Iterable, so it can be looped over
        Iterable<String> departmentRoster = Arrays.asList("Alice", "Bob", "Charlie", "Diana");

        // The enhanced for-loop is ONLY possible because departmentRoster is Iterable
        for (String employee : departmentRoster) {
            System.out.println("Notifying employee: " + employee);
        }

        // Java 8+ Functional approach (using the default forEach method)
        departmentRoster.forEach(emp -> System.out.println("Processing payroll for: " + emp));
    }
}
