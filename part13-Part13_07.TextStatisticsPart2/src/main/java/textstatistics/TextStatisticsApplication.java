package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();

        TextArea textArea = new TextArea("");

        layout.setCenter(textArea);

        HBox texts = new HBox();
        Label lettersLabel = new Label("Letters: 0");
        Label wordsLabel = new Label("Words: 0");
        Label longestLabel = new Label("The longest word is:");

        texts.setSpacing(10);
        texts.getChildren().addAll(lettersLabel, wordsLabel, longestLabel);

        textArea.textProperty().addListener((change, oldValue, newValue) -> {
            int lettersAmount = newValue.length();
            lettersLabel.setText("Letters: " + lettersAmount);

            String[] parts = newValue.split(" ");

            int wordsAmount = parts.length;
            wordsLabel.setText("Words: " + wordsAmount);

            String longestWord = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
            longestLabel.setText("The longest word is: " + longestWord);
        });

        layout.setBottom(texts);

        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

}
