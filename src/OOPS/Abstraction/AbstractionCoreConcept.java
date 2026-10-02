package OOPS.Abstraction;

//Abstraction: Abstraction is the process of hiding the complex, underlying implementation details of a system and exposing only the essential features or functionalities to the user. It focuses on what an object does rather than how it does it.
//
//How it works with Inheritance: In Java, Abstraction is primarily achieved using abstract classes (and Interfaces). An abstract class acts as a high-level template. Through Inheritance, child classes extend this template. The parent class defines the "contract" (abstract methods with no bodies), and the child classes are strictly forced by the compiler to provide the actual implementation (the "how").
//
//2. Characteristics
//Cannot be Instantiated: You can never create an object of an abstract class directly (e.g., new Document() is illegal). It only exists to be inherited.
//
//The abstract Keyword: Used to declare both the class and the methods that lack a body.
//
//Mix of Behaviors: An abstract class can contain both fully implemented methods (concrete methods) and unimplemented methods (abstract methods).
//
//Compiler Enforcement: If a child class inherits an abstract parent, it must override and implement all the parent's abstract methods. If it fails to do so, the child class itself must also be declared abstract.
//
//Constructors Allowed: Abstract classes can have constructors. They are called using super() when a concrete child class is instantiated.
//
//3. Advantages & Disadvantages
//Advantages:
//
//Reduces Complexity: The end-user (or another developer using your API) only interacts with the high-level abstract methods, ignorant of the complex logic hidden inside the subclasses.
//
//Design Enforcement (Contracts): It forces all developers on a team to follow a specific structural design. You guarantee that every child class will have a specific set of behaviors.
//
//Code Reusability: Because abstract classes can hold concrete methods, you can write shared logic once in the parent, while leaving the specific details as abstract methods for the children.
//
//Disadvantages:
//
//Single Inheritance Limitation: Because abstraction here relies on extends, a child class is burned from inheriting any other class (unlike Interfaces, which allow multiple inheritance of type).
//
//Overhead: Introducing abstract classes into a small application can overcomplicate the architecture unnecessarily.
//
//4. Evolution / Upgradation Context
//What did it upgrade?
//Before Abstraction, developers just used standard Inheritance. If you wanted a parent class to define a method that all children must have, you had to provide a "dummy" implementation in the parent (like return null; or an empty method body).
//
//The problem? The compiler couldn't force the child to override it. A developer might forget to write the method in the child class, the dummy parent method would execute silently, and the program would fail in production. Abstraction upgraded this by making it a compile-time error to forget an implementation. It shifted the responsibility of enforcement from human memory to the Java compiler.

// 1. The Abstract Parent Class (The Template/Contract)
abstract class Document {

    protected String fileName;

    // Abstract classes can have constructors to initialize shared state
    public Document(String fileName) {
        this.fileName = fileName;
    }

    // Concrete Method: Shared behavior inherited as-is by all children
    public void saveToDrive() {
        System.out.println("Saving '" + this.fileName + "' to cloud storage...");
    }

    // Abstract Method: No body. Forces children to define HOW to render.
    public abstract void renderView();
}

// 2. Concrete Child 1
class PdfDocument extends Document {

    public PdfDocument(String fileName) {
        super(fileName);
    }

    // The compiler FORCES this method to be implemented
    @Override
    public void renderView() {
        System.out.println("Rendering PDF: Loading Adobe viewer engine for " + this.fileName);
    }
}

// 3. Concrete Child 2
class ExcelDocument extends Document {

    public ExcelDocument(String fileName) {
        super(fileName);
    }

    // The compiler FORCES this method to be implemented
    @Override
    public void renderView() {
        System.out.println("Rendering Excel: Drawing spreadsheet grid for " + this.fileName);
    }
}

public class AbstractionCoreConcept {
    public static void main(String[] args) {

        // Document doc = new Document("file.txt"); // ERROR: Cannot instantiate abstract class

        // Polymorphism + Abstraction: Superclass reference, subclass object
        Document report = new PdfDocument("Annual_Report.pdf");
        Document sheet = new ExcelDocument("Financials.xlsx");

        System.out.println("--- Processing PDF ---");
        report.renderView();  // Triggers specific PDF logic
        report.saveToDrive(); // Reuses inherited shared logic

        System.out.println("\n--- Processing Excel ---");
        sheet.renderView();   // Triggers specific Excel logic
        sheet.saveToDrive();  // Reuses inherited shared logic
    }
}
