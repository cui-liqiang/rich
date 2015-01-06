import java.util.Scanner;

public class RichGame {
    public void run() {
        showMap();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            if("quit".equals(scanner.next())) {
                System.out.println("游戏结束");
                break;
            }
        }
    }

    private void showMap() {
        System.out.println("S0000000000000Y0000000000000Z\n" +
                            "$                           0\n" +
                            "$                           0\n" +
                            "$                           0\n" +
                            "$                           0\n" +
                            "$                           0\n" +
                            "$                           0\n" +
                            "J0000000000000T0000000000000Z");
    }
}
