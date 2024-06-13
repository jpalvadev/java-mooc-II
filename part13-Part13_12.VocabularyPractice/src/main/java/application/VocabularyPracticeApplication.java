package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class VocabularyPracticeApplication extends Application {

    private Dictionary dictionary;

    @Override
    public void init() throws Exception {
        this.dictionary = new Dictionary();
    }

    @Override
    public void start(Stage window) {

        BorderPane layout = new BorderPane();

        PracticeView practiceView = new PracticeView(dictionary);
        CreateView createView = new CreateView(this.dictionary);

        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);

        Button createBtn = new Button("Enter new words");
        Button practiceBtn = new Button("Practice");

        menu.getChildren().addAll(createBtn, practiceBtn);
        layout.setTop(menu);

        createBtn.setOnAction(e -> {
            layout.setCenter(createView.getView());
        });
        practiceBtn.setOnAction(e -> layout.setCenter(practiceView.getView()));

        layout.setCenter(createView.getView());

        Scene scene = new Scene(layout, 640, 480);
        window.setScene(scene);
        window.setTitle("Vocabulary Practice Application");
        window.show();
    }

    public static void main(String[] args) {
        launch(VocabularyPracticeApplication.class);
    }
}