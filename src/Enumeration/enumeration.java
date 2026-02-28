package Enumeration;

// where you want to use constant
/// you cant extend the enum.
enum Status{ // this is a class
    Running, Failed , Pending , Success;
    // These all are objects.(named constant)
    // these all also have index - 0 1 2 3 ....
}

public class enumeration {
    public static void main(String[] args) {

        Status st = Status.Running;
        System.out.println(st);
        System.out.println(st.ordinal());
        Status st1 = Status.Success;
        System.out.println(st1);
        System.out.println(st1.ordinal());

        Status[] st2 = Status.values();
//        System.out.println(st2[1]);

        for(Status s : st2){
            System.out.println(s + " : " + s.ordinal());
        }
    }
}
