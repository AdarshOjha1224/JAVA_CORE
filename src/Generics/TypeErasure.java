package Generics;

//Basic Definition (Interview-Ready)
//"Type Erasure is the internal mechanism used by the Java compiler to implement Generics. During the compilation process, the compiler enforces all type constraints, but then absolutely erases all generic type information from the compiled bytecode. It replaces type parameters with their bounds (or Object if unbounded) and automatically inserts type casts where necessary. This means that at runtime, the Java Virtual Machine (JVM) has absolutely no knowledge that generics were ever used."


//Of Which Concept is this an Upgradation?
//Type Erasure is essentially a clever hack for Backward Compatibility.
//When Java 5 introduced Generics in 2004, there were already millions of enterprise systems running on Java 4 and below. The creators of Java faced a massive dilemma: If they changed the bytecode format to understand Generics, old JVMs would break, and older libraries couldn't interact with new generic code.

//Type Erasure upgraded the compiler without upgrading the JVM. By erasing the generics after compiling, the resulting bytecode looks exactly like the old, pre-Java 5 bytecode (using raw Object types). This allowed legacy code and modern generic code to interoperate seamlessly on the same machine.


//Characteristics (The Erasure Rules)
//When compiling, Java applies these strict transformations behind the scenes:
//Unbounded Erasure: If a class uses <T>, every instance of T is replaced with java.lang.Object.
//Bounded Erasure: If a class uses <T Number extends>, every instance of T is replaced with the first bound, which is Number.
//Automatic Casting: When you retrieve an item from a generic structure, the compiler automatically inserts the necessary cast (e.g., (String)) into the bytecode so you don't have to write it.
//Bridge Methods: The compiler sometimes synthesizes hidden "bridge methods" to preserve polymorphism if you extend a generic class or interface.


//Advantages
//Absolute Backward Compatibility: The primary reason this exists. An old Java 1.4 library can accept a modern List<String> because, at runtime, it's just a raw List.
//No Runtime Overhead: Because all type checks happen at compile-time and types are erased, there is zero memory or processing penalty for using Generics at runtime.

//Disadvantages
//Runtime Type Ignorance: Because the types are gone, you cannot perform runtime type checks. Code like if (myList instanceof ArrayList<String>) causes a compile error. You can only check if (myList instanceof ArrayList<?>).
//No Generic Array Creation: You cannot write new T[10]. At runtime, T becomes Object, so the JVM would create an Object[], which violates the strict type safety of arrays.
//Method Overloading Conflicts: You cannot have two methods that only differ by generic types. public void process(List<String> a) and public void process(List<Integer> a) will clash because, after erasure, they both become public void process(List a).


//Code Example: The Illusion of Generics
//To understand Type Erasure, you need to see what you write versus what the Java compiler actually produces in the .class file.

// ==========================================
// 1. WHAT YOU WRITE (The Java Source Code)
// ==========================================
class Vault<T> {
    private T secretItem;

    public void store(T item) {
        this.secretItem = item;
    }

    public T retrieve() {
        return secretItem;
    }
}

public class TypeErasure {
    public static void main(String[] args) {
        // You write strictly typed code
        Vault<String> textVault = new Vault<>();
        textVault.store("Classified Document");

        // No casting needed in your code
        String file = textVault.retrieve();
    }
}

/*
// ==========================================
// 2. WHAT THE COMPILER PRODUCES (The Bytecode Equivalent)
// ==========================================
// Notice that all <T> and <String> tags are COMPLETELY GONE.

public class Vault {
    // Unbounded <T> is replaced with Object
    private Object secretItem;

    public void store(Object item) {
        this.secretItem = item;
    }

    public Object retrieve() {
        return secretItem;
    }
}

public class TypeErasureDemo {
    public static void main(String[] args) {
        // The <String> is erased. It's just a raw Vault now.
        Vault textVault = new Vault();

        textVault.store("Classified Document");

        // The compiler secretly inserts the (String) cast right here!
        String file = (String) textVault.retrieve();
    }
}
*/
