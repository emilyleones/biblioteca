package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by eleones on 9/23/15.
 */
public class MainMenu {
    private Library library;
    private PrintStream printStream;
    private BufferedReader reader;

    MainMenu(Library library, PrintStream printStream, BufferedReader bufferedReader){
        this.library = library;
        this.printStream = printStream;
        this.reader = bufferedReader;
    }

    public void displayOptions() throws IOException {
        printStream.println("Menu:\n1 - List Books");
        String option = reader.readLine();
        if (option.equals("1")) {
            library.listBooks();
        }
    }
}
