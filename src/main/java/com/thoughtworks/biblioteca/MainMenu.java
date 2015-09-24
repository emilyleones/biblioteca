package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by eleones on 9/23/15.
 */
public class MainMenu {
    private PrintStream printStream;
    private BufferedReader reader;
    private Options options;

    MainMenu(PrintStream printStream, BufferedReader bufferedReader, Options options){
        this.printStream = printStream;
        this.reader = bufferedReader;
        this.options = options;
    }

    public void displayOptions() throws IOException {
        printStream.println("Menu:\n1 - List Books\nQ - Quit");
        String option = reader.readLine();
        while(notQuitting(option)){
            options.runSelection(option);
            option = reader.readLine();
        }
    }

    private boolean notQuitting(String choice) {
        return !choice.toUpperCase().equals("Q");
    }
}
