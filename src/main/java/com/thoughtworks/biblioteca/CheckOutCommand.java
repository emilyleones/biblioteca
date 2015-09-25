package com.thoughtworks.biblioteca;

/**
 * Created by eleones on 9/25/15.
 */
public class CheckOutCommand implements Command {

    private Library library;
    private String userInputtedBookNumber;

    public CheckOutCommand(Library library, String userInputtedBookNumber)
    {
        this.library = library;
        this.userInputtedBookNumber = userInputtedBookNumber;
    }

    @Override
    public void execute() {
        int userInputtedBookNumberAsInt = Integer.parseInt(userInputtedBookNumber);
        library.checkOut(userInputtedBookNumberAsInt);
    }
}
