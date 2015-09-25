package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by eleones on 9/25/15.
 */
public class ShowBooksCommandTest {

    private Library library;
    private ShowBooksCommand command;

    @Before
    public void init(){
        library = mock(Library.class);

        command = new ShowBooksCommand(library);
    }

    @Test
    public void shouldListBooksWhenExecuting(){
        command.execute();

        verify(library).listBooks();
    }

}