package Generics;

//Basic Definition (Interview-Ready)
//"A Generic Interface in Java is an interface that declares one or more type parameters. It establishes a standard contract or set of behaviors where the specific data types used in its methods are left open. The exact data types are locked in only when a concrete class chooses to implement the interface, ensuring compile-time type safety across varying implementations."

//Of Which Concept is this an Upgradation?
//Generic Interfaces are an upgradation of Rigid API Contracts and Object-based Interfaces.
//Before generics, if you were building an application architecture and wanted a standard way to save data to a database, you had to write entirely separate interfaces: UserRepository, ProductRepository, OrderRepository—even if the methods (save(), delete(), findById()) were identical. Alternatively, you could write one Repository interface that accepted Object, which forced manual casting every time you fetched data. Generic interfaces upgraded this by allowing you to define the contract once (Repository<T>) and safely apply it to any entity.

//Characteristics
//Declaration: The type parameter is placed immediately after the interface name: public interface Processor<T, R> { ... }
//Two Implementation Paths: When a class implements a generic interface, it has two choices:
//Specific/Concrete Implementation: The class locks in the type. (e.g., class UserValidator implements Validator<User>). The class itself is not generic.
//Propagated/Generic Implementation: The class remains generic and passes its own type parameter up to the interface. (e.g., class DefaultValidator<T> implements Validator<T>).
//Widespread Framework Use: This is the foundational concept behind modern Java frameworks (like Spring Data JPA's CrudRepository<T, ID> or Java's built-in Comparable<T> and Callable<V>).

//Advantages
//Architectural Consistency: Enforces a uniform naming convention and method structure across an entire application for varying data types.
//Type-Safe Polymorphism: You can pass a Validator<String> to a method, and the compiler guarantees that this specific validator will only ever be fed Strings, preventing runtime crashes.
//High Cohesion: Grouping standard operations into one generic interface keeps your codebase clean and adheres strongly to the DRY (Don't Repeat Yourself) principle.

//Disadvantages
//No Generic Static Constants: In Java, variables declared in an interface are implicitly public static final. Because they are static, they belong to the interface itself, not instances. Therefore, you cannot declare a generic constant like T defaultItem; inside an interface.
//Signature Bloat: If a class needs to implement multiple generic interfaces, the class signature can become overwhelmingly long and difficult to read (e.g., class DataPipeline<I, O> implements Reader<I>, Transformer<I, O>, Writer<O>).
//Code Example: The Validation Engine
//In enterprise applications, you often need to validate different types of data before saving them—like checking if a User has a valid age, or if a password String is strong enough. We can create a single Validator<T> contract to handle all of this.

// 1. The Generic Interface
// We define a contract: Anything that implements this must be able to validate type 'T'
interface Validator<T> {
    boolean isValid(T item);
    String getErrorMessage();
}

// ---------------------------------------------------------
// 2. Concrete Implementation A (Locks 'T' to a custom Object)
// ---------------------------------------------------------
class UserAccount {
    String username;
    int age;

    public UserAccount(String username, int age) {
        this.username = username;
        this.age = age;
    }
}

// Notice we specify <UserAccount>. The class itself is NOT generic.
class UserValidator implements Validator<UserAccount> {

    @Override
    public boolean isValid(UserAccount user) {
        // We don't need to cast 'user'. It is guaranteed to be a UserAccount.
        return user.age >= 18 && user.username != null && !user.username.isEmpty();
    }

    @Override
    public String getErrorMessage() {
        return "User must be at least 18 and have a valid username.";
    }
}

// ---------------------------------------------------------
// 3. Concrete Implementation B (Locks 'T' to a standard String)
// ---------------------------------------------------------
class PasswordValidator implements Validator<String> {

    @Override
    public boolean isValid(String password) {
        return password != null && password.length() >= 8;
    }

    @Override
    public String getErrorMessage() {
        return "Password must be at least 8 characters long.";
    }
}

// ---------------------------------------------------------
// 4. Using the Generic Interfaces
// ---------------------------------------------------------
public class GenericInterface {
    public static void main(String[] args) {

        // Scenario 1: Validating a custom object
        UserAccount newUser = new UserAccount("john_doe", 16); // Too young!
        Validator<UserAccount> userChecker = new UserValidator();

        System.out.println("--- User Validation ---");
        if (!userChecker.isValid(newUser)) {
            System.out.println("Failed: " + userChecker.getErrorMessage());
        }

        // Scenario 2: Validating a simple String
        String myPassword = "pass"; // Too short!
        Validator<String> passChecker = new PasswordValidator();

        System.out.println("\n--- Password Validation ---");
        if (!passChecker.isValid(myPassword)) {
            System.out.println("Failed: " + passChecker.getErrorMessage());
        }

        /*
        // Type Safety Proof:
        // The compiler will physically block you from mixing them up:
        // passChecker.isValid(newUser); // ERROR: Incompatible types
        */
    }
}
