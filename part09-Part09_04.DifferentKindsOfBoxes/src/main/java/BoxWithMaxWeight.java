import java.util.ArrayList;

public class BoxWithMaxWeight extends Box {
    private final int capacity;
    private ArrayList<Item> items;

    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();

    }

    public void add(Item newItem) {
        int totalWeight = 0;
        for (Item currItem : items) {
            totalWeight = totalWeight + currItem.getWeight();
            if (totalWeight >= this.capacity && newItem.getWeight() > 0) {
                return;
            }
        }
        items.add(newItem);
    }

    public boolean isInBox(Item item) {
        return this.items.contains(item);
    }
}
