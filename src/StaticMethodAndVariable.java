class mobile{
//    instances of class

    String brand;
    int price;
    String name;
    static String network; // it will change network in all object
                           // for referring -> use class name.
                           // static keywork make the instance -> Class member , not as a Object member.
                           // Also saves memory


    public void show() {
        System.out.println(brand + " " + price + " " + name + " " + network);
    }

    public static void show1(mobile m){
        System.out.println("This is Static Method !!");

//        you cant call non static variable in static method.
//        because its getting confuse for the object when it called.

        System.out.println(m.brand + " " + m.price + " " + m.name + " " + network);
    }

}


public class StaticMethodAndVariable {
    public static void main(String[] args) {

        mobile mob1 = new mobile();
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
