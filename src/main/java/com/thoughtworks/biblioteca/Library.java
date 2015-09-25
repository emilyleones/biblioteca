package com.thoughtworks.biblioteca;

import java.util.List;

/**
 * Created by eleones on 9/22/15.
 */
public class Library {
    private List<Book> books;

    public Library(List<Book> books){
        this.books = books;
    }

    public void listBooks() {
        for (Book book : books) {
            if(book.isAvailable())
            {
                book.printDetails();
            }

        }
    }

    public void checkOut(int userInputtedBookNumber) {
        int bookIndex = userInputtedBookNumber - 1;
        books.get(bookIndex).checkOut();
    }

//    public void addBook(String title, String author, int year) {
//        Book book = new Book(title, author, year);
//        books.add(book);
//
//    }
}
