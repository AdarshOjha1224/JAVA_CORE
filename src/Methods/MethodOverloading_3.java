package Methods;

class Calculator {
    public int add(int n1, int n2) {
        return n1 + n2;
    }

    public int add(int n1, int n2, int n3) {
        return n1 + n2 + n3;
    }
    public double add(double n1 , double n2) {
        return n1 + n2 ;
    }
}


public class MethodOverloading_3 {
    public static void main(String[] args) {
        Calculator c1 = new Calculator();
        int r1 = c1.add(5, 6);
        int r2 = c1.add(6, 8, 5);
        double r3 = c1.add(3.20,6.45);
    }
}
