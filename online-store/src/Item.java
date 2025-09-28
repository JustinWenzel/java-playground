public class Item {
    private String product;
    private int qty;
    private int unitPrice;

    public Item(String product, int qty, int unitPrice) {
        this.product = product;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    // total price for this item (unitPrice * qty)
    public int getPrice() {
        return this.unitPrice * this.qty;
    }

    // standard getters / setters
    public String getProduct() {
        return this.product;
    }

    public int getQty() {
        return this.qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getUnitPrice() {
        return this.unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void increaseQuantity() {
        this.qty++;
    }

    @Override
    public String toString() {
        return this.product + ": " + this.qty;
    }
}
