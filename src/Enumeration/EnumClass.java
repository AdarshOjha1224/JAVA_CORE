package Enumeration;

enum Laptop{
    Macbook(850000) , LOQ(60000) , ThinkPad, Victus(53000) ;

    private int price ;

    // we are using private constructor because,
    // we are creating the objects in the same class itself.

    private Laptop() {
        price = 10000;
    }

    private Laptop(int price) {
        this.price = price;
        System.out.println("In Laptop " + this.name());
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

public class EnumClass {
    public static void main(String[] args) {

//        Laptop l1 = Laptop.Macbook;
//        System.out.println(l1 + " : " + l1.getPrice());

        for(Laptop lap : Laptop.values()){
            System.out.println(lap + " " + lap.getPrice());
        }
    }
}
