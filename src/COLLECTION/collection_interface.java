package COLLECTION;

import java.util.*;
// Collection API

// includes - Collection
//            Set
//            List
//            Iterator
//            Map


public class collection_interface {
    public static void main(String[] args) {

        // ----------COLLECTION----------
        // Collection works with Wrapper class.
        System.out.println("----------COLLECTION----------");

        // I dont want to use anonymous class like -
        // Collection num1 = new Collection() {
        //       various overriding methods
        //       --------------------------
        //       --------------------------
        // }

        // collection - we didnt mention the datatype here.
        // So if you want to add integers value then you have to mention in generic <> .

        Collection<Integer> num1 = new ArrayList<Integer>();
        // Here the values are objects not integers.
        num1.add(30);
        num1.add(40);
        num1.add(20);
        num1.add(20);
        num1.add(10);
//        num1.add("50");

        // we have no indexing for collection interface.

        for(int n : num1) System.out.print(n + " ");
        System.out.println();

        for(Object n : num1){
            int num = (Integer)n;
            System.out.print(num*2 + " ");
        }
        System.out.println();
        System.out.println(num1);



        // ------------ LIST -------------
        System.out.println("------------ LIST -------------");

        // If you want to work with index value then use List instead of Collection.

        List<Integer> num2 = new ArrayList<Integer>();
        num2.add(1);
        num2.add(2);
        num2.add(3);
        num2.add(4);
        num2.add(5);

        System.out.println(num2.get(2)); // 3
        System.out.println(num2.indexOf(4)); // 3


        // ------------- SET --------------
        System.out.println("------------- SET --------------");
        // doesn't support index value
        // No duplicate elements

        Set<Integer> num3 = new HashSet<Integer>();
        num3.add(4);
        num3.add(5);
        num3.add(2);
        num3.add(7);
        num3.add(4);

        // Printing non-repeating elements and maybe sorted.
        for(int n : num3) System.out.print(n + " ");
        System.out.println();

        Set<Integer> num4 = new HashSet<Integer>();
        num4.add(67);
        num4.add(45);
        num4.add(89);
        num4.add(34);
        num4.add(98);

        // Here we are getting elements Unsorted
        for(int n : num4) System.out.print(n + " ");
        System.out.println();


        // To get Sorted elements.
        Set<Integer> num5 = new TreeSet<Integer>();
        num5.add(67);
        num5.add(45);
        num5.add(89);
        num5.add(67);
        num5.add(98);

        for(int n : num5) System.out.print(n + " ");
        System.out.println();

        // ------------- ITERATOR --------------
        System.out.println("------------- ITERATOR --------------");

        // num5.iterator will return values so we are storing them in values objects.
        Iterator<Integer> values = num5.iterator();
        // Not using a for loop.

        while(values.hasNext()) System.out.println(values.next());

        // ------------ MAP -------------
        System.out.println("------------ MAP<K,V> -------------");
        // Map is collection of key-value pairs.

        Map<String,Integer> students = new HashMap<>();
        // HashTable will work fine in the place of HashMap , but the difference is HashTable is synchronized.
        // If you want to use hashMap with multiple threads then use synchronized externally.

        // put - try to add the element if you already have this key just replace it.
        students.put("A",95);
        students.put("B",80);
        students.put("C",78);
        students.put("D",67);
        students.put("E",89);
        // this will update the value , not add a object.
        students.put("D",85);

        System.out.println(students);
        System.out.println(students.get("C"));

        // Access all the keys
        System.out.println(students.keySet());
        for(String key : students.keySet()){
            System.out.print(key + " " + students.get(key));
            System.out.println();
        }


    }
}
