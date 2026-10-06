package Generics;

//Basic Definition (Interview-Ready)
//"A Generic Class in Java is a class that is designed to work with different data types by using one or more type parameters. Instead of hardcoding a specific data type like String or Integer, you declare a placeholder (usually <T>) at the class level. The exact data type is decided by the programmer only when they instantiate an object of that class."

//Of Which Concept is this an Upgradation?
//Generic Classes are an upgradation of Code Duplication and Object-based Wrapper Classes.
//Imagine you are building a delivery application and need a Package class to hold items. Without generics, if you wanted a package strictly for Books and another strictly for Electronics, you had two bad choices:
//Write separate classes: BookPackage and ElectronicsPackage (violates the DRY principle - Don't Repeat Yourself).
//Write one Package class that holds a generic Object (leads to the type-safety and casting issues we discussed in Part 1).
//Generic classes solve this by letting you write a single Package<T> class once, and safely reuse it for any item type.

//Characteristics
//Type Parameters (The < > syntax): Declared immediately after the class name (e.g., class Container<T>).
//Standard Naming Conventions: While you can use any letter, Java developers use single uppercase letters to denote type parameters to distinguish them from real classes:
//T - Type (Most common)
//E - Element (Used heavily in Collections like List<E>)
//K, V - Key and Value (Used in Maps)
//N - Number
//Multiple Parameters: A class can have more than one generic type, separated by commas (e.g., class Pair<K, V>).


//Advantages
//Massive Reusability: You write the internal logic of the class exactly once. It can then securely handle thousands of different data types.
//API Standardization: In modern web and mobile applications, generic classes are the standard way to wrap responses (e.g., a standard API response that returns different types of data depending on the request).
//Readability: When another developer sees Box<Shoe>, they know instantly and reliably what is inside, making the code self-documenting.

//Disadvantages
//Cannot Instantiate Type Parameters: You cannot write T obj = new T(); inside the class. The compiler doesn't know what T is at compile time, so it doesn't know what constructor to call.
//No Static Generic Variables: You cannot declare a static variable of type T (e.g., static T sharedItem;). Static variables are shared across all instances of the class, but T might be a String for one instance and an Integer for another, which creates a logical conflict.



//Code Example: The API Response Wrapper
//In real-world enterprise applications, when an application requests data from a server, the server usually replies with a standard "Response" object. This object contains a status code, a message, and the actual requested data. Because the requested data changes every time (sometimes it's a User, sometimes a Product), it is the perfect use case for a Generic Class.

// We use <T> to indicate this class will hold "some type of data"
class ApiResponse<T> {

    private int statusCode;
    private String message;
    private T data; // The type of data will be decided later!

    // Constructor
    public ApiResponse(int statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public int getStatusCode() { return statusCode; }
    public String getMessage() { return message; }
    public T getData() { return data; }

    public void printDetails() {
        System.out.println("Status: " + statusCode + " | Message: " + message);
        if (data != null) {
            // We can safely call methods on data, or print it
            System.out.println("Data attached: " + data.toString());
        }
    }
}

// ---- Let's use it in a real-world scenario ----

class User {
    String name;
    public User(String name) { this.name = name; }
    @Override public String toString() { return "User Profile: " + name; }
}

public class GenericClasses {
    public static void main(String[] args) {

        // Scenario 1: We requested a User profile.
        // We tell the ApiResponse that its 'data' will be a User object.
        User fetchedUser = new User("John Doe");
        ApiResponse<User> userResponse = new ApiResponse<>(200, "Success", fetchedUser);

        System.out.println("--- Scenario 1 ---");
        userResponse.printDetails();

        // We get type safety out of the box. No casting needed!
        User safeUser = userResponse.getData();
        System.out.println(safeUser);

        System.out.println("\n--- Scenario 2 ---");
        // Scenario 2: We just want a simple success message, so the data is a String.
        ApiResponse<String> stringResponse = new ApiResponse<>(201, "Created", "Item successfully saved to database.");
        stringResponse.printDetails();

        String safeString = stringResponse.getData();
        System.out.println(safeString);
    }
}
