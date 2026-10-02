package OOPS.Abstraction;

//Abstract Class: A partial blueprint used for closely related objects. It defines an "IS-A" relationship and represents a core identity. You use it when you want to share common state (instance variables) and default behavior among child classes, while leaving some specific methods to be implemented by them.
// Interface: A stateless contract used for unrelated objects. It defines a "CAN-DO" (or capability) relationship. You use it when you want to guarantee that a class can perform a specific action, regardless of where that class sits in the inheritance hierarchy.

// 2. Characteristics (The Key Differences):
//+-------------------+--------------------------------+--------------------------------+
//| Feature           | Abstract Class                 | Interface                      |
//+===================+================================+================================+
//| Inheritance Rule  | A class can extend only one    | A class can implement multiple |
//|                   | abstract class.                | interfaces.                    |
//+-------------------+--------------------------------+--------------------------------+
//| State (Variables) | Can hold instance variables    | Cannot hold instance           |
//|                   | (e.g., private int id;) to     | variables. All variables are   |
//|                   | maintain state.                | implicitly public static final |
//|                   |                                | (constants).                   |
//+-------------------+--------------------------------+--------------------------------+
//| Constructors      | Yes. Used to initialize the    | No. Interfaces cannot be       |
//|                   | shared state via super().      | instantiated and have no state |
//|                   |                                | to construct.                  |
//+-------------------+--------------------------------+--------------------------------+
//| Access Modifiers  | Methods can be public,         | Methods are implicitly public. |
//|                   | protected, or private.         | (Java 9 added private methods  |
//|                   |                                | for internal interface logic). |
//+-------------------+--------------------------------+--------------------------------+
//| When to use?      | When classes are fundamentally | When unrelated classes share a |
//|                   | the same type of thing (e.g.,  | behavior (e.g., Airplane and   |
//|                   | Dog and Cat are Animals).      | Bird can both Fly).            |
//+-------------------+--------------------------------+--------------------------------+

// 3. Advantages & Disadvantages
// Advantages of Abstract Classes:
// State Management: You can write shared logic that relies on shared instance variables, drastically reducing code duplication among sibling classes.

// Disadvantages of Abstract Classes:
// Burns the Inheritance Ticket: Because Java only allows single class inheritance, extending an abstract class means that child class can never extend anything else.


// Advantages of Interfaces:
// Cross-Hierarchy Capabilities: You can apply an interface to completely unrelated classes across different parts of your application.
// Total Decoupling: Ideal for creating APIs and microservices where components communicate purely through contracts without caring about implementation.

// Disadvantages of Interfaces:No Instance State: Because they cannot hold variables (other than constants), any state required by the interface's methods must be manually declared in every single implementing class.


// 4. Evolution / Upgradation ContextWhat did it upgrade? (The Java 8 Blur)Historically, the line between them was absolute: Abstract Classes had code bodies, Interfaces had none.
// However, as Java ecosystems grew massive, architects hit a wall: if you added a new method to a popular interface, it instantly broke millions of implementing classes worldwide. To upgrade this, Java 8 introduced default and static methods to Interfaces. This allowed architects to add new methods with a fallback body to an interface without breaking backward compatibility.
// Interview Trap: Because of Java 8, interviewers will ask: "If interfaces can now have method bodies, why use Abstract Classes at all?"The Answer: State and Constructors. Interfaces still cannot hold instance variables or constructors. If your shared logic needs to remember or modify object-specific data, you must use an Abstract Class.

// 1. The Interface: A capability applied across unrelated classes
interface Auditable {
    void logAction(String action);
}

// 2. The Abstract Class: Core identity and shared state for Employees
abstract class Employee {
    protected String name; // State
    protected String id;   // State

    public Employee(String name, String id) {
        this.name = name;
        this.id = id;
    }

    // Common behavior for all employees
    public void swipeIn() {
        System.out.println(this.name + " swiped into the building.");
    }

    // Abstract behavior specific to role
    public abstract void performDuties();
}

// 3. Child Class 1: Extends the Abstract Class AND Implements the Interface
class SoftwareEngineer extends Employee implements Auditable {

    public SoftwareEngineer(String name, String id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println(this.name + " is writing Java code.");
    }

    @Override
    public void logAction(String action) {
        System.out.println("[AUDIT LOG - HR Dept]: Employee " + this.id + " performed action: " + action);
    }
}

// 4. Completely Unrelated Class: Also implements the Interface
class DatabaseServer implements Auditable {

    private String dbUrl = "jdbc:postgresql://localhost:5432/prod";

    public void backupData() {
        System.out.println("Backing up data from " + dbUrl);
    }

    @Override
    public void logAction(String action) {
        System.out.println("[AUDIT LOG - IT Security]: Database server executed: " + action);
    }
}

public class AbstractionAndInterfaceCoreConcept {
    public static void main(String[] args) {
        SoftwareEngineer engineer = new SoftwareEngineer("Alice", "E192");
        DatabaseServer dbServer = new DatabaseServer();

        System.out.println("--- Core Behaviors ---");
        engineer.swipeIn();
        engineer.performDuties();
        dbServer.backupData();

        System.out.println("\n--- Polymorphic Interface Behavior ---");
        // We can treat unrelated objects exactly the same through their shared contract
        Auditable[] auditTargets = {engineer, dbServer};

        for (Auditable target : auditTargets) {
            target.logAction("System check at 08:00 AM");
        }
    }
}
