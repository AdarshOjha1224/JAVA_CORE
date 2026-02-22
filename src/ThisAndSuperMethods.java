
// every class in java extends Objects class
class A extends Object {
    public A(){
        super();
        System.out.println("This is A");
    }

    public A(int a){
        super();
        System.out.println("This is int a");
    }
}


class B extends A {
    public B(){
        super(); // Call the constructor of super class (The default constructor).
        System.out.println("This is B");
    }

    public B(int b){
        this(); // this will execute the constructor of same class.
//        super(b); // if you want to pass the parameterized constructor then you have to mention super explicitely.
        System.out.println("This is int b");
    }
}


public class ThisAndSuperMethods {
    public static void main(String[] args) {
//        B b1 = new B();

        B b2 = new B(10);

        // i want to execute the both constructor of B.


    }
}
