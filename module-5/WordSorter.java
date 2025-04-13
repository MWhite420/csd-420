/*
Mark White
CSD420
Assignment 5.2
*/

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class WordSorter {

    public static void main(String[] args) {
        String filename = "collection_of_words.txt";
        
        // Read words from file
        List<String> words = readWordsFromFile(filename);

        // TreeSet to remove duplicates and sort words
        Set<String> FruitSet = new TreeSet<>(words);  // Ascending order
        List<String> FruitWords = new ArrayList<>(FruitSet);

        System.out.println("Original Words: " + words);
        

        // Ascending order
        System.out.println("\nWords in Ascending Order:");
        for (String word : FruitWords) {
            System.out.println(word);
        }

        // Descending order
        System.out.println("\nWords in Descending Order:");
        List<String> descending = new ArrayList<>(FruitWords);
        Collections.reverse(descending);
        for (String word : descending) {
            System.out.println(word);
        }
    }


    // Method to read words from file
    private static List<String> readWordsFromFile(String filename) {
        List<String> words = new ArrayList<>();
        try {
            String content = new String(Files.readAllBytes(Paths.get(filename)));
            String[] splitWords = content.split("\\s+");
            words = Arrays.asList(splitWords);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return words;
    }
}
