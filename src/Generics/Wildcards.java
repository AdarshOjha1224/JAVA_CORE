package Generics;

//Basic Definition (Interview-Ready)
//"In Java Generics, the wildcard character (?) represents an 'unknown type.' It is used primarily as a type argument for method parameters, fields, or local variables to accept a generic object of any type. Unlike a named type parameter (like <T>), the wildcard is used when the code does not care about the exact type being passed, or when it only relies on methods from the base Object class."


//Of Which Concept is this an Upgradation?
//Wildcards are an upgradation of Generic Type Invariance.
//In standard inheritance, if Manager extends Employee, then an array of Manager[] is compatible with Employee[]. However, Generics are strictly invariant. A List<Manager> is NOT considered a subclass of List<Employee>, nor is List<String> a subclass of List<Object>.

//Because of this strictness, if you wrote a helper method public void printList(List<Object> list), the compiler would aggressively block you from passing a List<String> or List<Integer> into it. Wildcards (List<?>) were introduced as the ultimate wildcard pass, telling the compiler: "I don't know what type this list holds, and I don't care. Let any list in."


//Characteristics
//The Question Mark Syntax: It is written as a question mark inside the angle brackets, e.g., List<?>, Set<?>.
//Parameter Usage Only: You use wildcards when using a generic class (like in a method signature). You cannot use a wildcard when declaring a generic class (e.g., public class Box<?> is illegal).
//The Three Flavors:
//Unbounded Wildcard: List<?> (Accepts anything. We focus on this here).
//Upper Bounded Wildcard: List<? extends Number> (Accepts Number or its children. Covered in Part 7).
//Lower Bounded Wildcard: List<? super Integer> (Accepts Integer or its parents. Covered in Part 7).


//Advantages
//Maximum Flexibility: It solves the invariance problem. A method accepting Collection<?> can accept Collection<String>, Collection<User>, or Collection<Double> without complaining.
//Simpler Syntax than <T>: If a method doesn't need to return the generic type or use it to enforce relationships between parameters, ? is cleaner than declaring <T> in the method signature. public void print(List<?> list) is simpler than public <T> void print(List<T> list).

//Disadvantages
//The "Read-Only" Restriction: This is the most crucial detail for interviews! When you use an unbounded wildcard (List<?>), the compiler physically blocks you from adding anything to that list (except null). Because the compiler doesn't know what type the list actually is at runtime, it cannot guarantee type safety if you try to add() an item. It becomes a read-only structure.
//Limited Operation: Because the type is unknown, you can only pull items out as basic Object instances, limiting the methods you can call on them.


//Code Example: The Universal Inventory Printer
//Imagine an inventory management system where you have lists of Laptop, lists of Chair, and lists of SoftwareLicense. You want a single diagnostic method that can print the size and contents of any inventory list, regardless of what type of item it holds.

import java.util.ArrayList;
import java.util.List;

public class Wildcards {

    // 1. THE PROBLEM (Strict Invariance)
    // If we write this, it ONLY accepts exactly List<Object>.
    // It will reject List<String> or List<Integer>.
    public static void rigidPrint(List<Object> list) {
        System.out.println("Printing Object List...");
    }

    // 2. THE SOLUTION (Unbounded Wildcard)
    // By using <?> we say: "I accept a List of literally ANY unknown type."
    public static void universalPrint(List<?> list) {
        System.out.println("Inventory count: " + list.size());

        // We can iterate through it safely because whatever it is,
        // it is guaranteed to be at least an Object.
        for (Object item : list) {
            System.out.println(" - " + item.toString());
        }

        // THE READ-ONLY RESTRICTION:
        // You CANNOT add elements to a wildcard list!
        // list.add("New Item"); // ERROR: The compiler blocks this!
        // list.add(new Object()); // ERROR: Still blocked!

        // Why? Because 'list' might actually be a List<Integer> passed from main(),
        // and adding a String or random Object would corrupt it.
    }

    public static void main(String[] args) {

        List<String> softwareList = new ArrayList<>();
        softwareList.add("Windows 11 License");
        softwareList.add("IntelliJ IDEA License");

        List<Integer> palletIds = new ArrayList<>();
        palletIds.add(1045);
        palletIds.add(8092);

        // rigidPrint(softwareList); // COMPILE ERROR: List<String> is not List<Object>

        // Wildcards accept everything flawlessly
        System.out.println("--- Software Inventory ---");
        universalPrint(softwareList);

        System.out.println("\n--- Pallet Inventory ---");
        universalPrint(palletIds);
    }
}
