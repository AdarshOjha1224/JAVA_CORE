package Enumeration;

public class EnumIfAndSwitch {
    public static void main(String[] args) {
        Status s = Status.Success;

        System.out.println(s.getClass().getSuperclass());

///     WITH IF-ELSE  -->>>>
//        if(s == Status.Running) System.out.println("ALL GOOD !");
//        else if(s == Status.Failed) System.out.println("TRY AGAIN !");
//        else if(s == Status.Pending) System.out.println("PLEASE WAIT !");
//        else System.out.println("DONE !");

        switch (s) {
            case Running :
                System.out.println("ALL GOOD !");
                break;
            case Failed:
                System.out.println("TRY AGAIN !");
                break;
            case Pending:
                System.out.println("PLEASE WAIT !");
                break;
            default:
                System.out.println("DONE !");
                break;
        }


    }
}
