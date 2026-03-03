// The abstract class
abstract class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    // A regular, concrete method. All animals sleep,
    // and we provide a default implementation.
    public void sleep() {
        System.out.println(name + " is sleeping... Zzz");
    }

    // An abstract method. Every animal makes a sound,
    // but the specific sound is different.
    public abstract void makeSound();

    // Getter for name
    public String getName() {
        return name;
    }
}

// A concrete child class inheriting from Animal
class Dog extends Animal {

    // Constructor calling the parent (super) constructor
    public Dog(String name) {
        super(name);
    }

    // Providing the specific implementation for the abstract method
    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Woof! Woof!");
    }
}

// Another concrete child class inheriting from Animal
class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    // Providing the specific implementation for the abstract method
    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Meow!");
    }
}

// The main class to run the program
public class InheritanceAndAbstract {
    public static void main(String[] args) {
        // Animal myAnimal = new Animal("Generic"); // Error! Cannot instantiate an abstract class

        // Creating instances of the concrete subclasses
        Dog myDog = new Dog("Buddy");
        Cat myCat = new Cat("Whiskers");

        // Calling the inherited method from the abstract parent class
        myDog.sleep();
        myCat.sleep();

        // Calling the overridden abstract methods
        myDog.makeSound();
        myCat.makeSound();
    }
}