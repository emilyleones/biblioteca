package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;


/**
 * Created by eleones on 9/22/15.
 */
public class LibraryTest {
    private Library library;
    private PrintStream printStream;
    private ArrayList<Book> bookList;
    private Book book1;
    private Book book2;


    @Before
    public void setup(){
        printStream = new PrintStream(System.out);
        bookList= new ArrayList<Book>();
        book1 = new Book("The Hungry Caterpillar", "Eric Carle", 1969);
        book2 = new Book("Goodnight, Moon", "Margaret Wise Brown", 1947);


    }

    @Test
    public void shouldPrintNothingWhenBookListIsEmpty() {
        library = new Library(bookList);
        assertThat(library.listBooks(), is(""));
    }

    @Test
    public void shouldPrintOneTitleWhenOneBookInBib() {
        bookList.add(book1);
        library = new Library(bookList);
        assertTrue(library.listBooks().contains(book1.getTitle()));
    }

    @Test
    public void shouldPrintBothTitlesWhenTwoBooksAreInBib() {
        bookList.add(book1);
        bookList.add(book2);
        library = new Library(bookList);
        assertTrue(library.listBooks().contains(book1.getTitle()));
        assertTrue(library.listBooks().contains(book2.getTitle()));

    }

    @Test
    public void shouldPrintOneTitleAuthorAndYearWhenOneBookInBib() {
        bookList.add(book1);
        library = new Library(bookList);
        String strFormat = "%-30s %-30s %-30d%n";
        String book1Info = String.format(strFormat, book1.getTitle(), book1.getAuthor(), book1.getYear());
        assertThat(library.listBooks(), is(book1Info));
    }

    @Test
    public void shouldPrintTwoitleAuthorAndYearWhenTwoBookInBib() {
        bookList.add(book1);
        bookList.add(book2);
        library = new Library(bookList);
        String booksInfo = "";
        String strFormat = "%-30s %-30s %-30d%n";
        String book1Info = String.format(strFormat, book1.getTitle(), book1.getAuthor(), book1.getYear());
        booksInfo += book1Info;
        String book2Info = String.format(strFormat, book2.getTitle(), book2.getAuthor(), book2.getYear());
        booksInfo += book2Info;
        assertThat(library.listBooks(), is(booksInfo));
    }

}