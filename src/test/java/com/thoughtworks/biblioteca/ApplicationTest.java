package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


/**
 * Created by eleones on 9/22/15.
 */
public class ApplicationTest {

    private Application application;
    private PrintStream printStream;
    private Library library;


    @Before
    public void setup() {
        printStream = mock(PrintStream.class);
        library = mock(Library.class);
        application = new Application(printStream, library);
    }

    @Test
    public void shouldPrintWelcomeWhenStarting() {
        application.start();
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldCallListBooksWhenStarting(){
        application.start();
        verify(library).listBooks();
    }

    @Test
    public void shouldPrintMenuOptionsWhenStarting(){
        application.start();
        verify(printStream).println(contains("These are the menu options:\n1 - List Books"));
    }

}