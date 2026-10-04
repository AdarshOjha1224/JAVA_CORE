package StaticAndFinalKeyword;

//1. Interview-Ready Definition
//The final Keyword: The final keyword in Java is a non-access modifier used to impose strict architectural restrictions on elements. It universally implies immutability or finality: a final variable's value cannot be changed once assigned, a final method cannot be overridden by subclasses, and a final class cannot be extended (inherited) by any other class.

//2. Characteristics

//Final Variables (Constants):
//Initialization Rules: A final variable must be initialized. If it is not initialized at the time of declaration, it is called a "blank final variable." A blank final variable can only be initialized inside a constructor (or a static block if it is a static blank final variable).
//Reference Trap: If a final variable holds an object reference (e.g., an array or a List), the reference itself cannot point to a new object, but the internal state of that object can still be modified (e.g., you can add items to a final list).

//Final Methods:
//Locked Behavior: A subclass can inherit a final method and use it, but it cannot override it to change its logic.
//Early Binding: Because the compiler knows a final method will never be overridden, it resolves the method call at compile-time (Static Binding), which is slightly faster than runtime dynamic binding.

//Final Classes:
//End of the Line: Prevents inheritance entirely. You cannot use the extends keyword on a final class.
//Implicitly Final Methods: If a class is declared final, all of its methods are implicitly final (though its variables are not automatically final). Standard Java classes like String, Math, and Integer are all final classes.


//3. Advantages & Disadvantages
//Advantages:
//Security (The Biggest Advantage): It prevents malicious or accidental modification of core business logic. If you write a verifyPassword() method in a security framework, marking it final ensures no junior developer (or hacker) can subclass it and override it to always return true.
//Thread Safety: Final variables are inherently thread-safe. Once initialized, their values never change, so multiple threads can read them simultaneously without needing complex synchronization.
//Performance Optimization: The JVM can optimize final methods through a process called "inlining," which eliminates the overhead of a method call at runtime.

//Disadvantages:
//Architectural Rigidity: It severely restricts OOP's core power of Inheritance and Polymorphism.
//Testing Limitations: Mocking frameworks (like Mockito) historically struggle to create "mock" objects out of final classes or stub final methods, which can make Unit Testing highly frustrating.


//4. Evolution / Upgradation Context
//What did it upgrade?
//In older languages like C and C++, developers used #define macros or const to create constants, but these were often just text-replacements that lacked strict scope rules or object-oriented structure.
//As Object-Oriented Programming grew, a new problem emerged: The Fragile Base Class Problem. When architects built massive frameworks, they found that allowing developers to inherit and override everything led to disastrous system crashes if core methods were altered improperly.
//The final keyword upgraded application design by introducing Design by Contract (Sealed Logic). It allowed API designers to finally say: "You can reuse my class, but I am locking down the critical parts so you can't break the system."


// 1. FINAL CLASS: Cannot be extended by anyone.
// Protects core encryption logic from being manipulated.
final class SecurityEngine {
    public void encryptData(String data) {
        System.out.println("Encrypting data securely...");
    }
}

// // ERROR: Cannot inherit from final class
// class HackerEngine extends SecurityEngine { }

class BankAccount {

    // 2. BLANK FINAL VARIABLE: Uninitialized at declaration.
    private final String accountNumber;

    // 3. REGULAR FINAL VARIABLE: Initialized directly.
    private final String bankName = "Global Trust Bank";

    public BankAccount(String accountNumber) {
        // Blank final variable MUST be initialized in the constructor.
        // Once set here, it can NEVER be changed again.
        this.accountNumber = accountNumber;
    }

    public void displayAccount() {
        System.out.println("Account: " + this.accountNumber + " | Bank: " + this.bankName);
    }

    // 4. FINAL METHOD: Subclasses can use it, but cannot change how it works.
    public final void performFraudCheck(double transactionAmount) {
        System.out.println("Running strictly regulated Gov fraud check on $" + transactionAmount);
        if (transactionAmount > 10000) {
            System.out.println("[ALERT] Large transaction flagged for manual review.");
        }
    }
}

// Child Class
class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountNumber) {
        super(accountNumber);
    }

    // // ERROR: Cannot override the final method from BankAccount
    // @Override
    // public void performFraudCheck(double transactionAmount) {
    //     System.out.println("Bypassing check...");
    // }
}

public class FinalCoreConcept {
    public static void main(String[] args) {
        SavingsAccount myAccount = new SavingsAccount("ACC-998877");

        myAccount.displayAccount();

        // Allowed: We can call the final method inherited from the parent
        myAccount.performFraudCheck(15000.00);

        SecurityEngine engine = new SecurityEngine();
        engine.encryptData("Transaction Approved");
    }
}
