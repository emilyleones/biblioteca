package com.thoughtworks.biblioteca;

import java.io.PrintStream;

/**
 * Created by eleones on 9/22/15.
 */
public class Book {
    private String title;
    private String author;
    private String year;
    private PrintStream printStream;
    private boolean isAvailable;

    public Book(String title, String author, String year, PrintStream printStream){
        this.title = title;
        this.author = author;
        this.year = year;
        this.printStream =printStream;
        isAvailable = true;
    }

    public void printDetails() {
        String bookDetails = String.format("%-30s| %-30s| %s", title, author, year);
        printStream.println(bookDetails);
    }

    public void checkOut() {
        isAvailable = false;
    }

    public boolean isAvailable() {
        return isAvailable;
    }


}
