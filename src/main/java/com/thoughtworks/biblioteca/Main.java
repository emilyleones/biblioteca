package com.thoughtworks.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<Book>();
        Book TheHungryCaterpillar = new Book("The Hungry Caterpillar", "Eric Carle", "1969", System.out);
        bookList.add(TheHungryCaterpillar);

        Book GoodnightMoon = new Book("Goodnight, Moon", "Margaret Wise Brown", "1947", System.out);
        bookList.add(GoodnightMoon);

        Library library = new Library(bookList, System.out);
        MainMenu mainMenu = new MainMenu(library, System.out);
        Application application = new Application(System.out, mainMenu);
        application.start();
    }
}