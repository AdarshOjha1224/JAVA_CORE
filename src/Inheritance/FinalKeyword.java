package Inheritance;// final - variable , method , class.

final class A_{ // final class -> stoping the inheritance.

    public void show(){
        System.out.println("This is class ThisAndConstructor.A");
    }
    public void add(int a,int b){
        System.out.println(a+b);
    }
}

class B_{
    final public void show(){ // final method -> Stoping the override.
        System.out.println("This is class ThisAndConstructor.B");
    }
    public void add(int a,int b){
        System.out.println(a+b);
    }
}

class C_ extends B_{
//    public void show(){
//        System.out.println("This is class C");
//    }
}


public class FinalKeyword {
    public static void main(String[] args) {
        final int num = 0 ; // final variable -> stoping changing the value(making that constant)
        System.out.println(num);

        A_ a1 = new A_();
        a1.show();
        a1.add(4,8);

        C_ c1 = new C_();
        c1.show();
        c1.add(10,20);


    }
}
