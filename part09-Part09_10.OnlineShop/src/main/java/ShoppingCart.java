import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String, Item> cart;

    public ShoppingCart() {
        this.cart = new HashMap<>();
    }

    public void add(String product, int price) {
        Item cartProduct = this.cart.get(product);
        if (cartProduct == null) {
            this.cart.put(product, new Item(product, 1, price));
        } else {
            this.cart.get(product).increaseQuantity();
        }
    }

    public int price() {
        int totalPrice = 0;
        for (Item currItem : this.cart.values()) {
            totalPrice = totalPrice + currItem.price();
        }
        return totalPrice;
    }

    public void print() {
        for (String currProduct : this.cart.keySet()) {
            System.out.println(currProduct + ": " + this.cart.get(currProduct).getQuantity());
        }
    }
}
