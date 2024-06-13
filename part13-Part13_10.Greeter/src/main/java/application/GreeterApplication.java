package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GreeterApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox inputLayout = new VBox(10);
        inputLayout.setPadding(new Insets(20, 20, 20, 20));
        inputLayout.setAlignment(Pos.CENTER);

        Label instructionLabel = new Label("Enter your name and start.");
        TextField nameInput = new TextField();
        Button startButton = new Button("Start");

        inputLayout.getChildren().addAll(instructionLabel, nameInput, startButton);

        StackPane welcomeLayout = new StackPane();
        Label welcomeLabel = new Label();
        welcomeLayout.getChildren().add(welcomeLabel);
        welcomeLayout.setPadding(new Insets(20, 20, 20, 20));
        welcomeLayout.setAlignment(Pos.CENTER);

        Scene inputScene = new Scene(inputLayout, 300, 200);
        Scene welcomeScene = new Scene(welcomeLayout, 300, 200);

        startButton.setOnAction(e -> {
            welcomeLabel.setText("Welcome " + nameInput.getText() + "!");
            primaryStage.setScene(welcomeScene);
        });

        primaryStage.setScene(inputScene);
        primaryStage.setTitle("Greeter Application");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }
}