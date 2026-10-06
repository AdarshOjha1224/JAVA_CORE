package Generics;

//Basic Definition (Interview-Ready)
//"Bounded Types in Java Generics allow you to restrict the types that can be used as type arguments in a parameterized class or method. By using the extends keyword, you set an 'upper bound,' ensuring that the generic type parameter is either a specific class or a subclass of it, or implements a specific interface. This allows the compiler to safely grant access to the methods defined in that bounding class or interface."


//Of Which Concept is this an Upgradation?
//Bounded Types are an upgradation of Unbounded Generics (the simple <T> we used in Parts 2 and 3).
//When you use a simple <T>, the Java compiler erases it and replaces it with Object behind the scenes. This means you can only call basic Object methods like .toString() or .equals() on your generic variables.
//What if you want to write a generic Calculator class? You want it to accept Integer, Double, or Float, and you need to perform math on them. If you just use <T>, the compiler blocks you because an Object doesn't have math methods (like .doubleValue()). Bounded Types solve this by allowing you to say <T Number extends>. Now, the compiler knows for a fact that T will always be a number, granting you access to all methods inside the Number class!


//Characteristics
//The extends Keyword: Used for both classes and interfaces in generics. Even if you are bounding to an interface, you write <T Runnable extends>, not implements.
//Upper Bounding: <T SuperClass extends> means T can be SuperClass or any class that inherits from it.
//Multiple Bounds: You can restrict a type to inherit from a class and implement multiple interfaces using the & symbol.
//Syntax: <T & InterfaceA InterfaceB SomeClass extends>
//Rule: If you have multiple bounds, the Class must always come first, followed by interfaces.


//Advantages
//Expanded Method Access: The biggest advantage. By proving to the compiler that T is of a certain lineage, you unlock the ability to call specific methods on generic objects.
//Domain Restriction (Stricter Type Safety): You prevent illogical uses of your generic classes. A MathAnalyzer<T> should not accept a String or a Customer object. Bounded types block this misuse at compile-time.

//Disadvantages
//No Lower Bounding at Declaration: You can only use extends (upper bound) when declaring generic classes or methods. You cannot use super (lower bound) at the class/method declaration level (e.g., <T Integer super> is illegal). Lower bounds are reserved strictly for Wildcards (Part 7).
//Multiple Bounds Complexity: When using multiple bounds (&), the syntax can become highly unreadable, and it tightly couples your generic class to very specific inheritance hierarchies.


//Code Example: The Financial Calculator
//Imagine we are building a financial dashboard that calculates the average of a dataset (like daily revenues or user salaries). The dataset might come as an array of Integer (cents), Double (dollars), or Float. We need a generic method that processes only numbers.


// We restrict 'T' so it MUST be a subclass of java.lang.Number
// This includes Integer, Double, Float, Long, etc.
class DataAnalyzer<T extends Number> {

    private T[] data;

    // Constructor
    public DataAnalyzer(T[] data) {
        this.data = data;
    }

    // Since T extends Number, we can safely call Number methods like .doubleValue()
    // If T was just <T> (unbounded), the compiler would throw an error here.
    public double calculateAverage() {
        if (data == null || data.length == 0) {
            return 0.0;
        }

        double sum = 0.0;
        for (T number : data) {
            // Unlocked capability: .doubleValue() is guaranteed to exist!
            sum += number.doubleValue();
        }

        return sum / data.length;
    }
}

public class BoundedTypes {
    public static void main(String[] args) {

        // Scenario 1: Using Integers
        Integer[] dailySalesCount = {100, 150, 120, 130};
        DataAnalyzer<Integer> intAnalyzer = new DataAnalyzer<>(dailySalesCount);
        System.out.println("Average Sales: " + intAnalyzer.calculateAverage());

        // Scenario 2: Using Doubles
        Double[] dailyRevenue = {150.50, 200.75, 99.99, 300.00};
        DataAnalyzer<Double> doubleAnalyzer = new DataAnalyzer<>(dailyRevenue);
        System.out.println("Average Revenue: $" + doubleAnalyzer.calculateAverage());

        /*
        // Scenario 3: The Compile-Time Block
        // If we try to create an analyzer for Strings, it WON'T COMPILE.
        String[] names = {"Alice", "Bob", "Charlie"};

        // ERROR: Type parameter String is not within its bound
        DataAnalyzer<String> stringAnalyzer = new DataAnalyzer<>(names);
        */
    }
}
