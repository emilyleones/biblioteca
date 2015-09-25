package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;


/**
 * Created by eleones on 9/22/15.
 */
public class ApplicationTest {

    private Application application;
    private PrintStream printStream;
    private MainMenu mainMenu;


    @Before
    public void setup() {
        printStream = mock(PrintStream.class);
        mainMenu = mock(MainMenu.class);
        application = new Application(printStream, mainMenu);
        when(mainMenu.isRunning()).thenReturn(true, false);
    }

    @Test
    public void shouldPrintWelcomeWhenStarting() throws IOException {
        application.start();
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldCallListBooksWhenStarting() throws IOException {
        application.start();
        verify(mainMenu).displayOptions();
    }

    @Test
    public void shouldRunMainMenuWhenNotQuitting() throws IOException {
        when(mainMenu.isRunning()).thenReturn(true, false);
        application.start();

        verify(mainMenu).displayOptions();
    }

    @Test
    public void shouldQuitApplicationWhenMainMenuIsQuitting() throws IOException {
        when(mainMenu.isRunning()).thenReturn(false);

        application.start();

        verify(mainMenu).isRunning();
        verifyNoMoreInteractions(mainMenu);
    }



}
