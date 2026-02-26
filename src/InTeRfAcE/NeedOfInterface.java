package InTeRfAcE;

interface Computer{
    void code();
}

class Laptop implements Computer {
    public void code(){
        System.out.println("Code -> Compile -> Run");
    }
}

class Desktop implements Computer {
    public void code(){
        System.out.println("Code -> Compile -> Run : Faster");
    }
}

class Developer {

    // Developer is depending on the computer, it can be laptop or computer.
    // here we are passing the object reference of Computer class.
    public void devApp(Computer comp){ // you are accepting a Computer reference.
        comp.code();
    }
}

public class NeedOfInterface {
    public static void main(String[] args) {

        // we creating here is interface references.
        Computer l1 = new Laptop();
        Computer d1 = new Desktop();

        Developer dev1 = new Developer();
        dev1.devApp(d1);// you are passing a Computer reference.
        dev1.devApp(l1);
    }
}
