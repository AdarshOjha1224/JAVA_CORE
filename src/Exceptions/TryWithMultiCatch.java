package Exceptions;

public class TryWithMultiCatch {
    public static void main(String[] args) {

        int i = 2 ;
        int j = 0 ;

        int[] nums = new int[5];
        String str = null;

        try {
            j = 18/i;
            System.out.println(str.length());
            System.out.println(nums[1]);
            System.out.println(nums[5]); // going out of bound
        }
        catch (ArithmeticException e){
            System.out.println("Cannot divide by zero !");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Stay in you limits !");
        }
        catch (Exception e){
            System.out.println("Something went wrong..." + e);
        }

//        Exception class (parent) should be at the bottom of all the exceptions (child)


        System.out.println(j);
        System.out.println("The end.");
    }
}
