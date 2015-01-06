import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.MatcherAssert.assertThat;

public class RichGameTest {
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
        String inputString = "\26";
        InputStream in = new StringBufferInputStream(inputString);
        System.setIn(in);
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

    @Test
    public void should_be_able_to_quit() {
        String inputString = "quit\n";
        InputStream in = new StringBufferInputStream(inputString);
        System.setIn(in);
        richGame.run();

        assertThat(outputStream.toString(), endsWith("游戏结束\n"));
    }
}
