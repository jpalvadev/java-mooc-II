package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane mainLayout = new BorderPane();

        HBox menu = createMenu();

        mainLayout.setTop(menu);

        StackPane jokeView = createView("What do you call a bear with no teeth?");
        StackPane answerView = createView("A gummy bear.");
        StackPane explanationView = createView(
                "It's funny because a toothless bear would have only gums, making it a gummy bear.");

        configureMenuActions(menu, mainLayout, jokeView, answerView, explanationView);

        mainLayout.setCenter(jokeView);

        Scene mainScene = new Scene(mainLayout);

        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Joke Application");
        primaryStage.show();
    }

    private HBox createMenu() {
        HBox menu = new HBox(10);
        menu.setPadding(new Insets(20));
        menu.setAlignment(Pos.CENTER);

        Button jokeButton = new Button("Joke");
        Button answerButton = new Button("Answer");
        Button explanationButton = new Button("Explanation");

        menu.getChildren().addAll(jokeButton, answerButton, explanationButton);

        return menu;
    }

    private StackPane createView(String text) {
        Label textLabel = new Label(text);
        textLabel.setWrapText(true);
        StackPane viewLayout = new StackPane();
        viewLayout.setPrefSize(320, 240);
        viewLayout.getChildren().add(textLabel);
        viewLayout.setAlignment(Pos.CENTER);
        return viewLayout;
    }

    private void configureMenuActions(HBox menu, BorderPane mainLayout, StackPane jokeView, StackPane answerView,
            StackPane explanationView) {
        Button jokeButton = (Button) menu.getChildren().get(0);
        Button answerButton = (Button) menu.getChildren().get(1);
        Button explanationButton = (Button) menu.getChildren().get(2);

        jokeButton.setOnAction(e -> mainLayout.setCenter(jokeView));
        answerButton.setOnAction(e -> mainLayout.setCenter(answerView));
        explanationButton.setOnAction(e -> mainLayout.setCenter(explanationView));
    }

    public static void main(String[] args) {
        launch(JokeApplication.class);
    }
}