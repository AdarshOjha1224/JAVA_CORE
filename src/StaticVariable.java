
class Mobile{
//    instances of class

    String brand;
    int price;
    String name;
    static String network; // it will change network in all object
                           // for referring -> use class name.
                           // static keywork make the instance -> Class member , not as a Object member.
                           // Also saves memory


    public void show(){
        System.out.println(brand + " " + price + " " + name + " " + network);
    }
}

public class StaticVariable {
    public static void main(String[] args) {
        Mobile m1 = new Mobile();
        m1.brand = "Apple";
        m1.price = 650000;
        m1.name = "Iphone 16 pro";
        Mobile.network = "5G";

        Mobile m2 = new Mobile();
        m2.brand = "Xiaomi";
        m2.price = 27000;
        m2.name = "POCO X6 PRO";

        Mobile m3 = new Mobile();
        m3.brand = "Motorola";
        m3.price = 23000;
        m3.name = "Neo edge 50 pro";

        m1.show();
        m2.show();
        m3.show();

        System.out.println();

        m2.network = "4G";
        m1.show();
        m2.show();
        m3.show();

    }
}
