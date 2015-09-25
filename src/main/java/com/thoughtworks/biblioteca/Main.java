package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {
        List<Book> bookList = new ArrayList<Book>();
        Book TheHungryCaterpillar = new Book("The Hungry Caterpillar", "Eric Carle", "1969", System.out);
        bookList.add(TheHungryCaterpillar);

        Book GoodnightMoon = new Book("Goodnight, Moon", "Margaret Wise Brown", "1947", System.out);
        bookList.add(GoodnightMoon);

        Library library = new Library(bookList);
        Options options = new Options(library, System.out);
        MainMenu mainMenu = new MainMenu(System.out, new BufferedReader(new InputStreamReader(System.in)), options);
        Application application = new Application(System.out, mainMenu);
        application.start();
    }
}