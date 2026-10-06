package Generics;

//Basic Definition (Interview-Ready)
//"A Generic Method in Java is a method that introduces its own type parameter, independent of the class it resides in. The scope of the type parameter is limited strictly to that specific method. By declaring a type parameter (like <T>) right before the method's return type, it allows a single method definition to operate type-safely on various data types without requiring the enclosing class to be generic."


//Of Which Concept is this an Upgradation?
//Generic Methods are an upgradation of Method Overloading for Type Handling and Object-based Utility Methods.
//Before generic methods, if you wanted to write a utility method to simply print the contents of an array, you had to write a separate method for every single type (one for String[], one for Integer[], one for Double[], etc.). This resulted in massive code bloat. Alternatively, you could accept an Object[], but that stripped away type safety. Generic methods solve this by allowing you to write the logic exactly once, adapting to whatever type is passed into the arguments.


//Characteristics
//Placement of Type Parameter: The generic type declaration (e.g., <T>) MUST be placed before the return type in the method signature.
//Syntax: public static <T> void printArray(T[] array)
//Class Independence: A generic method can exist inside a completely normal, non-generic class.
//Static Compatibility: Unlike class-level type parameters, generic methods can be static. This is because the type T is determined at the moment the method is called, not when the class is instantiated.
//Type Inference: When you call a generic method, you rarely have to specify the type in angle brackets (e.g., MyClass.<String>printArray(arr)). The Java compiler is smart enough to look at the arguments you passed and infer that T is a String.


//Advantages
//Granularity: You don't have to force an entire class to be generic (and force users to instantiate it with a type) just because a single helper method needs to handle multiple types.
//Perfect for Utility Classes: This is the backbone of Java's Collections and Arrays utility classes (e.g., Collections.sort()). You can create powerful, reusable static tools.
//Reduces Code Bloat: Eliminates the need to write identical overloaded methods just to satisfy Java's strict typing system.

//Disadvantages
//Limited Object Interactions: Inside a generic method, because the compiler doesn't know what T will be at runtime, you can only safely call methods that belong to the base java.lang.Object class (like .toString() or .equals()). You cannot call .length() or .toUpperCase() because T might not be a String. (Note: We will solve this in Part 5: Bounded Types).
//Complex Signatures: When a method requires multiple generic parameters or complex return types, the signature can become difficult to read: public static <K, V> Map<V, K> reverseMap(Map<K, V> map).

import java.util.Random;

// Notice the class itself is NOT generic. It's a standard utility class.
public class GenericMethods {
    // 1. The <T> is placed before the return type 'T'.
    // 2. This is a static method, so it can be called without instantiating UtilityAgent.
    public static <T> T pickRandom(T[] items) {
        if (items == null || items.length == 0) {
            return null; // Safety check
        }

        Random random = new Random();
        int randomIndex = random.nextInt(items.length);

        // Returns an element of the exact type that was passed in
        return items[randomIndex];
    }

    public static void main(String[] args) {

        // Scenario 1: Array of Strings
        String[] names = {"Alice", "Bob", "Charlie", "Diana"};

        // Type Inference in action: We don't need to write UtilityAgent.<String>pickRandom()
        // Java sees we passed a String[], so it guarantees a String comes out.
        String randomName = GenericMethods.pickRandom(names);
        System.out.println("Random Name: " + randomName);

        // Scenario 2: Array of Integers (Must use Wrapper class, not primitive 'int')
        Integer[] numbers = {10, 20, 30, 40, 50, 99};

        // Java infers T is Integer. No casting required!
        Integer randomNumber = GenericMethods.pickRandom(numbers);
        System.out.println("Random Number: " + randomNumber);

        /*
        // Scenario 3: Compile-Time Error Example
        // If we try to assign the result to the wrong type, the compiler blocks it instantly.
        String wrongType = UtilityAgent.pickRandom(numbers); // ERROR: Incompatible types
        */
    }
}
