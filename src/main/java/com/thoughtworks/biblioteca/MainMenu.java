package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.PrintStream;

/**
 * Created by eleones on 9/23/15.
 */
public class MainMenu {
    private Library library;
    private PrintStream printStream;
    private BufferedReader reader;

    MainMenu(Library library, PrintStream printStream){
        this.library = library;
        this.printStream = printStream;
        this.reader = reader;
    }

    public void displayOptions() {
        printStream.println("Menu:\n1 - List Books");
        library.listBooks();
    }
}
