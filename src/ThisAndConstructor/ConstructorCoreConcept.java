package ThisAndConstructor;

//1. Interview-Ready Definition
//Constructor: A constructor is a special block of code that is automatically invoked when an object of a class is created. It has the exact same name as the class, has no return type (not even void), and its primary purpose is to initialize the newly created object's state.

//this Keyword: The this keyword is a reference variable in Java that refers to the current object (the specific instance) on which a method or constructor is currently being invoked.

//2. Characteristics
//Constructor:
//Automatic Invocation: You never call a constructor explicitly like a regular method; the new keyword triggers it.
//Default Fallback: If you don't write any constructor, the Java compiler automatically inserts a hidden, no-argument "default constructor" with empty curly braces.
//Overloadable: You can have multiple constructors in the same class as long as their parameter lists (signatures) are different.
//No Return Type: A constructor returns the instance of the class internally, but you cannot declare a return type.

//this Keyword:
//Resolves Shadowing: If a local parameter and a class instance variable have the same name, this.variableName tells the compiler to use the class's variable, not the local parameter.
//Constructor Chaining: this() can be used inside one constructor to call another constructor within the same class, reducing duplicate code. (Must be the very first line).
//Instance Context Only: You can never use this inside a static method because static methods belong to the class itself, not to any specific object.

//3. Advantages & Disadvantages
//Advantages:
//Constructors: Enforces safe initialization. An object cannot exist in a "half-baked" or invalid state because you can require all mandatory data upfront before the object is fully created.
//this Keyword: Eliminates the need to invent weird parameter names (e.g., p_name vs name). It also enables advanced techniques like constructor chaining and method chaining.
//Disadvantages (or Caveats):
//Constructors: They cannot be overridden by subclasses (though they can be overloaded). Also, having too many parameters leads to the "Telescoping Constructor Anti-Pattern," making the code hard to read.
//this Keyword: Using this() for constructor chaining can get confusing if there are too many overloaded constructors, leading to complex execution flows.

//4. Evolution / Upgradation Context
//What did they upgrade?
//Before constructors existed (in early procedural programming or early struct-based systems), developers had to manually write an init() method and remember to call it after allocating memory. If a developer forgot to call init(), the program would crash or behave unpredictably due to null or garbage values. Constructors upgraded this by forcing initialization at the exact moment of creation.
//Before the this keyword, developers were forced to use different variable names for parameters and instance variables to avoid "variable hiding" or "shadowing." this upgraded the syntax by allowing clean, consistent naming conventions.

class BankAccount {
    // Instance variables (State)
    private String accountNumber;
    private String customerName;
    private double balance;

    // 1. Parameterized Constructor
    public BankAccount(String accountNumber, String customerName, double balance) {
        // 'this' is crucial here to resolve variable shadowing.
        // It tells Java: assign the local parameter 'balance' to the object's 'balance'.
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = balance;
        System.out.println("Created Account for: " + this.customerName);
    }

    // 2. Default/No-Args Constructor (Overloaded)
    public BankAccount() {
        // Constructor Chaining: using this() to call the parameterized constructor above.
        // This MUST be the first statement in the constructor.
        this("UNKNOWN", "Unregistered User", 0.0);
        System.out.println("Default setup completed.");
    }

    // 3. Method using 'this' to return the current object (Method Chaining)
    public BankAccount deposit(double amount) {
        this.balance += amount;
        System.out.println("Deposited $" + amount + ". New balance: $" + this.balance);
        return this; // Returning the current instance allows for chained calls
    }

    public void displayProfile() {
        System.out.println("Acc: " + this.accountNumber + " | Owner: " + this.customerName + " | Bal: $" + this.balance);
    }
}

public class ConstructorCoreConcept {
    public static void main(String[] args) {

        // Triggers the No-Args constructor, which immediately uses this() to call the other one
        System.out.println("--- Creating Account 1 ---");
        BankAccount acc1 = new BankAccount();

        // Triggers the Parameterized constructor directly
        System.out.println("\n--- Creating Account 2 ---");
        BankAccount acc2 = new BankAccount("100293", "Sarah Connor", 500.0);

        System.out.println("\n--- Operations ---");

        // Method chaining made possible by returning 'this'
        acc2.deposit(200.0).deposit(100.0);

        acc1.displayProfile();
        acc2.displayProfile();
    }
}
