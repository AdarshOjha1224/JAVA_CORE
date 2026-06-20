package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class forEachMethod {
    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(4,8,3,5,6,7,2,9);

        // Normal for loop (fetch every element one by one)
//        for(int i=0 ; i<nums.size();i++){
//            System.out.println(nums.get(i));
//        }


        // enhanced for loop (give every element in n and then print)
//        for(int n : nums) System.out.println(n);



        // forEach Method ->>>
        // forEach is method for Iterable interface which accept Object of Consumer Functional Interface having only one method - void accept(T t);
        // So we can apply lambda expression.

        /// First Implementation ->>

//        Consumer<Integer> con = new Consumer<Integer>() {
//            @Override
//            public void accept(Integer n) {
//                System.out.println(n);
//            }
//        };
//        nums.forEach(con);


        /// Second Implementation ->>

//        Consumer<Integer> con = n -> System.out.println(n);
//        nums.forEach(con);

        /// Final Implementation ->>

        nums.forEach(n -> System.out.println(n));
        // gives you value from nums in n and you can do whatever you want.


    }
}
