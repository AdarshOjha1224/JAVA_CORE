package COLLECTION.LIST;

// Basic Definition (Interview Perfect)The List interface is a child of the Collection interface that represents an ordered sequence of elements. Unlike a basic Collection, a List provides precise control over where every element is inserted and allows you to access, manipulate, or remove elements based on their exact integer index (their position in the sequence).

// Concept Upgradation: While Collection upgraded standard arrays by making them dynamic, it lost the ability to access elements by their position (no [i] access). The List interface upgraded the Collection interface by bringing back the power of zero-based indexing. It bridges the gap by giving you the dynamic flexibility of a Collection combined with the exact positional control of a standard array.

// Core Characteristics Explained:
// Ordering (Insertion Order Preservation):When you add elements to a List, the List remembers the exact sequence. If you add "Apple" then "Banana", the List guarantees that "Apple" will always come before "Banana" when you iterate through it. It does not auto-sort your elements alphabetically or numerically; it strictly honors your insertion order.
// Indexing (Zero-Based Positional Access):Elements in a List are assigned an integer index starting at 0. This unlocks a whole suite of methods that standard Collections don't have:
// get(int index): Retrieve an element at a specific spot.
// set(int index, E element): Replace an element at a specific spot.
// add(int index, E element): Insert an element in the middle, shifting subsequent elements to the right.
// remove(int index): Delete an element at a specific position.

// Duplicates & Nulls:Lists explicitly allow duplicate elements. If you want to store the number 5 ten times, a List will happily store them at indexes 0 through 9. Lists also typically allow multiple null values.

// Advantages & Disadvantages:
// Advantages:
// Positional Control: You can insert or update data exactly where you want it.
// Predictability: Because insertion order is maintained, you know exactly how your data will be presented when you loop through it.
// Duplication: Perfect for real-world scenarios where repeats are normal (e.g., a history of user clicks, a grocery list with two identical items).

// Disadvantages:
// Value-Based Search Speed: While finding an item by its index is usually very fast, finding an item by its value (e.g., list.indexOf("Target")) requires checking every single item from the beginning until it finds a match, which is slow for massive lists ($O(N)$ time complexity).



// Real-World Code ExampleImagine a music streaming application building a user's "Driving Playlist". Order matters (you want the intro track first), duplicates matter (you might want to play your favorite song twice), and indexing matters (you want to skip to track number 3).

import java.util.*;

public class ListInterface {
    public static void main(String[] args) {
        // We declare the type as List (Interface) but instantiate an ArrayList (Implementation)
        List<String> drivingPlaylist = new ArrayList<>();

        // 1. ORDERING: Elements remain in the exact order they are added
        drivingPlaylist.add("Bohemian Rhapsody");
        drivingPlaylist.add("Hotel California");

        // 2. DUPLICATES: Adding the same song again is perfectly fine
        drivingPlaylist.add("Bohemian Rhapsody");

        // 3. INDEXING: Inserting exactly at index 1 (pushes Hotel California down)
        drivingPlaylist.add(1, "Stairway to Heaven");

        System.out.println("Full Playlist: " + drivingPlaylist);
        // Output: [Bohemian Rhapsody, Stairway to Heaven, Hotel California, Bohemian Rhapsody]

        // Fetching by index (Zero-based)
        String trackThree = drivingPlaylist.get(2);
        System.out.println("Track 3 is: " + trackThree);
        // Output: Track 3 is: Hotel California

        // Updating an element by index (Replacing Track 4)
        drivingPlaylist.set(3, "Free Bird");

        // Searching for an element's index
        int hotelIndex = drivingPlaylist.indexOf("Hotel California");
        System.out.println("Hotel California is at index: " + hotelIndex);
        // Output: 2
    }
}
