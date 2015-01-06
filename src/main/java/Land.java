public class Land extends Dot {
    private final int price;

    public Land(int x, int y, int price) {
        super(x, y);
        this.price = price;
    }

    @Override
    public String toString() {
        return "0";
    }
}
