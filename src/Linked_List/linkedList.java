package Linked_List;

import java.util.Arrays;
import java.util.LinkedList;

// A complete demonstration of a Singly Linked List in Java

public class linkedList {
    public static void main(String[] args) {
        // Node -> Data + Reference.
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.get(2); // O(n)
        list.addLast(33); // O(1)
        list.addFirst(1); // O(1)
        list.getFirst();
        list.getLast();
        System.out.println(list);
        list.removeIf(x -> x%2==0);
        System.out.println(list);

        LinkedList<String> animals = new LinkedList<>(Arrays.asList("Cat","Dog","Tiger","elephant"));
        LinkedList<String> animalsRemove = new LinkedList<>(Arrays.asList("Dog","Tiger"));
        animals.removeAll(animalsRemove);
        System.out.println(animals);

    }
}
