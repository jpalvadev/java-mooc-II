package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CreateView {

    private final Dictionary dictionary;

    public CreateView(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public Parent getView() {
        GridPane layout = new GridPane();

        Label wordLabel = new Label("Word");
        TextField wordInput = new TextField();
        Label translationLabel = new Label("Translation");
        TextField translationInput = new TextField();

        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        Button addToDictBtn = new Button("Add the word pair");

        layout.add(wordLabel, 0, 0);
        layout.add(wordInput, 0, 1);
        layout.add(translationLabel, 0, 2);
        layout.add(translationInput, 0, 3);
        layout.add(addToDictBtn, 0, 4);

        addToDictBtn.setOnAction((event) -> {
            String word = wordInput.getText();
            String translation = translationInput.getText();

            dictionary.add(word, translation);

            wordInput.clear();
            translationInput.clear();
        });

        return layout;
    }
}