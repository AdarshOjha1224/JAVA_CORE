package Annotation;

class A {
    public void show(){
        System.out.println("In A show !!");
    }
}

class B extends A {
     // if we mistake to name the method which we are overriding,
    // In that case , we use annotations so the it can alert us while writing code.
     @Override
    public void show(){
        System.out.println("In B show !!");
    }
}
public class Annot {
    public static void main(String[] args) {
        B b1 = new B();
        b1.show();
    }
}
