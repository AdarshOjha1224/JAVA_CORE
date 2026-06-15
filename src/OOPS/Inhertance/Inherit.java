package OOPS.Inhertance;

// Base/Parent class
class Shape {
    String color;
    public void area(){
        System.out.println("Displays Area !");
    }
}


// Derived/Child class
class Triangle extends Shape {

}


public class Inherit {
    public static void main(String[] args) {
        Triangle t1 = new Triangle();
        t1.color = "Red";
    }
}
