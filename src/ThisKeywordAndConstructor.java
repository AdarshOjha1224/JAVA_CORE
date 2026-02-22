
class Human {
    private int age ;
    private String name ;

    // Constructor - Special method which has name is same as class name (look like a method)
    // Don't specify the return type. (never returns anything)
    // We specify the access only.
    // everytime we create a new object it calls the constructor , You not need to call them specially.

    public Human(){   // DEFAULT CONSTRUCTOR
        System.out.println("Its a constructor.");
    }

    public Human(int age,String name){ // PARAMETERIZED CONSTRUCTOR
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //// this -> keyword which represent the current object which is calling the method.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}


public class ThisKeywordAndConstructor {
    public static void main(String[] args) {
        Human h1 = new Human();
        // when you create the object in the heap memory then it create a empty object.
        System.out.println(h1.getAge() + " " + h1.getName());
        h1.setAge(21);
        h1.setName("Adarsh Ojha");
        System.out.println(h1.getAge() + " " + h1.getName());
        Human h2 = new Human(18,"TAPPU");
        System.out.println(h2.getAge() + " " + h2.getName());
        new Human();

    }
}
