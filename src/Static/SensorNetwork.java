package Static;

//Interview-Ready Definition:
//The static keyword in Java indicates that a particular member (variable, method, or block) belongs to the class itself, rather than to any specific instance (object) of that class. Because it belongs to the class, a static member is loaded into memory exactly once when the class is loaded by the ClassLoader, and it is shared by all objects of that class.

//Characteristics:
//Static Variables: Only a single copy of the variable exists in memory (stored in the Metaspace/Method Area), regardless of how many objects are created. If one object changes the static variable, the change is reflected across all objects.
//Static Methods: Can be executed without creating an object of the class (e.g., Math.max(10, 20)).
//The Golden Rule: A static method can only directly access other static variables and static methods. It cannot use the this or super keywords because it has no concept of an instance.
//Static Blocks (static { ... }): A block of code executed exactly once when the class is first loaded into memory. It runs before the constructor and even before the main method.

//Evolution (The "Why"):
//Java is a strict Object-Oriented language, meaning everything must be an object. However, C/C++ developers heavily relied on "global variables" and standalone "functions" that didn't require object instantiation. Java introduced static to provide a safe, class-bound equivalent to global variables and functions.
//Without static, you would have to write new Math().max(10, 20), pointlessly creating and destroying a Math object just to do a simple calculation.
//It is heavily used today in frameworks (like Spring Boot) for defining constant configurations (public static final) and Singleton design patterns.

//Advantages & Disadvantages:
//Advantages: Exceptional memory efficiency for shared data (like a global counter or configuration settings). Eliminates the need to instantiate objects just to run utility methods.
//Disadvantages: Overusing static breaks Object-Oriented principles. Static methods cannot be overridden (no runtime polymorphism). Furthermore, static variables are notorious for causing thread-safety issues in multi-threaded applications (like web servers) because multiple threads might try to modify that single shared variable simultaneously.

public class SensorNetwork {
    // 1. Static Variable (Shared state across the entire application)
    // Every sensor created will share this exact same variable.
    public static int totalActiveSensors = 0;

    // Instance variable (Unique to each object)
    private String sensorId;

    // 2. Static Block (Used for one-time heavy initialization)
    // Runs exactly once when the JVM loads the SensorNetwork class into memory.
    static {
        System.out.println("[SYSTEM] Loading native network drivers...");
        System.out.println("[SYSTEM] Establishing secure MQTT connection pool...\n");
    }

    public SensorNetwork(String sensorId) {
        this.sensorId = sensorId;
        // Accessing the static variable inside an instance constructor
        totalActiveSensors++;
    }

    // 3. Static Method (Utility method called via the Class name)
    // Notice: We cannot use 'this.sensorId' in here. The compiler would throw an error!
    public static void printNetworkStatus() {
        System.out.println("Total sensors currently active: " + totalActiveSensors);
    }

    public static void main(String[] args) {
        // Static block has ALREADY executed before this first line of main()!

        // Calling static method without creating any objects
        SensorNetwork.printNetworkStatus(); // Output: 0

        // Creating instances
        SensorNetwork node1 = new SensorNetwork("ESP32-01");
        SensorNetwork node2 = new SensorNetwork("ESP32-02");
        SensorNetwork node3 = new SensorNetwork("Arduino-01");

        // The static variable is updated globally
        SensorNetwork.printNetworkStatus(); // Output: 3

        // Proof that the variable is shared:
        // Accessing it via instances (bad practice, but proves the point)
        System.out.println("Node 1 sees total: " + node1.totalActiveSensors); // Output: 3
        System.out.println("Node 2 sees total: " + node2.totalActiveSensors); // Output: 3
    }
}
