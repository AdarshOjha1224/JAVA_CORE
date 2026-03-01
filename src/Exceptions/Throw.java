package Exceptions;

public class Throw {
    public static void main(String[] args) {

        int i = 20 ;
        int j = 0 ;

        try{
            j = 18/i;
            // lets handle the error.
            // we are trying to throw an error.
            // throwing the object of ArithmeticException and catch will catch it.
            if(j==0) throw new ArithmeticException("I dont want to print zero ");
            // this is an constructor.
        }
        catch (ArithmeticException e){
            j = 18/1;
            System.out.println("DEFAULT OUTPUT " + e);
        }
        catch (Exception e){
            System.out.println("Something went wrong ! " + e);
        }

        System.out.println(j);
        System.out.println("Bye Bye");
    }
}
