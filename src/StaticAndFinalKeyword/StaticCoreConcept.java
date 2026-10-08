package StaticAndFinalKeyword;

//Interview-Ready Definition:
//The static keyword in Java indicates that a particular member (variable, method, or block) belongs to the class itself, rather than to any specific instance (object) of that class. Because it belongs to the class, a static member is loaded into memory exactly once when the class is loaded by the ClassLoader, and it is shared by all objects of that class.

//Characteristics:
//Static Variables: Only a single copy of the variable exists in memory (stored in the Metaspace/Method Area), regardless of how many objects are created. If one object changes the static variable, the change is reflected across all objects.
//Static Methods: Can be executed without creating an object of the class (e.g., Math.max(10, 20)).
//The Golden Rule: A static method can only directly access other static variables and static methods. It cannot use the this or super keywords because it has no concept of an instance.
//Static Blocks (static { ... }): A block of code executed exactly once when the class is first loaded into memory. It runs before the constructor and even before the main method.
//Static Classes: Only inner (nested) classes can be declared static. A static inner class can be instantiated without needing an object of the outer class.

//Evolution (The "Why"):
//Java is a strict Object-Oriented language, meaning everything must be an object. However, C/C++ developers heavily relied on "global variables" and standalone "functions" that didn't require object instantiation. Java introduced static to provide a safe, class-bound equivalent to global variables and functions.
//Without static, you would have to write new Math().max(10, 20), pointlessly creating and destroying a Math object just to do a simple calculation.
//It is heavily used today in frameworks (like Spring Boot) for defining constant configurations (public static final) and Singleton design patterns.

//Advantages & Disadvantages:
//Advantages: Exceptional memory efficiency for shared data (like a global counter or configuration settings). Eliminates the need to instantiate objects just to run utility methods.
//Disadvantages: Overusing static breaks Object-Oriented principles. Static methods cannot be overridden (no runtime polymorphism). Furthermore, static variables are notorious for causing thread-safety issues in multi-threaded applications (like web servers) because multiple threads might try to modify that single shared variable simultaneously.

//4. Evolution / Upgradation Context
//What did it upgrade?
//In older languages like C, developers relied on Global Variables to share data across different parts of a program. Global variables were chaotic—any function could modify them, leading to unpredictable bugs and namespace clashes.
//
//Strict Object-Oriented design dictates that everything must be tied to an object. But forcing a developer to write Math m = new Math(); m.sqrt(9); is ridiculously inefficient for a simple utility function. The static keyword upgraded this by providing a controlled compromise. It gives developers the shared, accessible power of "global variables and global functions," but safely organizes them inside the strict namespace of a Class.


class Employee {

    // 1. Static Variables (Shared across ALL employees)
    public static final String COMPANY_NAME; // Constant
    private static int totalEmployeesHired = 0; // Counter

    // 2. Static Block (Runs exactly once when the class is loaded)
    static {
        System.out.println("[SYSTEM]: Loading Company Configuration...");
        COMPANY_NAME = "TechGlobal Solutions";
        // Often used to load DB drivers or configuration files
    }

    // Instance Variables (Unique to EACH employee)
    private String employeeName;
    private String employeeId;

    // Constructor
    public Employee(String employeeName) {
        this.employeeName = employeeName;
        // Increment the shared static counter every time a new object is made
        totalEmployeesHired++;

        // Generate a unique ID using the static counter
        this.employeeId = "EMP-" + totalEmployeesHired;
        System.out.println("Hired: " + this.employeeName + " (ID: " + this.employeeId + ")");
    }

    // 3. Static Method (Utility/Class-level behavior)
    public static void displayCompanyInfo() {
        // Can access static variables
        System.out.println("Company: " + COMPANY_NAME);
        System.out.println("Total Workforce: " + totalEmployeesHired);

        // System.out.println(this.employeeName);
        // ERROR: Cannot use 'this' or access instance variables in a static method!
    }

    // Instance Method
    public void displayBadge() {
        // Instance methods CAN access static variables
        System.out.println("Badge -> " + this.employeeName + " | " + COMPANY_NAME);
    }
}

public class StaticCoreConcept {
    public static void main(String[] args) {

        // Notice we call a static method BEFORE creating any objects!
        // We call it using the Class Name, not an object reference.
        System.out.println("--- Day 1 ---");
        Employee.displayCompanyInfo();

        System.out.println("\n--- Onboarding ---");
        Employee emp1 = new Employee("Alice");
        Employee emp2 = new Employee("Bob");
        Employee emp3 = new Employee("Charlie");

        System.out.println("\n--- Day 2 ---");
        // The static counter was updated by the constructor 3 times
        Employee.displayCompanyInfo();

        System.out.println("\n--- Badges ---");
        emp1.displayBadge();
        emp3.displayBadge();
    }
}
