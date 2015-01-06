import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RichGameTest {
    public static final String EOF = "\26";
    Dice mockDice = mock(Dice.class);
    RichGame richGame = new RichGame(mockDice);
    OutputStream outputStream = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(outputStream);

    InputStream originalIn = System.in;
    PrintStream originalOut = System.out;

    @Before
    public void setup() {
        System.setOut(out);
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
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

    @Ignore
    @Test
    public void should_be_able_to_work_for_single_player_named_A() {
        setInput("work\n" + EOF);
        when(mockDice.roll()).thenReturn(4);
        richGame.run();

        String mapWithPlayer = "S000A000000000Y0000000000000Z\n" +
                               "$                           0\n" +
                               "$                           0\n" +
                               "$                           0\n" +
                               "$                           0\n" +
                               "$                           0\n" +
                               "$                           0\n" +
                               "J0000000000000T0000000000000Z\n";
        assertThat(outputStream.toString(), containsString(mapWithPlayer));
    }
}
