/*
 Mark White 
 CSD420
 Assignment6.2
 */
 

 import java.util.Comparator;

 public class BubbleSort {
 
     // Bubble sort using Comparable interface
     public static <E extends Comparable<E>> void bubbleSort(E[] list) {
         for (int i = 0; i < list.length - 1; i++) {
             for (int j = 0; j < list.length - 1 - i; j++) {
                 if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                     list[j] = list[j + 1];
                     list[j + 1] = temp;
                 }
             }
         }
     }
 
     // Bubble sort using Comparator interface
     public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
         for (int i = 0; i < list.length - 1; i++) {
             for (int j = 0; j < list.length - 1 - i; j++) {
                 if (comparator.compare(list[j], list[j + 1]) > 0) {
                     E temp = list[j];
                     list[j] = list[j + 1];
                     list[j + 1] = temp;
                 }
             }
         }
     }
 
     // Helper method to print arrays
     public static <E> void printArray(E[] array) {
         for (E element : array) {
             System.out.print(element + " ");
         }
         System.out.println();
     }
 
     // Main method to test both sorts using the same integer array
     public static void main(String[] args) {
         Integer[] originalArray = {5, 2, 9, 1, 3, 7, 4, 8, 6, 0};
 
         // Using Comparable
         Integer[] arrayForComparable = originalArray.clone();
         System.out.println("Before sorting:");
         printArray(arrayForComparable);
         bubbleSort(arrayForComparable);
         System.out.println("After sorting (Comparable):");
         printArray(arrayForComparable);
 
         // Using Comparator
         Integer[] arrayForComparator = originalArray.clone();
         System.out.println("\nBefore sorting:");
         printArray(arrayForComparator);
         bubbleSort(arrayForComparator, Comparator.naturalOrder());
         System.out.println("After sorting (Comparator):");
         printArray(arrayForComparator);
     }
 }
 