package LambdaExpressions;

@FunctionalInterface
interface A {
    void show(int i);
}


public class LambdaExp {
    public static void main(String[] args) {

//        A a1 = new A() {
//            @Override
//            public void show(int i) {
//                System.out.println("In the show !! " + i);
//            }
//        };


/// LAMBDA EXPRESSION ->>>

//        A a1 = (int i) -> System.out.println("In the show ! " + i);
//        A a1 = (i) -> System.out.println("In the show ! " + i);


        // create less class files , but because of LambdaExp the class got heavier.
        A a1 = i -> System.out.println("In the show ! " + i);
        a1.show(20);
    }
}
