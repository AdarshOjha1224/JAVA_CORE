package Inheritance;


public class inheritance {
    public static void main(String[] args) {

        // parent - child class.
        // super - sub class.
        // base - derived class.


        // child class  extends  parent class

//              ---------------------------
//            Car1 ----                   |
//             ^      | Single level      |
//             |      |  Inheritance      |  Multi level
//            Car2 ----                   |  Inheritance
//             ^                          |
//             |                          |
//            Car3                        |
//              ---------------------------

//        MULTIPLE INHERITANCE IS NOT WORK IN JAVA .


        Car3 c1 = new Car3();
        String r1 = c1.accelerator(40);
        String r2 = c1.brake(15);
        String r3 = c1.accelerator(15);
        String r4 = c1.brake(0);
        System.out.println(r1 + "\n" + r2 + "\n" + r3 + "\n" + r4);
        String r5 = c1.musicSystem(true);
        String r6 = c1.headlight(false);
        System.out.println(r5 + "\n" + r6);
        String r7 = c1.musicSystem(false);
        String r8 = c1.headlight(true);
        System.out.println(r7 + "\n" + r8);
        String r9 = c1.backCamera(true);
        String r10 = c1.airCondition(false);
        System.out.println(r9 + "\n" + r10);



    }
}