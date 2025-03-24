/* Mark White
CSD420
Assigment1.2 */


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomCards extends Application {
    private static final String CARD_PATH = "cards/";
    private static final int NUMBER_OF_CARDS = 4;
    
    private List<ImageView> cardViews = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        Button refreshButton = new Button("Refresh Cards");
        
        // Create image views for the cards
        for (int i = 0; i < NUMBER_OF_CARDS; i++) {
            ImageView cardView = new ImageView();
            cardView.setFitWidth(100);
            cardView.setFitHeight(140);
            cardViews.add(cardView);
            root.getChildren().add(cardView);
        }
        
        // Set up the action for the refresh button
        refreshButton.setOnAction(e -> displayRandomCards());
        root.getChildren().add(refreshButton);
        
        // Setup the scene
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Random Cards Display");
        primaryStage.show();
        
        // Initial card display
        displayRandomCards();
    }

    private void displayRandomCards() {
        // Shuffle and select four unique cards
        List<Integer> cardNumbers = new ArrayList<>();
        for (int i = 1; i <= 52; i++) {
            cardNumbers.add(i);
        }
        Collections.shuffle(cardNumbers);
        
        for (int i = 0; i < NUMBER_OF_CARDS; i++) {
            int cardNumber = cardNumbers.get(i);
            String filePath = CARD_PATH + cardNumber + ".png";
            cardViews.get(i).setImage(new Image(new File(filePath).toURI().toString()));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
