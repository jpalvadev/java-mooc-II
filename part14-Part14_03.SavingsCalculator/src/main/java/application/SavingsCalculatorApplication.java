package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Slider;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

    @Override
    public void start(Stage stage) {
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings Calculator");

        Slider savingsSlider = new Slider(25, 250, 25);
        savingsSlider.setShowTickMarks(true);
        savingsSlider.setShowTickLabels(true);
        savingsSlider.setMajorTickUnit(25);
        savingsSlider.setMinorTickCount(3);
        savingsSlider.setSnapToTicks(true);
        Label savingsLabel = new Label("25.0");

        Slider interestSlider = new Slider(0, 10, 0);
        interestSlider.setShowTickMarks(true);
        interestSlider.setShowTickLabels(true);
        interestSlider.setMinorTickCount(4);
        Label interestLabel = new Label("0");

        BorderPane monthlySavingsPane = new BorderPane();
        monthlySavingsPane.setLeft(new Label("Monthly savings"));
        monthlySavingsPane.setCenter(savingsSlider);
        monthlySavingsPane.setRight(savingsLabel);

        BorderPane interestRatePane = new BorderPane();
        interestRatePane.setLeft(new Label("Yearly interest rate"));
        interestRatePane.setCenter(interestSlider);
        interestRatePane.setRight(interestLabel);

        VBox controls = new VBox(10, monthlySavingsPane, interestRatePane);
        controls.setPadding(new Insets(10));

        BorderPane mainLayout = new BorderPane();
        mainLayout.setPrefSize(500, 400);
        mainLayout.setTop(controls);
        mainLayout.setCenter(lineChart);

        savingsSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            savingsLabel.setText(String.format("%.0f", newValue));
            updateChart(lineChart, newValue.doubleValue(), interestSlider.getValue());
        });

        interestSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            interestLabel.setText(String.format("%.1f", newValue));
            updateChart(lineChart, savingsSlider.getValue(), newValue.doubleValue());
        });

        Scene scene = new Scene(mainLayout);
        stage.setScene(scene);
        stage.setTitle("Savings Calculator");
        stage.show();
    }

    private void updateChart(LineChart<Number, Number> lineChart, double monthlySavings, double yearlyInterestRate) {
        lineChart.getData().clear();

        XYChart.Series<Number, Number> savingsSeries = new XYChart.Series<>();
        savingsSeries.setName("Savings without interest");

        XYChart.Series<Number, Number> interestSeries = new XYChart.Series<>();
        interestSeries.setName("Savings with interest");

        double totalSavingsWithoutInterest = 0;
        double totalSavingsWithInterest = 0;

        for (int year = 0; year <= 30; year++) {
            savingsSeries.getData().add(new XYChart.Data<>(year, totalSavingsWithoutInterest));
            interestSeries.getData().add(new XYChart.Data<>(year, totalSavingsWithInterest));

            totalSavingsWithoutInterest += monthlySavings * 12;
            totalSavingsWithInterest += monthlySavings * 12;
            totalSavingsWithInterest += totalSavingsWithInterest * (yearlyInterestRate / 100);
        }

        lineChart.getData().add(savingsSeries);
        lineChart.getData().add(interestSeries);
    }

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }
}
