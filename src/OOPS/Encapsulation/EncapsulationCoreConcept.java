package OOPS.Encapsulation;

//Encapsulation
//Encapsulation is the mechanism of wrapping the data (variables) and the code acting on the data (methods) together as a single unit. In practical Java terms, it means hiding the internal state of an object by declaring variables as private and providing public getter and setter methods to access and modify them safely.

//Access Modifiers
//Access modifiers are keywords in Java that set the visibility or accessibility level for classes, variables, constructors, and methods. They act as the gatekeepers that make Encapsulation possible.


//Characteristics
//Encapsulation:
//Data Hiding: The core trait. External classes cannot see or directly touch the object's variables.
//Controlled Access: Setters act as checkpoints where you can write validation logic (e.g., ensuring a price is not negative) before data is changed.
//Read-Only / Write-Only: By providing only a getter, you make a field read-only. By providing only a setter, you make it write-only.

//Access Modifiers (The 4 Levels in Java):
//private: Accessible only within the same class. (The foundation of data hiding).
//Default (No keyword): Accessible only within classes in the same package.
//protected: Accessible within the same package, AND by subclasses (child classes) in different packages.
//public: Accessible from anywhere in the application.

//Advantages & Disadvantages
//Advantages:
//Security & Data Integrity: Prevents unauthorized or invalid modifications to an object's state (e.g., preventing a bank balance from being manually set to a negative number).
//Flexibility & Maintainability: You can change the internal implementation of a class without breaking the external code that uses it, as long as the public method signatures remain the same.
//Disadvantages:
//Boilerplate Code: Requires writing many repetitive getters and setters, which makes files longer (though modern tools like Lombok or IDE generation solve this).
//Execution Overhead: Accessing data through a method call is fractionally slower than accessing a variable directly in memory, though modern JVM optimization makes this negligible.

//Evolution / Upgradation Context
//What did it upgrade?
//In older procedural languages like C, data was often exposed globally or stored in basic structs where any part of the program could directly modify any variable. This led to a "spaghetti code" nightmare—if a variable held an invalid value, it was impossible to trace which part of the program corrupted it. Encapsulation upgraded this by putting a protective shield around data. You can no longer just change the data; you must ask the object to change its own data through a method, leaving a clear audit trail and allowing the object to reject invalid requests.

class Product {

    // 1. Data Hiding: Variables are private
    private String productId;
    private String name;
    private double price;
    private int stockQuantity;

    public Product(String productId, String name, double price, int stockQuantity) {
        this.productId = productId;
        this.name = name;
        this.stockQuantity = stockQuantity;
        // Using the setter in the constructor ensures validation runs upon creation
        setPrice(price);
    }

    // 2. Public Getters (Read Access)
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    // 3. Public Setter with Validation (Controlled Write Access)
    public void setPrice(double price) {
        if (price >= 0.0) {
            this.price = price;
        } else {
            // Rejects invalid state
            System.out.println("Error: Cannot set a negative price for " + this.name);
        }
    }

    // 4. Business logic method modifying private state safely
    public void purchase(int quantity) {
        if (quantity > 0 && quantity <= this.stockQuantity) {
            this.stockQuantity -= quantity;
            System.out.println("Sold " + quantity + " of " + this.name + ". Remaining stock: " + this.stockQuantity);
        } else {
            System.out.println("Transaction failed: Invalid quantity or insufficient stock.");
        }
    }
}

public class EncapsulationCoreConcept {
    public static void main(String[] args) {

        Product laptop = new Product("P100", "ProBook Laptop", 1200.00, 10);

        // laptop.price = -500; // ERROR: Cannot access private variable directly

        // Attempting to set an invalid state via setter
        laptop.setPrice(-50.0); // Output: Error: Cannot set a negative price for ProBook Laptop

        // Successful safe modification
        laptop.setPrice(1150.00);
        System.out.println("Updated Price: $" + laptop.getPrice());

        laptop.purchase(3);
    }
}
