package Object;

import java.util.HashSet;
import java.util.Objects;

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
