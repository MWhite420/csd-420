/*
Mark White
CSD420
Assignment4
*/


import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTraversal {
    public static void main(String[] args) {
        testLinkedListPerformance(50000);
        System.out.println("");
        testLinkedListPerformance(500000);
    }

    public static void testLinkedListPerformance(int size) {
        // Create and populate LinkedList
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        System.out.println("Testing with " + size + " elements: ");
        

        // Test Iterator
        long startTime = System.nanoTime();
        int sumIterator = 0;
        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            sumIterator += iterator.next();
        }
        long endTime = System.nanoTime();
        long iteratorTime = (endTime - startTime) / 1_000_000; // Convert to milliseconds

        // Test get(index)
        startTime = System.nanoTime();
        int sumGetIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            sumGetIndex += list.get(i);
        }
        endTime = System.nanoTime();
        long getIndexTime = (endTime - startTime) / 1_000_000; // Convert to milliseconds

        // Print results
        System.out.println("Iterator traversal time: " + iteratorTime + " ms");
        System.out.println("get(index) traversal time: " + getIndexTime + " ms");
        
        }
        
        
    }
