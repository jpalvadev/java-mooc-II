import java.util.ArrayList;

public class OneItemBox extends Box {
    private int capacity;
    private ArrayList<Item> items;

    public OneItemBox() {
        this.capacity = 0;
        this.items = new ArrayList<>();
    }

    public void add(Item newItem) {
        if (this.items.isEmpty()) {
            this.items.add(newItem);
            this.capacity = newItem.getWeight();
        }
    }

    public boolean isInBox(Item item) {
        return this.items.contains(item);
    }
}
