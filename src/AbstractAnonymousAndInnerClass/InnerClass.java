package AbstractAnonymousAndInnerClass;// static is used only for the inner class.
// you cant make outer class static.

class _A {

    int age ;

    public void show(){
        System.out.println("In the show !!");
    }

    class _B {
        // It creates the class AbstractAnonymousAndInnerClass._A$_B

        public void print(){

            System.out.println("Printing.....");
        }
    }

    static class _C {
        public void display(){
            System.out.println("This is Static class !!");
        }
    }
}


public class InnerClass {
    public static void main(String[] args) {

        _A a1 = new _A();
        a1.show();

//        _B is not openly available.
//        _B b1 = new _B(); ->>> ERROR

        _A._B b1 = a1.new _B();
        //->> ThisAndConstructor.A.ThisAndConstructor.B means ThisAndConstructor.B belongs to ThisAndConstructor.A.
        // ->> if you want to call show() , which is a non-static method , which means
        // you need object to call it.
        // ->> if you want to access age , then you need a object of AbstractAnonymousAndInnerClass._A.
        // ->> Similarly, if you want to create a object of _B(to call print() which is non-static method) then,
        // you need the object of AbstractAnonymousAndInnerClass._A.

        b1.print();

        _A._C c1 = new _A._C(); // only work when the class is static.

        c1.display();

        //


    }
}
