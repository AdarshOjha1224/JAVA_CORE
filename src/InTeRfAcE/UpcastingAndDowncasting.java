package InTeRfAcE;

class Papa {
    public void show1(){
        System.out.println("Hello papa Ji !!");
    }
}

class Beta extends Papa {
    public void show2(){
        System.out.println("Hello beta Ji !!");
    }
}


public class UpcastingAndDowncasting {
    public static void main(String[] args) {

        // TYPECASTING ->>>>
        double d = 1.5;
        int i = (int)d;
        System.out.println(i);


        // UPCASTING ->>>>
        Papa p1 = (Papa) new Beta(); // you dont have to mention it implicitly.
        // it can also written as    [  InTeRfAcE.Papa p1 = new InTeRfAcE.Beta();  ]
        // the object of InTeRfAcE.Beta is refer to the InTeRfAcE.Papa (So we are going up) ->>
        p1.show1();


        // DOWNCASTING ->>>>
        // why we need this -> child-class can access the properties of parent-class,
        // but parent-class cant access the properties of child-class.
        // To Make possible this we use the concept of Downcasting.
        Beta b1 = (Beta) p1 ;
        b1.show2();

    }
}
