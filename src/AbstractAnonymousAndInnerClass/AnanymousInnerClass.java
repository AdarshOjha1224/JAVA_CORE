package AbstractAnonymousAndInnerClass;

class Animal {
    public void show() {
        System.out.println("This is AbstractAnonymousAndInnerClass.Animal...");
    }
}

// If you know that this extended class is going to use only once,
// then why we create this ??

//class Monkey extends AbstractAnonymousAndInnerClass.Animal {
//    public void show(){
//        System.out.println("This is Monkey...");
//    }
//}


public class AnanymousInnerClass {
    public static void main(String[] args) {

        // NEW IMPLEMENTATION -> (Inner class inside the main class, with NO NAME -> ANONYMOUS)
        Animal an1 = new Animal() {
            public void show() {
                System.out.println("This is Monkey...");
            }
        };

        an1.show(); // Here it will call the show of new implementation.
    }
}
