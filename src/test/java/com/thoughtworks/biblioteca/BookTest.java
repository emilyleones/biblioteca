package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static junit.framework.TestCase.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by eleones on 9/23/15.
 */
public class BookTest {

    private PrintStream printStream;
    private Book book;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        book = new Book("The Hungry Caterpillar", "Eric Carle", "1969", 0, printStream);
    }

    @Test
    public void shouldFormatDetailsIntoColumnsWhenPrintingDetails() {

        book.printDetails();

        verify(printStream).println("1    |The Hungry Caterpillar        | Eric Carle                    | 1969");
    }

    @Test
    public void shouldMarkBookAsNotAvailableWhenBookIsCheckedOut() {
        book.checkOut();

        assertFalse(book.isAvailable());
    }

    @Test
    public void shouldPrintSuccessfulCheckOutMessageWhenBookIsSuccessfullyCheckedOut () {
        book.checkOut();

        verify(printStream).println("Thank you! Enjoy the book");
    }
}