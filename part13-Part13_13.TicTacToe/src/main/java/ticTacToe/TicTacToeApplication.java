import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.text.Font;

public class TicTacToeApplication extends Application {

    private boolean xTurn = true;
    private Button[][] buttons = new Button[3][3];
    private Label infoLabel = new Label("Turn: X");

    private final int[][] winConditions = {
            { 0, 1, 2 },
            { 3, 4, 5 },
            { 6, 7, 8 },
            { 0, 3, 6 },
            { 1, 4, 7 },
            { 2, 5, 8 },
            { 0, 4, 8 },
            { 2, 4, 6 }
    };

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

    @Override
    public void start(Stage stage) {
        BorderPane layout = new BorderPane();
        layout.setTop(infoLabel);

        GridPane grid = new GridPane();

        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button button = new Button(" ");
                button.setMinSize(100, 100);
                button.setFont(Font.font("Monospaced", 40));
                int finalRow = row;
                int finalCol = col;
                button.setOnAction(e -> handleButtonClick(button, finalRow, finalCol));
                buttons[row][col] = button;
                grid.add(button, col, row);
            }
        }

        infoLabel.setFont(Font.font("Monospaced", 40));
        infoLabel.setPadding(new Insets(10, 10, 0, 10));

        layout.setCenter(grid);

        Scene scene = new Scene(layout, 340, 400);
        stage.setScene(scene);
        stage.show();
    }

    private void handleButtonClick(Button button, int row, int col) {
        if (!button.getText().equals(" ") || infoLabel.getText().equals("The end!")) {
            return;
        }

        if (xTurn) {
            button.setText("X");
            infoLabel.setText("Turn: O");
        } else {
            button.setText("O");
            infoLabel.setText("Turn: X");
        }

        xTurn = !xTurn;

        if (checkWinner()) {
            infoLabel.setText("The end!");
        }
    }

    private boolean checkWinner() {
        String[] board = new String[9];
        int index = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[index++] = buttons[row][col].getText();
            }
        }

        for (int[] condition : winConditions) {
            if (board[condition[0]].equals(board[condition[1]]) &&
                    board[condition[0]].equals(board[condition[2]]) &&
                    !board[condition[0]].equals(" ")) {
                return true;
            }
        }

        return false;
    }
}