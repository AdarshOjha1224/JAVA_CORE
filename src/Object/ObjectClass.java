package Object;

import java.util.HashSet;
import java.util.Objects;

// Interview-Ready Definition:
//The Object class (located in the java.lang package) is the cosmic superclass—the root of the class hierarchy in Java. Every single class you write directly or indirectly inherits from Object. If your class doesn't explicitly extend another class, the Java compiler silently adds extends Object behind the scenes.

//Characteristics:
//Universal Reference: A variable of type Object can hold a reference to absolutely any object in Java (e.g., Object obj = new Scanner(System.in);).
//Fundamental Blueprint: It equips every Java object with 11 core methods, handling garbage collection (finalize()), thread synchronization (wait(), notify()), object cloning (clone()), and state representation/comparison (toString(), equals(), hashCode()).

//Evolution (The "Why"):
//Java introduced a single root class to standardize fundamental behaviors across all objects. Without Object, the Java Collections Framework (like ArrayList or HashMap) couldn't have been built to hold "any type of object," and the JVM wouldn't have a unified way to manage memory or thread locking. The default implementations provided by Object are based on memory addresses, designed to be upgraded (overridden) by the developer to reflect actual business logic.

//Advantages & Disadvantages:
//Advantages: Guarantees a baseline level of functionality (polymorphism, threading, memory management) for every object in the ecosystem.
//Disadvantages: The default implementations of equals() and hashCode() are almost useless for real-world applications because they compare memory addresses instead of actual data. Forgetting to override them causes severe, hard-to-trace bugs, especially when using collections like HashSet or HashMap.

//2. toString()
//Default Behavior: Returns the class name followed by the @ symbol and the object's memory hash (e.g., IoTSensor@15db9742).
//The Upgrade (Why Override?): Memory hashes are useless for debugging. You override toString() to return a readable, often JSON-like string showing the actual state (field values) of the object. This is critical for logging application data.

//3. equals(Object obj)
//Default Behavior: Acts exactly like the == operator. It only returns true if both references point to the exact same memory location.
//The Upgrade (Why Override?): In reality, if you have two separate sensor objects pulling data from the same physical DHT11 sensor with the same ID, they are logically the "same" sensor. You override equals() to compare the values of their fields rather than their memory addresses.

//4. hashCode()
//Default Behavior: Converts the internal memory address of the object into an integer.
//The Upgrade (Why Override?): Whenever you override equals(), you must override hashCode(). This is a strict Java contract. Hash-based collections (like HashSet and HashMap) use hashCode() to sort objects into "buckets" for lightning-fast retrieval.
//The Contract: If two objects are equal according to equals(), they must return the exact same hashCode(). If you don't override this, two logically identical objects will be placed in different hash buckets, and your HashMap will fail to find them.

// By default, this implicitly extends Object
public class ObjectClass {
        private String sensorId;
        private String type; // e.g., "DHT11", "MQ-135"

        public ObjectClass(String sensorId, String type) {
            this.sensorId = sensorId;
            this.type = type;
        }

        // 1. Upgrading toString() for readable logging
        @Override
        public String toString() {
            return "ObjectClass{id='" + sensorId + "', type='" + type + "'}";
        }

        // 2. Upgrading equals() to compare actual business data
        @Override
        public boolean equals(Object obj) {
            // Step A: Optimization - check if they are the exact same object in memory
            if (this == obj) return true;

            // Step B: Null check and Type check
            if (obj == null || this.getClass() != obj.getClass()) return false;

            // Step C: Cast the object and compare the actual fields
            ObjectClass otherSensor = (ObjectClass) obj;
            return this.sensorId.equals(otherSensor.sensorId) &&
                    this.type.equals(otherSensor.type);
        }

        // 3. Upgrading hashCode() to respect the equals() contract
        @Override
        public int hashCode() {
            // Objects.hash() generates a consistent integer based on the provided fields
            return Objects.hash(sensorId, type);
        }

        public static void main(String[] args) {
            ObjectClass node1 = new ObjectClass("ESP32-A", "Temperature");
            ObjectClass node2 = new ObjectClass("ESP32-A", "Temperature");

            // Without overriding toString(), this would print memory garbage.
            System.out.println("Node 1: " + node1.toString());

            // Without overriding equals(), this would be false (different memory objects).
            // Because we overrode it, it correctly returns true.
            System.out.println("Are sensors equal? " + node1.equals(node2));

            // The Hash Contract test
            HashSet<ObjectClass> networkNodes = new HashSet<>();
            networkNodes.add(node1);

            // HashSet checks hashCode() first, then equals(). 
            // Because both are overridden, it recognizes node2 is a duplicate of node1 and won't add it.
            networkNodes.add(node2);

            System.out.println("Total unique sensors in network: " + networkNodes.size());
            // Output: 1 (Proving the equals/hashCode contract works perfectly)
        }
    }
