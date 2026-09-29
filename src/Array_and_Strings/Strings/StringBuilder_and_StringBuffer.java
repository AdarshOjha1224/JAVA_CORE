package Array_and_Strings.Strings;

// Interview-Ready Definition:
//StringBuffer and StringBuilder are classes used to create mutable sequences of characters. Unlike String, when you modify a StringBuilder or StringBuffer, it updates the exact same object in memory without creating new ones.
//StringBuffer is synchronized (thread-safe).
//StringBuilder is non-synchronized (not thread-safe, but much faster).

//Characteristics:
//They maintain an internal character array that dynamically expands its capacity when it runs out of room (default capacity is usually 16 + length of initial string).
//Both provide the highly used .append(), .insert(), and .reverse() methods.

//Evolution (The "Why"):
//StringBuffer was introduced in Java 1.0 as an upgrade to String to solve the massive memory waste caused by string concatenation in loops.
//StringBuilder was introduced in Java 1.5 as an upgrade to StringBuffer. Because StringBuffer's methods are synchronized (locked for multi-threading), it is slow. Since 99% of string manipulations happen within a single thread (like a local variable inside a method), Java introduced StringBuilder to drop the synchronization overhead, making it significantly faster.

//Advantages & Disadvantages:
//Advantages: Phenomenal performance and memory efficiency when doing heavy string manipulations, loops, or constructing dynamic queries/JSONs.
//Disadvantages: StringBuilder is not thread-safe (though rarely an issue). Neither class overrides .equals(), so you cannot compare their contents directly without converting them to Strings first (e.g., sb1.toString().equals(sb2.toString())).

public class StringBuilder_and_StringBuffer {
    public static void main(String[] args) {

        // BAD PRACTICE (Using String in a loop)
        // This creates 10 separate String objects in memory, abandoning 9 of them to garbage collection.
        String badQuery = "SELECT * FROM users WHERE id IN (";
        for (int i = 1; i <= 10; i++) {
            badQuery += i + ",";
        }
        System.out.println(badQuery);

        // BEST PRACTICE (Using StringBuilder)
        // This modifies a single object in memory. Extremely fast and efficient.
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM users WHERE id IN (");
        for (int i = 1; i <= 10; i++) {
            queryBuilder.append(i).append(",");
        }
        System.out.println(queryBuilder);

        // Removing the trailing comma and closing the bracket
        queryBuilder.deleteCharAt(queryBuilder.length() - 1);
        queryBuilder.append(");");

        // Convert back to immutable String only when completely finished
        String finalQuery = queryBuilder.toString();
        System.out.println(finalQuery);
        // Output: SELECT * FROM users WHERE id IN (1,2,3,4,5,6,7,8,9,10);

        // Note: Use StringBuffer instead of StringBuilder ONLY IF this object
        // is declared globally and accessed by multiple threads simultaneously.
    }
}
