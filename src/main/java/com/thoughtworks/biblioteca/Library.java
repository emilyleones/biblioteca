package com.thoughtworks.biblioteca;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by eleones on 9/22/15.
 */
public class Library {
    private List<Book> books;

    public Library(List<Book> books){
        this.books = books;
    }

    public String listBooks() {
        String bookListing = "";
        for (Book book : books) {
            String strFormat = "%-30s %-30s %-30d%n";
            String bookInfo = String.format(strFormat, book.getTitle(), book.getAuthor(), book.getYear());
            bookListing += bookInfo;
        }
        return bookListing;
    }

//    public void addBook(String title, String author, int year) {
//        Book book = new Book(title, author, year);
//        books.add(book);
//
//    }
}
