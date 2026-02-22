
class First {
    public void show(){
        System.out.println("In First show");
    }

    public void display(){
        System.out.println("In the Display");
    }
}

class Second extends First {
    public void show(){ // Method Overriding. (which gives preference its own feature first)
        System.out.println("In Second show");
    }
}

public class MethodOverRiding {
    public static void main(String[] args) {
        Second s1 = new Second();
        s1.show();
        s1.display();
    }
}
