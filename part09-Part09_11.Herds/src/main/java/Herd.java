import java.util.ArrayList;

public class Herd implements Movable {

    private ArrayList<Movable> herd;

    public Herd() {
        this.herd = new ArrayList<>();
    }

    public void addToHerd(Movable movable) {
        this.herd.add(movable);
    }

    public String toString() {
        String response = "";
        for (Movable currMovable : this.herd) {
            response += currMovable + "\n";
        }
        return response;
    }

    public void move(int dx, int dy) {
        for (Movable currMovable : this.herd) {
            currMovable.move(dx, dy);
        }
    }
}
