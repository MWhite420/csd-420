import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DataWriter {
    public static void main(String[] args) {
        String filename = "MarkWhite_datafile.dat"; // Replace 'yourname' with your actual name.
        Random random = new Random();
        
        try (FileWriter writer = new FileWriter(filename, true)) {
            // Generating and writing random integers
	    writer.write("Random Integers: \n");	
	    
            for (int i = 0; i < 5; i++) {
                int randomInt = random.nextInt(100); // Random integers between 0 and 99
                writer.write(randomInt + System.lineSeparator());
            }
            
            // Generating and writing random doubles
            writer.write("Random Doubles: \n");	
	    
            for (int i = 0; i < 5; i++) {
                double randomDouble = random.nextDouble() * 100; // Random doubles between 0.0 and 99.0
                writer.write(randomDouble + System.lineSeparator());
            }
            
            System.out.println("Data written to " + filename);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}