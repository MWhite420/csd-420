/*
 Mark White 
CSD420
Assignment6.2
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create four circles
        Circle circle1 = new Circle(50);
        circle1.getStyleClass().add("plaincircle");

        Circle circle2 = new Circle(50);
        circle2.setId("redcircle");

        Circle circle3 = new Circle(50);
        circle3.setId("greencircle");

        Circle circle4 = new Circle(50);
        circle4.getStyleClass().add("plaincircle");

        // Add circles 
        HBox pane = new HBox(20); // spacing between circles
        pane.getChildren().addAll(circle1, circle2, circle3, circle4);

        //  apply CSS
        Scene scene = new Scene(pane, 400, 150);
        scene.getStylesheets().add("mystyle.css");

        // Set stage
        primaryStage.setTitle("Circle Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
