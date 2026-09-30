package Method;

// Interview-Ready Definition:
//A method is a block of code bound to a class or object that executes only when called.

//Method Declaration: Consists of an access modifier (public, private), a return type, a method name, and a parameter list.
//Parameters: Variables defined in the method signature that act as placeholders for the data you pass in.
//Return Values: The specific data a method sends back to the caller after execution (dictated by the return type, or void if nothing is returned).

//Characteristics:
//Pass-by-Value (The Golden Rule of Java): Java is strictly pass-by-value. When you pass a variable to a method, Java passes a copy of the variable.
//For primitives (like int), it copies the actual numeric value. Changing it inside the method does not affect the original.
//For objects (like an array or a custom class), it copies the memory reference. You cannot make the original reference point to a new object, but you can modify the internal state of the object it points to.

//Method Overloading: The ability to create multiple methods with the exact same name in the same class, as long as their parameter lists differ (different types, number of parameters, or order). This is a form of Compile-Time Polymorphism.

//Varargs (...): Variable-Length Arguments allow a method to accept zero or multiple arguments of the same type. Under the hood, Java treats it as an array. It must be the final parameter in the method signature.

//Recursion Basics: A method that calls itself from within its own body. Every recursive method absolutely requires a base case (a condition to stop calling itself); otherwise, it will run infinitely until the JVM crashes.

//Evolution (The "Why"):
//Why Methods? They evolved from procedural programming (like C functions) to enforce the DRY principle (Don't Repeat Yourself) and encapsulate logic into modular, testable blocks.
//Why Overloading? In early languages, developers had to invent tedious names like printInteger(), printString(), printDouble(). Overloading allows a single, intuitive method name (print()) to handle different data types seamlessly.
//Why Varargs? Before Java 5, if you wanted a method to process an unknown number of items, you had to manually construct an array and pass it in. Varargs was introduced to make APIs cleaner and eliminate array boilerplate.

//Advantages & Disadvantages:
//Advantages: Overloading creates incredibly clean APIs. Varargs makes utility methods highly flexible. Recursion provides elegant solutions for traversing complex data structures (like folder trees or database hierarchies).
//Disadvantages:
//Overuse of overloading combined with varargs can confuse the compiler, leading to ambiguity errors.

//Recursion is heavily memory-intensive. Each recursive call consumes a frame on the Call Stack. Without a proper base case, it triggers a fatal StackOverflowError.

import java.util.Arrays;

public class Methods {

        // 1. Basic Method Declaration (Parameters and Return Value)
        public double calibrate(double rawReading, double offset) {
            return rawReading + offset;
        }

        // 2. Method Overloading (Same name, different parameters)
        // Useful when offset isn't provided, we default it to 0
        public double calibrate(double rawReading) {
            return rawReading + 0.0;
        }

        // 3. Varargs (Accepts any number of sensor readings)
        // Must be the last parameter. Called like: calculateAverage("DHT11", 35.5, 36.1, 35.8)
        public double calculateAverage(String sensorId, double... readings) {
            if (readings.length == 0) return 0.0; // Prevent division by zero

            double sum = 0;
            for (double temp : readings) { // Treated as a standard array internally
                sum += temp;
            }
            return sum / readings.length;
        }

        // 4. Pass-by-Value (The Object Reference Trap)
        public void resetSensorStatus(String[] statusFlags, int batteryLevel) {
            // Modifying the array's contents WORKS because we have a copy of the reference
            // pointing to the exact same array in memory.
            statusFlags[0] = "OFFLINE";

            // Modifying the primitive DOES NOT affect the original variable in main()
            // because we only received a copy of the number.
            batteryLevel = 100;
        }

        // 5. Recursion (Calculating factorial for data permutations)
        public int calculatePermutations(int n) {
            // Base case: without this, we get a StackOverflowError
            if (n <= 1) {
                return 1;
            }
            // Recursive step: method calls itself with a smaller problem
            return n * calculatePermutations(n - 1);
        }

        public static void main(String[] args) {
            Methods processor = new Methods();

            // Testing Overloading
            System.out.println(processor.calibrate(34.2, 1.5)); // Calls 2-param version
            System.out.println(processor.calibrate(34.2));      // Calls 1-param version

            // Testing Varargs
            double avg = processor.calculateAverage("ESP32-Temp", 32.1, 32.5, 33.0);
            System.out.println("Average: " + avg);

            // Testing Pass-by-Value
            String[] systemFlags = {"ONLINE", "ACTIVE"};
            int systemBattery = 45;

            processor.resetSensorStatus(systemFlags, systemBattery);

            System.out.println("Flags after method: " + Arrays.toString(systemFlags)); // Output: [OFFLINE, ACTIVE]
            System.out.println("Battery after method: " + systemBattery);              // Output: 45 (Unchanged!)
        }
    }
