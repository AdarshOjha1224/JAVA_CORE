package Generics;

// This is an excellent way to master Java Generics:

//1. Introduction to Generics.
//2. Generic Classes (Creating your own parameterized types)
//3. Generic Methods (Type parameters at the method level)
//4. Generic Interfaces (Applying generics to contracts/APIs)
//5. Bounded Types (Restricting which types can be used)
//6. Wildcards (?) (Handling unknown types flexibly)
//7. extends / super (Upper and Lower bounds in wildcards)
//8. Type Erasure (How Java handles generics behind the scenes)

//Basic Definition (Interview-Ready)
//"Generics in Java is a feature introduced in Java 5 that allows you to specify the exact data type an object, class, or method will operate on. It provides compile-time type safety by catching invalid types during compilation rather than at runtime, and it eliminates the need for explicit type casting."
//
//Of Which Concept is this an Upgradation?
//Generics represent an upgradation of the early Java Collections Framework.
//Before Java 5, collections (like ArrayList or HashMap) operated purely on the base Object class. Because every class in Java inherits from Object, you could put literally anything into a single list (a String, an Integer, a Customer object).
//
//While this seemed flexible, it was dangerous. When you retrieved an item from that collection, Java only knew it was an Object. You had to manually "cast" it back to its original type. If you accidentally cast an Integer to a String, your program would crash unexpectedly at runtime with a ClassCastException. Generics fixed this by letting you declare exactly what a collection is allowed to hold (e.g., ArrayList<String>).
//
//Characteristics
//Parameterization: Allows types (classes and interfaces) to be parameters when defining classes, interfaces, and methods.
//
//Compile-Time Verification: The Java compiler rigorously checks the types you use and immediately fails if you try to use an incompatible type.
//
//Backward Compatibility: Java implemented generics using a concept called "Type Erasure" (we will cover this deeply in Part 8), ensuring that code written with generics can still run on older Java Virtual Machines.
//
//Advantages
//Type Safety: The biggest advantage. Bugs are caught early during compilation (when writing code) rather than crashing in production.
//
//No Explicit Casting: You don't need to write (String) or (Employee) every time you pull data out of a data structure. The compiler handles it invisibly.
//
//Code Reusability: You can write a single sorting algorithm or data structure that works safely with integers, strings, or custom objects without duplicating code.
//
//Disadvantages
//Cannot Use Primitives: You cannot use primitive data types like int, double, or char with Generics. You must use their Wrapper classes (Integer, Double, Character).
//
//Increased Complexity: Advanced generic concepts (like wildcards and bounds) can make code syntax look intimidating and complex for beginners.
//
//Type Erasure Limitations: Because generics are removed at runtime, you cannot create generic arrays (e.g., new T[10] is illegal) or check generic types at runtime (e.g., if (obj instanceof List<String>) is illegal).


import java.util.ArrayList;
import java.util.List;


public class GenericsCoreConcepts {
    public static void main(String[] args) {

        // ==========================================
        // 1. THE OLD WAY (Before Java 5 - Raw Types)
        // ==========================================
        List oldNamesList = new ArrayList();

        oldNamesList.add("Alice");
        oldNamesList.add("Bob");
        // We accidentally add a number instead of a name.
        // The compiler DOES NOT complain because it accepts any "Object".
        oldNamesList.add(404);

        // Later in the program, we try to process the names
        try {
            for (int i = 0; i < oldNamesList.size(); i++) {
                // We MUST explicitly cast to (String).
                // This crashes on the 3rd loop with a ClassCastException!
                String name = (String) oldNamesList.get(i);
                System.out.println("Processing: " + name);
            }
        } catch (ClassCastException e) {
            System.out.println("CRASH! Cannot cast an Integer to a String.");
        }

        System.out.println("---------------------------------");

        // ==========================================
        // 2. THE MODERN WAY (Java 5+ with Generics)
        // ==========================================
        // We enforce that this list can ONLY hold Strings using <String>
        List<String> modernNamesList = new ArrayList<>();

        modernNamesList.add("Alice");
        modernNamesList.add("Bob");

        // modernNamesList.add(404);
        // ^ If you uncomment the line above, the code WON'T EVEN COMPILE.
        // The IDE will give a red error: "add(String) cannot be applied to (int)"
        // This is exactly what we want: failing early!

        for (int i = 0; i < modernNamesList.size(); i++) {
            // Notice: NO CASTING REQUIRED!
            // Java already knows everything inside is a String.
            String name = modernNamesList.get(i);
            System.out.println("Processing Safely: " + name);
        }
    }
}
