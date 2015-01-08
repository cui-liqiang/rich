package com.thoughtworks.rich;

import com.thoughtworks.rich.io.IO;
import org.junit.After;
import org.junit.Before;

import java.io.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class IOTestBase {
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
        IO.reset();
    }

    protected void setInputWithDefaultRoles(String inputString) {
        String roles = "A";
        setInputWithRoles(roles, inputString);
    }

    protected void setInputWithRoles(String roles, String inputString) {
        InputStream in = new StringBufferInputStream(roles +"\n" + inputString);
        System.setIn(in);
    }

    protected void setInput(String inputString) {
        InputStream in = new StringBufferInputStream(inputString);
        System.setIn(in);
    }

    protected void assertOutputContains(String... expectedOutputs) {
        String actual = outputStream.toString();
        for (String expectedOutput : expectedOutputs) {
            assertThat(actual, containsString(expectedOutput));
        }

    }
}
