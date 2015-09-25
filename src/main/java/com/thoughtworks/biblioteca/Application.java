package com.thoughtworks.biblioteca;

import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by eleones on 9/22/15.
 */
public class Application {

    private PrintStream printStream;
    private MainMenu mainMenu;

    public Application(PrintStream printStream, MainMenu mainMenu) {
        this.printStream = printStream;
        this.mainMenu = mainMenu;
    }

    public void start() throws IOException {
        printStream.println("Welcome to Biblioteca!");
        while (mainMenu.isNotQuitting()){
            mainMenu.displayOptions();
        }
    }


}
