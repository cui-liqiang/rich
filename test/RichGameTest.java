import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

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
    public void should_be_able_to_show_map() {
        richGame.run();
        assertEquals("S0000000000000Y0000000000000Z\n" +
                "$                           0\n" +
                "$                           0\n" +
                "$                           0\n" +
                "$                           0\n" +
                "$                           0\n" +
                "$                           0\n" +
                "J0000000000000T0000000000000Z\n", outputStream.toString());
    }
}
