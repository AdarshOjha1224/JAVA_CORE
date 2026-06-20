package COLLECTION;
import java.util.*;

class Student {
    String name ;
    int age ;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student {" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class ComparatorWithClass {

    public static void main(String[] args) {
        Comparator<Student> com = (i,j) -> (i.age>j.age) ? 1 : -1 ;

        List<Student> studs = new ArrayList<>();
        studs.add(new Student("A",21));
        studs.add(new Student("B",20));
        studs.add(new Student("C",23));
        studs.add(new Student("D",24));
        studs.add(new Student("E",22));

//        Collections.sort(studs); // This is not working in this until you implements Comparable Interface.
//        Comparable has methods call compareTo(T o) accepting the Object
//        if we implement that method then we can use simple sort method of collections.

        for(Student s : studs) System.out.println(s);

        // Here we are using comparator(com).

        System.out.println("Sorted according to age >>>>");
        Collections.sort(studs,com);
        //
        for(Student s : studs) System.out.println(s);


    }

}
