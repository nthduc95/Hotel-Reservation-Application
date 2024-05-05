package com.application;

import java.util.Scanner;
import com.application.MainMenu;

public class HotelApplication {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            MainMenu menu = MainMenu.getInstance();
            menu.displayMainMenu(input);
        } catch (Exception err) {
            System.out.println("Thank you for using our application !!!");
        }

    }
}
