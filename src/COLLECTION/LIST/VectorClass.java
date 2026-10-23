package COLLECTION.LIST;

//Basic Definition (Interview Perfect)
//Vector is a legacy, dynamic array implementation of the List interface. Functionally, it is almost identical to an ArrayList—it uses an internal array to store data and resizes itself when full. However, its defining characteristic is that all of its core methods are synchronized, making it thread-safe by default.
//
//Concept Upgradation (Or rather, Downgradation)
//Vector is actually older than the Java Collections Framework itself (introduced in Java 1.0). When the Collections Framework was introduced in Java 1.2, Vector was retrofitted to implement the List interface. In modern Java, ArrayList is considered the upgrade to Vector. The creators realized that making every single operation thread-safe by default was a massive performance drain for single-threaded applications.
//
//Core Characteristics & Differences from ArrayList
//Synchronization: Every time you call add(), get(), or remove() on a Vector, it places a lock on the entire object. If Thread A is reading from the Vector, Thread B cannot even add to it until Thread A is finished.
//
//Resizing Logic: When an ArrayList gets full, it increases its capacity by 50%. When a Vector gets full, it defaults to doubling its capacity (100% increase). This can lead to significant wasted memory if the data size is large.
//
//Legacy Status: Because of its inherent performance bottleneck, it is considered obsolete for modern development.
//
//Advantages & Disadvantages
//Advantages:
//
//Thread-safe out of the box without needing manual synchronization blocks.
//
//Disadvantages:
//
//Extremely Slow: The synchronization overhead makes it dramatically slower than ArrayList in single-threaded environments.
//
//Poor Concurrency Scaling: Even in multi-threaded environments, locking the entire list for a simple read operation is inefficient. Modern Java uses CopyOnWriteArrayList or ConcurrentLinkedQueue for high-performance thread safety instead.
//
//Real-World Code Example
//You generally won't write new code using Vector, but you might see it in old codebases or specific legacy APIs.

import java.util.*;

public class VectorClass {
    public static void main(String[] args) {
        // Operates exactly like an ArrayList from a syntax perspective
        List<String> synchronizedList = new Vector<>();

        // Thread-safe addition, but very slow due to locking
        synchronizedList.add("Thread 1 Data");
        synchronizedList.add("Thread 2 Data");

        System.out.println("Vector contains: " + synchronizedList);
    }
}
