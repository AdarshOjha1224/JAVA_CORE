package OOPS.Abstraction;

//Inner Class: An inner class is a class declared completely within the body of another class. It is used to logically group classes that are only used in one place, increasing encapsulation and making the code more readable and maintainable.

//Anonymous Inner Class: A special type of inner class that has no name. It is declared and instantiated in a single, concise statement. It is typically used for "one-time use" scenarios where you need to implement an interface or extend a class (like an abstract class) on the fly without creating a completely separate Java file.


//2. Characteristics
//Inner Class:
//Access Privileges: An inner class has unrestricted access to all variables and methods of its enclosing outer class, including private ones.
//Compilation: When compiled, Java creates a separate .class file named OuterClassName$InnerClassName.class.
//Instantiation: A non-static inner class cannot exist without an instance of the outer class.

//Anonymous Class (Interface-Anonymous & Abstract-Anonymous):
//No Name, No Constructor: Because it has no name, it cannot have an explicit constructor block.
//Single Instantiation: You define the class and create an object of it simultaneously using the new keyword.

//Interface vs. Abstract:
//Interface-Anonymous: You use new InterfaceName() { ... } to instantly create a class that implements the interface.
//Abstract-Anonymous: You use new AbstractClassName() { ... } to instantly create a concrete subclass that overrides the abstract methods.


//3. Advantages & Disadvantages
//Advantages:
//Ultimate Encapsulation: If a class is only useful to one specific outer class, burying it inside hides it from the rest of the application completely.
//Zero File Clutter: Anonymous classes prevent you from creating dozens of tiny, single-use .java files just to override one method (like a button click listener or a custom sorting rule).
//Immediate Context: You define the behavior exactly at the line of code where it is used, making the logical flow easier to read.

//Disadvantages:
//Readability (Spaghetti Code): If an anonymous class contains more than 5-10 lines of code, it severely degrades readability and makes the enclosing method look bloated.
//No Reusability: Because anonymous classes have no name, you cannot reuse them. If you need the exact same behavior elsewhere, you must duplicate the code.


//4. Evolution / Upgradation Context
//What did they upgrade?
//Before Inner Classes, if a ShoppingCart class needed a small CartValidator helper class, you had to make CartValidator a standalone file. This polluted the package namespace and forced you to expose the ShoppingCart's internal variables via getters/setters so the validator could see them. Inner classes upgraded this by allowing the helper to live inside the cart, directly accessing its private state.

//Anonymous Classes upgraded boilerplate inheritance. Historically, if you had an abstract TaxCalculator and needed a one-time custom calculation for a specific holiday, you had to create a whole new file HolidayTaxCalculator extends TaxCalculator. Anonymous classes allowed you to write that one-off logic instantly, right where the calculation was happening. (Note: Java 8 later upgraded Anonymous Classes further with Lambdas, but Anonymous Classes are still required when implementing interfaces or abstract classes with multiple methods).

// 1. The Abstract Class
abstract class DiscountPolicy {
    abstract double calculateDiscount(double amount);
}

// 2. The Interface
interface PaymentCallback {
    void onSuccess();
    void onFailure();
}

// 3. The Outer Class
class OrderProcessor {

    // Private state of the outer class
    private String processorId = "SYS-99";

    // --- 4. REGULAR INNER CLASS ---
    // Logically grouped here because only the OrderProcessor uses it.
    private class OrderValidator {
        public boolean isValid(double amount) {
            // Inner class freely accesses the outer class's private variable!
            System.out.println("Validating via processor: " + processorId);
            return amount > 0;
        }
    }

    public void processOrder(double amount) {
        OrderValidator validator = new OrderValidator();
        if (!validator.isValid(amount)) return;

        // --- 5. ABSTRACT-ANONYMOUS CLASS ---
        // We need a one-time discount policy for a Flash Sale.
        // Instead of making a whole new file, we extend the abstract class on the fly.
        DiscountPolicy flashSaleDiscount = new DiscountPolicy() {
            @Override
            double calculateDiscount(double amt) {
                System.out.println("Applying special Flash Sale discount...");
                return amt * 0.20; // 20% off
            }
        }; // Notice the semicolon here!

        double finalAmount = amount - flashSaleDiscount.calculateDiscount(amount);

        // --- 6. INTERFACE-ANONYMOUS CLASS ---
        // We pass a one-time implementation of the PaymentCallback interface directly into the method.
        executePayment(finalAmount, new PaymentCallback() {
            @Override
            public void onSuccess() {
                System.out.println("Payment of $" + finalAmount + " cleared. Dispatching order.");
            }

            @Override
            public void onFailure() {
                System.out.println("Payment failed. Triggering retry protocol.");
            }
        });
    }

    // A method expecting an interface implementation
    private void executePayment(double amount, PaymentCallback callback) {
        System.out.println("Contacting bank gateway...");
        if (amount < 5000) {
            callback.onSuccess();
        } else {
            callback.onFailure();
        }
    }
}

public class AnonymousAndInnerClass {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        processor.processOrder(100.0);
    }
}
