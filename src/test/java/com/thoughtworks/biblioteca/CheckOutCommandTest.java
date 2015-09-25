package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by eleones on 9/25/15.
 */
public class CheckOutCommandTest {

    private Library library;
    private PrintStream printStream;
    private BufferedReader reader;
    private CheckOutCommand command;

    @Before
    public void setUp() {
        library = mock(Library.class);
        String userBookNumber = "1";
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        command = new CheckOutCommand(library, printStream, reader);
    }

    @Test
    public void shouldCheckOutBookWhenUserChecksOutBook() throws IOException {
        when(reader.readLine()).thenReturn("1");
        command.execute();

        verify(library).checkOut(1);
    }

}