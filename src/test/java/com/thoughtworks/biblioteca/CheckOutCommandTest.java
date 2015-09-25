package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by eleones on 9/25/15.
 */
public class CheckOutCommandTest {

    @Test
    public void shouldCheckOutBookWhenUserChecksOutBook(){
        Library library = mock(Library.class);
        String userBookNumber = "1";
        PrintStream printStream = mock(PrintStream.class);
        BufferedReader reader = mock(BufferedReader.class);

        CheckOutCommand command = new CheckOutCommand(library, printStream, reader);

        command.execute();

        verify(library).checkOut(1);
    }

}