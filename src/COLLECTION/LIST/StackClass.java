package COLLECTION.LIST;

// Basic Definition (Interview Perfect)
//Stack is a legacy class that extends Vector. It represents a Last-In-First-Out (LIFO) data structure, meaning the last element added to the stack will be the very first one removed—much like a physical stack of plates at a buffet.
//
//Concept Upgradation
//Because Stack extends Vector, it inherited all of Vector's flaws (slowness, full-object synchronization locking). More problematically, it inherited all of Vector's methods. A pure Stack should only allow you to access the top element. But because Java's Stack extends Vector, you can technically use stack.get(0) or stack.insertElementAt(), completely breaking the LIFO abstraction.
//
//The modern upgrade is to use the Deque interface (specifically ArrayDeque) when you need a stack.
//
//Core Characteristics
//LIFO Principle: It operates strictly on the Last-In-First-Out principle using specific terminology:
//push(E item): Pushes an item onto the top of the stack.
//pop(): Removes and returns the object at the top of the stack.
//peek(): Looks at the object at the top without removing it.


//Why ArrayDeque is Preferred
//The official Java documentation explicitly recommends using ArrayDeque instead of Stack.
//Speed: ArrayDeque is not synchronized, making it drastically faster.
//Memory: ArrayDeque uses a highly optimized circular array structure rather than Vector's outdated resizing logic.
//Encapsulation: By typing your variable as a Deque, you prevent developers from accidentally using index-based methods that break the LIFO rule.


//Real-World Code Example
//Imagine the "Undo" feature in a text editor. Every time you type a word, it goes on the stack. When you hit Ctrl+Z, the most recent word is popped off first.

import java.util.*;

public class StackClass {
    public static void main(String[] args) {
        // MODERN APPROACH: Using ArrayDeque as a Stack
        Deque<String> undoStack = new ArrayDeque<>();

        // Pushing actions onto the top of the stack
        undoStack.push("Typed: 'Hello'");
        undoStack.push("Typed: ' World'");
        undoStack.push("Deleted: 'World'");

        // Peeking at the top without removing
        System.out.println("Next undo action will be: " + undoStack.peek());
        // Output: Deleted: 'World'

        // Popping items off (LIFO - Last In, First Out)
        System.out.println("Executing Undo: " + undoStack.pop()); // Pops "Deleted: 'World'"
        System.out.println("Executing Undo: " + undoStack.pop()); // Pops "Typed: ' World'"

        System.out.println("Remaining history: " + undoStack.size()); // Output: 1
    }
}
