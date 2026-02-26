package InTeRfAcE;

/// class to class -> extends
/// class to interface -> implements
/// interface to interface -> extends


// it is necessary to implement all the method which is in the interface class.
// Other-wise class will become abstract and you need another class to implement the remaining methods.
// in implements you only get the methods , not the variables.
// -- thats why variables is static so you can call them with the name of interface class.
/// for interface we use "implements" instead of "extends"
///  interface just tell the things which you need (THE DESIGN)
///  all the methods which is in the interface class is "public abstract" by default.

/// every variable in the interface class is final and static
///  reason for -----
/// static ->> in implements you only get the methods , not the variables.
/// that's why variables is static so you can call them with the name of interface class.
///
/// final ->> because the interface don't have own memory in the heap

interface first{
       int age = 21 ;
    String name = "Adarsh" ;

    void show();
    void config();
}

interface third{
    void run();
}

interface fourth extends third {

}

// can implement the multiple interfaces ->>
class second implements first , third {

    @Override
    public void show() {
        System.out.println("In the Show !! ");
    }

    @Override
    public void config() {
        System.out.println("In the Config !!");
    }

    @Override
    public void run() {
        System.out.println("Running.....");
    }
}


public class Interface {
    public static void main(String[] args) {

        // reference of first and object of second.
        first f1 = new second();
        f1.show();
        f1.config();

        third t1 = new second();
        t1.run();

        // to use static things , we don't need object.
        System.out.println(first.age);
        System.out.println(first.name);


    }
}
