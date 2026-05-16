package Linked_List;

import java.util.Arrays;
import java.util.LinkedList;

// A complete demonstration of a Singly Linked List in Java

public class linkedList {
    public static void main(String[] args) {
        // Node -> Data + Reference.
        LinkedList<Integer> lList = new LinkedList<>();
        lList.add(10);
        lList.add(20);
        lList.add(30);
        lList.get(2); // O(n)
        lList.addLast(33); // O(1)
        lList.addFirst(1); // O(1)
        lList.getFirst();
        lList.getLast();
        System.out.println(lList);
        lList.removeIf(x -> x%2==0);
        System.out.println(lList);

        LinkedList<String> animals = new LinkedList<>(Arrays.asList("Cat","Dog","Tiger","elephant"));
        LinkedList<String> animalsRemove = new LinkedList<>(Arrays.asList("Dog","Tiger"));
        animals.removeAll(animalsRemove);
        System.out.println(animals);

    }
}
