package com.thoughtworks.biblioteca;

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

    public void start() {
        printStream.println("Welcome to Biblioteca!");
        mainMenu.displayOptions();
    }


}
