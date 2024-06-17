package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class PartiesApplication extends Application {

    @Override
    public void start(Stage stage) {
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");

        try (Scanner fileReader = new Scanner(Paths.get("partiesdata.tsv"))) {
            String[] years = fileReader.nextLine().split("\t");

            while (fileReader.hasNextLine()) {
                String[] parts = fileReader.nextLine().split("\t");
                String partyName = parts[0];
                XYChart.Series<Number, Number> series = new XYChart.Series<>();
                series.setName(partyName);

                for (int i = 1; i < parts.length; i++) {
                    if (!parts[i].equals("-")) {
                        double support = Double.parseDouble(parts[i]);
                        int year = Integer.parseInt(years[i]);
                        series.getData().add(new XYChart.Data<>(year, support));
                    }
                }

                lineChart.getData().add(series);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();
    }

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }
}
