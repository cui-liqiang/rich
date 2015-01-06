public class Dot {
    private final int x;
    private final int y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void fillMap(String[][] map) {
        map[x][y] = this.toString();
    }
}
