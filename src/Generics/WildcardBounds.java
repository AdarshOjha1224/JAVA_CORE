package Generics;

//Basic Definition (Interview-Ready)"Bounded wildcards in Java Generics restrict the unknown type (?) to a specific inheritance hierarchy. An Upper Bounded Wildcard (<? extends T>) dictates that the type must be T or any of its subclasses, making the structure safe for reading. A Lower Bounded Wildcard (<? super T>) dictates that the type must be T or any of its superclasses, making the structure safe for writing. This is governed by the famous PECS principle: Producer Extends, Consumer Super.


// "Of Which Concept is this an Upgradation?This is an upgradation of Unbounded Wildcards (<?>).As we saw in Part 6, List<?> is extremely flexible but heavily restricted: when you read from it, you only get an Object, and you are absolutely forbidden from adding items to it. Bounded wildcards upgrade this by restoring partial read and write capabilities safely. By establishing an inheritance boundary, the compiler knows enough about the types to allow specific operations that an unbounded wildcard would block.


// Characteristics (The PECS Principle)
// To master this topic, you must understand PECS (coined by Joshua Bloch in Effective Java):
// Producer extends (Upper Bound): Use <? extends T> when the collection is a producer of data (you are reading from it).
// Rule: You can safely read items as type T.Restriction: You cannot write/add anything to it (except null).
// Consumer super (Lower Bound): Use <? super T> when the collection is a consumer of data (you are writing to it).
// Rule: You can safely write/add items of type T or its subclasses.Restriction: When you read from it, Java only guarantees an Object, requiring manual casting if you want the specific type.



// Advantages:
// Ultimate API Flexibility: This allows frameworks to be incredibly forgiving. If an API method promises to only read Employee data, <? extends Employee> allows a user to pass in a List<Manager> or List<Director> seamlessly.
// Prevents Heap Pollution: By mathematically enforcing what can be read and written based on class hierarchy, it completely eliminates runtime ClassCastExceptions in complex polymorphic structures.

// Disadvantages:
// Steep Learning Curve: The PECS rule is notoriously counter-intuitive for beginners. Understanding why you cannot read a Manager from List<? super Manager> trips up many developers.
// Mutually Exclusive: You cannot define both an upper and lower bound on the same wildcard. <? extends Manager super Employee> is illegal syntax.


// Code Example: The HR Payroll SystemImagine a company hierarchy: Person (Base) --> Employee (Child) --> Manager (Grandchild). We need utility methods to process payroll and recruit new managers.

import java.util.ArrayList;
import java.util.List;

// --- 1. Class Hierarchy ---
class Person { }

class Employee extends Person {
    public void paySalary() {
        System.out.println("Paying salary to Employee.");
    }
}

class Manager extends Employee {
    public void paySalary() {
        System.out.println("Paying higher salary to Manager.");
    }
}

public class WildcardBounds {

    // --- 2. PRODUCER EXTENDS (Upper Bound) ---
    // We only want to READ employees to pay them.
    // Accepts List<Employee>, List<Manager>, etc.
    public static void processPayroll(List<? extends Employee> staffList) {
        for (Employee emp : staffList) {
            // We can safely read and call Employee methods
            emp.paySalary();
        }

        // THE CATCH: We CANNOT add to an 'extends' wildcard!
        // staffList.add(new Employee()); // ERROR: Compiler blocks this.
        // Why? Because staffList might actually be a List<Manager>.
        // Adding a standard Employee to a List<Manager> would break type safety!
    }

    // --- 3. CONSUMER SUPER (Lower Bound) ---
    // We want to WRITE/ADD a new Manager to a list.
    // Accepts List<Manager>, List<Employee>, or List<Person>.
    public static void onboardManager(List<? super Manager> recruitingList) {

        // We can safely ADD a Manager (or its subclasses)
        recruitingList.add(new Manager());
        System.out.println("Successfully added a new Manager to the system.");

        // THE CATCH: Reading from a 'super' wildcard is limited!
        // Manager m = recruitingList.get(0); // ERROR: Compiler blocks this.
        // Why? Because recruitingList might actually be a List<Person>.
        // Java can only guarantee that the item is an Object.
        Object obj = recruitingList.get(0); // This works, but isn't very useful.
    }

    public static void main(String[] args) {

        List<Employee> employeeDatabase = new ArrayList<>();
        List<Manager> managerDatabase = new ArrayList<>();
        List<Person> generalDatabase = new ArrayList<>();

        System.out.println("--- Processing Payroll (Producer Extends) ---");
        // We can pass different lists because both contain Employee or subclasses
        employeeDatabase.add(new Employee());
        managerDatabase.add(new Manager());

        processPayroll(employeeDatabase);
        processPayroll(managerDatabase);
        // processPayroll(generalDatabase); // ERROR: Person does not extend Employee

        System.out.println("\n--- Onboarding (Consumer Super) ---");
        // We can add a Manager to any list that holds Manager or its superclasses
        onboardManager(managerDatabase);
        onboardManager(employeeDatabase);
        onboardManager(generalDatabase);
    }
}
