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
           bookListing += book.getTitle() + "\n";
        }
        return bookListing;
    }

//    public void addBook(String title, String author, int year) {
//        Book book = new Book(title, author, year);
//        books.add(book);
//
//    }
}
