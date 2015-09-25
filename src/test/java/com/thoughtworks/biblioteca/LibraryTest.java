package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;


/**
 * Created by eleones on 9/22/15.
 */
public class LibraryTest {
    private Library library;
    private PrintStream printStream;
    private ArrayList<Book> bookList;
    private Book book;


    @Before
    public void setup(){
        printStream = mock(PrintStream.class);
        bookList = new ArrayList();
        book = mock(Book.class);
        bookList.add(book);
        library = new Library(bookList);

//        book1 = new Book("The Hungry Caterpillar", "Eric Carle", "1969", printStream);
//        book2 = new Book("Goodnight, Moon", "Margaret Wise Brown", "1947", printStream);
    }


    @Test
    public void shouldPrintBookDetailsWhenListingBooks() {
        library.listBooks();
        verify(book).printDetails();
    }

//    @Test
//    public void shouldRemoveBookAvailabilityWhenBookIsCheckedOut() {
//        library.checkOut(1);
//        assertFalse(book1.isAvailable());
//    }

    @Test
    public void shouldNotListBookWhenBookIsNotAvailable(){
        when(book.isAvailable()).thenReturn(false);
        library.listBooks();

        verify(book).isAvailable();
        verifyNoMoreInteractions(book);
    }

    @Test
    public void shouldCheckOutBookWhenBookIsBeingCheckedOut() {
        library.checkOut(1);

        verify(book).checkOut();
    }



}