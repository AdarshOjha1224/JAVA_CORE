package AbstractAnonymousAndInnerClass;

abstract class Parent {
    public abstract void show();
    public abstract void display();
}


public class AbstractAndAnonymous {
    public static void main(String[] args) {

        // if you want to implement interface/abstract class only once then you can use inner class.
        // we are creating the object not AbstractAnonymousAndInnerClass.Parent , we are creating the object of inner class.
        Parent p1 = new Parent() {
            public void show() {
                System.out.println("In the new show!!");
            }

            @Override
            public void display() {
                System.out.println("In the new Display");
            }
        };


    }
}
