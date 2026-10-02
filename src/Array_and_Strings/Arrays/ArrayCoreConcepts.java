package Array_and_Strings.Arrays;

import java.util.Arrays;

// Interview-Ready Definition:An array is a dynamically allocated object that stores a fixed-size, contiguous (sequential) sequence of elements of the same type. In Java, arrays are created on the Heap memory using the new keyword, which explicitly instructs the Java Virtual Machine (JVM) to allocate memory at runtime. The variable that holds the array is simply a reference (memory address) stored on the Stack.

// Characteristics:
// Contiguous Memory: Elements are stored right next to each other in RAM. If the first element is at memory address 1000 and each integer takes 4 bytes, index 1 is strictly at 1004, index 2 at 1008, etc.
// Fixed Size: Once an array is instantiated, its length cannot be changed. You can only overwrite the values inside it.
// 0-Indexed: The first element is always at index 0.
// The new Keyword's Job: When you write new, you are telling the JVM: "Find a continuous block of free space in the Heap big enough to hold this data, reserve it, assign default values (like 0 for numbers, null for objects), and return the starting memory address back to my variable.

// "Evolution (The "Why"):
// Why Arrays? Without arrays, storing 1,000 temperature readings would require declaring 1,000 distinct variables (temp1, temp2, etc.). Arrays allow grouping under a single variable name, unlock the ability to use loops, and are mathematically the most efficient way for a CPU to read sequential data.
// Why new? In older languages like C, developers had to manually calculate bytes and use functions like malloc() to allocate memory, and free() to release it. This caused massive security flaws (memory leaks and buffer overflows). Java introduced new to make memory allocation safe and automatic, offloading the destruction of the array to the Garbage Collector once the program no longer needs it. Java also bounds-checks arrays at runtime, throwing an ArrayIndexOutOfBoundsException instead of allowing a program to read memory it shouldn't.

// Advantages & Disadvantages:
// Advantages: Phenomenal read speed. Accessing any element by its index is an $O(1)$ operation (instantaneous), because the JVM simply does a math calculation: (start_address) + (index * data_size).
// Disadvantages: Inflexibility. Because arrays are fixed in size, if you need to add an 11th item to a 10-item array, you must create a brand new, larger array and manually copy all the old elements over. Furthermore, inserting or deleting an element in the middle is extremely slow ($O(n)$) because every subsequent element must physically shift left or right in memory.

public class ArrayCoreConcepts {
    public static void main(String[] args) {

        // 1. Declaration and Allocation using 'new'
        // 'sensorReadings' is stored on the Stack.
        // The actual block holding 5 integers is allocated on the Heap.
        int[] sensorReadings = new int[5];

        // Because of 'new', Java automatically initialized them to default values (0).
        System.out.println("Default values: " + Arrays.toString(sensorReadings));
        // Output: [0, 0, 0, 0, 0]

        // 2. Writing data (Direct memory access)
        sensorReadings[0] = 35;
        sensorReadings[1] = 42;
        sensorReadings[2] = 38;

        // 3. Array Literal Syntax (The 'new' keyword happens invisibly behind the scenes)
        // Used when you already know the exact values upfront.
        String[] activePorts = {"COM1", "COM3", "COM4"};

        // 4. Memory Reference Trap
        int[] originalArray = {10, 20, 30};

        // This DOES NOT create a new array.
        // 'fakeCopy' just points to the exact same memory address as 'originalArray'.
        int[] fakeCopy = originalArray;

        fakeCopy[0] = 999;

        // Both variables show 999 because they look at the same Heap location.
        System.out.println("Original array after modifying copy: " + originalArray[0]);

        // 5. The proper way to resize/copy (Creating a brand new object)
        // Arrays.copyOf internally creates a 'new int[5]', copies the 3 old values, and adds two 0s.
        int[] expandedArray = Arrays.copyOf(originalArray, 5);
        System.out.println("Expanded array: " + Arrays.toString(expandedArray));
        // Output: [999, 20, 30, 0, 0]
    }
}
