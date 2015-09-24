package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by eleones on 9/24/15.
 */
public class OptionsTest {

    private Library library;
    private Options options;

    @Before
    public void setUp(){
        library = mock(Library.class);
        options = new Options(library);
    }

    @Test
    public void shouldListBooksWhenOptionIsOne() {

        options.chooseSelection("1");

        verify(library).listBooks();
    }
}