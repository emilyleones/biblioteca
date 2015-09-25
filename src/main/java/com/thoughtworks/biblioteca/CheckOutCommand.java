package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by eleones on 9/25/15.
 */
public class CheckOutCommand implements Command {

    private Library library;
    private final PrintStream printStream;
    private final BufferedReader reader;

    public CheckOutCommand(Library library, PrintStream printStream, BufferedReader reader)
    {
        this.library = library;
        this.printStream = printStream;
        this.reader = reader;
    }

    @Override
    public void execute()  {

        printStream.println("Please enter book number:");

        String userInputtedBookNumber = null;
        try {
            userInputtedBookNumber = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


        int userInputtedBookNumberAsInt = Integer.parseInt(userInputtedBookNumber);
        library.checkOut(userInputtedBookNumberAsInt);
    }
}
