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
//        int b = 10/a ;
//        // After the exception , the code stops running.
//        System.out.println(b);

        int a = 0 ;
        int b = 0 ;

//        you can use try-catch multiple times according to the needs.
//        you can write normal statements in the try as well , but it is more sensible to write only critical.
//        Catch block runs only when the Exception occurs, otherwise the catch block is skipped.
//        Exception is class and e is a object here.
        try {
            b = 10/a;
        }
        catch (Exception e) {
            System.out.println("SOMETHING WENT WRONG..." + e);
        }


        System.out.println(b);

        System.out.println("BYE BYE");

    }
}
