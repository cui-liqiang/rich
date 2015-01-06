package com.thoughtworks.rich;

import com.thoughtworks.rich.io.IO;
import org.junit.After;
import org.junit.Before;

import java.io.*;

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

    protected void setInput(String inputString) {
        InputStream in = new StringBufferInputStream(inputString);
        System.setIn(in);
    }
}