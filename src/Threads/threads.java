package Threads;

// To run these class methods parallel
// If you want to make Object behave like threads then just extends the class to "Thread" class.
// In Thread , run method is present.

class A extends Thread {
    public void run(){
        for(int i = 1 ; i <= 100 ; i++){
            System.out.println("A");
        }
    }
}

class B extends Thread {
    public void run(){
        for(int i = 1 ; i <= 100 ; i++){
            System.out.println("B");
        }
    }
}

public class threads {
    public static void main(String[] args) {

        A a1 = new A();
        B b1 = new B();

        // Start is method of Thread Class.

        a1.start();
        b1.start();
    }
}
