package Exceptions;

// old technique with same name of main class.
//class A {
//    public void show() {
//        try {
//            Class.forName("Throws");
//        }
//        catch (ClassNotFoundException e){
//            System.out.println("Class not found ! " + e);
//        }
//    }
//}


// not handle the exception just throws the responsibility to the exception.
// and here the main is responsible for the exception handling.
class A {
    public void show() throws ClassNotFoundException {
            Class.forName("first");
    }
}


public class Throws {

    static {
        System.out.println("Class Loaded ! ");
    }

    // two option here -> either you can use try-catch here or use Throws
    // like ->  "public static void main(String[] args) throws ClassNotFoundException"
    // IT IS NOT RECOMMENDED TO ALLOW main TO THROWS THE EXCEPTION.
    // reason -> if you let main throws exception then it will duck it to the JVM ,
    // and JVM will stops the execution.
    public static void main(String[] args) {
         // DUCKING EXCEPTION

        A a1 = new A();
        try {
            a1.show();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
