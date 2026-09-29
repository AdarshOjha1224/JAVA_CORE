package Array_and_Strings.Strings;

// Interview-Ready Definition:
//A String in Java is an object representing a sequence of characters. It is immutable, meaning once a String object is created in memory, its state or value cannot be modified. To optimize memory, Java caches literal strings in a specialized memory area inside the Heap called the String Pool (String Constant Pool).

// Characteristics:
//Final Class: The String class is marked final, meaning it cannot be subclassed.
//Memory Allocation: Strings created with double quotes (" ") go to the String Pool. Strings created using the new keyword (e.g., new String("IoT")) are created in the general Heap memory, bypassing the pool's direct caching.
//Immutability: Any operation that seems to modify a String (like concatenation or replacing characters) actually creates and returns a completely new String object, leaving the original unchanged.


//Evolution (The "Why"):
//This upgrades the C/C++ concept of mutable character arrays. Java made Strings immutable for three main reasons:
//Security: Strings are used for sensitive data (database URLs, usernames, network ports). If they were mutable, a malicious thread could change the URL after access was granted.
//Caching (String Pool): If Strings were mutable, caching them would be impossible because changing one reference would secretly change every other variable pointing to that same string.
//Thread Safety: Because they cannot change, Strings are automatically thread-safe and can be shared across multiple threads without synchronization.


//Advantages & Disadvantages:
//Advantages: Extremely secure, inherently thread-safe, memory efficient (multiple variables can point to the exact same literal in the String Pool without risk).
//Disadvantages: Poor performance and high memory consumption if you perform heavy string manipulations (like concatenating in a loop), as it creates massive amounts of "garbage" objects for the Garbage Collector to clean up.


//2. == vs .equals()
//Interview-Ready Definition:
//In Java, == is an operator that compares memory references (checking if two variables point to the exact same object in memory). The .equals() method is overridden in the String class to compare the actual character content (value equality) of the two strings.

//Interview Trap: Always use .equals() for Strings. Using == might randomly return true if both variables point to the String Pool, but will fail if one was created using the new keyword.


//3. Essential String Methods:
//length(): Returns the number of characters.
//charAt(int index): Returns the character at a specific index.
//substring(int begin, int end): Extracts a portion of the string.
//split(String regex): Breaks a string into an array based on a delimiter (crucial for parsing CSVs or logs).
//trim() / strip(): Removes leading and trailing spaces (always do this on user input).
//toLowerCase() / toUpperCase(): Converts casing.
//contains(CharSequence s): Checks if a substring exists.
//replace(target, replacement): Swaps out characters or substrings.


public class StringCoreConcepts {
    public static void main(String[] args) {
        // 1. String Pool vs Heap
        String s1 = "Java";          // Goes to String Pool
        String s2 = "Java";          // Reuses the object in String Pool
        String s3 = new String("Java"); // Forces creation in standard Heap

        // 2. == vs .equals()
        System.out.println(s1 == s2);      // true (Same memory reference in pool)
        System.out.println(s1 == s3);      // false (Different memory locations)
        System.out.println(s1.equals(s3)); // true (Content is identical)

        // 3. Immutability Check
        String original = "Hello";
        original.concat(" World"); // This creates "Hello World" in memory, but original ignores it!
//        original += " World";
        System.out.println(original); // Output: Hello (Original is unchanged)

        // 4. Practical Method Usage (Sanitizing User Input)
        String rawInput = "   admin@GMAIL.com   ";
        String cleanEmail = rawInput.trim().toLowerCase(); // Chaining methods
        System.out.println("Clean Email: " + cleanEmail);  // Output: admin@gmail.com

        // Parsing data (like from a sensor)
        String sensorData = "Temp:35C,Humidity:60%,Oxygen:Medium";
        String[] parts = sensorData.split(",");
        System.out.println("Temperature chunk: " + parts[0]); // Output: Temp:35C
        System.out.println("Humidity chunk: " + parts[1]);
        System.out.println("Oxygen chunk: " + parts[2]);
    }
}
