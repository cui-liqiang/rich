import java.util.Scanner;

public class RichGame {
    public static final String QUIT_COMMAND = "quit";
    private Dice dice;
    private RichMap richMap = new RichMap();

    public RichGame(Dice dice) {
        this.dice = dice;
    }

    public void run() {
        System.out.println(richMap.mapString());
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            if(QUIT_COMMAND.equals(scanner.next())) {
                System.out.println("游戏结束");
                break;
            }
        }
    }
}
