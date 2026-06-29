package Exceptions;

public class Excepn {
    public static void main(String[] args) {

        // ERRORS - 1. Compile time error (because of syntax error generally)
        //          2. Runtime error (EXCEPTION , which need Handling)
        //          3. Logical error (No compile error and runtime error, needs debugging and testing)

        // STATEMENTS - 1. Normal statements, 2. Critical statements

        // normal
        int i = 9 ;
        int j = 27/i;
        System.out.println(j);

//        // critical
//        int a = 0 ;
//        int b = 10/a;

//        When exception arise , the code stops running.
//        To Make it run without any halt , Exception Handling Required.

//        System.out.println(b);

        int a = 0 ;
        int b = 0 ;

//        you can use try-catch multiple times according to the needs.
//        you can write normal statements in the try as well , but it is more sensible to write only critical.
//        Catch block runs only when the Exception occurs, otherwise the catch block is skipped.
//        Exception is class and e is a object here.

        // Hey JAVA execute this code -
        // Run try block
        // If runs without any error catch block will be skipped continue OR
        // If not then run catch block then continue.

        try {
            b = 10/a;
        }
        // its not working , Java throw an error and you have to catch it.
        // it is throwing an Object.
        catch (Exception e) {
            System.out.println("SOMETHING WENT WRONG..." + e);
        }
        System.out.println(b);
        System.out.println("BYE BYE");
    }
}
