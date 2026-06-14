package OOPS.Constructor;

class Student{

    String name ;
    int age ;

    public void printInfo(){
        System.out.println(this.name + " " + this.age);
    }

//    When object is created , constructor being called FIRST.
    Student(){
        System.out.println("Constructor Called");
    }

    // Copy Constructor
    Student(Student stud){
        this.name = stud.name;
        this.age = stud.age;
    }

}

public class Constructor {

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Adarsh";
        s1.age = 21 ;

        Student s2 = new Student(s1);
        s2.printInfo();
    }

}
