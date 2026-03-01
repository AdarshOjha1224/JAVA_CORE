package Objects;

public class StRiNgOBJECT {
    public static void main(String[] args) {

//      String name = new String("Adarsh");
        String name = "Adarsh";
        name = name + " Ojha";
//      You are not changing the original string.
        System.out.println(name);
        System.out.println(name.hashCode());
        System.out.println(name.charAt(1));
      System.out.println(name.concat(" Ojha"));

        String s1 = "Adarsh";
        String s2 = "Adarsh";

        System.out.println(s1 == s2);


//        JVM -> Heap -> String Constant Pool(every string which you used is Constant)
//        Stack has variables and addresses which refer in the heap
//        by creating a new object and store similar data -> its just change the address
//        Mutable String -> Changable , Immutable String -> unChangable

//        StringBuffer sb = new StringBuffer(); // 16 bytes
//        System.out.println(sb.capacity());



//        STRING BUFFER -->>>>

        StringBuffer sb = new StringBuffer("Adarsh");
        System.out.println(sb.capacity()); // 22
        System.out.println(sb.length());   // 6
        sb.append(" Ojha");
        System.out.println(sb); // Adarsh Ojha

        String str = sb.toString();
        System.out.println(str);

        sb.deleteCharAt(3);
        System.out.println(sb); // Adash Ojha

        sb.insert(3,"r");
        System.out.println(sb); // Adarsh Ojha

        sb.setLength(30);
        System.out.println(sb);

        sb.ensureCapacity(100);
        System.out.println(sb);



    }
}
