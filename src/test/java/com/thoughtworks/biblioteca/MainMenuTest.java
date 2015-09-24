package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

/**
 * Created by eleones on 9/23/15.
 */
public class MainMenuTest {
    private PrintStream printStream;
    private Library library;
    private MainMenu menu;
    private BufferedReader reader;

    @Before
    public void setup() {
        printStream = mock(PrintStream.class);
        library = mock(Library.class);
        reader = mock(BufferedReader.class);
        menu = new MainMenu(library, printStream, reader);
    }
    @Test
    public void shouldDisplayOptionsWhenStarts() throws IOException {
        when(reader.readLine()).thenReturn("0","Q");

        menu.displayOptions();

        verify(printStream).println("Menu:\n" +
                "1 - List Books\n" +
                "Q - Quit");
    }

    @Test
    public void shouldReadInputWhenDisplayingOptions() throws IOException {
        when(reader.readLine()).thenReturn("Q");

        menu.displayOptions();

        verify(reader).readLine();

    }

    @Test
    public void shouldListBooksWhenOptionIsOne() throws IOException {
        when(reader.readLine()).thenReturn("1","Q");

        menu.displayOptions();

        verify(library).listBooks();
    }


    @Test
    public void shouldNotListBooksWhenOptionIsInvalid() throws IOException {
        when(reader.readLine()).thenReturn("0","Q");

        menu.displayOptions();

        verifyZeroInteractions(library);
    }

    @Test
    public void shouldGiveErrorMessageWhenOptionIsInvalid() throws IOException {
        when(reader.readLine()).thenReturn("afd","Q");

        menu.displayOptions();

        verify(printStream).println("Invalid option!");
    }

    @Test
    public void shouldQuitWhenQuitOptionSelected() throws IOException {
        when(reader.readLine()).thenReturn("Q");

        menu.displayOptions();

        verify(printStream).println("Application has ended.");
    }

    @Test
    public void shouldContinueToAcceptInputWhenQuitHasNotBeenSelected () throws IOException{
        when(reader.readLine()).thenReturn("0","1","Q");

        menu.displayOptions();

        verify(printStream).println("Application has ended.");
    }
}