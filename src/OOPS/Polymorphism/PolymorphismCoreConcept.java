package OOPS.Polymorphism;

//Polymorphism
//Polymorphism (from Greek, meaning "many forms") is the ability of a single interface, method, or reference variable to take on multiple distinct behaviors based on the object it is acting upon. In Java, it allows you to write flexible code that can handle different types of objects in a uniform way.

//Method Overriding (Runtime Polymorphism)
//Method Overriding is the mechanism by which a subclass provides a specific, customized implementation of a method that is already defined in its parent class. It is the core enabler of "Dynamic Method Dispatch"—where the JVM decides at runtime which version of the method to execute based on the actual object created, not the reference variable type.


//Characteristics
//Polymorphism:
//Two Flavors: Compile-Time Polymorphism (achieved via Method Overloading—same method name, different parameters) and Run-Time Polymorphism (achieved via Method Overriding).
//Upcasting: A superclass reference variable can hold a subclass object (e.g., Parent p = new Child();). This is the foundation of polymorphic behavior.

//Method Overriding:
//Strict Signature Match: The child's method must have the exact same name, parameter list, and return type (or a covariant return type—a subclass of the original return type) as the parent's method.
//Visibility Rules: The access modifier in the child class cannot be more restrictive than the parent. (e.g., If the parent method is protected, the child's overridden method can be protected or public, but never private).
//Un-overrideable Methods: You cannot override static, final, or private methods.
//@Override Annotation: A best practice tag that tells the compiler to check if you are actually overriding a parent method correctly, preventing silent typos.


//Advantages & Disadvantages
//Advantages:
//Eliminates Massive if-else Blocks: Instead of writing logic to check what type an object is before acting on it, you just call the overridden method and let the JVM route it correctly.
//Plug-and-Play Extensibility: You can introduce entirely new child classes into an application, and the existing code that processes the parent class will automatically work with the new child class without modification.
//Interface/API Design: It allows architects to define a contract (the parent methods) while letting individual developers write the specific implementations.

//Disadvantages:
//Performance Overhead: Runtime polymorphism requires the JVM to perform "dynamic binding" (looking up the correct method in a virtual table at runtime), which is fractionally slower than static binding (compile-time).
//Code Traceability: In very deep inheritance hierarchies, it can be difficult for a developer reading the code to know exactly which version of a method is going to execute without running the program.


//Evolution / Upgradation Context
//What did it upgrade?
//In purely procedural languages like C, if you wanted to process different types of payments, you had to write separate functions (e.g., processCreditCard(), processCash(), processCrypto()). To execute them, you had to use complex switch statements or if-else chains based on a type flag. If a new payment type was added, you had to hunt down and update every switch statement in the application.
//Polymorphism and Overriding upgraded this fundamentally. You now write one processTransaction() method on a generic Payment reference. When a new payment method is invented, you just create a new subclass, override the method, and the old system instantly knows how to use it without changing a single line of the original code.

// 1. The Superclass
class PaymentMethod {
    // Generic method to be overridden
    public void processPayment(double amount) {
        System.out.println("Processing a generic payment of $" + amount);
    }
}

// 2. Subclass 1: Credit Card
class CreditCard extends PaymentMethod {
    private String cardNumber;

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    // Overriding the parent's behavior
    @Override
    public void processPayment(double amount) {
        System.out.println("Connecting to Visa/Mastercard network...");
        System.out.println("Charged $" + amount + " to Card ending in " + cardNumber.substring(cardNumber.length() - 4));
    }
}

// 3. Subclass 2: UPI / Digital Wallet
class UPIPayment extends PaymentMethod {
    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    // Overriding the parent's behavior differently
    @Override
    public void processPayment(double amount) {
        System.out.println("Pinging UPI gateway for ID: " + upiId + "...");
        System.out.println("Transferred $" + amount + " instantly via UPI.");
    }
}

public class PolymorphismCoreConcept {
    // This method takes the SUPERCLASS as a parameter.
    // It doesn't need to know if it's a CreditCard or UPI.
    public static void completeCheckout(PaymentMethod payment, double totalAmount) {
        System.out.println("--- Starting Checkout ---");
        // RUNTIME POLYMORPHISM: The JVM decides which version to call based on the actual object passed.
        payment.processPayment(totalAmount);
        System.out.println("--- Checkout Complete ---\n");
    }

    public static void main(String[] args) {
        // Upcasting: Superclass reference holds subclass object
        PaymentMethod cardPayment = new CreditCard("4111222233334444");
        PaymentMethod upiPayment = new UPIPayment("user@bankname");

        // We pass different objects to the exact same checkout method
        completeCheckout(cardPayment, 150.75);

        completeCheckout(upiPayment, 45.00);
    }
}
