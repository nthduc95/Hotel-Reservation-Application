package com.application;

import java.util.Scanner;

public class HotelApplication {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MainMenu menu = new MainMenu();
        menu.displayMainMenu(input);
    }
}
