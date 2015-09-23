package com.thoughtworks.biblioteca;

/**
 * Created by eleones on 9/23/15.
 */
public class MainMenu {
    String menuOptions;

    MainMenu(){
        menuOptions = "These are the menu options:\n1 - List Books";
    }

    public String getMenuOptions() {
        return menuOptions;
    }
}
