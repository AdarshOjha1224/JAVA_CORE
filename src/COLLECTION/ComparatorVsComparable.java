package COLLECTION;
import java.util.*;


class Students implements Comparable<Students> {
    String name ;
    int age ;

    public Students(String name, int age) {
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

    public int compareTo(Students that) {
        if(this.age > that.age) return 1 ;
        return -1 ;
    }
}


public class ComparatorVsComparable {
    public static void main(String[] args) {

//        Comparator<Student> com = new Comparator<Student>() {
//            @Override
//            public int compare(Student i, Student j) {
//                if (i.age > j.age) return 1;
//                return -1;
//            }
//        };

        List<Students> studs = new ArrayList<>();
        studs.add(new Students("A", 21));
        studs.add(new Students("B", 20));
        studs.add(new Students("C", 23));
        studs.add(new Students("D", 24));
        studs.add(new Students("E", 22));

        // Here we are using simple sort with the help of implementation of Comparable interface with Student Class.
        Collections.sort(studs);
        for(Students s : studs) System.out.println(s);

    }
}
