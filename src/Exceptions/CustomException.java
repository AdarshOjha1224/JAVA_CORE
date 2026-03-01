package Exceptions;

class AdarshException extends RuntimeException {
    public AdarshException(String str){
        super(str);
    }
}


public class CustomException {
    public static void main(String[] args) {

        int i = 20 ;
        int j = 0 ;

        try{
            j = 18/i;
            if(j==0) throw new AdarshException("I dont want Zero");
        }
        catch(AdarshException e){
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
