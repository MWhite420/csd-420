/*
Mark White
CSD420
Assignment3.2
*/

import java.util.ArrayList;
import java.util.Random;

public class NoDuplicates {

    // Generic method to remove duplicates
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> result = new ArrayList<>();
        for (E element : list) {
            if (!result.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> originalList = new ArrayList<>();
        Random rand = new Random();

        // 50 random values 
        for (int i = 0; i < 50; i++) {
            originalList.add(rand.nextInt(100) + 1);
        }

        // Print original list
        System.out.println("Original List:");
        System.out.println(originalList);

        // Remove duplicates
        ArrayList<Integer> noDuplicates = removeDuplicates(originalList);

        // Print list without duplicates
        System.out.println("\nList Without Duplicates:");
        System.out.println(noDuplicates);
    }
}
