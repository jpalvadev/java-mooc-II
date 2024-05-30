public class ProductWarehouseWithHistory extends ProductWarehouse {

    private ChangeHistory balanceHistory;

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        this.balanceHistory = new ChangeHistory();
        this.addToWarehouse(initialBalance);
    }

    public String history() {
        return this.balanceHistory.toString();
    }

    public void addToWarehouse(double amount) {
        super.addToWarehouse(amount);
        this.balanceHistory.add(super.getBalance());
    }

    public double takeFromWarehouse(double amount) {
        double amountTaken = super.takeFromWarehouse(amount);
        this.balanceHistory.add(super.getBalance());
        return amountTaken;
    }

    public void printAnalysis() {
        System.out.println("Product: " + this.getName() + "\nHistory: " + history() + "\nLargest amount of product: "
                + this.balanceHistory.maxValue() + "\nSmallest amount of product: " + this.balanceHistory.minValue()
                + "\nAverage: " + this.balanceHistory.average());

    }

}
