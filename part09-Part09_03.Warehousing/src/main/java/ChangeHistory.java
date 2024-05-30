import java.util.ArrayList;
import java.util.Collections;

public class ChangeHistory {
    private ArrayList<Double> changeHistory;

    public ChangeHistory() {
        this.changeHistory = new ArrayList<>();
    }

    public void add(double status) {
        this.changeHistory.add(status);
    }

    public void clear() {
        this.changeHistory.clear();
    }

    public String toString() {
        return this.changeHistory.toString();
    }

    public double maxValue() {
        return Collections.max(changeHistory);
    }

    public double minValue() {
        return Collections.min(changeHistory);
    }

    public double average() {
        if (this.changeHistory.isEmpty()) {
            return 0.0;
        }

        double total = 0;

        for (double number : this.changeHistory) {
            total += number;
        }

        return total / this.changeHistory.size();
    }
}
