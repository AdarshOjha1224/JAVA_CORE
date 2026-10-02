package OOPS.Interface;

//Interface: An interface in Java is a reference type, similar to a class, that acts as a strict contract. It contains a collection of abstract methods (rules) and constant variables. When a class chooses to "implement" an interface, it signs a contract guaranteeing that it will provide the actual code (implementation) for every method defined in that interface.

//2. Characteristics
//The implements Keyword: A class uses this keyword to inherit from an interface (e.g., class Invoice implements Taxable).
//Multiple Inheritance: A single class can implement multiple interfaces separated by commas, allowing an object to play multiple roles simultaneously.
//Implicit Modifiers: Prior to Java 8, all methods in an interface were implicitly public and abstract (no body). All variables are implicitly public, static, and final (they are constants).
//No Constructors: Because interfaces cannot hold state (instance variables) and cannot be instantiated, they do not have constructors.
//Modern Java Additions (Java 8+): Interfaces can now contain default methods (methods with a body that can be optionally overridden) and static methods.

//3. Advantages & Disadvantages
//Advantages:
//Solves the Multiple Inheritance Problem: You can inherit behaviors from multiple sources without the ambiguity that comes from inheriting multiple classes.
//Total Loose Coupling: You can design a system where components interact strictly through interfaces, completely hiding the underlying class implementations. This makes replacing or updating parts of an application incredibly easy.
//Highly Testable: Interfaces make it trivial to create "mock" objects for Unit Testing (e.g., mocking a database connection interface).
//Disadvantages:
//Code Fragmentation: Heavy use of interfaces can lead to a massive number of small files in a project, making navigation harder for beginners.
//Forced Implementation (Pre-Java 8): Historically, if you added a new method to an interface, it instantly broke every class implementing it until you manually went in and added the new method to all of them.

//4. Evolution / Upgradation Context
//What did it upgrade?
//Interfaces were created to solve a massive flaw in C++ called the "Diamond Problem." In C++, a class could inherit from two parent classes. If both parents had a method called start(), the child class wouldn't know which parent's start() to use, causing memory ambiguity and crashes. Java banned multiple class inheritance completely to fix this.
//However, developers still needed a way for a class to inherit multiple behaviors. Interfaces upgraded the architecture by allowing multiple inheritance of type/contract, but not state. Since the interface only says what the method is called, and the child class provides the actual body, there is never any ambiguity about which code to run.
//Later, Java 8 upgraded Interfaces themselves by adding default methods. This was done so developers could add new features to legacy interfaces without breaking millions of older classes that had already implemented them.


// 1. Interface One
interface Taxable {
    // Variables are implicitly public static final (Constants)
    double TAX_RATE = 0.15;

    // Abstract method: implicitly public and abstract
    double calculateTax(double amount);
}

// 2. Interface Two
interface Discountable {
    double applyDiscount(double amount);

    // Java 8 feature: Default method.
    // Implementing classes don't HAVE to override this, but they can.
    default void printDiscountPolicy() {
        System.out.println("Standard Corporate Discount Policy Applies.");
    }
}

// 3. The Implementation Class
// Demonstrating Multiple Inheritance: Implementing both interfaces
class CorporateInvoice implements Taxable, Discountable {

    private String clientName;
    private double baseAmount;

    public CorporateInvoice(String clientName, double baseAmount) {
        this.clientName = clientName;
        this.baseAmount = baseAmount;
    }

    // Fulfilling the contract from Taxable
    @Override
    public double calculateTax(double amount) {
        return amount * TAX_RATE; // Using the constant from the interface
    }

    // Fulfilling the contract from Discountable
    @Override
    public double applyDiscount(double amount) {
        if (amount > 1000) {
            return amount - 100; // Flat $100 off for large orders
        }
        return amount;
    }

    // Class's own business logic
    public void generateFinalBill() {
        double discountedAmount = applyDiscount(baseAmount);
        double finalTax = calculateTax(discountedAmount);
        double total = discountedAmount + finalTax;

        System.out.println("--- Invoice for " + clientName + " ---");
        System.out.println("Base Amount: $" + baseAmount);
        System.out.println("After Discount: $" + discountedAmount);
        System.out.println("Tax Applied: $" + finalTax);
        System.out.println("Total Due: $" + total);
    }
}

public class InterfaceCoreConcept {
    public static void main(String[] args) {

        CorporateInvoice invoice = new CorporateInvoice("Acme Corp", 1500.0);

        // Calling the default method inherited from Discountable
        invoice.printDiscountPolicy();

        // Running the fully implemented logic
        invoice.generateFinalBill();
    }
}
