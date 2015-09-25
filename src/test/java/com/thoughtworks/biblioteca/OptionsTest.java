package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Created by eleones on 9/24/15.
 */
public class OptionsTest {

    private Library library;
    private Options options;
    private PrintStream printStream;
    private Map<String, Command> commandMap;
    private ShowBooksCommand showBooksMock;
    private QuitCommand quitMock;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        library = mock(Library.class);
        commandMap = new HashMap<>();
        showBooksMock = mock(ShowBooksCommand.class);
        quitMock = mock(QuitCommand.class);
        commandMap.put("1", showBooksMock);
        commandMap.put("Q", quitMock);
        options = new Options(library,printStream, commandMap);
    }

    @Test
    public void shouldListBooksWhenOptionIsOne() {
        options.runSelection("1");

        verify(showBooksMock).execute();
    }

    @Test
    public void shouldGiveErrorMessageWhenOptionIsInvalid() throws IOException {
        options.runSelection("afd");
        verify(printStream).println("Invalid option!");
    }

    @Test
    public void shouldReturnTrueWhenLastChosenOptionWasQuit() {
        options.runSelection("Q");

        assertTrue(options.timeToQuit());
    }

    @Test
    public void shouldReturnFalseWhenLastChosenOptionWasNotQuit(){
        options.runSelection("1");

        assertFalse(options.timeToQuit());
    }


}