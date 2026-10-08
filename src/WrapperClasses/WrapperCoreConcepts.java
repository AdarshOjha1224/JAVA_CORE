package WrapperClasses;

//Interview-Ready Definition:
//Wrapper classes provide a mechanism to encapsulate primitive data types (like int, boolean, double) into fully-fledged objects. For every one of the 8 primitive types in Java, there is a corresponding Wrapper class (e.g., Integer for int, Boolean for boolean) located in the java.lang package.

//Characteristics:
//Object Properties: Because they are objects, they contain utility methods (like parsing) and can be assigned a null value—a state impossible for standard primitives.
//Immutability: Just like the String class, Wrapper objects are immutable. Once created, their internal primitive value cannot be changed.
//Final: All wrapper classes are declared as final and cannot be subclassed.
//The Big 8: byte -> Byte, short -> Short, int -> Integer, long -> Long, float -> Float, double -> Double, char -> Character, boolean -> Boolean.
//Allows null values: A primitive int defaults to 0 and can never be null. An Integer object can be null, which is critical for representing "missing data" in databases.
//Integer Caching (The Interview Trap): To save memory, Java caches Integer objects for values strictly between -128 and 127. If you autobox an int within this range, Java reuses the exact same object in memory. If the value is outside this range (e.g., 128), Java creates a brand new object.
//Utility Methods: Wrappers are packed with static methods to convert strings to numbers (Integer.parseInt()), find max/min values (Integer.MAX_VALUE), and check data types (Character.isDigit()).

//Evolution (The "Why"):
//Java kept primitives for performance (they execute faster and use less memory than objects). However, Java's most powerful architectures—specifically the Collections Framework (like ArrayList, HashMap) and Generics—only operate on Objects. Wrapper classes bridge this gap, allowing primitive data to participate in object-only ecosystems. Furthermore, in frameworks like Spring Boot or when mapping to SQL databases, wrappers are mandatory because database columns can be NULL, whereas a primitive int defaults to 0 (which could represent actual data rather than missing data).

//Advantages & Disadvantages:
//Advantages: Enables primitives to be stored in data structures, provides powerful utility methods (like Integer.parseInt()), and safely represents missing data/state via null.
//Disadvantages: Memory overhead. A primitive int takes exactly 32 bits, while an Integer object takes at least 128 bits due to object metadata. They also require Garbage Collection.


//2. Autoboxing and Unboxing
//Interview-Ready Definition:
//Autoboxing is the automatic conversion the Java compiler makes from a primitive type to its corresponding wrapper class (e.g., automatically turning an int into an Integer). Unboxing is the exact reverse process, converting an object of a wrapper type back into its corresponding primitive value.
//Characteristics:
//It happens invisibly at compile-time. The compiler silently injects .valueOf() for autoboxing and .intValue() (or the respective type method) for unboxing.
//It is triggered automatically during variable assignments, method parameter passing, and arithmetic operations.

//Evolution (The "Why"):
//Before Java 5, developers had to manually wrap and unwrap primitives. To put a number in an ArrayList, you had to write list.add(new Integer(5)); and to get it out, you had to write int val = list.get(0).intValue();. This created verbose, cluttered code. Autoboxing and Unboxing were introduced to make the code drastically cleaner and developer-friendly.
//Advantages & Disadvantages:
//Advantages: Clean, readable syntax. Eliminates boilerplate code when moving data in and out of Collections.
//Disadvantages (The Hidden Traps):
//NullPointerExceptions: If a wrapper object is null and the compiler attempts to unbox it into a primitive, it throws a fatal NullPointerException.
//Performance drain: Performing arithmetic inside a loop using Wrapper classes triggers invisible boxing and unboxing on every iteration, creating thousands of temporary objects and choking the CPU with Garbage Collection.

import java.util.ArrayList;
import java.util.List;

public class WrapperCoreConcepts {
    public static void main(String[] args) {

        // 1. Collections and Autoboxing
        // List<double> is ILLEGAL. Collections demand Objects.
        List<Double> sensorReadings = new ArrayList<>();

        // AUTOBOXING: The compiler implicitly does Double.valueOf(35.5)
        System.out.println(Double.valueOf(35.5));
        sensorReadings.add(35.5);

        // UNBOXING: The compiler implicitly does sensorReadings.get(0).doubleValue()
        double currentTemp = sensorReadings.get(0);

        // 2. Powerful Utility MethodsConcept of "static" keyword with variable, method, block or Classes(inner).
        // Crucial when parsing string payloads from hardware (like an ESP32) or a React frontend
        String payload = "120";
        int parsedValue = Integer.parseInt(payload); // Converts String directly to primitive

        // 3. The Null Advantage (Handling Database/API absence)
        // A primitive defaults to 0, which might mean a sensor is offline.
        // A wrapper can be null, meaning "no data recorded yet."
        Integer databaseRecordId = null;

        // 4. THE TRAP: Unboxing NullPointerException
        try {
            // UNBOXING FAILS: compiler tries databaseRecordId.intValue(), but the object is null!
            int id = databaseRecordId;
        } catch (NullPointerException e) {
            System.out.println("Caught hidden exception: Cannot unbox a null wrapper!");
        }

        // 5. THE TRAP: Accidental Autoboxing in Loops
        // Notice we used Long (Wrapper) instead of long (primitive)
        Long sum = 0L;
        for (long i = 0; i < 1000; i++) {
            // BAD PRACTICE: Unboxes 'sum', adds 'i', then autoboxes the result back to Long.
            // This silently creates 1,000 abandoned objects in memory!
            sum += i;
        }
    }
}
