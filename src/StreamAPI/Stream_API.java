package StreamAPI;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Stream_API {
    public static void main(String[] args) {

        // Stream makes you work easy with filter, map and reduce.
        List<Integer> nums = Arrays.asList(4,3,7,5,12,8,5);

        // They are Same (Even getting Same Output)
        int sum = 0 ;
        for(int n : nums){
            if(n%2==0){
                n *= 2 ;
                sum += n ;
            }
        }
        System.out.println(sum);

        /// ---------------- STREAM ---------------
        Stream<Integer> s1 = nums.stream();
        // Whatever value you have in the List is available in the s1 Stream.
        // Perform changes in Stream s1 , not in the List nums Original.
        // You can't REUSE it.

        // There is no Compile time error but have Runtime error Because of One time use of Stream.
        // s1 is used in the Stream s2 . so ...

//        s1.forEach(n -> System.out.println(n));
//        s1.forEach(n -> System.out.println(n));


        Stream<Integer> s2 = s1.filter(n -> n%2==0);
//        s2.forEach(n -> System.out.println(n)); // s2 is reused here.

        Stream<Integer> s3 = s2.map(n -> n*2);
//        s3.forEach(n -> System.out.println(n));
        int result = s3.reduce(0,(c,e) -> c+e);
        System.out.println(result);


        /// Can be written as

        int total = nums.stream()
                .filter(n->n%2==0)
                .map(n->n*2)
                .reduce(0,(a,b)->a+b);
        System.out.println(total);



//      for single thread , for multiple thread parallelStream() but then dont use sorted().
        Stream<Integer> sortedValues = nums.stream()
                .filter(n -> n%2==0)
                .sorted();

        sortedValues.forEach(n -> System.out.println(n));

    }
}
