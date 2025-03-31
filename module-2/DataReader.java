import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {
    public static void main(String[] args) {
        String filename = "MarkWhite_datafile.dat"; 
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("Data in the file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}