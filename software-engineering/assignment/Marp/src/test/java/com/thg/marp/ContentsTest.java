package com.thg.marp;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ContentsTest {

    @Test
    void replaceHashWithSpace() {
        String inputString = "## Heading";
        String result = Contents.replaceHashWithSpace(inputString);
        assertEquals("     Heading", result);
        }

    @Test
    void contentsGenerator() {
        ArrayList<String> headingInfo = new ArrayList<>();
        headingInfo.add("# Heading 1");
        headingInfo.add("## Heading 2");
        headingInfo.add("### Heading 3");

        // Redirect System.out.println to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Contents.contentsGenerator(headingInfo);

        // Restore normal System.out.println behavior
        System.setOut(System.out);

        String expectedOutput = "\nContents: \n   Heading 1\n     Heading 2\n       Heading 3\n";
        assertEquals(expectedOutput, outputStream.toString());


    }
}