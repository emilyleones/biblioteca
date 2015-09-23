package com.thoughtworks.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<Book>();
        Book TheHungryCaterpillar = new Book("The Hungry Caterpillar", "Eric Carle", 1969);
        bookList.add(TheHungryCaterpillar);

        Book GoodnightMoon = new Book("Goodnight, Moon", "Margaret Wise Brown", 1947);
        bookList.add(GoodnightMoon);

        Library library = new Library(bookList);
        Application application = new Application(System.out, library);
        application.start();
    }
}