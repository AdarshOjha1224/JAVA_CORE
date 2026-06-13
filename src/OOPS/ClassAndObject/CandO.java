package OOPS.ClassAndObject;

class Pen {
    String color;
    String type;

    public void write(){
        System.out.println("Writing Something !");
    }

    public void printColor() {
        System.out.println(this.color);
    }
}

class Student {
    String name ;
    int age ;

    public void printInfo(){
        System.out.println(this.name);
        System.out.println(this.age);
    }
}

public class CandO {
    public static void main(String[] args) {
        Pen pen1 = new Pen();
        pen1.color = "Blue";
        pen1.type = "Ball";
        pen1.write();

        Pen pen2 = new Pen();
        pen2.color = "Black";
        pen2.type = "Gel";

        pen1.printColor();
        pen2.printColor();

        Student s1 = new Student();
        s1.name = "Adarsh";
        s1.age = 21 ;

        s1.printInfo();

    }
}
