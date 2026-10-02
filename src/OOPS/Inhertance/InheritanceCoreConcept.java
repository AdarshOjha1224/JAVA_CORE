package OOPS.Inhertance;

//1. Interview-Ready Definition
//Inheritance: Inheritance is an Object-Oriented mechanism where one class (the subclass or child) acquires the properties (variables) and behaviors (methods) of another class (the superclass or parent). It establishes an "IS-A" relationship (e.g., a Manager IS-A Employee).

//The super Keyword: The super keyword is a reference variable used inside a subclass to directly refer to its immediate parent class. It acts as a bridge to access the parent's constructors, methods, and variables.


//2. Characteristics
//Inheritance:
//The extends Keyword: This is how you declare inheritance in Java (e.g., class Car extends Vehicle).
//Single Inheritance Only (for classes): A Java class can only extend one parent class. This prevents the "Diamond Problem" (ambiguity when two parents have the same method). Multiple inheritance is only allowed via Interfaces.
//Method Overriding: A child class can provide its own specific implementation of a method that is already defined in its parent.

//The super Keyword:
//super() for Constructors: Calls the parent class's constructor. Rule: It must be the very first line of code in the child's constructor.
//super.methodName(): Used to call the parent's version of a method, even if the child has overridden it.
//super.variableName: Used to access a parent's variable if the child class has declared a variable with the exact same name (shadowing).


//3. Advantages & Disadvantages
//Advantages:
//Code Reusability: You write the common logic (like ID, Name, Email) in a base class once, and hundreds of child classes can inherit it without rewriting a single line.
//Extensibility: You can add new features by creating new subclasses without touching the heavily tested, core parent class.
//The Power of super: It allows a child class to "add on" to a parent's logic rather than completely replacing it. You can say: "Do everything the parent does, and then do my specific extra steps."
//Disadvantages:
//Tight Coupling: The biggest flaw of Inheritance. The child depends entirely on the parent. If you change a method signature in the parent, you might break every single child class (known as the Fragile Base Class problem).
//Overuse: Developers often use Inheritance just to reuse a piece of code, even when an "IS-A" relationship doesn't make sense. (e.g., making a Customer class extend a DatabaseConnection class just to reuse a save method. This is bad design. Composition is usually better).


//4. Evolution / Upgradation Context
//What did they upgrade?
//Before Inheritance, if you were building an HR system with FullTimeEmployee and ContractEmployee, you had to write name, id, and department twice. If a bug was found in how names were processed, you had to hunt down and fix it in both files. Inheritance upgraded this by centralizing shared data.
//Before the super keyword, if a child class wanted to override a parent's method but still needed some of the parent's functionality, it was impossible without copy-pasting the parent's code into the child. super upgraded Method Overriding by allowing the child to cleanly trigger the parent's logic on demand.

// 1. The Parent Class (Superclass)
class User {
    protected String username; // 'protected' allows child classes to access this directly
    private String email;      // 'private' is hidden from the child

    // Parent Constructor
    public User(String username, String email) {
        this.username = username;
        this.email = email;
        System.out.println("Basic User profile created for: " + this.username);
    }

    // Parent Method
    public void playContent() {
        System.out.println(this.username + " is playing standard content with Ads.");
    }
}

// 2. The Child Class (Subclass) using 'extends'
class PremiumUser extends User {

    private String resolution; // Child's specific property

    // Child Constructor
    public PremiumUser(String username, String email, String resolution) {
        // 3. Using super() to call the Parent's constructor.
        // This MUST be the first line. The parent must be built before the child.
        super(username, email);

        // Initializing the child's own specific state
        this.resolution = resolution;
        System.out.println("Premium features unlocked for: " + this.username);
    }

    // 4. Method Overriding: Replacing the parent's behavior
    @Override
    public void playContent() {
        // 5. Using super.methodName() to reuse parent logic if we wanted to
        // super.playContent(); // Uncommenting this would play the Ad version first

        System.out.println(this.username + " is playing Ad-Free content in " + this.resolution);
    }
}

public class InheritanceCoreConcept {
    public static void main(String[] args) {
        System.out.println("--- Registering Standard User ---");
        User standard = new User("JohnDoe", "john@email.com");
        standard.playContent();

        System.out.println("\n--- Registering Premium User ---");
        PremiumUser premium = new PremiumUser("JaneVIP", "jane@email.com", "4K Ultra HD");
        premium.playContent();
    }
}
