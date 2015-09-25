package com.thoughtworks.biblioteca;

/**
 * Created by eleones on 9/25/15.
 */
public class ShowBooksCommand implements Command {
    private Library library;

    public ShowBooksCommand(Library library) {
        this.library = library;
    }

    @Override
    public void execute() {
        library.listBooks();
    }
}
