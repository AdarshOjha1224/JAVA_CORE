package Objects;

class Student{
    int rollno;
    String name ;
    int marks;

}


public class ArrayOfObjects {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.rollno = 1004 ;
        s1.name = "Adarsh Ojha";
        s1.marks = 90;

        Student s2 = new Student();
        s2.rollno = 1005 ;
        s2.name = "Badshah";
        s2.marks = 87;

        Student s3 = new Student();
        s3.rollno = 1006 ;
        s3.name = "Raftaar";
        s3.marks = 79;

        Student students[] = new Student[3]; // we are not creating a object here ,
                                            // we are creating a array which can hold students references .
                                            // it will not create those object itself
        students[0] = s1;
        students[1] = s2;
        students[2] = s3;

        for(int i = 0; i< students.length ; i++) {
            System.out.println(students[i].name + " " + students[i].rollno + " " + students[i].marks);
        }


        System.out.println();


        // ENHANCED FOR LOOP --> FOR EACH

        for(Student stud : students){
            System.out.println(stud.name + " " + stud.rollno + " " + stud.marks);
        }

    }
}
