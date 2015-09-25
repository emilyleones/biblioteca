package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by eleones on 9/25/15.
 */
public class CheckOutCommandTest {

    @Test
    public void shouldCheckOutBookWhenUserChecksOutBook(){
        Library library = mock(Library.class);
        String userBookNumber = "1";

        CheckOutCommand command = new CheckOutCommand(library, userBookNumber);

        command.execute();

        verify(library).checkOut(1);
    }

}