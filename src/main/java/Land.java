public class Land extends Dot {
    private final int price;

    public Land(int x, int y, int price) {
        super(x, y);
        this.price = price;
    }

    public String defaultSymbol() {
        return "0";
    }
}
