class pehli {
    public void show(){
        System.out.println("Pehli class hai ye.");
    }
}

class dusri extends pehli {
    public void show(){
        System.out.println("dusri class hai ye.");
    }
}

class teesri extends pehli {
    public void show(){
        System.out.println("Teesri class hai ye.");
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        // Two types - 1.Compile time polymorphism (early binding) - Overloading.
        //             2.Run time polymorphism (late binding). - Overriding.


        // concept - DYNAMIC METHOD DISPATCH -->>>
        // Only possible in Inheritance.

        pehli p1 = new pehli();
        // we are here referring the p1 variable to pehli class
        // but creating the object of dusri class.
        p1.show();

        // we can assign a new object to a old variable.
        p1 = new dusri();
        p1.show();

        p1 = new teesri();
        p1.show();

    }
}
