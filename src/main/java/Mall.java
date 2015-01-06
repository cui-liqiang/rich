public class Mall extends Dot {
    private final int minConsume;
    private final int maxConsume;

    public Mall(int x, int y, int minConsume, int maxConsume) {
        super(x, y);
        this.minConsume = minConsume;
        this.maxConsume = maxConsume;
    }

    public String defaultSymbol() {
        return "Z";
    }
}
