package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Created by eleones on 9/23/15.
 */
public class MainMenuTest {
    private PrintStream printStream;
    private MainMenu menu;
    private BufferedReader reader;
    private Options options;

    @Before
    public void setup() {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        options = mock(Options.class);
        menu = new MainMenu(printStream, reader, options);
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
        when(options.notQuitting("")).thenReturn(true);

        menu.displayOptions();

        verify(reader).readLine();

    }

    @Test
    public void shouldCallOptionWhenOptionIsInputted() throws IOException {
        when(options.notQuitting("")).thenReturn(true);
        when(reader.readLine()).thenReturn("1","Q");
        menu.displayOptions();
        verify(options).runSelection("1");
    }

    @Test
    public void shouldReturnTrueWhenNotQuitting(){

        assertTrue(menu.isNotQuitting());
    }

    @Test
    public void shouldReturnFalseWhenQuitting(){

        assertFalse(menu.isNotQuitting());
    }
}