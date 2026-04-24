/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.seriesmodel;

import java.util.Scanner;

/**
 * Main.java
 * Entry point for the TV Series Management Application.
 * Displays the menu and calls appropriate methods from the Series class.
 * During the planning and coding phases of this assignment, Claude AI (Anthropic, 2026) was used for initial code generation suggestions, debugging assistance, and structuring of unit tests. All AI-generated code was thoroughly reviewed, modified where necessary, and tested to ensure correctness and understanding.
 * Claude AI (2026) Claude 3.5 Sonnet. Anthropic. Available at: https://claude.ai/ .
 */
public class Main {
    public static void main(String[] args) {
        Series app = new Series();
        Scanner mainScanner = new Scanner(System.in);
        String launchChoice;

        // Main launch prompt
        System.out.println("LATEST SERIES OF THE YEAR 2026");
        System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-");
        System.out.print("Enter (1) to launch menu or any other key to exit: ");
        launchChoice = mainScanner.nextLine();

        if (launchChoice.equals("1")) {
            boolean running = true;
            while (running) {
                // This is the display menu
                System.out.println("\nPlease select one of the following menu items:");
                System.out.println("(1) Capture a new series.");
                System.out.println("(2) Search for a series.");
                System.out.println("(3) Update series age restriction");
                System.out.println("(4) Delete a series.");
                System.out.println("(5) Print series report - 2025");
                System.out.println("(6) Exit Application.");
                System.out.print("Enter choice: ");

                String choice = mainScanner.nextLine();

                switch (choice) {
                    case "1":
                        app.CaptureSeries();
                        break;
                    case "2":
                        app.SearchSeries();
                        break;
                    case "3":
                        app.UpdateSeries();
                        break;
                    case "4":
                        app.DeleteSeries();
                        break;
                    case "5":
                        app.SeriesReport();
                        break;
                    case "6":
                        app.ExitSeriesApplication();
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }

                // After each operation, this will ask users if they want to return to menu
                if (running) {
                    System.out.print("\nEnter (1) to launch menu or any other key to exit: ");
                    String continueChoice = mainScanner.nextLine();
                    if (!continueChoice.equals("1")) {
                        running = false;
                        System.out.println("Exiting application. Goodbye.");
                    }
                }
            }
        } else {
            System.out.println("Exiting application. Goodbye.");
        }

        mainScanner.close();
    }
}