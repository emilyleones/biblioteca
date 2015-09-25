package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {


    public static void main(String[] args) throws IOException {
        List<Book> bookList = new ArrayList<Book>();
        Book TheHungryCaterpillar = new Book("The Hungry Caterpillar", "Eric Carle", "1969", bookList.size(), System.out);
        bookList.add(TheHungryCaterpillar);

        Book GoodnightMoon = new Book("Goodnight, Moon", "Margaret Wise Brown", "1947", bookList.size(), System.out);
        bookList.add(GoodnightMoon);

        PrintStream printStream = System.out;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Library library = new Library(bookList);
        Map<String, Command> commandMap = new HashMap<>();
        commandMap.put("1", new ShowBooksCommand(library));
        commandMap.put("2", new CheckOutCommand(library, printStream, reader));
        commandMap.put("Q", new QuitCommand());

        Options options = new Options(library, printStream, commandMap);
        MainMenu mainMenu = new MainMenu(printStream, reader, options);
        Application application = new Application(printStream, mainMenu);
        application.start();
    }
}