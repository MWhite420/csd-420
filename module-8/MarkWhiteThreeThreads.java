/*
 Mark White
 CSD420
 Assignment8.2
 */


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Random;

public class MarkWhiteThreeThreads extends Application {

    private static final int COUNT = 10000; // Number of outputs per thread
    private TextArea textArea = new TextArea();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        textArea.setWrapText(true);

        VBox root = new VBox(textArea);
        Scene scene = new Scene(root, 600, 400);

        primaryStage.setTitle("Three Threads Output");
        primaryStage.setScene(scene);
        primaryStage.show();

        startThreadsInOrder();
    }

    private void startThreadsInOrder() {
        Thread thread1 = new Thread(new RandomLetterGenerator(), "Thread 1");
        Thread thread2 = new Thread(new RandomNumberGenerator(), "Thread 2");
        Thread thread3 = new Thread(new RandomSymbolGenerator(), "Thread 3");

        thread1.start();
        try {
            thread1.join(); // Wait for thread1
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start();
        try {
            thread2.join(); // Wait for thread2
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread3.start();
        try {
            thread3.join(); // Wait for thread3
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class RandomLetterGenerator implements Runnable {
        private Random random = new Random();

        @Override
        public void run() {
            appendText(Thread.currentThread().getName() + ":\n");
            for (int i = 0; i < COUNT; i++) {
                char letter = (char) (random.nextInt(26) + 'a'); // random letter
                appendText(letter + "");
            }
            appendText("\n\n"); 
        }
    }

    class RandomNumberGenerator implements Runnable {
        private Random random = new Random();

        @Override
        public void run() {
            appendText(Thread.currentThread().getName() + ":\n");
            for (int i = 0; i < COUNT; i++) {
                char number = (char) (random.nextInt(10) + '0'); // random digit
                appendText(number + "");
            }
            appendText("\n\n"); 
        }
    }

    class RandomSymbolGenerator implements Runnable {
        private final char[] symbols = {'!', '@', '#', '$', '%', '&', '*'};

        private Random random = new Random();

        @Override
        public void run() {
            appendText(Thread.currentThread().getName() + ":\n");
            for (int i = 0; i < COUNT; i++) {
                char symbol = symbols[random.nextInt(symbols.length)];
                appendText(symbol + "");
            }
            appendText("\n\n"); 
        }
    }

    private void appendText(String text) {
        javafx.application.Platform.runLater(() -> textArea.appendText(text));
    }
}

