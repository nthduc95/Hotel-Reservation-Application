package com.application;

import java.util.Scanner;
import com.application.MainMenu;

public class HotelApplication {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MainMenu menu = MainMenu.getInstance();
        menu.displayMainMenu(input);
    }
}
