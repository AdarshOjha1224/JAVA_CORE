class mobile{
//    non-static variable -> instances variable.

    String brand;
    int price;
    String name;
    static String network; // it will change network in all object
                           // for referring -> use class name.
                           // static keywork make the instance -> Class member , not as a Object member.
                           // Also saves memory


    public mobile(){  // Automatically called when the object is created.
        brand = "";
        price = 10000;
        name = "Phone";
        System.out.println("It is the Constructor.");
    }

    static {
        network = "5G";
        System.out.println("It is always calling first  'Static Block'");
    }


    public void show() {
        System.out.println(brand + " " + price + " " + name + " " + network);
    }
//
    public static void show1(mobile m){
        System.out.println("This is Static Method !!");
//
//        you cant call non-static variable in static method.
//        because its getting confuse for the object when it called.
//
        System.out.println(m.brand + " " + m.price + " " + m.name + " " + network);
    }

}


public class StaticMethodAndVariable {
    public static void main(String[] args) throws ClassNotFoundException {

        // we have a main static -> if we dont then we have to create a object to call class StaticMethodAndVariable
        // main is a starting point of a program then how it is possible to create object before START
        // THIS IS CALL DEADLOCK.
        // to solve that we create the main static.



        Class.forName("mobile"); // this can be used to load class .

        mobile mob1 = new mobile();
        // when object is created then -> first load class first and then objects are instantiated.
        // Class loader is present in JVM which loads all the classes.
        // here when the class loads so the static block run first.

        mob1.brand = "Apple";
        mob1.price = 650000;
        mob1.name = "Iphone 16 pro";
        mobile.network = "5G";

        mobile mob2 = new mobile();
        mob2.brand = "Xiaomi";
        mob2.price = 27000;
        mob2.name = "POCO X6 PRO";

        mobile mob3 = new mobile();
        mob3.brand = "Motorola";
        mob3.price = 23000;
        mob3.name = "Neo edge 50 pro";

        mob1.show();
        mob2.show();
        mob3.show();

        mob2.network = "4G";
        mob1.show();
        mob2.show();
        mob3.show();

        mobile.show1(mob1); // you can call static method directly with the class name

    }
}
