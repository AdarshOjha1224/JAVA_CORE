
// Wrapper Classes -
// for every primitive type - we are going to have class for it.

// for example -
//         int -> Integer,
//         char -> Character,
//         double -> double


public class WrapperClass {
    public static void main(String[] args) {

        int num = 2412 ;
//        Integer num1 = new Integer(num); // Boxing ->Taking primitive value and
//        storing in primitive object(wrapper object/class object)
        Integer num1 = num; // AUTOBOXING -> the boxing is doing in the Automatically
        System.out.println(num1);


//        int num2 = num1.intValue();  // UNBOXING -> value object type -> primitive type
        int num2 = num1; // AUTO-UNBOXING
        System.out.println(num2);

        String str = "1204";
        int num3 = Integer.parseInt(str); // In Integer Class , there is a parseInt method which take string as a input and convert it into integer.
        System.out.println(num3 * 2);


        // TRY ALL THE CLASSES AND ITS PROPERTIES WHICH IS SIMILAR TO THIS.
    }
}
