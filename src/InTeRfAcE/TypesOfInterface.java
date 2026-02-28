package InTeRfAcE;


/// Types -> 1. Normal , 2. Functional(or SAM) , 3. Marker
/// NORMAL INTERFACE -- if the interface has two or more methods
/// FUNCTIONAL (SINGLE ABSTRACT METHOD) INTERFACE -- The interface which have single method
/// MARKER INTERFACE -- blank interface (use the concept of SERIALIZATION)

// A is functional interface
    @FunctionalInterface
interface A {
    void show();
}

//class B implements A {
//    public void show(){
//        System.out.println("In the show !!");
//    }
//}


public class TypesOfInterface {
    public static void main(String[] args) {

        A a1 = new A() {
            @Override
            public void show() {
                System.out.println("In the show !!");
            }
        };
        a1.show();
    }
}
