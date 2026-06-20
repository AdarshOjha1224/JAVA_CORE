package COLLECTION;

import java.util.*;

public class CoMparator {
    public static void main(String[] args) {

        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer i,Integer j) {
                if(i%10 > j%10) return 1;
                return -1;
            }
        };

        List<Integer> nums = new ArrayList<>();
        nums.add(41);
        nums.add(65);
        nums.add(13);
        nums.add(98);
        nums.add(22);
        nums.add(58);

        Collections.sort(nums); // Sorted.
        System.out.println(nums);

        // I want to sort them according to different logic
        // like based on their last digit.

        Collections.sort(nums,com); // If the end value is same then the order get priority.
        System.out.println(nums);
    }
}
