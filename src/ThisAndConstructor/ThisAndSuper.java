package ThisAndConstructor;

// Parent Class
class Animal {
    String name = "Generic Animal";

    Animal(String species) {
        System.out.println("Animal created: " + species);
    }

    void makeSound() {
        System.out.println("Some general sound");
    }
}

// Child Class
class Dog extends Animal {
    String name; // Hides the parent's 'name' variable

    Dog(String dogName) {
        // super() MUST be the first line. Calls Animal(String)
        super("Canine");

        // this.name refers to the Dog class variable
        // dogName refers to the parameter
        this.name = dogName;
    }

    // Overriding the parent method
    void makeSound() {
        // super.makeSound() calls the Animal class version
        super.makeSound();
        System.out.println("Woof!");
    }

    void printNames() {
        System.out.println("Child name: " + this.name);
        System.out.println("Parent name: " + super.name);
    }
}

public class ThisAndSuper {
    public static void main(String[] args) {
        Dog myDog = new Dog("Buddy");
        // Output: Animal created: Canine

        myDog.printNames();
        // Output: Child name: Buddy
        // Output: Parent name: Generic Animal

        myDog.makeSound();
        // Output: Some general sound
        // Output: Woof!
    }
}
