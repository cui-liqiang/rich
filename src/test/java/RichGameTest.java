import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;

public class RichGameTest {
    public static final String EOF = "\26";
//    Dice mockDice = mock(Dice.class);
    RichGame richGame = new RichGame();
    OutputStream outputStream = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(outputStream);

    @Before
    public void setup() {
        System.setOut(out);
    }

    @After
    public void tearDown() {
        System.setOut(System.out);
    }

    @Test
    public void should_be_able_to_draw_map() {
        setInput(EOF);
        richGame.run();

        String map = "S0000000000000Y0000000000000Z\n" +
                "$                           0\n" +
                "$                           0\n" +
                "$                           0\n" +
                "$                           0\n" +
                "$                           0\n" +
                "$                           0\n" +
                "J0000000000000T0000000000000Z\n";

        String actualOutput = outputStream.toString();
        assertThat(actualOutput, containsString(map));
    }

    private void setInput(String inputString) {
        InputStream in = new StringBufferInputStream(inputString);
        System.setIn(in);
    }

    @Test
    public void should_be_able_to_quit() {
        setInput("quit\n");
        richGame.run();

        assertThat(outputStream.toString(), endsWith("游戏结束\n"));
    }

    @Test
    public void should_be_able_to_work_for_single_player() {
        setInput("work\n" + EOF);
        richGame.run();

        String mapWithPlayer = "S0000000000000Y0000000000000Z\n" +
                               "$                           0\n" +
                               "$                           0\n" +
                               "$                           0\n" +
                               "$                           0\n" +
                               "$                           0\n" +
                               "$                           0\n" +
                               "J0000000000000T0000000000000Z\n";
    }
}
