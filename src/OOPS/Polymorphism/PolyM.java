package OOPS.Polymorphism;

class Student {

    String name ;
    int age ;

    // Function Overloading (Compile-Time Polymorphism)
    // if the argument are same then return type must be different or vise-versa.

    public void printInfo(String name){
        System.out.println(name);
    }
    public void printInfo(int age){
        System.out.println(age);
    }
    public void printInfo(String name, int age){
        System.out.println(name + " " + age);
    }

}

public class PolyM {

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Adarsh";
        s1.age = 21;
        s1.printInfo(s1.name , s1.age);

        Student s2 = new Student();
        s2.name = "Ojha";
        s2.age = 24 ;
        s2.printInfo(s2.name);
        s1.printInfo(s2.age);


    }
}