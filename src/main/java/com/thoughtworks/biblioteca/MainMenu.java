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

    MainMenu(PrintStream printStream, BufferedReader bufferedReader, Options options) {
        this.printStream = printStream;
        this.reader = bufferedReader;
        this.options = options;
    }

    public void displayOptions() throws IOException {
        printStream.println("\nMenu:\n1 - List Books\n2 - Check Out Book\nQ - Quit");
        readAndRunInput();
    }

    private void readAndRunInput() throws IOException {
        String option = reader.readLine();
        options.runSelection(option);
    }

    public boolean isRunning() {
        return !options.timeToQuit();
    }

//    private boolean notQuitting(String choice) {
//        return !choice.toUpperCase().equals("Q");
//    }
}
