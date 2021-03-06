package com.thoughtworks.biblioteca;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by eleones on 9/24/15.
 */
public class Options {
    private Library library;
    private PrintStream printStream;
    private String lastOption;
    private Map<String, Command> commandMap;

    public Options(Library library, PrintStream printStream, Map<String, Command> commandMap) {
        this.library = library;
        this.printStream = printStream;
        lastOption = "";
        this.commandMap = commandMap;
    }

    //Add command map instead of if else
    public void runSelection(String choice) {
        lastOption = choice.toUpperCase();
        if (commandMap.containsKey(lastOption)) {
            commandMap.get(lastOption).execute();
        } else {
            printStream.println("Invalid option!");
        }
    }

    public boolean timeToQuit() {
        return lastOption.equals("Q");
    }
}
