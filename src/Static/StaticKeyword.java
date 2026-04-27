package Static;

// The static keyword in java is used for memory management primarily.
// It can be applied to variable , methods , blocks and nested classes.
// The main concept behind static is that it belongs to the class rather than instance of the class.


public class StaticKeyword {
    public static void main(String[] args) {
        Student stud1 = new Student();

        System.out.println(stud1.getAge());
    }
}
