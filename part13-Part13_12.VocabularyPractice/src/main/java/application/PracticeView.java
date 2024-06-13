package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PracticeView {

    private final Dictionary dictionary;
    private String word;

    public PracticeView(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.word = dictionary.getRandomWord();
    }

    public Parent getView() {
        GridPane layout = new GridPane();

        Label wordLabel = new Label("Translate the word '" + this.word + "'");
        TextField translationInput = new TextField();

        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        Button addBtn = new Button("Check");

        Label feedback = new Label("");

        layout.add(wordLabel, 0, 0);
        layout.add(translationInput, 0, 1);
        layout.add(addBtn, 0, 2);
        layout.add(feedback, 0, 3);

        addBtn.setOnAction(e -> {
            String translation = translationInput.getText();
            if (dictionary.get(word).equals(translation)) {
                feedback.setText("Correct!");
            } else {
                feedback.setText(
                        "Incorrect! The translation for the word '" + word + "' is " + dictionary.get(word) + ".");
                return;
            }

            this.setRandomWord();
            wordLabel.setText("Translate the word '" + this.word + "'");
            translationInput.clear();
        });

        return layout;
    }

    public void setRandomWord() {
        this.word = this.dictionary.getRandomWord();
    }
}