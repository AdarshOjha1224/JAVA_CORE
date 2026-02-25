/// Abstract keyword used with -> methods and class
/// Abstract method only belongs to abstract class
/// You can't create the object of the abstract class.
/// abstract class can have both - abstract methods and normal methods (ONLY ALSO) BUT.
/// abstract method only allowed in abstract class.
/// Abstract -> giving the abstract idea but,at the moment don't know how to implement it.
///  It is compulsory to implement all the abstract methods.

abstract class Car {

    public void playMusic(){
        System.out.println("DHOOM MACHALE DHOOM MACHALE DHOOOM !!");
    }
    public abstract void drive();
    public abstract void fly();

}

///  If the extends (Inherited) class is not able to implement all the methods then
/// that class also have to be abstract class.

abstract class ferrari extends Car {
//    public void fly(){
//        System.out.println("FAMILY !!");
//    }

    public void drive() {
        System.out.println("Driving !!");
    }
}

class UpdatedFerrari extends ferrari {    // CONCRETE CLASS

    public void fly() {
        System.out.println("FAMILYYYYY !!");
    }
}

public class AbstractKeyword {
    public static void main(String[] args) {

        Car c1 = new UpdatedFerrari();
        c1.drive();
        c1.playMusic();
    }
}
