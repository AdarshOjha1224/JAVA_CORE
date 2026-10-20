package COLLECTION.LIST;

//Basic Definition (Interview Perfect): ArrayList is a resizable-array implementation of the List interface. It stores elements internally in a standard array but abstracts away the size limitations. When the internal array becomes full, the ArrayList automatically creates a new, larger array, copies the old elements over, and continues accepting new data.
//
// Concept Upgradation: Standard Java arrays (String[] arr = new String[5];) are strictly fixed-size. If you need to add a 6th element, the program crashes with an ArrayIndexOutOfBoundsException. ArrayList upgraded standard arrays by handling the resizing math for you. You get the speed of an array with the infinite flexibility of a dynamic data structure.
//
// Core Mechanics & Sub-topics:
// Internal Array & Capacity:Under the hood, an ArrayList is literally just an Object[]. The "Capacity" is the actual physical length of this hidden array. By default, when you add the very first element, Java initializes this internal array with a capacity of 10.
// Resizing (The Magic Trick):What happens when you add the 11th element? The ArrayList realizes it is full. It calculates a new capacity (usually 1.5x the old capacity, using bitwise shifting: oldCapacity + (oldCapacity >> 1)). So, a size 10 array becomes size 15. It builds a brand new array of size 15, copies the 10 old items over, adds the 11th, and garbage-collects the old array.
// Time Complexity (Big O):
// get(index) & set(index, value) - $O(1)$: Lightning fast. Because it's backed by an array, Java calculates the exact memory address instantly.
// add(value) - Amortized $O(1)$: Adding to the end is usually instant. Only on the rare occasion it has to resize does it take $O(N)$ time.
// add(index, value) & remove(index) - $O(N)$: Slow. If you insert or delete an item in the middle of an ArrayList, every single element to the right of that index must be manually shifted one position over to make room (or close the gap).
// contains(value) & indexOf(value) - $O(N)$: Slow. It must iterate through the array from index 0 until it finds a match.
//
// Advantages & Disadvantages:
// Advantages:
// Fast Reads: The absolute best data structure for reading data by index.
// Cache-Friendly: Because data is stored in contiguous memory blocks, modern CPU caches read ArrayLists incredibly efficiently compared to node-based structures like LinkedList.
//
// Disadvantages:
// Slow Middle Modifications: Inserting or removing near the front or middle requires mass-shifting of data.
// Memory Waste: Resizing jumps by 50%. If you have 100 items and add 1, it resizes to 150. You now have 49 empty memory slots sitting unused.
//
//
// Real-World Code ExampleImagine managing a restaurant's waiting list. People usually get added to the bottom of the list, but occasionally a VIP shows up and gets inserted in the middle, pushing everyone else down.

import java.util.*;

public class ArrayListClass {
    public static void main(String[] args) {
        // Initial capacity of 10 is created under the hood
        List<String> waitlist = new ArrayList<>();

        // O(1) amortized - Fast inserts at the end
        waitlist.add("Table for John");
        waitlist.add("Table for Sarah");
        waitlist.add("Table for Mike");

        System.out.println("Current Waitlist: " + waitlist);

        // O(N) - Slow insert! Mike must be shifted to index 2
        waitlist.add(1, "VIP Table for the Mayor");

        // O(1) - Instant retrieval
        System.out.println("Who is next? " + waitlist.get(0));

        // O(N) - Slow removal! Sarah and Mike must shift left to close the gap
        waitlist.remove(0); // John gets seated

        System.out.println("Current Waitlist: " + waitlist);

        // O(N) - Linear search to find Sarah's index
        int sarahPosition = waitlist.indexOf("Table for Sarah");
        System.out.println("Sarah is at index: " + sarahPosition);
    }
}
