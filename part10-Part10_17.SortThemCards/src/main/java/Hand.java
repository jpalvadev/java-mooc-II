import java.util.ArrayList;
import java.util.Collections;

public class Hand implements Comparable<Hand> {

    private ArrayList<Card> hand;

    public Hand() {
        this.hand = new ArrayList<>();
    }

    public void add(Card card) {
        this.hand.add(card);
    }

    public void print() {
        this.hand.stream().forEach(System.out::println);
    }

    public void sort() {
        Collections.sort(hand);
    }

    public int compareTo(Hand other) {
        int thisValue = this.hand.stream()
                .map(card -> card.getValue())
                .reduce(0, (total, current) -> total + current);

        int otherValue = other.hand.stream()
                .map(card -> card.getValue())
                .reduce(0, (total, current) -> total + current);

        return thisValue - otherValue;
    }

    public void sortBySuit() {
        Collections.sort(this.hand, new BySuitInValueOrder());
    }
}
