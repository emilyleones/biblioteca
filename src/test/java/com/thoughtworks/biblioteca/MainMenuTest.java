package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by eleones on 9/23/15.
 */
public class MainMenuTest {

    @Before
    @Test
    public void shouldDisplayOptionsWhenStarts() {

        MainMenu menu = new MainMenu();
        menu.getMenuOptions();
        assertThat(menu.getMenuOptions(), is("These are the menu options:\n1 - List Books"));

    }

    @Test
    public void shouldListBooksWhenOptionIsOne() {
        Library library = mock(Library.class);
        when(reader.readLine()).thenReturn("1");
        verify()
    }

}