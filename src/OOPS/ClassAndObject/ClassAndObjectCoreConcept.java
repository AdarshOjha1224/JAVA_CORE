package OOPS.ClassAndObject;

//Class
//A class is a user-defined blueprint or template from which objects are created. It defines a data type by bundling data (attributes) and methods (behaviors) that work on that data into a single unit.
//Object
//An object is an instance of a class. It is a real-world entity that has a state (defined by the class attributes), behavior (defined by the class methods), and a unique identity (a specific memory address assigned when created at runtime).

//Characteristics
//Logical vs. Physical: A class is a logical construct and does not allocate memory when created. An object is a physical reality in the program that consumes heap memory as soon as the new keyword is used.
//Multiplicity: You declare a class only once, but you can instantiate an infinite number of objects from that single class.
//Independent State: Every object maintains its own independent copy of the class variables. Changing an attribute in one object does not affect the others.

//Advantages & Disadvantages
//Advantages:
//Real-World Modeling: Makes it incredibly easy to map real-world business requirements directly into code.
//Reusability: Write the logic once in a class, and reuse it across the application by creating multiple objects.
//Maintainability: Code is organized into modular blocks, making debugging and updating much easier than sprawling procedural code.
//Disadvantages:
//Memory Overhead: Creating many objects consumes memory and requires the Garbage Collector to work harder, which can impact performance if not managed well.
//Design Complexity: Requires upfront planning and architectural thought; poor class design leads to tightly coupled and rigid applications.

//Evolution / Upgradation Context
//Classes and Objects are the fundamental upgrade over Procedural Programming (like C). In procedural languages, data (variables) and behavior (functions) are completely separate. Data is often passed around globally, making it vulnerable to accidental modification as the program grows. The Class/Object concept was introduced to solve this by tightly binding the data and the functions that manipulate it together into one secure, organized capsule.

// 1. The Class (The Blueprint)
class Employee {

    // Properties (State/Attributes)
    private String name;
    private int employeeId;
    private double salary;

    // Constructor (Sets up the object's initial state)
    public Employee(String name, int employeeId, double salary) {
        this.name = name;
        this.employeeId = employeeId;
        this.salary = salary;
    }

    // Method (Behavior/Action)
    public void giveBonus(double bonusPercentage) {
        double bonusAmount = this.salary * (bonusPercentage / 100);
        this.salary += bonusAmount;
        System.out.println(this.name + " received a bonus! New Salary: $" + this.salary);
    }

    // Method to display object state
    public void printDetails() {
        System.out.println("ID: " + this.employeeId + " | Name: " + this.name + " | Salary: $" + this.salary);
    }
}

// 2. The Execution (Creating Objects)
public class ClassAndObjectCoreConcept {
    public static void main(String[] args) {

        // Creating Object 1: 'new' allocates memory, constructor assigns values
        Employee emp1 = new Employee("Alice Smith", 101, 75000);

        // Creating Object 2: Completely independent state from emp1
        Employee emp2 = new Employee("Bob Johnson", 102, 68000);

        // Operating on the objects
        emp1.printDetails();
        emp2.printDetails();

        System.out.println("--- Year End Reviews ---");

        // Only Alice gets the bonus; Bob's state remains unchanged
        emp1.giveBonus(10.0);

        emp1.printDetails();
        emp2.printDetails();
    }
}
