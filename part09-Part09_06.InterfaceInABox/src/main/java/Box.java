import java.util.ArrayList;

public class Box implements Packable {
    private double maximumCapacity;
    private ArrayList<Packable> items;

    public Box(double maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.items = new ArrayList<>();
    }

    public void add(Packable newItem) {
        double totalWeight = this.weight();
        if (totalWeight + newItem.weight() <= this.maximumCapacity) {
            items.add(newItem);
        }
    }

    public double weight() {
        double totalWeight = 0;
        for (Packable item : items) {
            totalWeight = totalWeight + item.weight();
        }
        return totalWeight;
    }

    public String toString() {
        return this.getClass().getSimpleName() + ": " + this.items.size() + " items, total weight " + this.weight()
                + " kg";
    }

}
