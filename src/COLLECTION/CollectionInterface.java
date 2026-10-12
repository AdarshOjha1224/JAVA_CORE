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


        // MY UNDERSTANDING --->>>>

        // ----------COLLECTION----------
        // Collection works with Wrapper class.
        System.out.println("----------COLLECTION----------");

        // I dont want to use anonymous class like -
        // Collection num1 = new Collection() {
        //       various overriding methods
        //       --------------------------
        //       --------------------------
        // }

        // collection - we didnt mention the datatype here.
        // So if you want to add integers value then you have to mention in generic <> .

        Collection<Integer> num1 = new ArrayList<Integer>();
        // Here the values are objects not integers.
        num1.add(30);
        num1.add(40);
        num1.add(20);
        num1.add(20);
        num1.add(10);
//        num1.add("50");

        // we have no indexing for collection interface.

        for(int n : num1) System.out.print(n + " ");
        System.out.println();

        for(Object n : num1){
            int num = (Integer)n;
            System.out.print(num*2 + " ");
        }
        System.out.println();
        System.out.println(num1);



        // ------------ LIST -------------
        System.out.println("------------ LIST -------------");

        // If you want to work with index value then use List instead of Collection.

        List<Integer> num2 = new ArrayList<Integer>();
        num2.add(1);
        num2.add(2);
        num2.add(3);
        num2.add(4);
        num2.add(5);

        System.out.println(num2.get(2)); // 3
        System.out.println(num2.indexOf(4)); // 3


        // ------------- SET --------------
        System.out.println("------------- SET --------------");
        // doesn't support index value
        // No duplicate elements

        Set<Integer> num3 = new HashSet<Integer>();
        num3.add(4);
        num3.add(5);
        num3.add(2);
        num3.add(7);
        num3.add(4);

        // Printing non-repeating elements and maybe sorted.
        for(int n : num3) System.out.print(n + " ");
        System.out.println();

        Set<Integer> num4 = new HashSet<Integer>();
        num4.add(67);
        num4.add(45);
        num4.add(89);
        num4.add(34);
        num4.add(98);

        // Here we are getting elements Unsorted
        for(int n : num4) System.out.print(n + " ");
        System.out.println();


        // To get Sorted elements.
        Set<Integer> num5 = new TreeSet<Integer>();
        num5.add(67);
        num5.add(45);
        num5.add(89);
        num5.add(67);
        num5.add(98);

        for(int n : num5) System.out.print(n + " ");
        System.out.println();

        // ------------- ITERATOR --------------
        System.out.println("------------- ITERATOR --------------");

        // num5.iterator will return values so we are storing them in values objects.
        Iterator<Integer> values = num5.iterator();
        // Not using a for loop.

        while(values.hasNext()) System.out.println(values.next());

        // ------------ MAP -------------
        System.out.println("------------ MAP<K,V> -------------");
        // Map is collection of key-value pairs.

        Map<String,Integer> students = new HashMap<>();
        // HashTable will work fine in the place of HashMap , but the difference is HashTable is synchronized.
        // If you want to use hashMap with multiple threads then use synchronized externally.

        // put - try to add the element if you already have this key just replace it.
        students.put("A",95);
        students.put("B",80);
        students.put("C",78);
        students.put("D",67);
        students.put("E",89);
        // this will update the value , not add a object.
        students.put("D",85);

        System.out.println(students);
        System.out.println(students.get("C"));

        // Access all the keys
        System.out.println(students.keySet());
        for(String key : students.keySet()){
            System.out.print(key + " " + students.get(key));
            System.out.println();
        }
    }
}
